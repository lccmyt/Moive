package com.bawei.moive.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.moive.R;
import com.bawei.moive.base.BaseActivity;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.bean.EmailCodeBean;
import com.bawei.moive.bean.RegisterBean;
import com.bawei.moive.contract.RegisterContract;
import com.bawei.moive.presenter.RegisterPresenter;
import com.bawei.moive.utils.EncryptUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements RegisterContract.IView {


    @BindView(R.id.activity_register_setname)
    EditText activityRegisterSetname;
    @BindView(R.id.activity_register_setemail)
    EditText activityRegisterSetemail;
    @BindView(R.id.activity_register_setpwd)
    EditText activityRegisterSetpwd;
    @BindView(R.id.activity_register_inputcodedemo)
    EditText activityRegisterInputcodedemo;
    @BindView(R.id.activity_register_getcodedemo)
    Button activityRegisterGetcodedemo;
    @BindView(R.id.activity_register_login)
    TextView activityRegisterLogin;
    @BindView(R.id.activity_register_register)
    Button activityRegisterRegister;

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected BasePresenter initPresent() {
        return new RegisterPresenter(this);
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

    @OnClick({R.id.activity_register_getcodedemo, R.id.activity_register_login, R.id.activity_register_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_register_getcodedemo:
                if (!TextUtils.isEmpty(activityRegisterSetemail.getText())) {
                    BasePresenter presenter = getPresenter();
                    if (presenter instanceof RegisterPresenter) {
                        ((RegisterPresenter)presenter).getEmailCode(activityRegisterSetemail.getText().toString());
                    }
                }else {
                    Toast.makeText(this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.activity_register_login:
                startActivity(new Intent(this,LoginActivity.class));
                break;
            case R.id.activity_register_register:
                if (TextUtils.isEmpty(activityRegisterSetname.getText())) {
                    Toast.makeText(this, "姓名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else
                if (TextUtils.isEmpty(activityRegisterSetemail.getText())) {
                    Toast.makeText(this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else
                if (TextUtils.isEmpty(activityRegisterSetpwd.getText())) {
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else
                if (TextUtils.isEmpty(activityRegisterInputcodedemo.getText())) {
                    Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    String setPwd = EncryptUtil.encrypt(activityRegisterSetpwd.getText().toString());
                    BasePresenter presenter = getPresenter();
                    if (presenter instanceof RegisterPresenter) {
                        ((RegisterPresenter)presenter).doRegister(activityRegisterSetname.getText().toString(),setPwd,activityRegisterSetemail.getText().toString(),activityRegisterInputcodedemo.getText().toString());
                    }
                }

                    break;
                default:
                    break;
        }
    }

    @Override
    public void onSuccess(RegisterBean registerBean) {
        if (registerBean != null) {
            Intent intent = new Intent(this, HomePageActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onFailure(String str) {

    }

    @Override
    public void onEmailCodeSuccess(EmailCodeBean emailCodeBean) {
        if (emailCodeBean != null) {
            Toast.makeText(this, emailCodeBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onEmailCodeFailure(String str) {

    }
}
