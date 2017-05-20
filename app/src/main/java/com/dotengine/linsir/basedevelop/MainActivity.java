package com.dotengine.linsir.basedevelop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.title) TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        title.setText("一些第三方库的测试的demo");


    }

    @OnClick(R.id.nohttp) public void onNohttpClicked() {
        startActivity(new Intent(MainActivity.this, NoHttpActivity.class));
    }

    @OnClick(R.id.glide) public void onGlideClicked() {
        startActivity(new Intent(MainActivity.this,GlideActivity.class));
    }

    @OnClick(R.id.baseRecyclerview_adapter_helper) public void onBaseRecyclerviewAdapterHelperClicked() {
        startActivity(new Intent(MainActivity.this,BaseRecyclerViewAdapterActivity.class));
    }

    @OnClick(R.id.event_bus) public void onEventBusClicked() {
        startActivity(new Intent(MainActivity.this,EventBusActivity.class));
    }

    @OnClick(R.id.glide_transformations) public void onGlideTransformationsClicked() {
        startActivity(new Intent(MainActivity.this,GlideTransFormationActivity.class));
    }

    @OnClick(R.id.tasty_toast) public void onTastyToastClicked() {
        startActivity(new Intent(MainActivity.this,TastyToastActivity.class));
    }

    @OnClick(R.id.material_dialogs) public void onMaterialDialogsClicked() {
        startActivity(new Intent(MainActivity.this,MaterialDialogActivity.class));
    }

    @OnClick(R.id.logger) public void onLoggerClicked() {
        startActivity(new Intent(MainActivity.this,LoggerActivity.class));
    }
}
