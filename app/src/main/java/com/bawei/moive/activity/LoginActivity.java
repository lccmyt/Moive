package com.bawei.moive.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.moive.R;
import com.bawei.moive.base.BaseActivity;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.bean.LoginBean;
import com.bawei.moive.contract.LoginContract;
import com.bawei.moive.presenter.LoginPresenter;
import com.bawei.moive.utils.EncryptUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.IView {


    @BindView(R.id.activity_login_email)
    EditText activityLoginEmail;
    @BindView(R.id.activity_login_pwd)
    EditText activityLoginPwd;
    @BindView(R.id.activity_login_forgetpwd)
    Button activityLoginForgetpwd;
    @BindView(R.id.activity_login_register)
    TextView activityLoginRegister;
    @BindView(R.id.activity_bt_login)
    Button activityBtLogin;
    @BindView(R.id.tv_huo)
    TextView tvHuo;
    @BindView(R.id.ll_left)
    LinearLayout llLeft;
    @BindView(R.id.ll_right)
    LinearLayout llRight;
    @BindView(R.id.activity_bt_wechat_login)
    LinearLayout activityBtWechatLogin;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected BasePresenter initPresent() {
        return new LoginPresenter(this);
    }

    @Override
    protected void initView() {
        hideDialog();
    }

    @Override
    protected void initData() {

    }



    @OnClick({R.id.activity_login_forgetpwd, R.id.activity_login_register, R.id.activity_bt_login, R.id.activity_bt_wechat_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //忘记密码
            case R.id.activity_login_forgetpwd:
                break;
            case R.id.activity_login_register:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            case R.id.activity_bt_login:
                if (TextUtils.isEmpty(activityLoginEmail.getText())) {
                    Toast.makeText(this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(activityLoginPwd.getText())) {
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    String pwd = EncryptUtil.encrypt(activityLoginPwd.getText().toString());
                    BasePresenter presenter = getPresenter();
                    if (presenter instanceof LoginPresenter) {
                        ((LoginPresenter)presenter).doLogin(activityLoginEmail.getText().toString(),pwd);
                    }
                }
                    break;
            case R.id.activity_bt_wechat_login:
                break;
                default:
                    break;
        }
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        if (loginBean != null) {
            startActivity(new Intent(this,HomePageActivity.class));
            finish();
        }
    }

    @Override
    public void onFailure(String str) {

    }
}
