package com.bawei.moive.fragment;

import android.view.View;
import android.widget.TextView;

import com.bawei.moive.R;
import com.bawei.moive.adapter.DaoYanAdapter;
import com.bawei.moive.adapter.YanYuanAdapter;
import com.bawei.moive.base.BaseFragment;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.bean.DetailsMovieBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.fragment
 * @ClassName: IntroduceFragment
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/25 22:10
 */
public class IntroduceFragment extends BaseFragment {
    @BindView(R.id.tv_jianjie)
    TextView tvJianjie;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv_yanzhi)
    TextView tvYanzhi;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.rc1)
    RecyclerView rc1;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.rc2)
    RecyclerView rc2;
    private List<DetailsMovieBean.ResultBean.MovieDirectorBean> movieDirector = new ArrayList<>();
    private List<DetailsMovieBean.ResultBean.MovieActorBean> movieActor = new ArrayList<>();
    private DaoYanAdapter daoYanAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_details_introduce;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getDetailsBean(DetailsMovieBean.ResultBean Bean) {
        tv1.setText(Bean.getSummary());
        //导演
        movieDirector = Bean.getMovieDirector();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rc1.setLayoutManager(linearLayoutManager);
        daoYanAdapter = new DaoYanAdapter(getContext());
        daoYanAdapter.setData(movieDirector);
        rc1.setAdapter(daoYanAdapter);
        //演员
        movieActor = Bean.getMovieActor();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        rc2.setLayoutManager(gridLayoutManager);
        YanYuanAdapter yanYuanAdapter = new YanYuanAdapter(getContext());
        yanYuanAdapter.setData(movieActor);
        rc2.setAdapter(yanYuanAdapter);
        tv2.setText("导演  ("+ String.valueOf(movieDirector.size())+")");
        tv3.setText("演员  ("+ String.valueOf(movieActor.size())+")");
    }

    @Override
    protected void initView(View v) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void unEvent() {

    }
}
