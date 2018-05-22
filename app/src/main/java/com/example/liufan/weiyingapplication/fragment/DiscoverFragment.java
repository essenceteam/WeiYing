package com.example.liufan.weiyingapplication.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liufan.weiyingapplication.Lateralspreads.ResideLayout;
import com.example.liufan.weiyingapplication.R;

/**
 * Created by liufan on 2018/5/21.
 */

public class DiscoverFragment  extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate (R.layout.discover_layout, container, false);

        return view;
    }
}
