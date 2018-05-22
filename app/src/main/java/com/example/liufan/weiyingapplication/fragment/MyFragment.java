package com.example.liufan.weiyingapplication.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.liufan.weiyingapplication.R;

/**
 * Created by liufan on 2018/5/21.
 */

public class MyFragment  extends Fragment {

    private ImageView img_setting;
    private ListView my_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         View inflate = View.inflate(getActivity(), R.layout.myfragment, null);
         //设置的控件
        img_setting = inflate.findViewById(R.id.img_setting);
        //listView
        my_list = inflate.findViewById(R.id.my_list);

        return inflate;
    }
}

