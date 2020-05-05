package com.bawei.moive.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bawei.moive.R;
import com.bawei.moive.base.BaseActivity;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.network.RetrofitManager;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntroductionActivity extends BaseActivity {


    @BindView(R.id.activity_introduction_iv)
    ImageView activityIntroductionIv;
//    @BindView(R.id.activity_introduction_iv)
//    SimpleDraweeView activityIntroductionIv;

    @Override
    protected BasePresenter initPresent() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_introduction;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        activityIntroductionIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RetrofitManager.getInstance().isWorkInfo(IntroductionActivity.this)) {
                    showDialog();
                    startActivity(new Intent(IntroductionActivity.this, LoginActivity.class));
                    finish();
                } else {
                    showDialog();
                    startActivity(new Intent(IntroductionActivity.this, NoNetWorkActivity.class));
                    finish();
                }

            }
        });
    }


}
