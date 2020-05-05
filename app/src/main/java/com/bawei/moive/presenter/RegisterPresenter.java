package com.bawei.moive.presenter;

import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.EmailCodeBean;
import com.bawei.moive.bean.RegisterBean;
import com.bawei.moive.contract.RegisterContract;
import com.bawei.moive.model.RegisterModel;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.presenter
 * @ClassName: RegisterPresenter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/22 10:16
 */
public class RegisterPresenter extends BasePresenter implements RegisterContract.IPresenter {

    private RegisterModel mModel;

    public RegisterPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        mModel = new RegisterModel();
    }

    @Override
    public void doRegister(String nickName, String pwd, String email, String code) {
        mModel.doRegister(nickName, pwd, email, code, new RegisterContract.IModel.registerCallBack() {
            @Override
            public void onSuccess(RegisterBean registerBean) {
                IBaseView view = getView();
                if (view instanceof RegisterContract.IView) {
                    ((RegisterContract.IView)view).onSuccess(registerBean);
                }
            }

            @Override
            public void onFailure(String str) {
                IBaseView view = getView();
                if (view instanceof RegisterContract.IView) {
                    ((RegisterContract.IView)view).onFailure(str);
                }
            }
        });
    }

    @Override
    public void getEmailCode(String emailPath) {
        mModel.getEmailCode(emailPath, new RegisterContract.IModel.emailCodeCallBack() {
            @Override
            public void onEmailCodeSuccess(EmailCodeBean emailCodeBean) {
                IBaseView view = getView();
                if (view instanceof RegisterContract.IView) {
                    ((RegisterContract.IView)view).onEmailCodeSuccess(emailCodeBean);
                }
            }

            @Override
            public void onEmailCodeFailure(String str) {
                IBaseView view = getView();
                if (view instanceof RegisterContract.IView) {
                    ((RegisterContract.IView)view).onEmailCodeFailure(str);
                }
            }
        });
    }
}
