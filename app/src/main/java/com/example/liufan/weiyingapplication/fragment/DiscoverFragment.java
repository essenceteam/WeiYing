package com.example.liufan.weiyingapplication.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liufan.weiyingapplication.Discover.Base.IOnView;
import com.example.liufan.weiyingapplication.Discover.Base.swipeadapterview.SwipeAdapterView;
import com.example.liufan.weiyingapplication.Discover.Bean.DiscoverBean;
import com.example.liufan.weiyingapplication.Discover.Presnter.Presneter;
import com.example.liufan.weiyingapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.ContentValues.TAG;

/**
 * Created by liufan on 2018/5/21.
 */

public class DiscoverFragment extends Fragment implements IOnView, SwipeAdapterView.onFlingListener, SwipeAdapterView.OnItemClickListener {

    Random ran = new Random();

    private int cardWidth;
    private int cardHeight;

    private SwipeAdapterView swipeView;
    private InnerAdapter adapter;
    private View view;
    private String catalogId="402834815584e463015584e539330016";
    private List<DiscoverBean.RetBean.ListBean> list1;
    private ArrayList<String> imgurl;
    private AsyncTask asyncTask;
    private String string;
    private String string1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate (R.layout.discover_layout, container, false);
        Presneter Presneter=new Presneter (this);
        Presneter.getpresenter (catalogId);
        initView();

        return view;
    }

    private void initView() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        float density = dm.density;
        cardWidth = (int) (dm.widthPixels - ( 3*20 * density));
        cardHeight = (int) (dm.heightPixels - (600 * density));


        swipeView =  view.findViewById(R.id.swipe_view);
//        swipeView.setIsNeedSwipe(false);
        swipeView.setFlingListener(this);
        swipeView.setOnItemClickListener(this);

        adapter = new InnerAdapter();
        swipeView.setAdapter(adapter);
    }


    @Override
    public void onItemClicked(View v, Object dataObject) {
        Log.e("tag", "click 大图");
    }

    @Override
    public void removeFirstObjectInAdapter() {
        adapter.remove(0);
    }

    @Override
    public void onLeftCardExit(Object dataObject) {
        Log.e("tag", "swipe left");
    }

    @Override
    public void onRightCardExit(Object dataObject) {
        Log.e("tag", "swipe right");
    }

    @Override
    public void onAdapterAboutToEmpty(int itemsInAdapter) {
        if (itemsInAdapter == 3) {
            loadData();
        }
    }

    @Override
    public void onScroll(float progress, float scrollXProgress) {
    }

    private void loadData() {
        asyncTask = new AsyncTask<Void, Void, List<Talent>> () {

            @Override
            protected List<Talent> doInBackground(Void... voids) {
                ArrayList<Talent> list = new ArrayList<>();
                Talent talent;
                for (int i = 0; i < list1.size (); i++) {
                    talent = new Talent ();
                    talent.headerIcon = list1.get (i).getPic ();
                    talent.nickname =list1.get (i).getTitle () ;
                    talent.educationName = list1.get (i).getDescription ();
                    list.add(talent);
                }
                return list;
            }

            @Override
            protected void onPostExecute(List<Talent> list) {
                super.onPostExecute(list);
                adapter.addAll(list);
            }
        }.execute();
    }

    @Override
    public void OnScuuess(Object Object) {
        DiscoverBean object = (DiscoverBean) Object;
        list1 = object.getRet ().getList ();
        loadData();
    }

    @Override
    public void OnError(Throwable String) {

    }


    private class InnerAdapter extends BaseAdapter {

        ArrayList<Talent> objs;

        public InnerAdapter() {
            objs = new ArrayList<>();
        }

        public void addAll(Collection<Talent> collection) {
            if (isEmpty()) {
                objs.addAll(collection);
                notifyDataSetChanged();
            } else {
                objs.addAll(collection);
            }
        }

        public boolean isEmpty() {
            return objs.isEmpty();
        }

        public void remove(int index) {
            if (index > -1 && index < objs.size()) {
                objs.remove(index);
                notifyDataSetChanged();
            }
        }


        @Override
        public int getCount() {
            return objs.size();
        }

        @Override
        public Talent getItem(int position) {
            if(objs==null ||objs.size()==0) return null;
            return objs.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            Talent talent = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_new_item, parent, false);
                holder = new ViewHolder();
                convertView.setTag(holder);
                convertView.getLayoutParams().width = cardWidth;
                holder.portraitView = (ImageView) convertView.findViewById(R.id.portrait);

                holder.portraitView.getLayoutParams().height = cardHeight;
                holder.nameView = (TextView) convertView.findViewById(R.id.name);
                holder.eduView = (TextView) convertView.findViewById(R.id.education);
            } else {
                //Log.e("tag", "recycler convertView");
                holder = (ViewHolder) convertView.getTag();
            }

            Picasso.with(parent.getContext()).load(talent.headerIcon)
                    .into(holder.portraitView);
            holder.nameView.setText(String.format("%s", talent.nickname));

            final CharSequence no = "暂无";

            holder.eduView.setHint(no);
            holder.eduView.setText("         @TV新片速递:"+talent.educationName);
            //holder.eduView.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.home01_icon_edu,0,0);




            return convertView;
        }

    }

    private static class ViewHolder {
        ImageView portraitView;
        TextView nameView;
        TextView eduView;

    }

    public static class Talent {
        public String headerIcon;
        public String nickname;
        public String educationName;

    }

}
