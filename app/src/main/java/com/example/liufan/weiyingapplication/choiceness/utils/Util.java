package com.example.liufan.weiyingapplication.choiceness.utils;

import com.example.liufan.weiyingapplication.choiceness.Api.Choi_Apiservers;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by WangZhiQiang on 2018/5/22.
 */
public class Util {

    private volatile static Util util = null;

    public Util() {
    }
    public static Util getminstance(){
        if (util == null) {
            synchronized (Util.class){
                if (util == null) {
                    util = new Util();
                }
            }
        }
        return util;
    }

    public Choi_Apiservers getnetjson(String uri){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(uri)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Choi_Apiservers testservive = retrofit.create(Choi_Apiservers.class);
        return testservive;

    }


}
