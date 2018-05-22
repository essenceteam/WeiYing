package com.example.liufan.weiyingapplication.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.liufan.weiyingapplication.MainActivity;
import com.example.liufan.weiyingapplication.R;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by liufan on 2018/5/21.
 */

public class DiscoverFragment extends Fragment {

    @BindView(R.id.frame)
    SwipeFlingAdapterView flingContainer;
    @BindView(R.id.left)
    Button left;
    @BindView(R.id.right)
    Button right;
    Unbinder unbinder;
    private View view;
    private ArrayList<String> al;
    private ArrayAdapter arrayAdapter;
    private int i;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate (R.layout.discover_layout, container, false);

        unbinder = ButterKnife.bind (this, view);
        getdata ();
        return view;
    }

        private void getdata() {
            al = new ArrayList<> ();
            al.add ("php");
            al.add ("c");
            al.add ("python");
            al.add ("java");
            al.add ("html");
            al.add ("c++");
            al.add ("css");
            al.add ("javascript");

            arrayAdapter = new ArrayAdapter<>(getActivity (), R.layout.item, R.id.helloText, al);


            flingContainer.setAdapter (arrayAdapter);
            flingContainer.setFlingListener (new SwipeFlingAdapterView.onFlingListener () {
                @Override
                public void removeFirstObjectInAdapter() {
                    // this is the simplest way to delete an object from the Adapter (/AdapterView)
                    Log.d ("LIST", "removed object!");
                    al.remove (0);
                    arrayAdapter.notifyDataSetChanged ();
                }

                @Override
                public void onLeftCardExit(Object dataObject) {
                    //Do something on the left!
                    //You also have access to the original object.
                    //If you want to use it just cast it (String) dataObject
                    makeToast (getActivity (), "Left!");
                }

                @Override
                public void onRightCardExit(Object dataObject) {
                    makeToast (getActivity (), "Right!");
                }

                @Override
                public void onAdapterAboutToEmpty(int itemsInAdapter) {
                    // Ask for more data here
                    al.add ("XML ".concat (String.valueOf (i)));
                    arrayAdapter.notifyDataSetChanged ();
                    Log.d ("LIST", "notified");
                    i++;
                }

                @Override
                public void onScroll(float scrollProgressPercent) {
                    View view = flingContainer.getSelectedView ();
                    view.findViewById (R.id.item_swipe_right_indicator).setAlpha (scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                    view.findViewById (R.id.item_swipe_left_indicator).setAlpha (scrollProgressPercent > 0 ? scrollProgressPercent : 0);
                }
            });


            // Optionally add an OnItemClickListener
            flingContainer.setOnItemClickListener (new SwipeFlingAdapterView.OnItemClickListener () {
                @Override
                public void onItemClicked(int itemPosition, Object dataObject) {
                    makeToast (getActivity (), "Clicked!");
                }
            });

        }

    static void makeToast(Context ctx, String s) {
        Toast.makeText (ctx, s, Toast.LENGTH_SHORT).show ();
    }


    @OnClick(R.id.right)
    public void right() {
        /**
         * Trigger the right event manually.
         */
        flingContainer.getTopCardListener ().selectRight ();
    }

    @OnClick(R.id.left)
    public void left() {
        flingContainer.getTopCardListener ().selectLeft ();
    }





    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        unbinder.unbind ();
    }
}
