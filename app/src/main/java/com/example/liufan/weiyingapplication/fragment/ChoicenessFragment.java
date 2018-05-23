package com.example.liufan.weiyingapplication.fragment;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.liufan.weiyingapplication.R;
import com.example.liufan.weiyingapplication.base.BaseFragment;
import com.example.liufan.weiyingapplication.choiceness.Bean.ShouyeBean;
import com.example.liufan.weiyingapplication.choiceness.adapter.Choic_Adapter;
import com.example.liufan.weiyingapplication.choiceness.presenter.LogPresenter;
import com.example.liufan.weiyingapplication.choiceness.view.OnView;
import com.squareup.picasso.Picasso;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liufan on 2018/5/21.
 */

public class ChoicenessFragment extends BaseFragment implements OnView {

    public LogPresenter logPresenter;
    private XBanner xbanner;

    String[] ss = {"https://i02piccdn.sogoucdn.com/61f036a72ddecdb7"
                ,"https://i01piccdn.sogoucdn.com/b6291d8c5c6cabe4"
                ,"https://i04piccdn.sogoucdn.com/60069e6a9dd920f2"
                ,"https://i02piccdn.sogoucdn.com/f1aa1fcd79082413"
                ,"https://i03piccdn.sogoucdn.com/bf4c85517b02a712"};
    List<String> xbammer_tu = new ArrayList<>();
    private RecyclerView rlay;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choiceness_view, container, false);
//        View Xview = View.inflate(getActivity(), R.layout.xbanner_view, null);
        getXbammer_tu();
        logPresenter = new LogPresenter(this);
        logPresenter.getPresenter();
        xbanner = view.findViewById(R.id.xbanner);
        rlay = view.findViewById(R.id.rlay);
        rlay.setLayoutManager(new LinearLayoutManager(getActivity()));
        
        return view;
    }
    @Override
    protected void loadData() {
    }
    @Override
    public void OnSoufder(Object object) {
        ShouyeBean shouyeBean = (ShouyeBean) object;
//        Log.i("LLLLLLLLL",""+shouyeBean.getCode()+shouyeBean.getMsg());
        xbanner.setData(xbammer_tu,null);
        xbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Picasso.with(getActivity()).load(xbammer_tu.get(position)).placeholder(R.drawable.ic_launcher_background).into((ImageView) view);
            }
        });
        List<ShouyeBean.RetBean.ListBean> list = shouyeBean.getRet().getList();
        Choic_Adapter choic_adapter = new Choic_Adapter(getActivity(),list);
        rlay.setAdapter(choic_adapter);
    }

    public void getXbammer_tu() {
        for (int i = 0; i < ss.length; i++) {
            xbammer_tu.add(ss[i]);
        }
    }
}
