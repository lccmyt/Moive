package com.bawei.moive.contract;

import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.EmailCodeBean;
import com.bawei.moive.bean.LoginBean;
import com.bawei.moive.bean.RegisterBean;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.contract
 * @ClassName: RegisterContract
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/22 10:07
 */
public interface LoginContract {
    interface IView extends IBaseView {
        void onSuccess(LoginBean loginBean);
        void onFailure(String str);

    }
    interface IPresenter{
        void doLogin(String email, String pwd);
    }

    interface IModel {
        void doLogin(String email, String pwd,loginCallBack callBack);
        interface loginCallBack {
            void onSuccess(LoginBean loginBean);
            void onFailure(String str);
        }

    }
}
