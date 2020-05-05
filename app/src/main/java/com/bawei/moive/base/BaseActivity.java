package com.bawei.moive.base;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bawei.moive.R;
import com.bumptech.glide.Glide;
import com.jaeger.library.StatusBarUtil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

/**
 * @ProjectName: Demo_0411
 * @Package: com.bawei.demo_0411.base
 * @ClassName: BaseActivity
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/11 8:52
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView{
    P mPresenter;
    private Dialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        StatusBarUtil.setTransparent(this);
        ButterKnife.bind(this);
        mPresenter = initPresent();
        initView();
        initData();
    }

    public void showDialog() {
        dialog = new Dialog(this);
        dialog.setCancelable(false);
        View view = View.inflate(this, R.layout.dialog_loading, null);
        ImageView iv = view.findViewById(R.id.iv);
        Glide.with(this).asGif().load(R.mipmap.dialog_loading).into(iv);
        dialog.addContentView(view,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        dialog.show();
    }

    public void hideDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }


    protected abstract int getLayout();

    protected abstract P initPresent();


    protected abstract void initView();

    protected abstract void initData();

    public P getPresenter(){
        if (mPresenter != null) {
            return mPresenter;
        }
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
