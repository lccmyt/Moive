package com.bawei.moive.fragment;

import android.view.View;

import com.bawei.moive.R;
import com.bawei.moive.adapter.FilmReviewlAdapter;
import com.bawei.moive.base.BaseFragment;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.bean.DetailsMovieBean;
import com.bawei.moive.bean.FilmReviewBean;
import com.bawei.moive.contract.FilmReviewContract;
import com.bawei.moive.presenter.FilmReviewPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
public class FilmReviewFragment extends BaseFragment implements FilmReviewContract.IView {


    @BindView(R.id.fragment_filmreview_rv)
    RecyclerView fragmentFilmreviewRv;
    private FilmReviewlAdapter filmReviewlAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_filmreview;
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
        return new FilmReviewPresenter(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getDetailsBean(DetailsMovieBean.ResultBean Bean) {
        BasePresenter presenter = getPresenter();
        if (presenter instanceof FilmReviewPresenter) {
            ((FilmReviewPresenter) presenter).showFilmReview(Bean.getMovieId(), 1, 8);
        }
    }

    @Override
    protected void initView(View v) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        fragmentFilmreviewRv.setLayoutManager(linearLayoutManager);
        filmReviewlAdapter = new FilmReviewlAdapter(getContext());
        fragmentFilmreviewRv.setAdapter(filmReviewlAdapter);
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

    @Override
    public void onSuccess(FilmReviewBean filmReviewBean) {
        if (filmReviewBean != null) {
            filmReviewlAdapter.setData(filmReviewBean.getResult());
        }
    }

    @Override
    public void onFailure(String str) {

    }
}
