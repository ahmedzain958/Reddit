package com.zain.reddit.provider;

/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.ID;


public class RedditDbHelper extends SQLiteOpenHelper {

    // The database name
    private static final String DATABASE_NAME = "reddit.db";

    // If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 1;

    // Constructor
    public RedditDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // Create a table to hold the plants data


        final String SQL_CREATE_SAVED_POSTS_TABLE = "CREATE TABLE " + RedditContract.SavedPostsEntry.TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                RedditContract.SavedPostsEntry.COLUMN_DOMAIN + " TEXT ," +
                RedditContract.SavedPostsEntry.COLUMN_SUBREDDIT_NAME_PREFIXED + " TEXT ," +
                RedditContract.SavedPostsEntry.COLUMN_USERNAME + " TEXT ," +
                RedditContract.SavedPostsEntry.COLUMN_NUMBER_OF_COMMENTS + " TEXT ," +
                RedditContract.SavedPostsEntry.COLUMN_TITLE + " TEXT )";



        sqLiteDatabase.execSQL(SQL_CREATE_SAVED_POSTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + RedditContract.SavedPostsEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
