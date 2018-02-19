package com.zain.reddit.util;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.zain.reddit.R;
import com.zain.reddit.network.ApiCalling;

/**
 * Created by Hazem Ali.
 * On 1/17/2018.
 */

public class AppApplication extends Application {
    UserStatus userStatus;
    static ApiCalling apiCalling;
    static AppApplication instance;
    private static GoogleAnalytics sAnalytics;
    private static Tracker sTracker;

    public static AppApplication getInstance() {
        return instance;
    }




    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        userStatus = new UserStatus(this);
        if (userStatus != null) {
            apiCalling = new ApiCalling(this, userStatus);
        }
        sAnalytics = GoogleAnalytics.getInstance(this);

    }
    synchronized public Tracker getDefaultTracker() {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracker);
        }

        return sTracker;
    }
    public UserStatus getUserStatus() {
        if (userStatus == null) {
            userStatus = new UserStatus(this);
        }
        return userStatus;
    }

    public ApiCalling getApiCalling() {
        if (apiCalling == null)
            apiCalling = new ApiCalling(this, getUserStatus());

        return apiCalling;
    }

}
