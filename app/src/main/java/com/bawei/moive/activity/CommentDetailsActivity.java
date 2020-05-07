package com.bawei.moive.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.moive.R;
import com.bawei.moive.adapter.CommentReplayAdapter;
import com.bawei.moive.base.BaseActivity;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.bean.CommentReplayBean;
import com.bawei.moive.bean.FilmReviewBean;
import com.bawei.moive.bean.ReplayCommentBean;
import com.bawei.moive.contract.CommentReplayContract;
import com.bawei.moive.presenter.CommentReplayPresenter;
import com.bawei.moive.view.RatingBar;
import com.bawei.moive.view.SpacesItemDecoration;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommentDetailsActivity extends BaseActivity implements CommentReplayContract.IView {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    RelativeLayout title;
    @BindView(R.id.iv_touxiang)
    SimpleDraweeView ivTouxiang;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ratingbar)
    RatingBar ratingbar;
    @BindView(R.id.tv_score)
    TextView tvScore;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_comment)
    TextView tvComment;
    @BindView(R.id.comment)
    RelativeLayout comment;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.rc1)
    RecyclerView rc1;
    @BindView(R.id.et1)
    EditText et1;
    @BindView(R.id.send)
    Button send;
    private CommentReplayAdapter commentReplayAdapter;
    private int commentId;

    @Override
    protected int getLayout() {
        return R.layout.activity_comment_details;
    }

    @Override
    protected BasePresenter initPresent() {
        return new CommentReplayPresenter(this);
    }

    @Override
    protected void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rc1.addItemDecoration(new SpacesItemDecoration(50));
        rc1.setLayoutManager(linearLayoutManager);
        commentReplayAdapter = new CommentReplayAdapter(this);
        rc1.setAdapter(commentReplayAdapter);
        Intent intent = getIntent();
        FilmReviewBean.ResultBean resultBean = (FilmReviewBean.ResultBean) intent.getSerializableExtra("comment");
        commentId = resultBean.getCommentId();
        ivTouxiang.setImageURI(Uri.parse(resultBean.getCommentHeadPic()));
        tvName.setText(resultBean.getCommentUserName());
        ratingbar.setStar((float) (resultBean.getScore() / 2));
        ratingbar.setClickable(false);
        tvScore.setText(String.valueOf(resultBean.getScore()) + "分");
        Date date = new Date(resultBean.getCommentTime());
        String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
        tvTime.setText(format);
        tvComment.setText(resultBean.getCommentContent());
        tvNum.setText(String.valueOf(resultBean.getReplyNum()) + "人回复");
        BasePresenter presenter = getPresenter();
        if (presenter instanceof CommentReplayPresenter) {
            ((CommentReplayPresenter) presenter).replay(resultBean.getCommentId(), 1, 50);
        }

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onSuccess(CommentReplayBean commentReplayBean) {
        if (commentReplayBean != null) {
            commentReplayAdapter.setData(commentReplayBean.getResult());
        }
    }


    @Override
    public void onFailure(String str) {

    }

    @Override
    public void onReplaySuccess(ReplayCommentBean replayCommentBean) {
        if (replayCommentBean != null) {
            Toast.makeText(this, replayCommentBean.getMessage(), Toast.LENGTH_SHORT).show();
            BasePresenter presenter = getPresenter();
            if (presenter instanceof CommentReplayPresenter) {
                ((CommentReplayPresenter) presenter).replay(commentId, 1, 50);
            }
        }
    }

    @Override
    public void onReplayFailure(String str) {

    }


    @OnClick({R.id.back, R.id.send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.send:
                BasePresenter presenter = getPresenter();
                if (presenter instanceof CommentReplayPresenter) {
                    ((CommentReplayPresenter)presenter).replayComment(commentId,et1.getText().toString());
                }
                break;
                default:
                    break;
        }
    }
}
