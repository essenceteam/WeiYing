package com.example.liufan.weiyingapplication.choiceness.view;

import android.content.Intent;

import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.liufan.weiyingapplication.R;
import com.example.liufan.weiyingapplication.base.BaseActivity;
import com.example.liufan.weiyingapplication.choiceness.Bean.ShiPinBean;
import com.example.liufan.weiyingapplication.choiceness.presenter.LogPresenter;

/**
 * author:Created by WangZhiQiang on 2018/5/23.
 */
public class ShiPinXQ extends BaseActivity implements OnView {


    private LogPresenter logPresenter;

    @Override
    protected int getLayout() {
        return R.layout.shipin_xq_view;
    }

    @Override
    protected void getView() {
        Intent intent = getIntent();
        String dataId = intent.getStringExtra("dataId");
//        Log.i("LLLLLLLLLLLLLssp","dataIds:"+dataId);
        logPresenter = new LogPresenter(this);
        logPresenter.getShiPin(dataId);


    }

    @Override
    protected void getData() {

    }

    @Override
    public void OnSoufder(Object object) {
        ShiPinBean shiPinBean = (ShiPinBean) object;
//        Log.i("LLLLLLLLLLLshipin",""+shiPinBean.getCode()+shiPinBean.getMsg());

//        View rootView = getLayoutInflater().from(this).inflate(R.layout.simple_player_view_player, null);
//        setContentView(rootView);
        String url ="http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4";
        new PlayerView(this)
                .setTitle("凤凰视频")//标题
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(url)
                .startPlay();
    }
}
