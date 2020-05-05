package com.bawei.moive.fragment;

import android.view.View;

import com.bawei.moive.R;
import com.bawei.moive.adapter.MoreHotMovieAdapter;
import com.bawei.moive.adapter.MoreLoadingMovieAdapter;
import com.bawei.moive.base.BaseFragment;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.bean.LoadingMovieBean;
import com.bawei.moive.bean.UpcomingBean;
import com.bawei.moive.bean.XBannerBean;
import com.bawei.moive.contract.MovieContract;
import com.bawei.moive.presenter.MoviePresenter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.fragment
 * @ClassName: LoadingMovieFragment
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/24 16:26
 */
public class HotMovieFragment extends BaseFragment implements MovieContract.IView {
    @BindView(R.id.rv)
    RecyclerView rv;
    private MoreHotMovieAdapter moreHotMovieAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_loadingmovie;
    }

    @Override
    protected BasePresenter initPresenter() {
        return new MoviePresenter(this);
    }

    @Override
    protected void initView(View v) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        moreHotMovieAdapter = new MoreHotMovieAdapter(getContext());
        rv.setAdapter(moreHotMovieAdapter);

    }

    @Override
    protected void initData() {
        BasePresenter presenter = getPresenter();
        if (presenter instanceof MoviePresenter) {
            ((MoviePresenter) presenter).showHotMovie(1, 30);
        }
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void unEvent() {

    }

    @Override
    public void onLoadingSuccess(LoadingMovieBean loadingMovieBean) {

    }

    @Override
    public void onLoadingFailure(String str) {

    }

    @Override
    public void onUpcomingSuccess(UpcomingBean upcomingBean) {

    }

    @Override
    public void onUpcomingFailure(String str) {

    }

    @Override
    public void onHotSuccess(LoadingMovieBean loadingMovieBean) {
        if (loadingMovieBean != null) {
            moreHotMovieAdapter.setData(loadingMovieBean.getResult());
        }
    }

    @Override
    public void onHotFailure(String str) {

    }

    @Override
    public void onSuccess(XBannerBean xBannerBean) {

    }

    @Override
    public void onFailure(String str) {

    }
}
