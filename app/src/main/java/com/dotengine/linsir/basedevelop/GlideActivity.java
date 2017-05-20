package com.dotengine.linsir.basedevelop;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  Created by linSir 
 *  date at 2017/5/20.
 *  describe: glide库的demo
 */

public class GlideActivity extends AppCompatActivity {

    @BindView(R.id.img1) ImageView img1;
    @BindView(R.id.img2) ImageView img2;
    @BindView(R.id.img3) ImageView img3;
    @BindView(R.id.img4) ImageView img4;
    @BindView(R.id.img5) ImageView img5;
    @BindView(R.id.img6) ImageView img6;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);

        Glide.with(this).load("http://goo.gl/gEgYUd").into(img1);


        Glide.with(this)
                .load("http://goo.gl/gEgYUd")
                .fitCenter()
                .centerCrop()
                .into(img2);


        Glide.with(this)
                .load("")
                .fitCenter()
                .centerCrop()
                .error(R.mipmap.ic_launcher)
                .into(img3);

        Glide.with(this)
                .load("http://goo.gl/gEgYUd")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img4);

        Glide.with(this)
                .load("http://goo.gl/gEgYUd")
                .crossFade()
                .into(img5);

        Glide.with(this)
                .load("http://goo.gl/gEgYUd")
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {

                        img6.setImageDrawable(resource);
                    }
                });
    }
}
