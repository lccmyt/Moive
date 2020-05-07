package com.bawei.moive.model;

import com.bawei.moive.bean.WhiteEvalutionBean;
import com.bawei.moive.contract.WhiteEvaluationContract;
import com.bawei.moive.network.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.model
 * @ClassName: WhiteEvaluationModel
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/7 19:53
 */
public class WhiteEvaluationModel implements WhiteEvaluationContract.IModel {
    @Override
    public void WhiteEvaluation(int movieId, String commentContent, double score, whiteEvalationCallBack callBack) {
        RetrofitManager.getInstance().getApis().whiteEvalution(movieId, commentContent, score)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WhiteEvalutionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WhiteEvalutionBean whiteEvalutionBean) {
                          callBack.onSuccess(whiteEvalutionBean);
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
