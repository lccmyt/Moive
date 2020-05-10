package com.bawei.moive.contract;

import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.NearByBean;
import com.bawei.moive.bean.RecommedCinemasBean;

/**
 * @ProjectName: Demo_050301
 * @Package: com.bawei.demo_050301.contract
 * @ClassName: Contract
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/3 18:46
 */
public interface NearByCinemasContract {
    interface IView extends IBaseView {
        void onSuccess(NearByBean nearByBean);
        void onFailure(String str);
    }

    interface IPresenter {
        void showMovie(String longitude,String latitude,int page, int count);
    }

    interface IModel {
        void showMovie(String longitude,String latitude,int page, int count, movieCallBack callBack);
        interface movieCallBack {
            void onSuccess(NearByBean nearByBean);
            void onFailure(String str);
        }
    }
}
