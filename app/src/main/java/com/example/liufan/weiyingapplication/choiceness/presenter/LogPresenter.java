package com.example.liufan.weiyingapplication.choiceness.presenter;

import com.example.liufan.weiyingapplication.choiceness.moudle.LogMoudle;
import com.example.liufan.weiyingapplication.choiceness.view.OnView;

/**
 * author:Created by WangZhiQiang on 2018/5/22.
 */
public class LogPresenter extends BasePresenter<OnView> implements OnMoudle {
    public final LogMoudle logMoudle;

    public LogPresenter(OnView onView) {
        super(onView);
        logMoudle = new LogMoudle(this);
    }
    public void getPresenter(){
        logMoudle.getShouYe();
    }
    @Override
    public void OnSoufder(Object object) {
        v.OnSoufder(object);
    }
}
