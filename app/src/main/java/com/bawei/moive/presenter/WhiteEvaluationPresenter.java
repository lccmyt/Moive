package com.bawei.moive.presenter;

import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.WhiteEvalutionBean;
import com.bawei.moive.contract.WhiteEvaluationContract;
import com.bawei.moive.model.WhiteEvaluationModel;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.presenter
 * @ClassName: WhiteEvaluationPresenter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/7 19:55
 */
public class WhiteEvaluationPresenter extends BasePresenter implements WhiteEvaluationContract.IPresenter {

    private WhiteEvaluationModel mModel;

    public WhiteEvaluationPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        mModel = new WhiteEvaluationModel();
    }

    @Override
    public void WhiteEvaluation(int movieId, String commentContent, double score) {
        mModel.WhiteEvaluation(movieId, commentContent, score, new WhiteEvaluationContract.IModel.whiteEvalationCallBack() {
            @Override
            public void onSuccess(WhiteEvalutionBean whiteEvalutionBean) {
                IBaseView view = getView();
                if (view instanceof WhiteEvaluationContract.IView) {
                    ((WhiteEvaluationContract.IView)view).onSuccess(whiteEvalutionBean);
                }
            }

            @Override
            public void onFailure(String str) {

            }
        });
    }
}
