package com.bawei.moive.presenter;

import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.FilmReviewBean;
import com.bawei.moive.contract.FilmReviewContract;
import com.bawei.moive.model.FilmReviewModel;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.presenter
 * @ClassName: FilmReviewPresenter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/6 20:47
 */
public class FilmReviewPresenter extends BasePresenter implements FilmReviewContract.IPresenter {

    private FilmReviewModel mModel;

    public FilmReviewPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        mModel = new FilmReviewModel();
    }

    @Override
    public void showFilmReview(int movieId, int page, int count) {
        mModel.showFilmReview(movieId, page, count, new FilmReviewContract.IModel.FilmReviewCallBack() {
            @Override
            public void onSuccess(FilmReviewBean filmReviewBean) {
                IBaseView view = getView();
                if (view instanceof FilmReviewContract.IView) {
                    ((FilmReviewContract.IView)view).onSuccess(filmReviewBean);
                }
            }

            @Override
            public void onFailure(String str) {

            }
        });
    }
}
