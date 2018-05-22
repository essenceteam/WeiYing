package com.example.liufan.weiyingapplication.choiceness.Api;


import com.example.liufan.weiyingapplication.choiceness.Bean.ShouyeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * author:Created by WangZhiQiang on 2018/5/22.
 */
public interface Choi_Apiservers {
    //  //http://api.svipmovie.com/front/homePageApi/homePage.do
    @GET("front/homePageApi/homePage.do")
    Observable<ShouyeBean> getShouYe();
}
