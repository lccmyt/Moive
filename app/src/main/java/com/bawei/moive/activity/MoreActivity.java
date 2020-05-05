package com.bawei.moive.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bawei.moive.R;
import com.bawei.moive.base.BaseActivity;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.fragment.HotMovieFragment;
import com.bawei.moive.fragment.LoadingMovieFragment;
import com.bawei.moive.fragment.UpcomingMovieFragment;
import com.facebook.drawee.view.SimpleDraweeView;
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

public class MoreActivity extends BaseActivity {


    @BindView(R.id.back)
    SimpleDraweeView back;
    @BindView(R.id.et1)
    EditText et1;
    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;

    private List<String> tabs = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.activity_more;
    }

    @Override
    protected BasePresenter initPresent() {
        return null;
    }

    @Override
    protected void initView() {
        tabs.add("正在热映");
        tabs.add("即将上映");
        tabs.add("热门电影");
        fragmentList.add(new LoadingMovieFragment());
        fragmentList.add(new UpcomingMovieFragment());
        fragmentList.add(new HotMovieFragment());
        tab.addTab(tab.newTab().setText(tabs.get(0)));
        tab.addTab(tab.newTab().setText(tabs.get(1)));
        tab.addTab(tab.newTab().setText(tabs.get(2)));
        vp.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tab.setupWithViewPager(vp);
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
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreActivity.this, SearchActivity.class);
                intent.putExtra("search", et1.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
