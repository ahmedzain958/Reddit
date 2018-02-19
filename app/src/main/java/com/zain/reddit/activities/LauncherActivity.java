package com.zain.reddit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zain.reddit.R;
import com.zain.reddit.util.AppApplication;
import com.zain.reddit.util.UserStatus;

import static com.zain.reddit.util.HelpMethods.isNetworkAvailable;
import static com.zain.reddit.util.UserStatus.NOT_LOGGED;

public class LauncherActivity extends AppCompatActivity {
    UserStatus userStatus;
    private AppApplication appApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        appApplication = AppApplication.getInstance();
        userStatus = appApplication.getUserStatus();
        if (isNetworkAvailable(this)) {
            if (userStatus != null) {
                if (userStatus.getFirstTime() ||
                        (userStatus.getUserStatus().equals(NOT_LOGGED) && !userStatus.getFirstTime())) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                finish();
            }
        } else {
            Toast.makeText(appApplication, "no network", Toast.LENGTH_SHORT).show();
        }
    }


}
