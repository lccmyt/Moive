package com.bawei.moive.presenter;

import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.LoadingMovieBean;
import com.bawei.moive.bean.LoginBean;
import com.bawei.moive.bean.UpcomingBean;
import com.bawei.moive.bean.XBannerBean;
import com.bawei.moive.contract.LoginContract;
import com.bawei.moive.contract.MovieContract;
import com.bawei.moive.model.LoginModel;
import com.bawei.moive.model.MovieModel;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.presenter
 * @ClassName: LoginPresenter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/22 14:34
 */
public class MoviePresenter extends BasePresenter implements MovieContract.IPresenter {

    private MovieModel mModel;

    public MoviePresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        mModel = new MovieModel();
    }

    @Override
    public void showLoadingMovie(int page , int count) {
        mModel.showLoadingMovie(page, count, new MovieContract.IModel.movieCallBack() {
            @Override
            public void onSuccess(LoadingMovieBean loadingMovieBean) {
                IBaseView view = getView();
                if (view instanceof MovieContract.IView) {
                    ((MovieContract.IView) view).onLoadingSuccess(loadingMovieBean);
                }
            }

            @Override
            public void onFailure(String str) {
                IBaseView view = getView();
                if (view instanceof MovieContract.IView) {
                    ((MovieContract.IView) view).onLoadingFailure(str);
                }
            }
        });
    }


    @Override
    public void showUpcomingMovie(int page, int count) {
        mModel.showUpcomingMovie(page, count, new MovieContract.IModel.upComingCallBack() {
            @Override
            public void onSuccess(UpcomingBean upcomingBean) {
                IBaseView view = getView();
                if (view instanceof MovieContract.IView) {
                    ((MovieContract.IView) view).onUpcomingSuccess(upcomingBean);
                }
            }

            @Override
            public void onFailure(String str) {
                IBaseView view = getView();
                if (view instanceof MovieContract.IView) {
                    ((MovieContract.IView) view).onUpcomingFailure(str);
                }
            }
        });
    }

    @Override
    public void showHotMovie(int page, int count) {
        mModel.showHotMovie(page, count, new MovieContract.IModel.movieCallBack() {
            @Override
            public void onSuccess(LoadingMovieBean loadingMovieBean) {
                IBaseView view = getView();
                if (view instanceof MovieContract.IView) {
                    ((MovieContract.IView) view).onHotSuccess(loadingMovieBean);
                }
            }

            @Override
            public void onFailure(String str) {
                IBaseView view = getView();
                if (view instanceof MovieContract.IView) {
                    ((MovieContract.IView) view).onHotFailure(str);
                }
            }
        });
    }

    @Override
    public void showBanner() {
        mModel.showBanner(new MovieContract.IModel.BannerCallBack() {
            @Override
            public void onSuccess(XBannerBean xBannerBean) {
                IBaseView view = getView();
                if (view instanceof MovieContract.IView) {
                    ((MovieContract.IView)view).onSuccess(xBannerBean);
                }
            }

            @Override
            public void onFailure(String str) {
                IBaseView view = getView();
                if (view instanceof MovieContract.IView) {
                    ((MovieContract.IView)view).onFailure(str);
                }
            }
        });
    }
    }

