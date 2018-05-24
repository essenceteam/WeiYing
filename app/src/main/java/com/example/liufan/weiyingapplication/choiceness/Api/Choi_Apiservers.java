package com.example.liufan.weiyingapplication.choiceness.Api;


import com.example.liufan.weiyingapplication.choiceness.Bean.ShiPinBean;
import com.example.liufan.weiyingapplication.choiceness.Bean.ShouyeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author:Created by WangZhiQiang on 2018/5/22.
 */
public interface Choi_Apiservers {
    //http://api.svipmovie.com/front/homePageApi/homePage.do
    @GET("front/homePageApi/homePage.do")
    Observable<ShouyeBean> getShouYe();
    //http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=223_c5133135b79346fea492421f22614c4c
    @GET("front/videoDetailApi/videoDetail.do")
    Observable<ShiPinBean> getShiPin(@Query("mediaId") String mediaId);
}
