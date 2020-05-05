package com.bawei.moive.fragment;

import android.view.View;

import com.bawei.moive.R;
import com.bawei.moive.adapter.StillAdapter;
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
 * @ClassName: ForeshowFragment
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/5 19:29
 */
public class StillFragment extends BaseFragment {


    @BindView(R.id.fragment_still_rv)
    RecyclerView fragmentStillRv;
    private StillAdapter stillAdapter;
    List<DetailsMovieBean.ResultBean> list = new ArrayList<>();
    @Override
    protected int getLayout() {
        return R.layout.fragment_still;
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
        list.add(Bean);
        stillAdapter.setData(list);
    }

    @Override
    protected void initView(View v) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        fragmentStillRv.setLayoutManager(gridLayoutManager);
        stillAdapter = new StillAdapter(getContext());
        fragmentStillRv.setAdapter(stillAdapter);
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
