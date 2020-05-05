package com.bawei.moive.model;

import com.bawei.moive.contract.DetailsContract;
import com.bawei.moive.network.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.model
 * @ClassName: DetailsMovieModel
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/25 18:03
 */
public class DetailsMovieModel implements DetailsContract.IModel {
    @Override
    public void detailsMovie(int movieId, detailsMovieCallBack callBack) {
        RetrofitManager.getInstance().getApis().detailsMovieBean(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<com.bawei.moive.bean.DetailsMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(com.bawei.moive.bean.DetailsMovieBean detailsMovieBean) {
callBack.onSuccess(detailsMovieBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
