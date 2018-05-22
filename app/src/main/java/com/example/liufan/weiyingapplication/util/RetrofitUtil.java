package com.example.liufan.weiyingapplication.util;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liufan on 2018/5/21.
 */

public class RetrofitUtil {
    private static RetrofitUtil RETROFIT_UTILS = null;

    private RetrofitUtil() {
    }

    public static RetrofitUtil getInData() {
        if (RETROFIT_UTILS == null){
            synchronized (RetrofitUtil.class){
                if (RETROFIT_UTILS == null){
                    RETROFIT_UTILS = new RetrofitUtil();
                }
            }
        }
        return RETROFIT_UTILS;
    }

    public <T> T getRetrofit(String path,Class<T> cla){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("TAG",message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(path)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        T t = retrofit.create(cla);

        return t;
    }
}
