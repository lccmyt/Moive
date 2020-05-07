package com.bawei.moive.contract;

import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.FilmReviewBean;
import com.bawei.moive.bean.LoginBean;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.contract
 * @ClassName: RegisterContract
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/22 10:07
 */
public interface FilmReviewContract {
    interface IView extends IBaseView {
        void onSuccess(FilmReviewBean filmReviewBean);
        void onFailure(String str);

    }
    interface IPresenter{
        void showFilmReview(int movieId ,int page ,int count);
    }

    interface IModel {
        void showFilmReview(int movieId,int page,int count,FilmReviewCallBack callBack);
        interface FilmReviewCallBack {
            void onSuccess(FilmReviewBean filmReviewBean);
            void onFailure(String str);
        }

    }
}
