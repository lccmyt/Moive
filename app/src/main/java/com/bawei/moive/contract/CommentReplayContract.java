package com.bawei.moive.contract;

import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.CommentReplayBean;
import com.bawei.moive.bean.DetailsMovieBean;
import com.bawei.moive.bean.ReplayCommentBean;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.contract
 * @ClassName: RegisterContract
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/22 10:07
 */
public interface CommentReplayContract {
    interface IView extends IBaseView {
        void onSuccess(CommentReplayBean commentReplayBean);
        void onFailure(String str);

        void onReplaySuccess(ReplayCommentBean replayCommentBean);
        void onReplayFailure(String str);
    }
    interface IPresenter{
        void replay(int commentId,int page,int count);
        void replayComment(int commentId,String replyContent);
    }

    interface IModel {
        void replay(int commentId,int page,int count,replayCallBack callBack);
        void replayComment(int commentId, String replyContent, replayMovieCallBack callBack);
        interface replayCallBack {
            void onSuccess(CommentReplayBean commentReplayBean);
            void onFailure(String str);
        }
        interface replayMovieCallBack {
            void onSuccess(ReplayCommentBean replayCommentBean);
            void onFailure(String str);
        }

    }
}
