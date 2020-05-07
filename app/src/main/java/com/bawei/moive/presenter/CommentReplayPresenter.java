package com.bawei.moive.presenter;

import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.base.IBaseView;
import com.bawei.moive.bean.CommentReplayBean;
import com.bawei.moive.bean.ReplayCommentBean;
import com.bawei.moive.contract.CommentReplayContract;
import com.bawei.moive.model.CommentReplayModel;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.presenter
 * @ClassName: CommentReplayPresenter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/7 22:27
 */
public class CommentReplayPresenter extends BasePresenter implements CommentReplayContract.IPresenter {

    private CommentReplayModel mModel;

    public CommentReplayPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        mModel = new CommentReplayModel();
    }

    @Override
    public void replay(int commentId, int page, int count) {
        mModel.replay(commentId, page, count, new CommentReplayContract.IModel.replayCallBack() {
            @Override
            public void onSuccess(CommentReplayBean commentReplayBean) {
                IBaseView view = getView();
                if (view instanceof CommentReplayContract.IView) {
                    ((CommentReplayContract.IView)view).onSuccess(commentReplayBean);
                }
            }

            @Override
            public void onFailure(String str) {

            }
        });
    }

    @Override
    public void replayComment(int commentId, String replyContent) {
        mModel.replayComment(commentId, replyContent, new CommentReplayContract.IModel.replayMovieCallBack() {
            @Override
            public void onSuccess(ReplayCommentBean replayCommentBean) {
                IBaseView view = getView();
                if (view instanceof CommentReplayContract.IView) {
                    ((CommentReplayContract.IView)view).onReplaySuccess(replayCommentBean);
                }
            }

            @Override
            public void onFailure(String str) {

            }
        });
    }
}
