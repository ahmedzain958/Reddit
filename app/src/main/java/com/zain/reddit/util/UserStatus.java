package com.zain.reddit.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Calendar;

import static android.content.Context.MODE_PRIVATE;
import static com.zain.reddit.util.Constants.REDDIT_PREFERENCE;

/**
 * Created by Zain on 29/01/2018.
 */

public class UserStatus {
    public static final String IS_LOGGED = "is_logged";
    public static final String ACCESS_TOKEN = "access_token";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String DATE = "date";

    public static final String NOT_LOGGED = "not_logged";
    public static final String SESSION_FINISHED = "session_finished";


    public static String IS_FIRST_TIME = "is_first_time";
    public static String CODE = "code";

    public static final String ACCESSING_TIME = "time";
    public static final String FINISHING_TIME = "finishing_time";


    static SharedPreferences pref;
    static SharedPreferences.Editor edit;
    Context context;

    public UserStatus(Context mContext) {
        this.pref = mContext.getSharedPreferences(REDDIT_PREFERENCE, MODE_PRIVATE);
        edit = pref.edit();
        context = mContext;
    }

    public static SharedPreferences getSharedPreference() {
        return pref;
    }

    public static void loginUser(String token, String refreshToken, String code) {
        Calendar now = Calendar.getInstance();
        edit.putLong(ACCESSING_TIME, now.getTimeInMillis());
        edit.putBoolean(IS_LOGGED, true);//logged = true
        if (!code.equals(""))
            edit.putString(CODE, code);
        now.add(Calendar.HOUR, 1);
        edit.putLong(FINISHING_TIME, now.getTimeInMillis());
        edit.putBoolean(NOT_LOGGED, false);
        //access_token && refresh_token
        edit.putString(ACCESS_TOKEN, token);
        if (!refreshToken.equals(""))
            edit.putString(REFRESH_TOKEN, refreshToken);
        edit.commit();
    }

    public boolean logoutUser() {
        try {
            edit.clear();
            pref = context.getSharedPreferences(REDDIT_PREFERENCE, MODE_PRIVATE);
            edit = pref.edit();
            edit.putBoolean(IS_FIRST_TIME, false);
            edit.putBoolean(NOT_LOGGED, true);
            edit.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }


    public static boolean getFirstTime() {
        return getSharedPreference().getBoolean(IS_FIRST_TIME, true);
    }

    public static boolean getLogged() {
        return getSharedPreference().getBoolean(IS_LOGGED, false);
    }


    public static void setFirstTime(boolean isFirstTime) {
        edit.putBoolean(IS_FIRST_TIME, isFirstTime);
        edit.commit();
    }


    public String getUserStatus() {
        Boolean userAuthorized = isAuthorizedUser();


        if (userAuthorized == null) return NOT_LOGGED;

        if (!userAuthorized) return SESSION_FINISHED;

        return "bearer  " + pref.getString(ACCESS_TOKEN, SESSION_FINISHED);
    }

    private Boolean isAuthorizedUser() {

        if (pref.getBoolean(IS_LOGGED, false)) {
            if (pref.getBoolean(NOT_LOGGED, true))
                return null;
            long time = pref.getLong(FINISHING_TIME, 0);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(time);
            return calendar.after(Calendar.getInstance());
        }

        return null;
    }

    public String getRefreshToken() {
        return pref.getString(REFRESH_TOKEN, "");
    }

}
