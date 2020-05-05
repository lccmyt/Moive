package com.bawei.moive.utils;

import android.content.Context;

/**
 * @ProjectName: Demo_0411
 * @Package: com.bawei.demo_0411.utils
 * @ClassName: SPUtils
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/11 9:31
 */
public class SPUtils {
    public static void putString(Context context, String name, String key, String value) {
        context.getSharedPreferences(name, Context.MODE_PRIVATE).edit().putString(key, value).commit();
    }
    public static void putBoolean(Context context, String name, String key, Boolean value) {
        context.getSharedPreferences(name, Context.MODE_PRIVATE).edit().putBoolean(key, value).commit();
    }
    public static String getString(Context context, String name, String key) {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE).getString(key, "");
    }
    public static Boolean getBoolean(Context context, String name, String key) {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE).getBoolean(key, false);
    }
}
