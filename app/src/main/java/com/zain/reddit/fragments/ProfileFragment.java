package com.zain.reddit.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.squareup.picasso.Picasso;
import com.zain.reddit.R;
import com.zain.reddit.adapters.LoginPagerAdapter;
import com.zain.reddit.models.interfaces.IAccesTokenReady;
import com.zain.reddit.models.me.Me;
import com.zain.reddit.models.me.Subreddit;
import com.zain.reddit.network.ApiCalling;
import com.zain.reddit.provider.DatabaseMethods;
import com.zain.reddit.provider.RedditContract;
import com.zain.reddit.util.AppApplication;
import com.zain.reddit.util.UserStatus;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.zain.reddit.provider.DatabaseMethods.getUsername;
import static com.zain.reddit.provider.RedditContract.SavedPostsEntry.CONTENT_URI;
import static com.zain.reddit.util.Constants.USER_DATA;

public class ProfileFragment extends Fragment implements DatabaseMethods.UsernameReady, IAccesTokenReady {


    private ImageView photo;
    private TextView username, karma, logout;
    private UserStatus userStatus;
    private ApiCalling apiCalling;
    static View view;
    DatabaseMethods db;
    TabLayout tabLayout;
    private AppApplication appApplication;
    private String accessToken;
    private boolean tabsAdded = false;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        tabLayout = view.findViewById(R.id.pager_header);
        username = view.findViewById(R.id.username);
        /*logout = view.findViewById(R.id.logout);*/
        karma = view.findViewById(R.id.karma);
        photo = view.findViewById(R.id.photo);

        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.posts)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.comments)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.saved_posts)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager = view.findViewById(R.id.pager);
        final LoginPagerAdapter adapter = new LoginPagerAdapter
                (getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        appApplication = AppApplication.getInstance();
        userStatus = appApplication.getUserStatus();
        apiCalling = new ApiCalling(getActivity(), userStatus);
        apiCalling.setAccessToken(this);
        apiCalling.getAccesToken();
       /* logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userStatus.logoutUser()) {
                    updateUsername("");
                    Intent intent = new Intent(getActivity(), LauncherActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    Toast.makeText(getActivity(), "logged out", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "failed to logout", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private static void insertUser(Context context, String username) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(RedditContract.SavedPostsEntry.COLUMN_USERNAME, username);
        context.getContentResolver().insert(CONTENT_URI, contentValues);
    }

   /* void updateUsername(String username) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username); //whatever column you want to update, I dont know the name of it
        getActivity().getContentResolver().update(CONTENT_URI, values, "ID=?", new String[]{String.valueOf(1)});
    }
*/
    @Override
    public void usernameReady(String username) {

    }

    @Override
    public void accessTokenReady(String accessToken) {
        if (null != accessToken && !accessToken.equals("")) {
            this.accessToken = accessToken;
            FetchUserData fetchUserData = new FetchUserData();
            fetchUserData.setlistener(new IAsyncResponse() {
                @Override
                public void processFinish(final Me me) {
                    if (me != null) {
                        final Subreddit subreddit = me.getSubreddit();
                        if (subreddit != null) {
                            getActivity().runOnUiThread(new Runnable() {
                                public void run() {
                                    Log.d("log", subreddit.getIconImg());
                                    Picasso.with(getActivity()).load(subreddit.getIconImg()).into(photo);
                                    String _username = me.getName();
                                    username.setText(_username);
                                    karma.setText(me.getLinkKarma() + " karma");
                                    String databaseUsername = getUsername(getActivity(), _username);
                                    if (null == databaseUsername || databaseUsername.equals(""))
                                        insertUser(getActivity(), _username);
                                    /*else {
                                        updateUsername(databaseUsername);
                                    }*/
                                }
                            });

                        }
                    }
                }
            });
            fetchUserData.execute("");
        }
    }


    public interface IAsyncResponse {
        void processFinish(Me me);
    }

    public class FetchUserData extends AsyncTask<String, Void, Me> {
        IAsyncResponse IAsyncResponse;
        public String Param;

        public void setlistener(IAsyncResponse IAsyncResponse) {
            this.IAsyncResponse = IAsyncResponse;
        }


        protected Me doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            String userJsonStr = null;
            try {
                Param = params[0];
                URL url = new URL(USER_DATA);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("Authorization", "bearer " + accessToken);
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    userJsonStr = null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    return null;

                }
                userJsonStr = buffer.toString();
            } catch (IOException e) {
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                    }
                }
            }
            try {
                return getUserDataFromJson(userJsonStr);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Me me) {
            if (me != null) {
                IAsyncResponse.processFinish(me);
            }
        }

        private Me getUserDataFromJson(String userJsonStr)
                throws JSONException {
            JsonParser parser = new JsonParser();
            JsonElement mJson = parser.parse(userJsonStr);
            Gson gson = new Gson();
            Me me = gson.fromJson(mJson, Me.class);
            return me;
        }
    }
}
