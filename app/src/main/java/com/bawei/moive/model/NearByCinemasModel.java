package com.bawei.moive.model;


import com.bawei.moive.bean.NearByBean;
import com.bawei.moive.bean.RecommedCinemasBean;
import com.bawei.moive.contract.NearByCinemasContract;
import com.bawei.moive.contract.RecommedCinemasContract;
import com.bawei.moive.network.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: Demo_050301
 * @Package: com.bawei.demo_050301.model
 * @ClassName: Model
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/3 18:56
 */
public class NearByCinemasModel implements NearByCinemasContract.IModel {


    @Override
    public void showMovie(String longitude, String latitude, int page, int count, movieCallBack callBack) {
        RetrofitManager.getInstance().getApis().showNearCinemas(longitude,latitude,page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NearByBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NearByBean movieBean) {
                        callBack.onSuccess(movieBean);
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
