package com.zain.reddit.util;

/**
 * Created by Zain on 26/01/2018.
 */

public class Constants {
    public static final String OAUTH_URL = "https://oauth.reddit.com/";
    public static final String BASE_URL = "https://www.reddit.com/";

    public static final String ACCESS_TOKEN = "api/v1/access_token/";
    public static String CLIENT_ID = "ieJgKpGXz7AaKQ";
    public static String REDIRECT_URI = "http://localhost-8080.com/";
    public static String SCOPE = "identity edit flair history modconfig modflair modlog" +
            " modposts modwiki mysubreddits privatemessages read report save submit subscribe vote wikiedit wikiread";
    public static String DURATION = "permanent";
    public static String REDDIT_PREFERENCE = "RedditPreference";
    public static String GRANT_TYPE = "authorization_code";
    public static String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";

    public static final String USER_DATA = "https://oauth.reddit.com/api/v1/me.json";





    public static final String POPULAR_POSTS = "r/popular";
    public static final String ALL_POSTS = "r/all";

    public static final String HOT_POSTS = "hot";
    public static final String NEW_POSTS = "new";
    public static final String TOP_POSTS = "top";
    public static final String CONTROVERSIAL_POSTS = "controversial";


}
