package com.zain.reddit.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zain.reddit.fragments.CommentsFragment;
import com.zain.reddit.fragments.PostsFragment;
import com.zain.reddit.fragments.SavedPostsFragment;

/**
 * Created by Zain on 29/01/2018.
 */

public class LoginPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public LoginPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PostsFragment postsFragment = new PostsFragment();
                return postsFragment;
            case 1:
                CommentsFragment commentsFragment = new CommentsFragment();
                return commentsFragment;
            case 2:
                SavedPostsFragment savedPostsFragment = new SavedPostsFragment();
                return savedPostsFragment;
            default:
                PostsFragment postsFragment1 = new PostsFragment();
                return postsFragment1;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}