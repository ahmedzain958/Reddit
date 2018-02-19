package com.zain.reddit.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Zain on 08/12/2017.
 */

public class RedditContract {
    public static final String AUTHORITY = "com.zain.reddit";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public static final String PATH_SAVED_POSTS = "saved_posts";


    public static final class SavedPostsEntry implements BaseColumns {

        // TaskEntry content URI = base content URI + path
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_SAVED_POSTS).build();

        public static final String TABLE_NAME = "savedPosts";
        public static final String ID = "Id";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_SUBREDDIT_NAME_PREFIXED = "subreddit_name_prefixed";
        public static final String COLUMN_DOMAIN = "domain";
        public static final String COLUMN_NUMBER_OF_COMMENTS = "no_comments";

    }
}
