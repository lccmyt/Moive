package com.bawei.moive.presenter;

import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.DetailsMovieBean;
import com.bawei.moive.contract.DetailsContract;
import com.bawei.moive.model.DetailsMovieModel;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.presenter
 * @ClassName: DetailsMoviePresenter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/25 18:04
 */
public class DetailsMoviePresenter extends BasePresenter implements DetailsContract.IPresenter {

    private DetailsMovieModel mModel;

    public DetailsMoviePresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        mModel = new DetailsMovieModel();
    }

    @Override
    public void detailsMovie(int movieId) {
    mModel.detailsMovie(movieId, new DetailsContract.IModel.detailsMovieCallBack() {
        @Override
        public void onSuccess(DetailsMovieBean detailsMovieBean) {
            IBaseView view = getView();
            if (view instanceof DetailsContract.IView) {
                ((DetailsContract.IView)view).onSuccess(detailsMovieBean);
            }
        }

        @Override
        public void onFailure(String str) {
            IBaseView view = getView();
            if (view instanceof DetailsContract.IView) {
                ((DetailsContract.IView)view).onFailure(str);
            }
        }
    });
    }
}
