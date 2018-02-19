package com.zain.reddit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zain.reddit.R;
import com.zain.reddit.util.AppApplication;
import com.zain.reddit.util.UserStatus;

public class MainActivity extends AppCompatActivity {
    private Button btn_redditLogin, btn_skipForNow;
    UserStatus userStatus;
    AppApplication appApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        btn_skipForNow = findViewById(R.id.btn_skipForNow);
        btn_redditLogin = findViewById(R.id.btn_redditLogin);
        appApplication = AppApplication.getInstance();
        userStatus = appApplication.getUserStatus();
        if (userStatus != null) {
            try {
               /* btn_skipForNow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        userStatus.setFirstTime(false);
                        startActivity(intent);

                    }
                });*/
                btn_redditLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {//   first time and not logged
                        Intent intent = new Intent(MainActivity.this, AuthorizationActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        userStatus.setFirstTime(false);
                        startActivity(intent);

                    }
                });

            } catch (Exception e) {
                Log.d("", e.getMessage());
            }
        }
    }

}




