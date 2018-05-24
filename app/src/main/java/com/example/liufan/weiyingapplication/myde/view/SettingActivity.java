package com.example.liufan.weiyingapplication.myde.view;

import android.app.AlertDialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.liufan.weiyingapplication.R;
import com.example.liufan.weiyingapplication.base.BaseActivity;

import java.lang.reflect.Field;

public class SettingActivity extends BaseActivity {


    private RelativeLayout rl_recommend;
    private RelativeLayout rl_clearcache;
    private RelativeLayout rl_about;
    private RelativeLayout rl_feedback;
    private TextView tv_cache;

    @Override
    protected int getLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void getView() {
        //推荐给好友
        rl_recommend = findViewById(R.id.rl_recommend);
        //清理缓存
        rl_clearcache = findViewById(R.id.rl_clearcache);
        //关于我们
        rl_about = findViewById(R.id.rl_about);
        //建议反馈
        rl_feedback = findViewById(R.id.rl_feedback);
        tv_cache = findViewById(R.id.tv_cache);
    }

    @Override
    protected void getData() {
        //推荐给好友点击事件
        rl_recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SettingActivity.this)
                        .setMessage(R.string.setting_recommend_content)
                        .setNegativeButton(R.string.setting_recommend_copy, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ClipboardManager cmb = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                                cmb.setText(getResources().getString(R.string.setting_recommend_url));
                                EventUtil.showToast(SettingActivity.this, "已复制到粘贴板");
                            }
                        })
                        .setPositiveButton(R.string.close, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).show();
            }
        });
        //清理缓存点击事件
        rl_clearcache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_cache.setText("0kb");
                EventUtil.showToast(SettingActivity.this, "已清理缓存");
            }
        });
        //关于我们点击事件
        rl_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SettingActivity.this)
                        .setTitle(R.string.about)
                        .setMessage(R.string.about_me)
                        .setPositiveButton(R.string.close,null)
                        .show();
            }
        });
        //建议反馈点击事件
        rl_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


}
