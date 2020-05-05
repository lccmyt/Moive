package com.bawei.moive.base;

import java.lang.ref.WeakReference;

/**
 * @ProjectName: Demo_0411
 * @Package: com.bawei.demo_0411.base
 * @ClassName: BasePresenter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/11 8:49
 */
public abstract class BasePresenter<V extends IBaseView> {

    private WeakReference<V> mWeakReference;

    public BasePresenter(V v){
        mWeakReference = new WeakReference<>(v);
        initModel();
    }

    protected abstract void initModel();

    public V getView(){
        if (mWeakReference != null) {
            return mWeakReference.get();
        }
        return null;
    }

    protected void detachView(){
        if (mWeakReference != null) {
            mWeakReference.clear();
            mWeakReference = null;
        }
    }

}
