package com.zain.reddit.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.zain.reddit.R;
import com.zain.reddit.network.ApiCalling;
import com.zain.reddit.util.AppApplication;
import com.zain.reddit.util.UserStatus;

import static com.zain.reddit.util.Constants.CLIENT_ID;
import static com.zain.reddit.util.Constants.DURATION;
import static com.zain.reddit.util.Constants.REDIRECT_URI;
import static com.zain.reddit.util.Constants.SCOPE;

public class AuthorizationActivity extends AppCompatActivity {
    private WebView webView;
    private String code;
    UserStatus userStatus;
    private AppApplication appApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//not logged
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        setTitle("Going to reddit");
        webView = findViewById(R.id.webView);
        appApplication = AppApplication.getInstance();
        userStatus = appApplication.getUserStatus();
        webView.getSettings().setJavaScriptEnabled(true);
        String url = "https://www.reddit.com/api/v1/authorize.compact?client_id=" + CLIENT_ID +
                "&response_type=code&state=TEST" + "&duration=" + DURATION + "&redirect_uri="
                + REDIRECT_URI + "&scope=" + SCOPE;
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (url.contains("?code=") || url.contains("&code=")) {
                    Uri uri = Uri.parse(url);
                    code = uri.getQueryParameter("code");
                    String state = uri.getQueryParameter("state");
                    try {
                        if (state != null && !state.equals("")) {
                            if (code != null && !code.equals("")) {
                                if (state.equals("TEST")) {
                                    webView.setVisibility(View.GONE);
                                    new ApiCalling(AuthorizationActivity.this, userStatus).loginUser(code);
                                    Log.d("code",code);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (url.contains("error=access_denied")) {
                    Toast.makeText(AuthorizationActivity.this, "error=access_denied", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
