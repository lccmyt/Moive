package com.bawei.moive.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.moive.R;
import com.bawei.moive.base.BaseActivity;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.bean.WhiteEvalutionBean;
import com.bawei.moive.contract.WhiteEvaluationContract;
import com.bawei.moive.presenter.WhiteEvaluationPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WhiteEvaluationActivity extends BaseActivity implements WhiteEvaluationContract.IView {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.rb)
    RatingBar rb;
    @BindView(R.id.et1)
    EditText et1;
    @BindView(R.id.bt_send)
    Button btSend;
    private int movieId;
    private float rating;

    @Override
    protected int getLayout() {
        return R.layout.activity_white_evaluation;
    }

    @Override
    protected BasePresenter initPresent() {
        return new WhiteEvaluationPresenter(this);
    }

    @Override
    protected void initView() {
        String movieName = getIntent().getStringExtra("movieName");
        movieId = getIntent().getIntExtra("movieId", 0);
        tv1.setText(movieName);
        rating = rb.getRating();

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

    @OnClick({R.id.back, R.id.bt_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_send:
                BasePresenter presenter = getPresenter();
                if (presenter instanceof WhiteEvaluationPresenter) {
                    ((WhiteEvaluationPresenter)presenter).WhiteEvaluation(movieId,et1.getText().toString(),rating*2.0);
                }
                break;
                default:
                    break;
        }
    }

    @Override
    public void onSuccess(WhiteEvalutionBean whiteEvalutionBean) {
        if (whiteEvalutionBean != null) {
            Toast.makeText(this, whiteEvalutionBean.getMessage(), Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void onFailure(String str) {

    }
}
