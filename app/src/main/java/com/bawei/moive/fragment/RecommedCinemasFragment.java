package com.bawei.moive.fragment;

import android.view.View;

import com.bawei.moive.R;
import com.bawei.moive.adapter.RecommedCinemasAdapter;
import com.bawei.moive.base.BaseFragment;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.bean.RecommedCinemasBean;
import com.bawei.moive.contract.RecommedCinemasContract;
import com.bawei.moive.presenter.RecommedCinemasPresenter;

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
public class RecommedCinemasFragment extends BaseFragment implements RecommedCinemasContract.IView {
    @BindView(R.id.rv)
    RecyclerView rv;
    private RecommedCinemasAdapter recommedCinemasAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_recommendcinemas;
    }

    @Override
    protected BasePresenter initPresenter() {
        return new RecommedCinemasPresenter(this);
    }

    @Override
    protected void initView(View v) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        recommedCinemasAdapter = new RecommedCinemasAdapter(getContext());
        rv.setAdapter(recommedCinemasAdapter);
    }

    @Override
    protected void initData() {
        BasePresenter presenter = getPresenter();
        if (presenter instanceof RecommedCinemasPresenter) {
            ((RecommedCinemasPresenter)presenter).showMovie(1,10);
        }
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void unEvent() {

    }

    @Override
    public void onSuccess(RecommedCinemasBean recommedCinemasBean) {
        if (recommedCinemasBean != null) {
            recommedCinemasAdapter.setData(recommedCinemasBean.getResult());
        }
    }

    @Override
    public void onFailure(String str) {

    }
}
