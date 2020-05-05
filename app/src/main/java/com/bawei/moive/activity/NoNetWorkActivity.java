package com.bawei.moive.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.moive.R;
import com.bawei.moive.base.BaseActivity;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.network.RetrofitManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoNetWorkActivity extends BaseActivity {


    @BindView(R.id.activity_nonetwork_shape)
    ImageView activityNonetworkShape;
    @BindView(R.id.activity_nonetwork)
    ImageView activityNonetwork;

    @Override
    protected int getLayout() {
        return R.layout.activity_no_net_work;
    }

    @Override
    protected BasePresenter initPresent() {
        return null;
    }

    @Override
    protected void initView() {

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

    @OnClick({R.id.activity_nonetwork_shape, R.id.activity_nonetwork})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_nonetwork_shape:
                break;
            case R.id.activity_nonetwork:
                if (RetrofitManager.getInstance().isWorkInfo(NoNetWorkActivity.this)) {
                    startActivity(new Intent(NoNetWorkActivity.this, LoginActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, "无网络", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
