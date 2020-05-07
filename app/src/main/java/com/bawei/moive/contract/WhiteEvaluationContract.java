package com.bawei.moive.contract;

import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.DetailsMovieBean;
import com.bawei.moive.bean.WhiteEvalutionBean;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.contract
 * @ClassName: RegisterContract
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/22 10:07
 */
public interface WhiteEvaluationContract {
    interface IView extends IBaseView {
        void onSuccess(WhiteEvalutionBean whiteEvalutionBean);
        void onFailure(String str);
    }
    interface IPresenter{
        void WhiteEvaluation(int movieId,String commentContent,double score);
    }

    interface IModel {
        void WhiteEvaluation(int movieId,String commentContent,double score,whiteEvalationCallBack callBack);
        interface whiteEvalationCallBack {
            void onSuccess(WhiteEvalutionBean whiteEvalutionBean);
            void onFailure(String str);
        }

    }
}
