package com.zain.reddit.network;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.zain.reddit.activities.HomeActivity;
import com.zain.reddit.models.OAuthToken;
import com.zain.reddit.models.interfaces.IAccesTokenReady;
import com.zain.reddit.util.UserStatus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zain.reddit.util.Constants.CLIENT_ID;
import static com.zain.reddit.util.Constants.GRANT_TYPE;
import static com.zain.reddit.util.Constants.GRANT_TYPE_REFRESH_TOKEN;
import static com.zain.reddit.util.Constants.REDIRECT_URI;
import static com.zain.reddit.util.UserStatus.ACCESS_TOKEN;
import static com.zain.reddit.util.UserStatus.NOT_LOGGED;
import static com.zain.reddit.util.UserStatus.REFRESH_TOKEN;
import static com.zain.reddit.util.UserStatus.SESSION_FINISHED;

/**
 * Created by Zain on 06/02/2018.
 */

public class ApiCalling {

    UserStatus userStatus;
    Context context;
    String token = "";
    private static IAccesTokenReady iAccesTokenReady_;

    public ApiCalling(Context mContext, UserStatus userStatus) {
        this.userStatus = userStatus;
        this.context = mContext;
    }


    public void setAccessToken(IAccesTokenReady iAccesTokenReady) {
        iAccesTokenReady_ = iAccesTokenReady;

    }

    public void loginUser(final String code) {
        RedditRestClient redditRestClient = new RedditRestClient(false);
        String encodedString = "Basic " + Base64.encodeToString((CLIENT_ID + ":").getBytes(), Base64.NO_WRAP)/*"Basic aWVKZ0twR1h6N0FhS1E6"*/;
        RedditAPI redditAPI = redditRestClient.getRedditApi();
        if (redditAPI != null) {
            Call<OAuthToken> call = redditAPI.retreiveAccessToken(encodedString, GRANT_TYPE, code, REDIRECT_URI);
            call.enqueue(new Callback<OAuthToken>() {
                @Override
                public void onResponse(Call<OAuthToken> call, Response<OAuthToken> response) {
                    if (response == null) {
                        Log.d("response", "null");
                    } else {
                        OAuthToken oAuthToken = response.body();
                        if (oAuthToken != null) {
                            String token = oAuthToken.getAccessToken();
                            String refreshToken = oAuthToken.getRefresh_token();
                            //save acces token in shared preferenec
                            if (token != null) {
                                userStatus.loginUser(token, refreshToken, code);
                                Log.d("token", token);
                                Log.d("refreshToken", refreshToken);
                                Intent intent = new Intent(context, HomeActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                context.startActivity(intent);
                                ((AppCompatActivity) context).finish();
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<OAuthToken> call, Throwable t) {
                    Log.d("onFailure", "failure");
                }
            });
        }
    }


    public String getAccesTokenSessionEnded(String refreshToken) {
        RedditRestClient redditRestClient = new RedditRestClient(false);
        String encodedString = "Basic " + Base64.encodeToString((CLIENT_ID + ":").getBytes(), Base64.NO_WRAP)/*"Basic aWVKZ0twR1h6N0FhS1E6"*/;
        RedditAPI redditAPI = redditRestClient.getRedditApi();
        if (redditAPI != null) {
            Call<OAuthToken> call = redditAPI.retreiveAccessTokenByRefresh(encodedString, GRANT_TYPE_REFRESH_TOKEN, refreshToken);
            call.enqueue(new Callback<OAuthToken>() {
                @Override
                public void onResponse(Call<OAuthToken> call, Response<OAuthToken> response) {
                    if (response == null) {
                        Log.d("response", "null");
                    } else {
                        OAuthToken oAuthToken = response.body();
                        if (oAuthToken.getAccessToken() != null) {
                            token = oAuthToken.getAccessToken();
                            Log.d("token", token);
                            //save acces token in shared preferenec
                            if (token != null) {
                                userStatus.loginUser(token, "", "");
                            }
                        } else {
                            Toast.makeText(context, "null token", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<OAuthToken> call, Throwable t) {
                    Log.d("onFailure", "failure");
                }
            });
        }
        return token;
    }

    public void getAccesToken() {
        if (userStatus.getUserStatus().equals(SESSION_FINISHED))// SESSION_FINISHED
        {
            String refreshToken = userStatus.getSharedPreference().getString(REFRESH_TOKEN, "");
            Log.d("refreshToken", refreshToken);
            if (refreshToken.equals("") || refreshToken == null) {
                iAccesTokenReady_.accessTokenReady("");
            } else {
                token = getAccesTokenSessionEnded(refreshToken);
                if (token != null) {
                    iAccesTokenReady_.accessTokenReady(token);
                }
            }
        } else if (userStatus.getUserStatus().equals(NOT_LOGGED)) {
            iAccesTokenReady_.accessTokenReady("");
        } else {
            token = userStatus.getSharedPreference().getString(ACCESS_TOKEN, "");
            if (token != null) {
                iAccesTokenReady_.accessTokenReady(token);
            }
        }
    }

}
