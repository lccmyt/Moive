package com.bawei.moive.base;

import android.content.Context;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;

public abstract class BaseFragment <P extends BasePresenter> extends Fragment implements IBaseView {
    P basePresenter;

    /**
     * 控件加载完成的标志
     */
    public boolean mViewInflateFinished;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("xxx","Fragment+onAttach()");
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("xxx","Fragment+onCreate()");
        basePresenter = initPresenter();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("xxx","Fragment+onActivityCreated()");
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("xxx","Fragment+onCreate()");
        View v = View.inflate(getContext(), getLayout(), null);
        ButterKnife.bind(this, v);
        initView(v);
        mViewInflateFinished = true;
        doNetWork();
        initEvent();
        return v;
    }


    private void doNetWork() {
        if (getUserVisibleHint()) {
            initData();
        }
    }
    /**
     * fragment 提供的回调，回调当天fragment是否对用用户可见
     * 他是在当这个 fragment 是否对用户的可见发生变化的时候
     * @param isVisibleToUser false对用户不可见， true对用户可见
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        // 如果还没有加载过数据 && 用户切换到了这个fragment
        // 那就开始加载数据
        if (mViewInflateFinished && isVisibleToUser) {
            initData();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("xxx","Fragment+onDestroyView()");
        unEvent();
    }

    public P getPresenter(){
        return basePresenter;
    }



    protected abstract int getLayout();
    protected abstract P initPresenter();
    protected abstract void initView(View v);
    protected abstract void initData();
    protected abstract void initEvent();
    protected abstract void unEvent();

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("xxx","Fragment+onDestroy()");
        if(basePresenter != null){
            basePresenter.detachView();
            basePresenter = null;
        }
    }

    //输出Fragment名字+生命周期方法名。
    @Override
    public void onStart() {
        super.onStart();
        Log.i("xxx","Fragment+onStart()");
    }
    //输出Fragment名字+生命周期方法名。
    @Override
    public void onPause() {
        super.onPause();
        Log.i("xxx","Fragment+onPause()");
    }
    //输出Fragment名字+生命周期方法名。
    @Override
    public void onResume() {
        super.onResume();
        Log.i("xxx","Fragment+onResume()");
    }
    //输出Fragment名字+生命周期方法名。
    @Override
    public void onStop() {
        super.onStop();
        Log.i("xxx","Fragment+onStop()");
    }

//输出Fragment名字+生命周期方法名。
    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("xxx","Fragment+onDetach()");
    }
}
