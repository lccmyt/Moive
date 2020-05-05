package com.bawei.moive.base;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @ProjectName: Demo_0411
 * @Package: com.bawei.demo_0411.base
 * @ClassName: App
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/11 8:47
 */
public class App extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        mContext = getApplicationContext();
    }

    public static Context getAppContext(){
        return mContext;
    }
}
