package com.example.ziyu.themostdemo.Util;

import android.graphics.Bitmap;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Ziyu on 2016/10/12.14:29
 */
public interface ApiService {

    String BASE_URL = "http://ikft.house.qq.com/";

    @GET
    Observable<String> getJSON(@Url String url);
    @GET
    Observable<Bitmap> getBitmap(@Url String url);
}
