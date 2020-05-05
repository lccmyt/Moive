package com.bawei.moive.activity;

import android.os.Bundle;

import com.bawei.moive.R;
import com.bawei.moive.base.BaseActivity;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.fragment.CinemaFragment;
import com.bawei.moive.fragment.MovieFragment;
import com.bawei.moive.fragment.MyFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePageActivity extends BaseActivity {


    @BindView(R.id.activity_homepage_vp)
    ViewPager activityHomepageVp;
    @BindView(R.id.activity_homepage_tab)
    TabLayout activityHomepageTab;
    private List<String> tabs = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();


    @Override
    protected int getLayout() {
        return R.layout.activity_home_page;
    }

    @Override
    protected BasePresenter initPresent() {
        return null;
    }

    @Override
    protected void initView() {
        tabs.add("电影");
        tabs.add("影院");
        tabs.add("我的");
        fragmentList.add(new MovieFragment());
        fragmentList.add(new CinemaFragment());
        fragmentList.add(new MyFragment());
        activityHomepageTab.addTab(activityHomepageTab.newTab().setText(tabs.get(0)));
        activityHomepageTab.addTab(activityHomepageTab.newTab().setText(tabs.get(1)));
        activityHomepageTab.addTab(activityHomepageTab.newTab().setText(tabs.get(2)));
        activityHomepageVp.setAdapter(new MyAdapter(getSupportFragmentManager()));
        activityHomepageTab.setupWithViewPager(activityHomepageVp);
    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs.get(position);
        }
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
