package com.bawei.moive.model;

import com.bawei.moive.bean.CommentReplayBean;
import com.bawei.moive.bean.ReplayCommentBean;
import com.bawei.moive.contract.CommentReplayContract;
import com.bawei.moive.network.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.model
 * @ClassName: CommentReplayModel
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/7 22:25
 */
public class CommentReplayModel implements CommentReplayContract.IModel {
    @Override
    public void replay(int commentId, int page, int count,replayCallBack callBack) {
        RetrofitManager.getInstance().getApis().replay(commentId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentReplayBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CommentReplayBean commentReplayBean) {
                        callBack.onSuccess(commentReplayBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void replayComment(int commentId, String replyContent, replayMovieCallBack callBack) {
        RetrofitManager.getInstance().getApis().replayComment(commentId, replyContent)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ReplayCommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ReplayCommentBean replayCommentBean) {
callBack.onSuccess(replayCommentBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
