package com.example.liufan.weiyingapplication.Lateralspreads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liufan.weiyingapplication.R;

import java.util.List;

/**
 * Created by lenovo on 2018/5/22.
 */

public class ResideBaseAdapter extends BaseAdapter {
    private Context context;
    private List<ResideBean> list;

    public ResideBaseAdapter(Context context, List<ResideBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size ();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            view=View.inflate (context, R.layout.reside_item_layout,null);
        }
        ImageView img = view.findViewById (R.id.img);
        TextView name = view.findViewById (R.id.name);
        img.setImageResource (list.get (i).getImg ());
        name.setText (list.get (i).getName ());
        return view;
    }
}
