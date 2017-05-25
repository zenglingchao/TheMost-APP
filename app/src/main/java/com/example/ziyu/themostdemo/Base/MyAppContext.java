package com.example.ziyu.themostdemo.Base;

import android.app.Application;

import com.example.ziyu.themostdemo.Util.DiskLruCacheUtil;

/**
 * Created by Ziyu on 2016/11/3.
 */

public class MyAppContext extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        DiskLruCacheUtil.init(this);
    }
}
