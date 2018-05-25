package com.example.liufan.weiyingapplication.Discover.Presnter;

import com.example.liufan.weiyingapplication.Discover.Base.BasePresnter;
import com.example.liufan.weiyingapplication.Discover.Base.OnModler;
import com.example.liufan.weiyingapplication.Discover.Base.IOnView;
import com.example.liufan.weiyingapplication.Discover.Modler.Modler;

/**
 * Created by lenovo on 2018/5/22.
 */

public class Presneter extends BasePresnter<IOnView> implements OnModler{

    private final Modler modler;

    public Presneter(IOnView onView) {
        super (onView);
        modler = new Modler (this);
    }
    public void getpresenter(String catalogId){
      modler.getModler (catalogId);
    }



    @Override
    public void OnScuuess(Object Object) {
        p.OnScuuess (Object);
    }

    @Override
    public void OnError(Throwable String) {
        p.OnError (String);
    }
}
