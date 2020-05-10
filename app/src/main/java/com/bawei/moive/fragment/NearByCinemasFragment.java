package com.bawei.moive.fragment;

import android.view.View;

import com.bawei.moive.R;
import com.bawei.moive.adapter.NearByCinemasAdapter;
import com.bawei.moive.adapter.RecommedCinemasAdapter;
import com.bawei.moive.base.BaseFragment;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.bean.NearByBean;
import com.bawei.moive.contract.NearByCinemasContract;
import com.bawei.moive.presenter.NearByCinemasPresenter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.fragment
 * @ClassName: RecommedCinemasFragment
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/10 20:18
 */
public class NearByCinemasFragment extends BaseFragment implements NearByCinemasContract.IView {
    @BindView(R.id.rv)
    RecyclerView rv;
    private NearByCinemasAdapter nearByCinemasAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_nearbycinemas;
    }

    @Override
    protected BasePresenter initPresenter() {
        return new NearByCinemasPresenter(this);
    }

    @Override
    protected void initView(View v) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        nearByCinemasAdapter = new NearByCinemasAdapter(getContext());
        rv.setAdapter(nearByCinemasAdapter);
    }

    @Override
    protected void initData() {
        BasePresenter presenter = getPresenter();
        if (presenter instanceof NearByCinemasPresenter) {
            ((NearByCinemasPresenter) presenter).showMovie(null, null, 1, 10);
        }
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void unEvent() {

    }

    @Override
    public void onSuccess(NearByBean nearByBean) {
        if (nearByBean != null) {
            nearByCinemasAdapter.setData(nearByBean.getResult());
        }
    }

    @Override
    public void onFailure(String str) {

    }
}
