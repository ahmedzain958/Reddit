package com.zain.reddit.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;
import com.zain.reddit.R;
import com.zain.reddit.adapters.RecyclerPostCommentsAdapter;
import com.zain.reddit.models.interfaces.IAccesTokenReady;
import com.zain.reddit.models.post_details.PostComment;
import com.zain.reddit.models.posts.Child;
import com.zain.reddit.models.posts.Data_;
import com.zain.reddit.network.ApiCalling;
import com.zain.reddit.network.RedditAPI;
import com.zain.reddit.network.RedditRestClient;
import com.zain.reddit.util.AppApplication;
import com.zain.reddit.util.UserStatus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zain.reddit.fragments.UserSubredditsFragment.POST;
import static com.zain.reddit.util.HelpMethods.BUNDLE_RECYCLER_LAYOUT;
import static com.zain.reddit.util.HelpMethods.saveRecyclerState;


public class PostDetailActivity extends AppCompatActivity implements IAccesTokenReady {
    TextView subreddit_name_prefixed, author, domain, title;
    ImageView url;
    private Child child;
    UserStatus userStatus;
    ApiCalling apiCalling;
    RecyclerView comments_recycler;
    private LinearLayoutManager recyclerLayoutManager;
    private RecyclerPostCommentsAdapter myRecyclerViewAdapter;
    String subreddit, id, accessToken;
    private AppApplication appApplication;
    private Bundle savedInstanceState;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        subreddit_name_prefixed = findViewById(R.id.subreddit_name_prefixed);
        author = findViewById(R.id.author);
        domain = findViewById(R.id.domain);
        title = findViewById(R.id.title);
        url = findViewById(R.id.url);
        comments_recycler = findViewById(R.id.comments_recycler);
        appApplication = AppApplication.getInstance();
        userStatus = appApplication.getUserStatus();
        apiCalling = new ApiCalling(this, userStatus);
        apiCalling.setAccessToken(this);
        runOnUiThread(new Runnable() {
            public void run() {
                apiCalling.getAccesToken();
            }
        });
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            child = (Child) getIntent().getSerializableExtra(POST); //Obtaining data
            Data_ data_ = child.getData();
            String subredditName_prefixed = data_.getSubredditNamePrefixed();
            String author_ = data_.getAuthor();
            String domain_ = data_.getDomain();
            String title_ = data_.getTitle();
            String url_ = data_.getUrl();
            if (subredditName_prefixed != null)
                subreddit_name_prefixed.setText(subredditName_prefixed);
            if (author_ != null)
                author.setText(author_);
            if (domain_ != null)
                domain.setText(domain_);
            if (title_ != null)
                title.setText(title_);
            if (url_ != null)
                Picasso.with(this).load(url_).into(url);
            subreddit = data_.getSubreddit();
            id = data_.getId();
        }
        this.savedInstanceState = savedInstanceState;
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        mAdView.loadAd(adRequest);
    }

    @Override
    protected void onResume() {
        super.onResume();
        accessTokenReady(accessToken);
    }

    @Override
    public void accessTokenReady(String accessToken) {
        this.accessToken = accessToken;
        if (accessToken != null && !"".equals(accessToken)
                && id != null && !"".equals(id)
                && subreddit != null && !"".equals(subreddit)) {
            RedditRestClient redditRestClient = new RedditRestClient(true);
            RedditAPI redditAPI = redditRestClient.getRedditApi();
            if (redditAPI != null) {
                Call<List<PostComment>> call = redditAPI.getPostCommentsAuth("bearer " + accessToken,
                        subreddit, id);
                try {
                    call.enqueue(new Callback<List<PostComment>>() {
                        @Override
                        public void onResponse(Call<List<PostComment>> call, Response<List<PostComment>> response) {
                            if (response == null) {
                                Log.d("response", "null");
                            } else {
                                List<PostComment> comments = response.body();
                                if (comments != null) {
                                    com.zain.reddit.models.post_details.Data data = comments.get(1).getData();
                                    if (data != null) {
                                        List<com.zain.reddit.models.post_details.Child> children = data.getChildren();
                                        if (children != null && children.size() > 0) {
                                            recyclerLayoutManager = new LinearLayoutManager(PostDetailActivity.this);
                                            comments_recycler.setLayoutManager(recyclerLayoutManager);
                                            comments_recycler.setItemAnimator(new DefaultItemAnimator());
                                            myRecyclerViewAdapter = new RecyclerPostCommentsAdapter(PostDetailActivity.this, children);
                                            comments_recycler.setAdapter(myRecyclerViewAdapter);
                                            saveRecyclerState(savedInstanceState, comments_recycler, recyclerLayoutManager);
                                        }
                                    }
                                }

                            }
                        }

                        @Override
                        public void onFailure(Call<List<PostComment>> call, Throwable t) {
                            Log.d("onFailure", t.getMessage());
                            Toast.makeText(PostDetailActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }


                    });
                } catch (Exception e) {
                    Log.d("onFailure", e.getMessage());

                }


            }
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (comments_recycler.getLayoutManager() != null)
            outState.putParcelable(BUNDLE_RECYCLER_LAYOUT, comments_recycler.getLayoutManager().onSaveInstanceState());
        super.onSaveInstanceState(outState);
    }
}
