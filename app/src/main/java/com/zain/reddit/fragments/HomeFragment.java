package com.zain.reddit.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zain.reddit.R;
import com.zain.reddit.adapters.TabViewPagerAdapter;

public class HomeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager firstViewPager;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        firstViewPager =  view.findViewById(R.id.viewpager_content);

        tabLayout =  view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(firstViewPager);

        setupViewPager(firstViewPager);
        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        TabViewPagerAdapter adapter = new TabViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new UserSubredditsFragment(), getResources().getString(R.string.title_home));
        adapter.addFragment(new PopularFragment(), getResources().getString(R.string.title_popular));
        viewPager.setAdapter(adapter);
    }

}
