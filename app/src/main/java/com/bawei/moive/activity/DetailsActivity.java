package com.bawei.moive.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bawei.moive.R;
import com.bawei.moive.base.BaseActivity;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.bean.DetailsMovieBean;
import com.bawei.moive.contract.DetailsContract;
import com.bawei.moive.custom.DrawerLayout;
import com.bawei.moive.fragment.CinemaFragment;
import com.bawei.moive.fragment.ForeshowFragment;
import com.bawei.moive.fragment.IntroduceFragment;
import com.bawei.moive.fragment.MovieFragment;
import com.bawei.moive.fragment.MyFragment;
import com.bawei.moive.fragment.StillFragment;
import com.bawei.moive.presenter.DetailsMoviePresenter;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends BaseActivity implements DetailsContract.IView {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.tv6)
    TextView tv6;
    @BindView(R.id.iv_xin)
    ImageView ivXin;
    @BindView(R.id.tv_xin)
    TextView tvXin;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.bt_Comment2)
    Button btComment2;
    @BindView(R.id.bt_butticket2)
    Button btButticket2;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.drawerHandle)
    ImageView drawerHandle;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.drawerContent)
    LinearLayout drawerContent;
    @BindView(R.id.drawer2)
    RelativeLayout drawer2;
    @BindView(R.id.dl)
    DrawerLayout dl;
    private List<String> tabs = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.activity_details;
    }

    @Override
    protected BasePresenter initPresent() {
        return new DetailsMoviePresenter(this);
    }

    @Override
    protected void initView() {
        int movieId = getIntent().getIntExtra("movieId", 0);
        BasePresenter presenter = getPresenter();
        if (presenter instanceof DetailsMoviePresenter) {
            ((DetailsMoviePresenter)presenter).detailsMovie(movieId);
        }
    }

    @Override
    protected void initData() {
    //抽屉的tabLayout
        tabs.add("介绍");
        tabs.add("预告");
        tabs.add("剧照");
        tabs.add("影评");
        fragmentList.add(new IntroduceFragment());
        fragmentList.add(new ForeshowFragment());
        fragmentList.add(new StillFragment());
        fragmentList.add(new MyFragment());
        tab.addTab(tab.newTab().setText(tabs.get(0)));
        tab.addTab(tab.newTab().setText(tabs.get(1)));
        tab.addTab(tab.newTab().setText(tabs.get(2)));
        tab.addTab(tab.newTab().setText(tabs.get(3)));
        vp.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tab.setupWithViewPager(vp);
        vp.setOffscreenPageLimit(4);

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
    public void onSuccess(DetailsMovieBean detailsMovieBean) {
        if (detailsMovieBean != null) {
            Glide.with(this).load(detailsMovieBean.getResult().getImageUrl()).into(iv);
            tv1.setText("评分   " + String.valueOf(detailsMovieBean.getResult().getScore()));
            tv2.setText("评论   " + String.valueOf(detailsMovieBean.getResult().getCommentNum()) + "万条");
            tv3.setText(detailsMovieBean.getResult().getName());
            tv4.setText(detailsMovieBean.getResult().getMovieType());
            tv5.setText(detailsMovieBean.getResult().getDuration());
            Date date = new Date(detailsMovieBean.getResult().getReleaseTime());
            String time = new SimpleDateFormat("yyyy-MM-dd").format(date);
            tv6.setText(time + "   " + detailsMovieBean.getResult().getPlaceOrigin() + "上映");
            EventBus.getDefault().postSticky(detailsMovieBean.getResult());
        }
    }

    @Override
    public void onFailure(String str) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.bt_Comment2, R.id.bt_butticket2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_Comment2:
                break;
            case R.id.bt_butticket2:
                break;
            default:
                break;
        }
    }
}
