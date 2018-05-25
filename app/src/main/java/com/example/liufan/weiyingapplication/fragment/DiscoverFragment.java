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
import android.widget.ImageView;

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
    Unbinder unbinder;
    private View view;
    private Presneter presneter;
    private String catalogId = "402834815584e463015584e539330016";

    private List<DiscoverBean.RetBean.ListBean> list;
    private InnerAdapter innerAdapter;
    private int cardWidth=150*150;
    private int cardHeight=300*300;
    private SwipeAdapterView swipeView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate (R.layout.discover_layout, container, false);
        unbinder = ButterKnife.bind (this, view);
        swipeView = view.findViewById (R.id.swipe_view);
        presneter = new Presneter (this);
        presneter.getpresenter (catalogId);
        loadData ();
        initView();
        return view;
    }

    @Override
    public void OnScuuess(Object Object) {
        DiscoverBean object = (DiscoverBean) Object;
        DiscoverBean.RetBean ret = object.getRet ();
        list = ret.getList ();


    }

    private void initView() {
       /* DisplayMetrics dm = getResources().getDisplayMetrics();
        float density = dm.density;*/
        /*cardWidth = (int) (dm.widthPixels - (2 * 18 * density));
        cardHeight = (int) (dm.heightPixels - (338 * density));*/
        swipeView.setOnItemClickListener ( this);
       swipeView.setFlingListener (this);
        innerAdapter = new InnerAdapter ();
        swipeView.getAdapter ();
    }

    @Override
    public void OnError(Throwable String) {

    }



    @Override
    public void removeFirstObjectInAdapter() {
        innerAdapter.remove (0);
    }

    @Override
    public void onLeftCardExit(Object dataObject) {

    }

    @Override
    public void onRightCardExit(Object dataObject) {

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
        new AsyncTask<Void, Void, List<Talent>> () {
            @Override
            protected List<Talent> doInBackground(Void... voids) {
                ArrayList<Talent>  list1 = new ArrayList<> (31);
               Talent talent;
                for (int i = 0; i <list1.size (); i++) {
                    talent = new Talent ();
                    talent.headerIcon=list.get (i).getPic ();
                    list1.add (talent);
                    Log.i (TAG +"ghjkl;", list1.get (i).headerIcon);
                }
                return list1;
            }

            @Override
            protected void onPostExecute(List<Talent> talents) {
                super.onPostExecute (talents);
                innerAdapter.addAll (talents);
            }
        }.execute ();

    }




    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        unbinder.unbind ();
    }

    @Override
    public void onItemClicked(View v, Object dataObject) {

    }


    private class InnerAdapter extends BaseAdapter {

        ArrayList<Talent> list2;

        public InnerAdapter() {
            list2 = new ArrayList<>();
        }

        public void addAll(Collection<Talent> collection) {
            if (isEmpty()) {
                list2.addAll(collection);
                notifyDataSetChanged();
            } else {
                list2.addAll(collection);
            }
        }

        public void clear() {
            list2.clear();
            notifyDataSetChanged();
        }

        public boolean isEmpty() {
            return list2.isEmpty();
        }

        public void remove(int index) {
            if (index > -1 && index < list2.size()) {
                list2.remove(index);
                notifyDataSetChanged();
            }
        }


        @Override
        public int getCount() {
            return list2.size();
        }

        @Override
        public Talent getItem(int position) {
            if(list2==null ||list2.size()==0) return null;
            return list2.get(position);
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
                //holder.portraitView.getLayoutParams().width = cardWidth;
                holder.portraitView.getLayoutParams().height = cardHeight;
                /*holder.nameView = (TextView) convertView.findViewById(R.id.name);
                //parentView.getLayoutParams().width = cardWidth;
                //holder.jobView = (TextView) convertView.findViewById(R.id.job);
                //holder.companyView = (TextView) convertView.findViewById(R.id.company);
                holder.cityView = (TextView) convertView.findViewById(R.id.city);
                holder.eduView = (TextView) convertView.findViewById(R.id.education);
                holder.workView = (TextView) convertView.findViewById(R.id.work_year);
                holder.collectView = (CheckedTextView) convertView.findViewById(R.id.favorite);
                holder.collectView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("tag", "+ 关注");
                    }
                });*/
            } else {
                //Log.e("tag", "recycler convertView");
                holder = (ViewHolder) convertView.getTag();
            }

           Picasso.with(parent.getContext()).load(talent.headerIcon)
                    .centerCrop().placeholder(R.drawable.default_card)
                    .into(holder.portraitView);
           /* holder.nameView.setText(String.format("%s", talent.nickname));*/

            final CharSequence no = "暂无";

            /*holder.cityView.setHint(no);
            holder.cityView.setText(talent.cityName);
            holder.cityView.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.home01_icon_location,0,0);

            holder.eduView.setHint(no);
            holder.eduView.setText(talent.educationName);
            holder.eduView.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.home01_icon_edu,0,0);

            holder.workView.setHint(no);
            holder.workView.setText(talent.workYearName);
            holder.workView.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.home01_icon_work_year,0,0);
*/

            return convertView;
        }

    }

    private static class ViewHolder {
        ImageView portraitView;
       /* TextView nameView;
        TextView cityView;
        TextView eduView;
        TextView workView;
        CheckedTextView collectView;*/
    }

    public static class Talent {
        public String headerIcon;
        /*public String nickname;
        public String cityName;
        public String educationName;
        public String workYearName;*/
    }
}
