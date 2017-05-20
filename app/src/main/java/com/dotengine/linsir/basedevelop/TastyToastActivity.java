package com.dotengine.linsir.basedevelop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sdsmdg.tastytoast.TastyToast;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  Created by linSir 
 *  date at 2017/5/20.
 *  describe: tastyToast库的测试类
 */

public class TastyToastActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasty_toast);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.button1) public void onButton1Clicked() {
        TastyToast.makeText(getApplicationContext(), "Hello World !", TastyToast.LENGTH_LONG, TastyToast.WARNING);
    }

    @OnClick(R.id.button2) public void onButton2Clicked() {
        TastyToast.makeText(getApplicationContext(), "Hello World !", TastyToast.LENGTH_LONG, TastyToast.CONFUSING);
    }

    @OnClick(R.id.button3) public void onButton3Clicked() {
        TastyToast.makeText(getApplicationContext(), "Hello World !", TastyToast.LENGTH_LONG, TastyToast.DEFAULT);
    }

    @OnClick(R.id.button4) public void onButton4Clicked() {
        TastyToast.makeText(getApplicationContext(), "Hello World !", TastyToast.LENGTH_LONG, TastyToast.ERROR);
    }

    @OnClick(R.id.button5) public void onButton5Clicked() {
        TastyToast.makeText(getApplicationContext(), "Hello World !", TastyToast.LENGTH_LONG, TastyToast.INFO);
    }

    @OnClick(R.id.button6) public void onButton6Clicked() {
        TastyToast.makeText(getApplicationContext(), "Hello World !", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);
    }
}
