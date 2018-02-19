package com.zain.reddit.fragments;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zain.reddit.R;
import com.zain.reddit.SavedPostsWidget;
import com.zain.reddit.adapters.RecyclerSavedPostsAdapter;
import com.zain.reddit.models.interfaces.IAccesTokenReady;
import com.zain.reddit.models.saved_posts.Child;
import com.zain.reddit.models.saved_posts.Data;
import com.zain.reddit.models.saved_posts.Data_;
import com.zain.reddit.models.saved_posts.SavedPost;
import com.zain.reddit.network.ApiCalling;
import com.zain.reddit.network.RedditAPI;
import com.zain.reddit.network.RedditRestClient;
import com.zain.reddit.provider.DatabaseMethods;
import com.zain.reddit.util.AppApplication;
import com.zain.reddit.util.UserStatus;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.COLUMN_DOMAIN;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.COLUMN_NUMBER_OF_COMMENTS;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.COLUMN_SUBREDDIT_NAME_PREFIXED;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.COLUMN_TITLE;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.COLUMN_USERNAME;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.CONTENT_URI;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.ID;
import static com.zain.reddit.util.HelpMethods.BUNDLE_RECYCLER_LAYOUT;
import static com.zain.reddit.util.HelpMethods.saveRecyclerState;

public class SavedPostsFragment extends Fragment implements DatabaseMethods.UsernameReady,
        LoaderManager.LoaderCallbacks<Cursor>, IAccesTokenReady {


    private LinearLayoutManager recyclerLayoutManager;
    private RecyclerSavedPostsAdapter myRecyclerViewAdapter;
    private RecyclerView myRecyclerView;
    UserStatus userStatus;
    ApiCalling apiCalling;
    private DatabaseMethods db;
    private boolean firstTimeLoaded = false;
    String accessToken, username;
    private AppApplication appApplication;
    private Bundle savedInstanceState;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved_posts, container, false);
        appApplication = AppApplication.getInstance();
        userStatus = appApplication.getUserStatus();
        apiCalling = new ApiCalling(getActivity(), userStatus);
        apiCalling.setAccessToken(this);
        apiCalling.getAccesToken();


        if (userStatus != null) {
            db = new DatabaseMethods(this);
            db.getUsername(getActivity());
        }
        myRecyclerView = view.findViewById(R.id.saved_posts_recycler);
        this.savedInstanceState = savedInstanceState;
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        appApplication = AppApplication.getInstance();
        userStatus = appApplication.getUserStatus();
        apiCalling = new ApiCalling(getActivity(), userStatus);
        apiCalling.setAccessToken(this);
        apiCalling.getAccesToken();


        if (userStatus != null) {
            db = new DatabaseMethods(this);
            db.getUsername(getActivity());
        }
    }

    private void save(SavedPost savedPost) {
        if (savedPost != null) {
            Data data = savedPost.getData();
            if (data != null) {
                List<Child> children = data.getChildren();
                if (children != null && children.size() > 0) {
                    savePosts(children);
                }
            }
        }
    }

    private void savePosts(List<Child> children) {
        if (getActivity() != null) {
            Cursor savedCursor = getActivity().getContentResolver().query(
                    CONTENT_URI,
                    null,
                    "ID>?",
                    new String[]{"1"},
                    ID);//there is data
            if (savedCursor != null && savedCursor.getCount() > 0) {//there is data not username
                getActivity().getContentResolver().delete(CONTENT_URI, "ID>?",//delete data not username
                        new String[]{"1"});
                insertNewSavedPosts(children);
                fillRecyclerViewFromDb();
                savedCursor.close();
                return;
            } else {
                insertNewSavedPosts(children);
            }
        } else {
            Log.d("error", "could not save posts");
        }
    }

    private void fillRecyclerViewFromDb() {
        if (firstTimeLoaded == false) {
            getLoaderManager().initLoader(1, null, this);
            firstTimeLoaded = true;
        } else {
            getLoaderManager().restartLoader(1, null, this);
        }
    }

    void insertNewSavedPosts(List<Child> children) {
        for (Child child : children) {
            com.zain.reddit.models.saved_posts.Data_ data_ = child.getData();
            if (data_ != null) {
                ContentValues widgetContentValues = new ContentValues();
                widgetContentValues.put(COLUMN_TITLE, data_.getTitle());
                widgetContentValues.put(COLUMN_SUBREDDIT_NAME_PREFIXED, data_.getSubredditNamePrefixed());
                widgetContentValues.put(COLUMN_DOMAIN, data_.getDomain());
                widgetContentValues.put(COLUMN_NUMBER_OF_COMMENTS, data_.getNumComments());
                widgetContentValues.put(COLUMN_USERNAME, "0");
                getActivity().getContentResolver().insert(CONTENT_URI, widgetContentValues);
            }
        }
    }

    @Override
    public void usernameReady(String username) {
        this.username = username;
        fillRecycler(username, accessToken);
    }

    private void fillRecycler(String username, String accessToken) {
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
                                    save(savedPost);
                                    saveRecyclerState(savedInstanceState, myRecyclerView, recyclerLayoutManager);
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

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if (id == 1) {
            return new CursorLoader(getActivity(), CONTENT_URI,
                    null,
                    "ID>?",
                    new String[]{"1"},
                    ID);
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor mCursor) {
        List<Child> children = new ArrayList<>();
        while (mCursor.moveToNext()) {
            int titleIndex = mCursor.getColumnIndex(COLUMN_TITLE);
            int subredditIndex = mCursor.getColumnIndex(COLUMN_SUBREDDIT_NAME_PREFIXED);
            int domainIndex = mCursor.getColumnIndex(COLUMN_DOMAIN);
            String title = mCursor.getString(titleIndex);
            String subredditNamePre = mCursor.getString(subredditIndex);
            String domain = mCursor.getString(domainIndex);
            com.zain.reddit.models.saved_posts.Data_ data_ = new Data_();
            data_.setTitle(title);
            data_.setSubredditNamePrefixed(subredditNamePre);
            data_.setDomain(domain);
            Child child = new Child();
            child.setData(data_);
            children.add(child);
        }
        if (children != null && children.size() > 0) {
            recyclerLayoutManager = new LinearLayoutManager(getActivity());
            myRecyclerView.setLayoutManager(recyclerLayoutManager);
            myRecyclerView.setItemAnimator(new DefaultItemAnimator());
            if (myRecyclerViewAdapter != null)
                myRecyclerViewAdapter.clear();
            myRecyclerViewAdapter = new RecyclerSavedPostsAdapter(getActivity(), children);
            myRecyclerView.setAdapter(myRecyclerViewAdapter);
            saveRecyclerState(savedInstanceState, myRecyclerView, recyclerLayoutManager);
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(getActivity());
            int[] ids = appWidgetManager.getAppWidgetIds(
                    new ComponentName(getActivity(), SavedPostsWidget.class));
            SavedPostsWidget.updateAllWidgets(getActivity(), appWidgetManager, ids);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void accessTokenReady(String accessToken) {
        this.accessToken = accessToken;
        fillRecycler(username, accessToken);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (myRecyclerView.getLayoutManager() != null)
            outState.putParcelable(BUNDLE_RECYCLER_LAYOUT, myRecyclerView.getLayoutManager().onSaveInstanceState());
        super.onSaveInstanceState(outState);
    }


}

