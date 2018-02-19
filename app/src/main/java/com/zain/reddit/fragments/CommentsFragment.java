package com.zain.reddit.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zain.reddit.R;
import com.zain.reddit.adapters.RecyclerUserCommentsAdapter;
import com.zain.reddit.models.interfaces.IAccesTokenReady;
import com.zain.reddit.models.user_comments.Comment;
import com.zain.reddit.models.user_comments.Data;
import com.zain.reddit.network.ApiCalling;
import com.zain.reddit.network.RedditAPI;
import com.zain.reddit.network.RedditRestClient;
import com.zain.reddit.provider.DatabaseMethods;
import com.zain.reddit.util.AppApplication;
import com.zain.reddit.util.UserStatus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zain.reddit.util.HelpMethods.BUNDLE_RECYCLER_LAYOUT;
import static com.zain.reddit.util.HelpMethods.saveRecyclerState;

public class CommentsFragment extends Fragment implements DatabaseMethods.UsernameReady, IAccesTokenReady {


    private LinearLayoutManager recyclerLayoutManager;
    private RecyclerUserCommentsAdapter myRecyclerViewAdapter;
    private RecyclerView myRecyclerView;
    UserStatus userStatus;
    ApiCalling apiCalling;
    private DatabaseMethods db;
    String accessToken, username;
    private AppApplication appApplication;
    private Bundle savedInstanceState;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comments, container, false);
        myRecyclerView = view.findViewById(R.id.comments_recycler);
        appApplication = AppApplication.getInstance();
        userStatus = appApplication.getUserStatus();
        apiCalling = new ApiCalling(getActivity(), userStatus);
        apiCalling.setAccessToken(this);
        apiCalling.getAccesToken();
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void fillRecyclerView(Comment comment) {
        if (comment != null) {
            Data data = comment.getData();
            if (data != null) {
                List<com.zain.reddit.models.user_comments.Child> children = data.getChildren();
                if (children != null && children.size() > 0) {
                    recyclerLayoutManager = new LinearLayoutManager(getActivity());
                    myRecyclerView.setLayoutManager(recyclerLayoutManager);
                    myRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    if (myRecyclerViewAdapter != null)
                        myRecyclerViewAdapter.clear();
                    myRecyclerViewAdapter = new RecyclerUserCommentsAdapter(getActivity(), children);

                    myRecyclerView.setAdapter(myRecyclerViewAdapter);

                }


            }
        }
    }

    @Override
    public void usernameReady(String username) {
        this.username = username;
        getComments();
    }

    @Override
    public void accessTokenReady(String accessToken) {
        this.accessToken = accessToken;
        getComments();
    }

    void getComments() {
        if (null != accessToken && !accessToken.equals("") && null != username && !username.equals("")) {

            RedditRestClient redditRestClient = new RedditRestClient(true);
            RedditAPI redditAPI = redditRestClient.getRedditApi();
            if (redditAPI != null) {
                Call<Comment> call = redditAPI.getUserCommentsAuth("bearer " + accessToken, username);
                try {
                    call.enqueue(new Callback<Comment>() {
                        @Override
                        public void onResponse(Call<Comment> call, Response<Comment> response) {
                            if (response == null) {
                                Log.d("response", "null");
                            } else {
                                Comment comment = response.body();
                                if (comment != null) {
                                    fillRecyclerView(comment);
                                    saveRecyclerState(savedInstanceState, myRecyclerView, recyclerLayoutManager);

                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<Comment> call, Throwable t) {
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
    public void onDestroy() {
        super.onDestroy();
        appApplication = null;
        userStatus = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (myRecyclerView.getLayoutManager() != null)
            outState.putParcelable(BUNDLE_RECYCLER_LAYOUT, myRecyclerView.getLayoutManager().onSaveInstanceState());
        super.onSaveInstanceState(outState);
    }
}
