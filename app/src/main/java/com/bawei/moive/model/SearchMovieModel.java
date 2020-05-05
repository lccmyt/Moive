package com.bawei.moive.model;

import com.bawei.moive.bean.LoadingMovieBean;
import com.bawei.moive.contract.SearchMovieContract;
import com.bawei.moive.network.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.model
 * @ClassName: SearchMovieModel
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/24 22:18
 */
public class SearchMovieModel implements SearchMovieContract.IModel {
    @Override
    public void doLogin(String keyword, int page,int count, searchMovieCallBack callBack) {
        RetrofitManager.getInstance().getApis().searchMovie(keyword, page, count)
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
}
