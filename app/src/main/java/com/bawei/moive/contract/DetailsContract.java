package com.bawei.moive.contract;

import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.DetailsMovieBean;
import com.bawei.moive.bean.LoginBean;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.contract
 * @ClassName: RegisterContract
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/22 10:07
 */
public interface DetailsContract {
    interface IView extends IBaseView {
        void onSuccess(DetailsMovieBean detailsMovieBean);
        void onFailure(String str);
    }
    interface IPresenter{
        void detailsMovie(int movieId);
    }

    interface IModel {
        void detailsMovie(int movieId, detailsMovieCallBack callBack);
        interface detailsMovieCallBack {
            void onSuccess(DetailsMovieBean detailsMovieBean);
            void onFailure(String str);
        }

    }
}
