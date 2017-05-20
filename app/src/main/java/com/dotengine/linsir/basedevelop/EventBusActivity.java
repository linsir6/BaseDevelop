package com.dotengine.linsir.basedevelop;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  Created by linSir 
 *  date at 2017/5/20.
 *  describe:      
 */

public class EventBusActivity extends AppCompatActivity {

    //当然，我们目前将，发送与接收放在了一个界面里面，他们可以在不同的界面里面，可以实现app内部的通信

    @Override protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        ButterKnife.bind(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(EventBusActivity.this, "收到的内容 -> " + event.event, Toast.LENGTH_SHORT).show();
    }


    @Override protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @OnClick(R.id.send) public void onViewClicked() {
        EventBus.getDefault().post(new MessageEvent("今天好开心"));
    }

    public class MessageEvent{
        String event;

        public MessageEvent(String event){
            this.event = event;
        }

    }

}
