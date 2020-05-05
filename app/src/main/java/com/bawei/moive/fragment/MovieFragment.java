package com.bawei.moive.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.maps2d.MapView;
import com.bawei.moive.R;
import com.bawei.moive.activity.MoreActivity;
import com.bawei.moive.activity.SearchActivity;
import com.bawei.moive.adapter.MovieHotAdapter;
import com.bawei.moive.adapter.MovieLoadingAdapter;
import com.bawei.moive.adapter.MovieUpcomingAdapter;
import com.bawei.moive.base.BaseFragment;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.bean.LoadingMovieBean;
import com.bawei.moive.bean.UpcomingBean;
import com.bawei.moive.bean.XBannerBean;
import com.bawei.moive.contract.MovieContract;
import com.bawei.moive.presenter.MoviePresenter;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.fragment
 * @ClassName: MovieFragment
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/22 22:21
 */
public class MovieFragment extends BaseFragment implements MovieContract.IView {
    @BindView(R.id.dingwei)
    ImageView dingwei;
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.map)
    MapView map;
    @BindView(R.id.xbn)
    XBanner xbn;
    @BindView(R.id.more1)
    TextView more1;
    @BindView(R.id.fragment_loading_rv)
    RecyclerView fragmentLoadingRv;
    @BindView(R.id.more2)
    TextView more2;
    @BindView(R.id.fragment_upcoming_rv)
    RecyclerView fragmentUpcomingRv;
    @BindView(R.id.more3)
    TextView more3;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.bt_buy)
    Button btBuy;
    @BindView(R.id.fragment_hot_rv)
    RecyclerView fragmentHotRv;
    @BindView(R.id.search)
    ImageView search;

    private MovieLoadingAdapter movieLoadingAdapter;
    private MovieHotAdapter movieHotAdapter;
    private MovieUpcomingAdapter movieUpcomingAdapter;

    @Override
    protected BasePresenter initPresenter() {
        return new MoviePresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_movie;
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void unEvent() {

    }

    @Override
    protected void initView(View view) {
        LinearLayoutManager LoadinghorizontalLinearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        fragmentLoadingRv.setLayoutManager(LoadinghorizontalLinearLayoutManager);
        LinearLayoutManager HothorizontalLinearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        fragmentHotRv.setLayoutManager(HothorizontalLinearLayoutManager);
        LinearLayoutManager verticalLinearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        fragmentUpcomingRv.setLayoutManager(verticalLinearLayoutManager);
        movieLoadingAdapter = new MovieLoadingAdapter(getContext());
        movieHotAdapter = new MovieHotAdapter(getContext());
        movieUpcomingAdapter = new MovieUpcomingAdapter(getContext());
        fragmentLoadingRv.setAdapter(movieLoadingAdapter);
        fragmentHotRv.setAdapter(movieHotAdapter);
        fragmentUpcomingRv.setAdapter(movieUpcomingAdapter);
    }


    @Override
    protected void initData() {


        BasePresenter presenter = getPresenter();
        if (presenter instanceof MoviePresenter) {
            ((MoviePresenter) presenter).showLoadingMovie(1, 3);
            ((MoviePresenter) presenter).showUpcomingMovie(1, 3);
            ((MoviePresenter) presenter).showHotMovie(1, 3);
            ((MoviePresenter) presenter).showBanner();
        }


    }


    @Override
    public void onLoadingSuccess(LoadingMovieBean loadingMovieBean) {
        if (loadingMovieBean != null) {
            movieLoadingAdapter.setData(loadingMovieBean.getResult());
        }
    }

    @Override
    public void onLoadingFailure(String str) {

    }

    @Override
    public void onUpcomingSuccess(UpcomingBean upcomingBean) {
        if (upcomingBean != null) {
            movieUpcomingAdapter.setData(upcomingBean.getResult());
        }
    }

    @Override
    public void onUpcomingFailure(String str) {

    }

    @Override
    public void onHotSuccess(LoadingMovieBean loadingMovieBean) {
        if (loadingMovieBean != null) {
            movieHotAdapter.setData(loadingMovieBean.getResult());

            Glide.with(this).load(loadingMovieBean.getResult().get(0).getImageUrl()).into(iv);
            tv1.setText(loadingMovieBean.getResult().get(0).getName());
            tv2.setText(String.valueOf(loadingMovieBean.getResult().get(0).getScore()) + "分");
        }
    }

    @Override
    public void onHotFailure(String str) {

    }

    @Override
    public void onSuccess(XBannerBean xBannerBean) {
        if (xBannerBean != null) {
//            xBannerBeanList.add(xBannerBean);
//            xbn.setBannerData((xBannerBeanList);
            List<XBannerBean.ResultBean> result = xBannerBean.getResult();
            xbn.setBannerData(result);

            xbn.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(MovieFragment.this).load(result.get(position).getImageUrl()).into((ImageView) view);
                }
            });
        }
    }

    @Override
    public void onFailure(String str) {

    }

    @OnClick({R.id.more1, R.id.more2, R.id.more3,R.id.search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.more1:
                startActivity(new Intent(getContext(), MoreActivity.class));
                break;
            case R.id.more2:
                startActivity(new Intent(getContext(), MoreActivity.class));
                break;
            case R.id.more3:
                startActivity(new Intent(getContext(), MoreActivity.class));
                break;
            case R.id.search:
                startActivity(new Intent(getContext(), SearchActivity.class));
                break;
            default:
                break;
        }
    }


}
