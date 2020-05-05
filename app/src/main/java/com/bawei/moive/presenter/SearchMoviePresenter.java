package com.bawei.moive.presenter;

import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.LoadingMovieBean;
import com.bawei.moive.contract.SearchMovieContract;
import com.bawei.moive.model.SearchMovieModel;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.presenter
 * @ClassName: SearchMoviePresenter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/24 22:20
 */
public class SearchMoviePresenter extends BasePresenter implements SearchMovieContract.IPresenter {

    private SearchMovieModel mModel;

    public SearchMoviePresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        mModel = new SearchMovieModel();
    }

    @Override
    public void doLogin(String keyword, int page, int count) {
mModel.doLogin(keyword, page, count, new SearchMovieContract.IModel.searchMovieCallBack() {
    @Override
    public void onSuccess(LoadingMovieBean loadingMovieBean) {
        IBaseView view = getView();
        if (view instanceof SearchMovieContract.IView) {
            ((SearchMovieContract.IView)view).onSuccess(loadingMovieBean);
        }
    }

    @Override
    public void onFailure(String str) {
        IBaseView view = getView();
        if (view instanceof SearchMovieContract.IView) {
            ((SearchMovieContract.IView)view).onFailure(str);
        }
    }
});
    }
}
