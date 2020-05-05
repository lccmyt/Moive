package com.bawei.moive.model;

import com.bawei.moive.bean.EmailCodeBean;
import com.bawei.moive.bean.RegisterBean;
import com.bawei.moive.contract.RegisterContract;
import com.bawei.moive.network.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.model
 * @ClassName: RegisterModel
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/22 10:10
 */
public class RegisterModel implements RegisterContract.IModel {
    @Override
    public void doRegister(String nickName, String pwd, String email, String code, registerCallBack callBack) {
        RetrofitManager.getInstance().getApis().register(nickName, pwd, email, code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        callBack.onSuccess(registerBean);
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

    @Override
    public void getEmailCode(String emailPath, emailCodeCallBack callBack) {
        RetrofitManager.getInstance().getApis().getEmailCode(emailPath)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EmailCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(EmailCodeBean emailCodeBean) {
                        callBack.onEmailCodeSuccess(emailCodeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        callBack.onEmailCodeFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
