package com.example.ziyu.themostdemo.Util;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Ken on 2016/10/12.14:31
 */
public class RetrofitClient {



        /**
         * 下载JSON
         */
//        RetrofitClient.getInstance(this)
//                .create()
//                .getDatas(url, new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.d("print", "------------>" + s);
//                    }
//                });
//
//        RetrofitClient.getInstance(this)
//                .create(MyApiService.class)
//                .getNewsJSON(url)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.d("print", "----->" + s);
//                    }
//                });

    private static Context context;

    private static RetrofitClient INSTANCE = new RetrofitClient();
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;


    public static RetrofitClient getInstance(Context context){
        if(RetrofitClient.context == null){
            RetrofitClient.context = context;
        }

        return INSTANCE;
    }

    /**
     * 构造方法
     */
    private RetrofitClient(){
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


    private ApiService apiService;

/*
    /**
     * 创建Retrofit对象
     */
    public RetrofitClient create(){
        apiService = retrofit.create(ApiService.class);
        return this;
    }

    /**
     * 使用自定义的接口
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> tClass){
        T apiService = retrofit.create(tClass);
        return apiService;
    }

   /* *//**
     * 下载JSON
     *//*
    public void getDatas(String jsonUrl, Action1<String> action1){
        Observable<String> json = apiService.getJSON(jsonUrl);
        json
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(action1);
    }*/
}
