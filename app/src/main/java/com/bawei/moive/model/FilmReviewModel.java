package com.bawei.moive.model;

import com.bawei.moive.bean.FilmReviewBean;
import com.bawei.moive.contract.FilmReviewContract;
import com.bawei.moive.network.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.model
 * @ClassName: FilmReviewModel
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/6 20:46
 */
public class FilmReviewModel implements FilmReviewContract.IModel {
    @Override
    public void showFilmReview(int movieId, int page, int count, FilmReviewCallBack callBack) {
        RetrofitManager.getInstance().getApis().showFilmReview(movieId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FilmReviewBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FilmReviewBean filmReviewBean) {
                        callBack.onSuccess(filmReviewBean);
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
