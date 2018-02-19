package com.zain.reddit.network;


import com.zain.reddit.models.OAuthToken;
import com.zain.reddit.models.Save;
import com.zain.reddit.models.me.Me;
import com.zain.reddit.models.post_details.PostComment;
import com.zain.reddit.models.posts.Post;
import com.zain.reddit.models.saved_posts.SavedPost;
import com.zain.reddit.models.user_comments.Comment;
import com.zain.reddit.models.user_posts.UserPosts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.zain.reddit.util.Constants.ACCESS_TOKEN;
import static com.zain.reddit.util.Constants.USER_DATA;


/**
 * Created by Zain on 28/01/2018.
 */

public interface RedditAPI {
    //    @Headers("Authorization:ieJgKpGXz7AaKQ")
//    @FormUrlEncoded
    @POST(ACCESS_TOKEN)
    Call<OAuthToken> retreiveAccessToken(@Header("Authorization") String Authorization, @Query("grant_type") String grant_type,
                                         @Query("code") String code,
                                         @Query("redirect_uri") String redirect_uri);

    @POST(ACCESS_TOKEN)
    Call<OAuthToken> retreiveAccessTokenByRefresh(@Header("Authorization") String Authorization,
                                                  @Query("grant_type") String grant_type, @Query("refresh_token") String refresh_token);

    @GET("{filterBY}/" + "{sortBy}" + ".json?limit=25")
    Call<Post> getPosts(@Header("Authorization") String Authorization, @Path(value = "filterBY") String filterBY, @Path(value = "sortBy") String sortBy);

    @GET("{sortBy}" + ".json?limit=25")
    Call<Post> getPostsAuth(@Header("Authorization") String Authorization, @Path(value = "sortBy") String sortBy);

    @GET(USER_DATA)
    Call<Me> getUserDataAuth(@Header("Authorization") String Authorization);

    @GET("user/{username}/submitted" + ".json")
    Call<UserPosts> getUserPostsAuth(@Header("Authorization") String Authorization,
                                     @Path(value = "username") String username);

    @GET("user/{username}/comments" + ".json")
    Call<Comment> getUserCommentsAuth(@Header("Authorization") String Authorization,
                                      @Path(value = "username") String username);

    @GET("user/{username}/saved" + ".json")
    Call<SavedPost> getSavedPostsAuth(@Header("Authorization") String Authorization,
                                      @Path(value = "username") String username);

    @GET("r/{subreddit}/" + "comments" + "/{id}" + ".json")
    Call<List<PostComment>> getPostCommentsAuth(@Header("Authorization") String Authorization,
                                                @Path(value = "subreddit") String subreddit,
                                                @Path(value = "id") String id);


    @POST("api/save")
    Call<Save> savePost(@Header("Authorization") String Authorization,
                        @Query("id") String id,
                        @Query("dir") String dir);

}
