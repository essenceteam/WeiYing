package com.example.liufan.weiyingapplication.Discover.API;

import com.example.liufan.weiyingapplication.Discover.Bean.DiscoverBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2018/5/23.
 */

public interface ApiSecive {
    @GET("columns/getVideoList.do")
    Observable<DiscoverBean>getmarter(@Query ("catalogId")String catalogId);
}
