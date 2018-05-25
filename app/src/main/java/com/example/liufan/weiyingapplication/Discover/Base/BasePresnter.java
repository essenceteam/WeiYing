package com.example.liufan.weiyingapplication.Discover.Base;

import android.content.Context;
import android.view.View;

/**
 * Created by lenovo on 2018/5/22.
 */

public class BasePresnter<P> {
    public P p;

    public BasePresnter(P p) {
        this.p = p;
    }
    public void onDestroys(){
        p=null;
    }
}
