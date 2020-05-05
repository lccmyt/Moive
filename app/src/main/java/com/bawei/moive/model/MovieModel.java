package com.bawei.moive.model;

import com.bawei.moive.bean.LoadingMovieBean;
import com.bawei.moive.bean.LoginBean;
import com.bawei.moive.bean.UpcomingBean;
import com.bawei.moive.bean.XBannerBean;
import com.bawei.moive.contract.LoginContract;
import com.bawei.moive.contract.MovieContract;
import com.bawei.moive.network.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.model
 * @ClassName: LoginModel
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/22 14:33
 */
public class MovieModel implements MovieContract.IModel {
    @Override
    public void showLoadingMovie(int page, int count, movieCallBack callBack) {
        RetrofitManager.getInstance().getApis().showLoadingMovie(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoadingMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoadingMovieBean loadingMovieBean) {
                        callBack.onSuccess(loadingMovieBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void showUpcomingMovie(int page, int count, upComingCallBack callBack) {
        RetrofitManager.getInstance().getApis().showUpcomingMovie(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UpcomingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UpcomingBean upcomingBean) {
                        callBack.onSuccess(upcomingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void showHotMovie(int page, int count, movieCallBack callBack) {
        RetrofitManager.getInstance().getApis().showHotMovie(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoadingMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoadingMovieBean loadingMovieBean) {
                        callBack.onSuccess(loadingMovieBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void showBanner(BannerCallBack callBack) {
        RetrofitManager.getInstance().getApis().xBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<XBannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(XBannerBean xBannerBean) {
                        callBack.onSuccess(xBannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        callBack.onFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
