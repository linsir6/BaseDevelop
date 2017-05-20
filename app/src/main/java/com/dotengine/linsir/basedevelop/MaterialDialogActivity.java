package com.dotengine.linsir.basedevelop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  Created by linSir 
 *  date at 2017/5/20.
 *  describe:      
 */

public class MaterialDialogActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md_dialogs);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.button1) public void onButton1Clicked() {
        new MaterialDialog.Builder(this)
                .title("标题")
                .content("是否同意")
                .positiveText("同意")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(MaterialDialogActivity.this, "同意", Toast.LENGTH_SHORT).show();

                    }
                })
                .negativeText("不同意")
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(MaterialDialogActivity.this, "不同意", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    @OnClick(R.id.button2) public void onButton2Clicked() {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(this)
                .title("标题")
                .content("是否同意")
                .positiveText("同意");

        MaterialDialog dialog = builder.build();
        dialog.show();
        //dialog.dismiss();
    }

    @OnClick(R.id.button3) public void onButton3Clicked() {
        new MaterialDialog.Builder(this)
                .title("标题")
                .content("是否同意")
                .positiveText("1111")
                .negativeText("2222")
                .neutralText("3333")
                .show();
    }

    @OnClick(R.id.button4) public void onButton4Clicked() {
        new MaterialDialog.Builder(this)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(MaterialDialogActivity.this, "1111", Toast.LENGTH_SHORT).show();
                    }
                })
                .onNeutral(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(MaterialDialogActivity.this, "2222", Toast.LENGTH_SHORT).show();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(MaterialDialogActivity.this, "3333", Toast.LENGTH_SHORT).show();
                    }
                })
                .onAny(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(MaterialDialogActivity.this, "4444", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @OnClick(R.id.button5) public void onButton5Clicked() {
        new MaterialDialog.Builder(this)
                .iconRes(R.mipmap.ic_launcher)
                .limitIconToDefaultSize()
                .title("test")
                .positiveText("allow")
                .negativeText("deny")
                .onAny(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(MaterialDialogActivity.this, "Prompt checked? " + dialog.isPromptCheckBoxChecked(), Toast.LENGTH_SHORT).show();
                    }
                })
                .checkBoxPromptRes(R.string.app_name, false, null)
                .show();
    }

    @OnClick(R.id.button6) public void onButton6Clicked() {
        new MaterialDialog.Builder(this)
                .title("test")
                .items(R.array.good)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        Toast.makeText(MaterialDialogActivity.this, "点击的是  " + which, Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    @OnClick(R.id.button7) public void onButton7Clicked() {
        new MaterialDialog.Builder(this)
                .title("test")
                .items(R.array.good)
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        /**
                         * If you use alwaysCallSingleChoiceCallback(), which is discussed below,
                         * returning false here won't allow the newly selected radio button to actually be selected.
                         **/
                        return true;
                    }
                })
                .positiveText(R.string.app_name)
                .show();
    }


}
