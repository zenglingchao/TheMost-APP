package com.example.ziyu.themostdemo.Util;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Ziyu on 2016/10/24.
 */

public class RetrofitUtil {

    private DownListener downListener;
    private Context context;

    public RetrofitUtil(Context context){
        this.context = context;
    }
    public RetrofitUtil setDownListener(DownListener downListener){
        this.downListener = downListener;
        return this;
    }

    public RetrofitUtil downJson(String url, final int requestCode) {
        RetrofitClient.getInstance(context)
                .create(ApiService.class)
                .getJSON(url)
                .subscribeOn(Schedulers.io())
                .map(new Func1<String, Object>() {
                    @Override
                    public Object call(String s) {
                        if (downListener != null)
                            return downListener.paresJson(s,requestCode);
                        return null;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        if (downListener != null)
                            downListener.downSucc(o,requestCode);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.d("print", "call: " + throwable.getMessage());
                    }
                });
        return this;
    }


    public RetrofitUtil downBitmap(String url, final int requestCode) {
        RetrofitClient.getInstance(context)
                .create(ApiService.class)
                .getBitmap(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {
                        if (bitmapListener != null)
                            bitmapListener.downBitmapSucc(bitmap,requestCode);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.d("print", "call: " + throwable.getMessage());
                    }
                });
        return this;
    }

    public interface DownListener {
        //解析JSON时回调
        Object paresJson(String json, int requestCode);
        //解析完成后回调
        void downSucc(Object object, int requestCode);
    }

    private DownBitmapListener bitmapListener;

    public void setBitmapListener(DownBitmapListener bitmapListener) {
        this.bitmapListener = bitmapListener;
    }

    public interface DownBitmapListener{
        void downBitmapSucc(Bitmap bitmap, int requestCode);
    }


}
