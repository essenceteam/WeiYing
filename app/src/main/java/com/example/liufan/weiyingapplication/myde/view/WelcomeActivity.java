package com.example.liufan.weiyingapplication.myde.view;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.liufan.weiyingapplication.MainActivity;
import com.example.liufan.weiyingapplication.R;
import com.example.liufan.weiyingapplication.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends BaseActivity {

    private ImageView iv_welcome_bg;

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void getView() {
        iv_welcome_bg = findViewById(R.id.iv_welcome_bg);
    }

    @Override
    protected void getData() {
        //创建timer对象，实现3秒跳转
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
