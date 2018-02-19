package com.zain.reddit.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;

import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.ID;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.TABLE_NAME;


public class RedditContentProvider extends ContentProvider {

    public static final int SAVED_POSTS = 100;
    public static final int SAVED_POSTS_WITH_ID = 101;


    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private static final String TAG = RedditContentProvider.class.getName();

    public static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(RedditContract.AUTHORITY, RedditContract.PATH_SAVED_POSTS, SAVED_POSTS);
        uriMatcher.addURI(RedditContract.AUTHORITY, RedditContract.PATH_SAVED_POSTS + "/#", SAVED_POSTS_WITH_ID);

        return uriMatcher;
    }

    private RedditDbHelper mRedditDbHelper;

    @Override
    public boolean onCreate() {
        Context context = getContext();
        mRedditDbHelper = new RedditDbHelper(context);
        return true;
    }

    /***
     * Handles requests to insert a single new row of data
     *
     * @param uri
     * @param values
     * @return
     */
    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        final SQLiteDatabase db = mRedditDbHelper.getWritableDatabase();

        // Write URI matching code to identify the match for the plants directory
        int match = sUriMatcher.match(uri);
        Uri returnUri; // URI to be returned
        switch (match) {
            case SAVED_POSTS:
                // Insert new values into the database
                long id = db.insert(TABLE_NAME, null, values);
                if (id > 0) {
                    returnUri = ContentUris.withAppendedId(RedditContract.SavedPostsEntry.CONTENT_URI, id);
                } else {
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                }
                break;
           /* case INGREDIENTS:
                // Insert new values into the database
                long ingredientId = db.insert(INGREDIENT_TABLE_NAME, null, values);
                if (ingredientId > 0) {
                    returnUri = ContentUris.withAppendedId(RedditContract.BakingEntry.CONTENT_URI2, ingredientId);
                } else {
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                }
                break;
            case WIDGETS:
                // Insert new values into the database
                long widgetId = db.insert(RedditContract.BakingEntry.SELECTED_RECIPES_TABLE_NAME, null, values);
                if (widgetId > 0) {
                    returnUri = ContentUris.withAppendedId(RedditContract.BakingEntry.CONTENT_URI3, widgetId);
                } else {
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                }
                break;*/
            // Default case throws an UnsupportedOperationException
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        // Notify the resolver if the uri has been changed, and return the newly inserted URI
        getContext().getContentResolver().notifyChange(uri, null);

        // Return constructed uri (this points to the newly inserted row of data)
        return returnUri;
    }

    /***
     * Handles requests for data by URI
     *
     * @param uri
     * @param projection
     * @param selection
     * @param selectionArgs
     * @param sortOrder
     * @return
     */
    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        // Get access to underlying database (read-only for query)
        final SQLiteDatabase db = mRedditDbHelper.getReadableDatabase();

        // Write URI match code and set a variable to return a Cursor
        int match = sUriMatcher.match(uri);
        Cursor retCursor;

        switch (match) {
            // Query for the plants directory
            case SAVED_POSTS:
                retCursor = db.query(TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
           /* case RECIPE_WITH_ID:
                String id = uri.getPathSegments().get(1);
                retCursor = db.rawQuery("SELECT * " +
                        "FROM " + TABLE_NAME + " JOIN " + INGREDIENT_TABLE_NAME + " ON " + ID + " = " + COLUMN_RECIPE_ID
                        + " WHERE " + COLUMN_RECIPE_ID + " = " + id + "", null);

                break;
            case INGREDIENTS:
                retCursor = db.query(INGREDIENT_TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            case INGREDIENT_WITH_RECIPE_ID:
                String recipeId = uri.getPathSegments().get(1);
                retCursor = db.query(INGREDIENT_TABLE_NAME,
                        projection,
                        COLUMN_RECIPE_ID + "=?",
                        new String[]{recipeId},
                        null,
                        null,
                        sortOrder);
                break;
            case WIDGETS:
                retCursor = db.query(RedditContract.BakingEntry.SELECTED_RECIPES_TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            case RECIPE_WITH_WIDGET_ID:
                String selectedId = uri.getPathSegments().get(1);
                retCursor = db.query(RedditContract.BakingEntry.SELECTED_RECIPES_TABLE_NAME,
                        projection,
                        COLUMN_WIDGET_ID + "=?",
                        new String[]{selectedId},
                        null,
                        null,
                        sortOrder);
                break;*/
            // Default exception
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        // Set a notification URI on the Cursor and return that Cursor
        retCursor.setNotificationUri(getContext().getContentResolver(), uri);

        // Return the desired Cursor
        return retCursor;
    }

    /***
     * Deletes a single row of data
     *
     * @param uri
     * @param selection
     * @param selectionArgs
     * @return number of rows affected
     */
    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        // Get access to the database and write URI matching code to recognize a single item
        final SQLiteDatabase db = mRedditDbHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        // Keep track of the number of deleted plants
        int plantsDeleted; // starts as 0
        switch (match) {
            // Handle the single item case, recognized by the ID included in the URI path
            case SAVED_POSTS_WITH_ID:
                // Get the plant ID from the URI path
                String id = uri.getPathSegments().get(1);
                // Use selections/selectionArgs to filter for this ID
                plantsDeleted = db.delete(TABLE_NAME, ID + ">?", new String[]{id});
                break;
            case SAVED_POSTS:
                // Get the plant ID from the URI path
                // Use selections/selectionArgs to filter for this ID
                plantsDeleted = db.delete(TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        // Notify the resolver of a change and return the number of items deleted
        if (plantsDeleted != 0) {
            // A plant (or more) was deleted, set notification
            getContext().getContentResolver().notifyChange(uri, null);
        }
        // Return the number of plant deleted
        return plantsDeleted;
    }

    /***
     * Updates a single row of data
     *
     * @param uri
     * @param selection
     * @param selectionArgs
     * @return number of rows affected
     */
    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // Get access to underlying database
        final SQLiteDatabase db = mRedditDbHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        // Keep track of the number of updated plants
        int plantsUpdated;

        switch (match) {
            case SAVED_POSTS:
                plantsUpdated = db.update(TABLE_NAME, values, selection, selectionArgs);
                break;
            case SAVED_POSTS_WITH_ID:
                if (selection == null) selection = ID + "=?";
                else selection += " AND " + ID + "=?";
                // Get the place ID from the URI path
                String id = uri.getPathSegments().get(1);
                // Append any existing selection options to the ID filter
                if (selectionArgs == null) selectionArgs = new String[]{id};
                else {
                    ArrayList<String> selectionArgsList = new ArrayList<String>();
                    selectionArgsList.addAll(Arrays.asList(selectionArgs));
                    selectionArgsList.add(id);
                    selectionArgs = selectionArgsList.toArray(new String[selectionArgsList.size()]);
                }
                plantsUpdated = db.update(TABLE_NAME, values, selection, selectionArgs);
                break;
            // Default exception
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        // Notify the resolver of a change and return the number of items updated
        if (plantsUpdated != 0) {
            // A place (or more) was updated, set notification
            getContext().getContentResolver().notifyChange(uri, null);
        }
        // Return the number of places deleted
        return plantsUpdated;
    }


    @Override
    public String getType(@NonNull Uri uri) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
