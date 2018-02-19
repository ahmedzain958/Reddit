package com.zain.reddit.util;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.zain.reddit.SavedPostsWidget;
import com.zain.reddit.models.saved_posts.Child;
import com.zain.reddit.models.saved_posts.Data;
import com.zain.reddit.models.saved_posts.SavedPost;
import com.zain.reddit.network.RedditAPI;
import com.zain.reddit.network.RedditRestClient;

import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.COLUMN_DOMAIN;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.COLUMN_SUBREDDIT_NAME_PREFIXED;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.COLUMN_TITLE;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.COLUMN_USERNAME;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.CONTENT_URI;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.ID;

/**
 * Created by Zain on 29/01/2018.
 */

public class HelpMethods {
    public static final String BUNDLE_RECYCLER_LAYOUT = "position";


    private static final NavigableMap<Long, String> suffixes = new TreeMap<>();

    static {
        suffixes.put(1_000L, "k");
        suffixes.put(1_000_000L, "M");
        suffixes.put(1_000_000_000L, "G");
        suffixes.put(1_000_000_000_000L, "T");
        suffixes.put(1_000_000_000_000_000L, "P");
        suffixes.put(1_000_000_000_000_000_000L, "E");
    }

    public static String format(long value) {
        if (value == Long.MIN_VALUE) return format(Long.MIN_VALUE + 1);
        if (value < 0) return "-" + format(-value);
        if (value < 1000) return Long.toString(value); //deal with easy case

        Map.Entry<Long, String> e = suffixes.floorEntry(value);
        Long divideBy = e.getKey();
        String suffix = e.getValue();

        long truncated = value / (divideBy / 10); //the number part of the output times 10
        boolean hasDecimal = truncated < 100 && (truncated / 10d) != (truncated / 10);
        return hasDecimal ? (truncated / 10d) + suffix : (truncated / 10) + suffix;
    }


    public static boolean isNetworkAvailable(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void saveRecyclerState(@Nullable Bundle savedInstanceState, RecyclerView myRecyclerView, LinearLayoutManager recyclerLayoutManager) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(BUNDLE_RECYCLER_LAYOUT)) {
                Parcelable p = savedInstanceState.getParcelable(BUNDLE_RECYCLER_LAYOUT);
                if (myRecyclerView != null && recyclerLayoutManager != null)
                    recyclerLayoutManager.onRestoreInstanceState(p);
            }
        }
    }


    public static void savePostForWidget(final FragmentActivity fragmentActivity, String username, String accessToken) {
        if (null != accessToken && !accessToken.equals("") && null != username && !username.equals("")) {
            RedditRestClient redditRestClient = new RedditRestClient(true);
            RedditAPI redditAPI = redditRestClient.getRedditApi();
            if (redditAPI != null) {
                Call<SavedPost> call = redditAPI.getSavedPostsAuth("bearer " + accessToken, username);
                try {
                    call.enqueue(new Callback<SavedPost>() {
                        @Override
                        public void onResponse(Call<SavedPost> call, Response<SavedPost> response) {
                            if (response == null) {
                                Log.d("response", "null");
                            } else {
                                SavedPost savedPost = response.body();
                                if (savedPost != null) {
                                    save(fragmentActivity, savedPost);
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<SavedPost> call, Throwable t) {
                            Log.d("onFailure", "onFailure");
                        }


                    });
                } catch (Exception e) {
                    Log.d("onFailure", e.getMessage());

                }
            }
        }
    }

    private static void save(FragmentActivity fragmentActivity, SavedPost savedPost) {
        if (savedPost != null) {
            Data data = savedPost.getData();
            if (data != null) {
                List<Child> children = data.getChildren();
                if (children != null && children.size() > 0) {
                    savePosts(fragmentActivity, children);
                }
            }
        }
    }

    private static void savePosts(FragmentActivity fragmentActivity, List<Child> children) {
        if (fragmentActivity != null) {
            Cursor savedCursor = fragmentActivity.getContentResolver().query(
                    CONTENT_URI,
                    null,
                    "ID>?",
                    new String[]{"1"},
                    ID);//there is data
            if (savedCursor != null && savedCursor.getCount() > 0) {//there is data not username
                fragmentActivity.getContentResolver().delete(CONTENT_URI, "ID>?",//delete data not username
                        new String[]{"1"});
                insertNewSavedPosts(fragmentActivity, children);
                savedCursor.close();
            } else {
                insertNewSavedPosts(fragmentActivity, children);
            }
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(fragmentActivity);
            int[] ids = appWidgetManager.getAppWidgetIds(
                    new ComponentName(fragmentActivity, SavedPostsWidget.class));
            SavedPostsWidget.updateAllWidgets(fragmentActivity, appWidgetManager, ids);
        } else {
            Log.d("error", "could not save posts");
        }
    }

    private static void insertNewSavedPosts(FragmentActivity fragmentActivity, List<Child> children) {
        for (Child child : children) {
            com.zain.reddit.models.saved_posts.Data_ data_ = child.getData();
            if (data_ != null) {
                ContentValues widgetContentValues = new ContentValues();
                widgetContentValues.put(COLUMN_TITLE, data_.getTitle());
                widgetContentValues.put(COLUMN_SUBREDDIT_NAME_PREFIXED, data_.getSubredditNamePrefixed());
                widgetContentValues.put(COLUMN_DOMAIN, data_.getDomain());
                widgetContentValues.put(COLUMN_USERNAME, "0");
                fragmentActivity.getContentResolver().insert(CONTENT_URI, widgetContentValues);
            }
        }
    }

}
