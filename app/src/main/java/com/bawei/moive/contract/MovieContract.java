package com.bawei.moive.contract;

import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.LoadingMovieBean;
import com.bawei.moive.bean.LoginBean;
import com.bawei.moive.bean.UpcomingBean;
import com.bawei.moive.bean.XBannerBean;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.contract
 * @ClassName: RegisterContract
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/22 10:07
 */
public interface MovieContract {
    interface IView extends IBaseView {
        void onLoadingSuccess(LoadingMovieBean loadingMovieBean);
        void onLoadingFailure(String str);
        void onUpcomingSuccess(UpcomingBean upcomingBean);
        void onUpcomingFailure(String str);
        void onHotSuccess(LoadingMovieBean loadingMovieBean);
        void onHotFailure(String str);
        void onSuccess(XBannerBean xBannerBean);
        void onFailure(String str);

    }
    interface IPresenter{
        void showLoadingMovie(int page, int count);
        void showUpcomingMovie(int page, int count);
        void showHotMovie(int page, int count);
        void showBanner();
    }

    interface IModel {
        void showLoadingMovie(int page, int count, movieCallBack callBack);
        void showUpcomingMovie(int page, int count, upComingCallBack callBack);
        void showHotMovie(int page, int count, movieCallBack callBack);
        void showBanner(BannerCallBack callBack);
        interface BannerCallBack {
            void onSuccess(XBannerBean xBannerBean);
            void onFailure(String str);
        }
        interface movieCallBack {
            void onSuccess(LoadingMovieBean loadingMovieBean);
            void onFailure(String str);
        }

        interface upComingCallBack {
            void onSuccess(UpcomingBean upcomingBean);
            void onFailure(String str);
        }

    }
}
