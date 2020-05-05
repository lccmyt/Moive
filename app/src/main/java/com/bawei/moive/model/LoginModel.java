package com.bawei.moive.model;

import com.bawei.moive.bean.LoginBean;
import com.bawei.moive.contract.LoginContract;
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
public class LoginModel implements LoginContract.IModel {
    @Override
    public void doLogin(String email, String pwd, loginCallBack callBack) {
        RetrofitManager.getInstance().getApis().doLogin(email, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onSuccess(loginBean);
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
