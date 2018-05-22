package com.example.liufan.weiyingapplication.choiceness.moudle;

import android.util.Log;

import com.example.liufan.weiyingapplication.choiceness.Api.Choi_Api;
import com.example.liufan.weiyingapplication.choiceness.Api.Choi_Apiservers;
import com.example.liufan.weiyingapplication.choiceness.Bean.ShouyeBean;
import com.example.liufan.weiyingapplication.choiceness.presenter.OnMoudle;
import com.example.liufan.weiyingapplication.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * author:Created by WangZhiQiang on 2018/5/22.
 */
public class LogMoudle extends BaseMoudle<OnMoudle> {


    public LogMoudle(OnMoudle onMoudle) {
        super(onMoudle);
    }

    public void getShouYe(){
        Observable<ShouyeBean> shouYe = RetrofitUtil.getInData().getRetrofit(Choi_Api.net, Choi_Apiservers.class).getShouYe();
        shouYe.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShouyeBean>() {
                    @Override
                    public void accept(ShouyeBean shouyeBean) throws Exception {
                        m.OnSoufder(shouyeBean);
                        Log.i("LLLLLLPPP",""+shouyeBean.getMsg()+shouyeBean.getCode());
                    }
                });
    }

}
