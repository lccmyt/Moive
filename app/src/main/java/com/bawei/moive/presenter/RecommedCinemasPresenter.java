package com.bawei.moive.presenter;


import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.RecommedCinemasBean;
import com.bawei.moive.contract.RecommedCinemasContract;
import com.bawei.moive.model.RecommedCinemasModel;

/**
 * @ProjectName: Demo_050301
 * @Package: com.bawei.demo_050301.presenter
 * @ClassName: Presenter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/3 18:57
 */
public class RecommedCinemasPresenter extends BasePresenter implements RecommedCinemasContract.IPresenter {


    private RecommedCinemasModel mModel;

    public RecommedCinemasPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        mModel = new RecommedCinemasModel();
    }

    @Override
    public void showMovie(int page, int count) {
        mModel.showMovie(page, count, new RecommedCinemasContract.IModel.movieCallBack() {
            @Override
            public void onSuccess(RecommedCinemasBean movieBean) {
                IBaseView view = getView();
                if (view instanceof RecommedCinemasContract.IView) {
                    ((RecommedCinemasContract.IView)view).onSuccess(movieBean);
                }
            }

            @Override
            public void onFailure(String str) {

            }
        });
    }
}
