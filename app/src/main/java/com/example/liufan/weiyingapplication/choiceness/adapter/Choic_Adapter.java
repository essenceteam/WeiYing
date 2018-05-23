package com.example.liufan.weiyingapplication.choiceness.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liufan.weiyingapplication.R;
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
        View view = View.inflate(context, R.layout.choic_ada_view, null);
        MyViewHobler myViewHobler = new MyViewHobler(view);
        return myViewHobler;
    }

    @Override
    public void onBindViewHolder(MyViewHobler holder, int position) {

        holder.choic_ada_view_tv.setText(list.get(position).getTitle());
       // Picasso.with(context).load(list.get(position).getChildList().get(position).getAngleIcon()).placeholder(R.drawable.ic_launcher_background).into(holder.choic_ada_view_sim);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHobler extends RecyclerView.ViewHolder{

        private final TextView choic_ada_view_tv;
        private final ImageView choic_ada_view_sim;

        public MyViewHobler(View itemView) {
            super(itemView);
            choic_ada_view_tv = itemView.findViewById(R.id.choic_ada_view_tv);
            choic_ada_view_sim = itemView.findViewById(R.id.choic_ada_view_sim);
        }
    }
}
