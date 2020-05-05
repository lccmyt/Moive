package com.bawei.moive.presenter;

import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.LoginBean;
import com.bawei.moive.contract.LoginContract;
import com.bawei.moive.model.LoginModel;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.presenter
 * @ClassName: LoginPresenter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/22 14:34
 */
public class LoginPresenter extends BasePresenter implements LoginContract.IPresenter {

    private LoginModel mModel;

    public LoginPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        mModel = new LoginModel();
    }

    @Override
    public void doLogin(String email, String pwd) {
        mModel.doLogin(email, pwd, new LoginContract.IModel.loginCallBack() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                IBaseView view = getView();
                if (view instanceof LoginContract.IView) {
                    ((LoginContract.IView)view).onSuccess(loginBean);
                }
            }

            @Override
            public void onFailure(String str) {
                IBaseView view = getView();
                if (view instanceof LoginContract.IView) {
                    ((LoginContract.IView)view).onFailure(str);
                }
            }
        });
    }
}
