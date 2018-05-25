package com.example.liufan.weiyingapplication.choiceness.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liufan.weiyingapplication.R;
import com.example.liufan.weiyingapplication.choiceness.Bean.ShouyeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * author:Created by WangZhiQiang on 2018/5/22.
 */
public class Choic_Adapter extends RecyclerView.Adapter<Choic_Adapter.MyViewHobler> {

    Context context;
    List<ShouyeBean.RetBean.ListBean> list;
    private Itemclick item;

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
    public void onBindViewHolder(final MyViewHobler holder, final int position) {

        holder.choic_ada_view_tv.setText(list.get(position).getChildList().get(0).getTitle());
        String pic = list.get(position).getChildList().get(0).getPic();
        if (pic.equals("") || pic == "") {
            return;
        } else {
//            Picasso.with(context).load(pic).placeholder(R.drawable.ic_launcher_background).into(holder.choic_ada_view_sim);
            holder.choic_ada_view_sim.setImageURI(pic);
        }

        //item为接口的变量名
        if (item!=null){
            //holder为Myhodler holder的参数
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //调用接口的方法
                    item.itemclick(holder.itemView,position);
                }
            });
        }

    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHobler extends RecyclerView.ViewHolder{

        private final TextView choic_ada_view_tv;
        private final SimpleDraweeView choic_ada_view_sim;
        public MyViewHobler(View itemView) {
            super(itemView);
            choic_ada_view_tv = itemView.findViewById(R.id.choic_ada_view_tv);
            choic_ada_view_sim = itemView.findViewById(R.id.choic_ada_view_sim);
        }
    }

    //定义接口
    public interface Itemclick{
        void itemclick(View view,int position);
    }

    //定义方法   参数1为接口  2为接口的变量名
    public void OnClickItemjiu(Itemclick item){
        this.item=item;
    }

}