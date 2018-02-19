package com.zain.reddit.provider;

import android.content.Context;
import android.database.Cursor;

import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.CONTENT_URI;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.ID;

/**
 * Created by Zain on 14/02/2018.
 */

public class DatabaseMethods {
    static UsernameReady usernameReady;

    public DatabaseMethods(UsernameReady usernameReady) {
        this.usernameReady = usernameReady;
    }

    public static String getUsername(Context context, String _username) {
        String username = "";

        Cursor mCursor = context.getContentResolver().query(
                CONTENT_URI,
                null,
                RedditContract.SavedPostsEntry.COLUMN_USERNAME + "= '" + _username + "'",
                null,
                ID);
        if (mCursor == null) {
            return username;
        } else if (mCursor.getCount() == 0) {
            mCursor.close();
            return username;
        } else if (mCursor.getCount() > 0) {
            if (mCursor.moveToNext()) {
                username = mCursor.getString(mCursor.getColumnIndex(RedditContract.SavedPostsEntry.COLUMN_USERNAME));
            }
        }
        mCursor.close();
        return username;
    }


    public static void getUsername(Context context) {
        String username = "";

        Cursor mCursor = context.getContentResolver().query(
                CONTENT_URI,
                null,
                "id=?",
                new String[]{"1"},
                ID);
       /* String count = String.v
        Log.d("count", mCursor.getCount());*/
        if (mCursor != null && mCursor.getCount() > 0) {
            if (mCursor.moveToFirst()) {
                username = mCursor.getString(mCursor.getColumnIndex(RedditContract.SavedPostsEntry.COLUMN_USERNAME));
            }
        }
        mCursor.close();
        if (!"".equals(username) && username != null) {
            usernameReady.usernameReady(username);
        } else {
            usernameReady.usernameReady(null);
        }
    }

   public interface UsernameReady {
        void usernameReady(String username);
    }
}
