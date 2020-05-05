package com.bawei.moive.contract;

import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.EmailCodeBean;
import com.bawei.moive.bean.RegisterBean;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.contract
 * @ClassName: RegisterContract
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/22 10:07
 */
public interface RegisterContract {
    interface IView extends IBaseView {
        void onSuccess(RegisterBean registerBean);
        void onFailure(String str);

        void onEmailCodeSuccess(EmailCodeBean emailCodeBean);
        void onEmailCodeFailure(String str);
    }
    interface IPresenter{
        void doRegister(String nickName, String pwd, String email, String code);
        void getEmailCode(String emailPath);
    }

    interface IModel {
        void doRegister(String nickName, String pwd, String email, String code,registerCallBack callBack);
        void getEmailCode(String emailPath,emailCodeCallBack callBack);
        interface registerCallBack {
            void onSuccess(RegisterBean registerBean);
            void onFailure(String str);
        }
        interface emailCodeCallBack{
            void onEmailCodeSuccess(EmailCodeBean emailCodeBean);
            void onEmailCodeFailure(String str);
        }
    }
}
