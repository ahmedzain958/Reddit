package com.zain.reddit.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zain.reddit.R;
import com.zain.reddit.activities.LauncherActivity;
import com.zain.reddit.activities.PostDetailActivity;
import com.zain.reddit.adapters.RecyclerPostsAdapter;
import com.zain.reddit.models.Save;
import com.zain.reddit.models.interfaces.IAccesTokenReady;
import com.zain.reddit.models.posts.Child;
import com.zain.reddit.models.posts.Data;
import com.zain.reddit.models.posts.Post;
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

import static com.zain.reddit.util.Constants.CONTROVERSIAL_POSTS;
import static com.zain.reddit.util.Constants.HOT_POSTS;
import static com.zain.reddit.util.Constants.NEW_POSTS;
import static com.zain.reddit.util.Constants.TOP_POSTS;
import static com.zain.reddit.util.HelpMethods.BUNDLE_RECYCLER_LAYOUT;
import static com.zain.reddit.util.HelpMethods.savePostForWidget;
import static com.zain.reddit.util.HelpMethods.saveRecyclerState;

public class UserSubredditsFragment extends Fragment implements RecyclerPostsAdapter.Listener, IAccesTokenReady, DatabaseMethods.UsernameReady {

    public static final String POST = "post";
    private LinearLayoutManager recyclerLayoutManager;
    private RecyclerPostsAdapter myRecyclerViewAdapter;
    private RecyclerView myRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private LinearLayout sortByLinear;
    private TextView sortByTxt;
    static String sortBy = HOT_POSTS;
    String accessToken;
    UserStatus userStatus;
    ApiCalling apiCalling;
    private AppApplication appApplication;
    private Bundle savedInstanceState;
    private String username;
    private DatabaseMethods db;
    String id_;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_subreddits, container, false);
        appApplication = AppApplication.getInstance();
        userStatus = appApplication.getUserStatus();
        myRecyclerView = view.findViewById(R.id.postsRecycler);
        sortByTxt = view.findViewById(R.id.sortByTxt);
        sortByLinear = view.findViewById(R.id.sortByLinear);
        mSwipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        apiCalling = new ApiCalling(getActivity(), userStatus);

        sortByLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(getResources().getString(R.string.sortBy));
            }
        });
        apiCalling.setAccessToken(this);
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                apiCalling.getAccesToken();
            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPosts(sortBy);

            }
        });
        this.savedInstanceState = savedInstanceState;
        return view;
    }

    public void showDialog(String msg) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setTitle(msg);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog);

        LinearLayout hotLinear = dialog.findViewById(R.id.hotLinear);
        hotLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortBy = HOT_POSTS;
                sortByTxt.setText(getResources().getString(R.string.hot_posts));
                getPosts(sortBy);
                dialog.dismiss();
            }
        });
        LinearLayout newLinear = dialog.findViewById(R.id.newLinear);
        newLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortBy = NEW_POSTS;
                sortByTxt.setText(getResources().getString(R.string.new_posts));
                getPosts(NEW_POSTS);
                dialog.dismiss();
            }
        });
        LinearLayout topLinear = dialog.findViewById(R.id.topLinear);
        topLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortBy = TOP_POSTS;

                sortByTxt.setText(getResources().getString(R.string.top_posts));

                getPosts(TOP_POSTS);
                dialog.dismiss();
            }
        });
        LinearLayout controversialLinear = dialog.findViewById(R.id.controversialLinear);
        controversialLinear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sortBy = CONTROVERSIAL_POSTS;
                sortByTxt.setText(getResources().getString(R.string.controversial_posts));
                getPosts(CONTROVERSIAL_POSTS);
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    private void getPosts(String sortBY) {
        RedditRestClient redditRestClient = new RedditRestClient(true);
        RedditAPI redditAPI = redditRestClient.getRedditApi();
        if ("".equals(accessToken) && null != accessToken) {

            Intent intent = new Intent(getActivity(), LauncherActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            if (redditAPI != null) {
                Call<Post> call = redditAPI.getPostsAuth("bearer " + accessToken, sortBY);
                try {
                    call.enqueue(new Callback<Post>() {
                        @Override
                        public void onResponse(Call<Post> call, Response<Post> response) {
                            if (response == null) {
                                Log.d("response", "null");
                            } else {
                                Post post = response.body();
                                fillRecyclerView(post);
                                saveRecyclerState(savedInstanceState, myRecyclerView, recyclerLayoutManager);

                            }
                        }

                        @Override
                        public void onFailure(Call<Post> call, Throwable t) {
                            Log.d("onFailure", "onFailure");
                        }


                    });
                } catch (Exception e) {
                    Log.d("onFailure", e.getMessage());

                }
            }
        }
    }

    private void fillRecyclerView(Post post) {
        if (post != null) {
            Data data = post.getData();
            if (data != null) {
                final List<Child> children = data.getChildren();
                if (children != null && children.size() > 0) {
                    recyclerLayoutManager = new LinearLayoutManager(getActivity());
                    myRecyclerView.setLayoutManager(recyclerLayoutManager);
                    myRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    if (myRecyclerViewAdapter != null)
                        myRecyclerViewAdapter.clear();
                    myRecyclerViewAdapter = new RecyclerPostsAdapter(getActivity(), children, this);

                    myRecyclerView.setAdapter(myRecyclerViewAdapter);
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }
        }
    }

    private void savePostWidget(String id) {
        if (username != null && !username.equals("") && id != null && !id.equals("")) {
            RedditRestClient redditRestClient = new RedditRestClient(true);
            RedditAPI redditAPI = redditRestClient.getRedditApi();
            if (redditAPI != null) {
                Call<Save> call = redditAPI.savePost("bearer " + accessToken, id, "1");
                try {
                    call.enqueue(new Callback<Save>() {
                        @Override
                        public void onResponse(Call<Save> call, Response<Save> response) {
                            if (response == null) {
                                Log.d("response", "null");
                            } else {
                                Save post = response.body();
                                if (post != null) {
                                    savePostForWidget(getActivity(), username, accessToken);
                                    Toast.makeText(getActivity(), "Post Saved Successfully", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<Save> call, Throwable t) {
                            Log.d("onFailure", "onFailure");
                        }


                    });
                } catch (Exception e) {
                    Log.d("onFailure", e.getMessage());

                }
            }
        }
    }

    private void getUsername() {
        if (userStatus != null) {
            db = new DatabaseMethods(this);
            db.getUsername(getActivity());
        }
    }

    @Override
    public void onItemClicked(Child child) {
        if (child != null) {
            try {
                Intent intent = new Intent(getActivity(), PostDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent.putExtra(POST, child));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onLongClick(Child child) {
        if (child != null) {
            String id = child.getData().getName();
            id_ = id;
            getUsername();
        }
    }

    @Override
    public void accessTokenReady(String accessToken) {
        this.accessToken = accessToken;
        if (userStatus != null) {
            getPosts(sortBy);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(POST, sortBy);
        if (myRecyclerView.getLayoutManager() != null)
            outState.putParcelable(BUNDLE_RECYCLER_LAYOUT, myRecyclerView.getLayoutManager().onSaveInstanceState());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.containsKey(POST)) {
            if (savedInstanceState.getString(POST) != null)
                sortByTxt.setText(savedInstanceState.getString(POST));
        }
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void usernameReady(String username) {
        this.username = username;
        savePostWidget(id_);
    }
}
