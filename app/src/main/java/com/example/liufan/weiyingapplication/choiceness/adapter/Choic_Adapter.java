package com.example.liufan.weiyingapplication.choiceness.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.liufan.weiyingapplication.choiceness.Bean.ShouyeBean;

import java.util.List;

/**
 * author:Created by WangZhiQiang on 2018/5/22.
 */
public class Choic_Adapter extends RecyclerView.Adapter<Choic_Adapter.MyViewHobler> {

    Context context;
    List<ShouyeBean.RetBean.ListBean> list;

    public Choic_Adapter(Context context, List<ShouyeBean.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHobler onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHobler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHobler extends RecyclerView.ViewHolder{

        public MyViewHobler(View itemView) {
            super(itemView);
        }
    }
}
