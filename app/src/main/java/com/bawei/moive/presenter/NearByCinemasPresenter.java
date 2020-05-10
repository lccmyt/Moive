package com.bawei.moive.presenter;


import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.NearByBean;
import com.bawei.moive.bean.RecommedCinemasBean;
import com.bawei.moive.contract.NearByCinemasContract;
import com.bawei.moive.contract.RecommedCinemasContract;
import com.bawei.moive.model.NearByCinemasModel;
import com.bawei.moive.model.RecommedCinemasModel;

/**
 * @ProjectName: Demo_050301
 * @Package: com.bawei.demo_050301.presenter
 * @ClassName: Presenter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/3 18:57
 */
public class NearByCinemasPresenter extends BasePresenter implements NearByCinemasContract.IPresenter {


    private NearByCinemasModel mModel;

    public NearByCinemasPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        mModel = new NearByCinemasModel();
    }


    @Override
    public void showMovie(String longitude, String latitude, int page, int count) {
        mModel.showMovie(longitude,latitude, page, count, new NearByCinemasContract.IModel.movieCallBack() {
            @Override
            public void onSuccess(NearByBean movieBean) {
                IBaseView view = getView();
                if (view instanceof NearByCinemasContract.IView) {
                    ((NearByCinemasContract.IView)view).onSuccess(movieBean);
                }
            }

            @Override
            public void onFailure(String str) {

            }
        });
    }
}
