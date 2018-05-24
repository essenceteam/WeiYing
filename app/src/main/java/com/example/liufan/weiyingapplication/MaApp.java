package com.example.liufan.weiyingapplication;

import android.app.Application;

import com.example.liufan.weiyingapplication.util.SpUtil;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by liufan on 2018/5/17.
 */

public class MaApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new SpUtil(this, 900).activate();
        Fresco.initialize(this);
    }
}
