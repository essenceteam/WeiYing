package com.example.liufan.weiyingapplication.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liufan.weiyingapplication.R;
import com.example.liufan.weiyingapplication.myde.adapter.Maadapter;
import com.example.liufan.weiyingapplication.myde.view.CollectActivity;
import com.example.liufan.weiyingapplication.myde.view.HistoryActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liufan on 2018/5/21.
 */

public class MyFragment  extends Fragment {

    private ImageView img_setting;
    private ListView my_list;
    private View inflate;
    private LinearLayout rl_record;
    private LinearLayout rl_down;
    private LinearLayout rl_collection;
    private LinearLayout rl_them;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        inflate = View.inflate(getActivity(), R.layout.myfragment, null);
         //设置的控件
        img_setting = inflate.findViewById(R.id.img_setting);
        //获取控件
        init();
        //逻辑操作
        inData();
        return inflate;
    }

    private void inData() {
        rl_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HistoryActivity.class);
                getActivity().startActivity(intent);
            }
        });
        rl_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"敬请期待",Toast.LENGTH_LONG).show();
            }
        });
        rl_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CollectActivity.class);
                getActivity().startActivity(intent);
            }
        });
        rl_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"主题",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void init() {
        rl_record = inflate.findViewById(R.id.rl_record);
        rl_down = inflate.findViewById(R.id.rl_down);
        rl_collection = inflate.findViewById(R.id.rl_collection);
        rl_them = inflate.findViewById(R.id.rl_them);
    }


}

