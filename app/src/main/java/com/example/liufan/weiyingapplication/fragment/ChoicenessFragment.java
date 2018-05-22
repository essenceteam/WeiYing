package com.example.liufan.weiyingapplication.fragment;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liufan.weiyingapplication.R;
import com.example.liufan.weiyingapplication.base.BaseFragment;
import com.example.liufan.weiyingapplication.choiceness.Bean.ShouyeBean;
import com.example.liufan.weiyingapplication.choiceness.presenter.LogPresenter;
import com.example.liufan.weiyingapplication.choiceness.view.OnView;

/**
 * Created by liufan on 2018/5/21.
 */

public class ChoicenessFragment extends BaseFragment implements OnView {

    public LogPresenter logPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.choiceness_view, null);
        logPresenter = new LogPresenter(this);
        logPresenter.getPresenter();
        return view;
    }
    @Override
    protected void loadData() {
    }
    @Override
    public void OnSoufder(Object object) {
        ShouyeBean shouyeBean = (ShouyeBean) object;
        Log.i("LLLLLLLLL",""+shouyeBean.getCode()+shouyeBean.getMsg());
    }
}
