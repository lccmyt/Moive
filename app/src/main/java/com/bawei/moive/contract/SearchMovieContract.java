package com.bawei.moive.contract;

import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.LoadingMovieBean;
import com.bawei.moive.bean.LoginBean;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.contract
 * @ClassName: RegisterContract
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/22 10:07
 */
public interface SearchMovieContract {
    interface IView extends IBaseView {
        void onSuccess(LoadingMovieBean loadingMovieBean);
        void onFailure(String str);

    }
    interface IPresenter{
        void doLogin(String keyword, int page,int count);
    }

    interface IModel {
        void doLogin(String keyword, int page,int count, searchMovieCallBack callBack);
        interface searchMovieCallBack {
            void onSuccess(LoadingMovieBean loadingMovieBean);
            void onFailure(String str);
        }

    }
}
