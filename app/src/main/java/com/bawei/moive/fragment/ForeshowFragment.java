package com.bawei.moive.fragment;

import android.view.View;

import com.bawei.moive.R;
import com.bawei.moive.adapter.ForeshowAdapter;
import com.bawei.moive.base.BaseFragment;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.bean.DetailsMovieBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.fragment
 * @ClassName: ForeshowFragment
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/5 19:29
 */
public class ForeshowFragment extends BaseFragment {
    @BindView(R.id.fragment_foreshow_rv)
    RecyclerView fragmentForeshowRv;
    private ForeshowAdapter foreshowAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_foreshow;
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

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getDetailsBean(DetailsMovieBean.ResultBean Bean) {
        List<DetailsMovieBean.ResultBean.ShortFilmListBean> shortFilmList = Bean.getShortFilmList();
        foreshowAdapter.setData(shortFilmList);
    }

    @Override
    protected void initView(View v) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        fragmentForeshowRv.setLayoutManager(linearLayoutManager);
        foreshowAdapter = new ForeshowAdapter(getContext());
        fragmentForeshowRv.setAdapter(foreshowAdapter);
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
