package com.zain.reddit.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.zain.reddit.util.Constants.BASE_URL;
import static com.zain.reddit.util.Constants.OAUTH_URL;

/**
 * Created by Pratik Agrawal on 11/20/2015.
 */
public class RedditRestClient {
    static RedditAPI redditAPI;

    public RedditRestClient(boolean authorized) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(authorized?OAUTH_URL:BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        redditAPI = retrofit.create(RedditAPI.class);

    }


    public RedditAPI getRedditApi() {
        if (redditAPI != null) {
            return redditAPI;
        }
        return null;
    }



}
