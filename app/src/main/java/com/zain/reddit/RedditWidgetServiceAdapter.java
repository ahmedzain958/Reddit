package com.zain.reddit;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.COLUMN_DOMAIN;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.COLUMN_SUBREDDIT_NAME_PREFIXED;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.COLUMN_TITLE;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.CONTENT_URI;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.ID;

public class RedditWidgetServiceAdapter extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new ListRemoteViewsFactory(this.getApplicationContext());
    }
}

class ListRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    Context mContext;
    Cursor mCursor;

    public ListRemoteViewsFactory(Context applicationContext) {
        mContext = applicationContext;
    }

    @Override
    public void onCreate() {

    }

    /*BookContract.BookEntry.COLUMNFAVFLAG + " = ? AND "+BookContract.BookEntry.COLUMNID + " = ?",
      new String[]{"1", "2"},*/
    //called on start and when notifyAppWidgetViewDataChanged is called
    @Override
    public void onDataSetChanged() {
        mCursor = mContext.getContentResolver().query(
                CONTENT_URI,
                null,
                "ID>?",
                new String[]{"1"},
                ID);

    }

    @Override
    public void onDestroy() {
        if (mCursor != null)
            mCursor.close();

    }

    @Override
    public int getCount() {
        if (mCursor == null) return 1;
        return mCursor.getCount();
    }

    /**
     * This method acts like the onBindViewHolder method in an Adapter
     *
     * @param position The current position of the item in the GridView to be displayed
     * @return The RemoteViews object to display for the provided postion
     */
    @Override
    public RemoteViews getViewAt(int position) {
        if (mCursor == null || mCursor.getCount() == 0) return null;
        RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.saved_posts_row);
        mCursor.moveToPosition(position);
        int titleIndex = mCursor.getColumnIndex(COLUMN_TITLE);
        int subredditIndex = mCursor.getColumnIndex(COLUMN_SUBREDDIT_NAME_PREFIXED);
        int domainIndex = mCursor.getColumnIndex(COLUMN_DOMAIN);

        String title = mCursor.getString(titleIndex);
        String subredditNamePre = mCursor.getString(subredditIndex);
        String domain = mCursor.getString(domainIndex);


        views.setTextViewText(R.id.title, title);
        views.setTextViewText(R.id.subreddit_name_prefixed, subredditNamePre);
        views.setTextViewText(R.id.domain, domain);
        return views;

    }


    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
