package com.example.liufan.weiyingapplication.Discover.Modler;

import android.util.Log;

import com.example.liufan.weiyingapplication.Discover.API.Api;
import com.example.liufan.weiyingapplication.Discover.API.ApiSecive;
import com.example.liufan.weiyingapplication.Discover.Base.BaseModler;
import com.example.liufan.weiyingapplication.Discover.Base.OnModler;
import com.example.liufan.weiyingapplication.Discover.Bean.DiscoverBean;
import com.example.liufan.weiyingapplication.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/5/22.
 */

public class Modler extends BaseModler<OnModler> {

    public Modler(OnModler onModler) {
        super (onModler);
    }
    public void  getModler(String catalogId){

        RetrofitUtil inData = RetrofitUtil.getInData ();
        Observable<DiscoverBean> getmarter = inData.getRetrofit (Api.url, ApiSecive.class).getmarter (catalogId);
        getmarter.subscribeOn (Schedulers.io ())
                .observeOn (AndroidSchedulers.mainThread ())
                .subscribe (new Observer<DiscoverBean> () {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DiscoverBean value) {
                        t.OnScuuess (value);
                        Log.i ("发现请求成功", "onNext: "+value.getMsg ());
                    }

                    @Override
                    public void onError(Throwable e) {
                        t.OnError (e);
                        Log.i ("发现请求失败", "onNext: "+e.getMessage ());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
