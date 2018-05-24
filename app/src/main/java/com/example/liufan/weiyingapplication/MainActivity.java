package com.example.liufan.weiyingapplication;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.liufan.weiyingapplication.Lateralspreads.ResideBaseAdapter;
import com.example.liufan.weiyingapplication.Lateralspreads.ResideBean;
import com.example.liufan.weiyingapplication.Lateralspreads.ResideLayout;
import com.example.liufan.weiyingapplication.base.BaseActivity;
import com.example.liufan.weiyingapplication.fragment.ChoicenessFragment;
import com.example.liufan.weiyingapplication.fragment.DiscoverFragment;
import com.example.liufan.weiyingapplication.fragment.MyFragment;
import com.example.liufan.weiyingapplication.fragment.SpecialFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.HEAD;


public class MainActivity extends BaseActivity {

    private RadioGroup tab_rg_menu;
    private ChoicenessFragment choicenessFragment;
    private DiscoverFragment discoverFragment;
    private SpecialFragment specialFragment;
    private MyFragment myFragment;
    private ResideLayout resideLayout;
    private   String name[]={"我的收藏","我的下载","福利","分享","建议反馈","设置"};


    @Override
    protected int getLayout() {
        return R.layout.residelayout_layout;
    }

    @Override
    protected void getView() {
        tab_rg_menu = findViewById(R.id.tab_rg_menu);
        resideLayout = findViewById (R.id.resideLayout);
//        resideListView = findViewById (R.id.resideListView);
    }

    @Override
    protected void getData() {

        resideLayout.setPanelSlideListener (new ResideLayout.PanelSlideListener () {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }
            @Override
            public void onPanelOpened(View panel) {
                Toast.makeText (MainActivity.this,"打开",Toast.LENGTH_SHORT).show ();
            }
            @Override
            public void onPanelClosed(View panel) {
                Toast.makeText (MainActivity.this,"关闭",Toast.LENGTH_SHORT).show ();
            }
        });
        //精选
        choicenessFragment = new ChoicenessFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.lf, choicenessFragment).commit();
        //RadioGroup的点击事件
        tab_rg_menu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Hined();
                 FragmentManager supportFragmentManager = getSupportFragmentManager();
                switch (checkedId) {
                    case R.id.tab_rb_1:
                        //精选
                        supportFragmentManager.beginTransaction().show(choicenessFragment).commit();
                        break;
                    case R.id.tab_rb_2:
                        //专题
                        if (specialFragment == null) {
                            specialFragment = new SpecialFragment();
                            supportFragmentManager.beginTransaction().add(R.id.lf, specialFragment).commit();
                        } else {
                            supportFragmentManager.beginTransaction().show(specialFragment).commit();
                        }
                        break;
                    case R.id.tab_rb_3:
                        //发现
                        //专题
                        if (discoverFragment == null) {
                            discoverFragment = new DiscoverFragment();
                            supportFragmentManager.beginTransaction().add(R.id.lf, discoverFragment).commit();
                        } else {
                            supportFragmentManager.beginTransaction().show(discoverFragment).commit();
                        }
                        break;
                    case R.id.tab_rb_4:
                        //我的
                        if (myFragment == null) {
                            myFragment = new MyFragment();
                            supportFragmentManager.beginTransaction().add(R.id.lf, myFragment).commit();
                        } else {
                            supportFragmentManager.beginTransaction().show(myFragment).commit();
                        }
                        break;
                }
            }
        });
    }




    //fragment的隐藏的方法
    public void Hined(){
        if (choicenessFragment!=null&&choicenessFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().hide(choicenessFragment).commit();
        }
        if (specialFragment!=null&&specialFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().hide(specialFragment).commit();
        }
        if (discoverFragment!=null&&discoverFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().hide(discoverFragment).commit();
        }
        if (myFragment!=null&&myFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().hide(myFragment).commit();
        }

    }


}
