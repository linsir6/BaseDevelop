package com.dotengine.linsir.basedevelop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;

/**
 *  Created by linSir 
 *  date at 2017/5/20.
 *  describe:      
 */

public class GlideTransFormationActivity extends AppCompatActivity {

    @BindView(R.id.img1) ImageView img1;
    @BindView(R.id.img2) ImageView img2;
    @BindView(R.id.img3) ImageView img3;
    @BindView(R.id.img4) ImageView img4;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_transformat);
        ButterKnife.bind(this);

        //可以修改颜色，加滤镜，剪裁，gpu加速等

        Glide.with(this).load("https://ws1.sinaimg.cn/large/006tNbRwly1ffs6l68mx3j30ge0gen08.jpg")
                .bitmapTransform(new BlurTransformation(this, 30), new CropCircleTransformation(this))
                .into((ImageView) findViewById(R.id.img1));

        Glide.with(this).load("https://ws1.sinaimg.cn/large/006tNbRwly1ffs6l68mx3j30ge0gen08.jpg")
                .bitmapTransform(new CropCircleTransformation(this))
                .into((ImageView) findViewById(R.id.img2));

        Glide.with(this).load("https://ws1.sinaimg.cn/large/006tNbRwly1ffs6l68mx3j30ge0gen08.jpg")
                .bitmapTransform(new CropSquareTransformation(this))
                .into((ImageView) findViewById(R.id.img3));

        Glide.with(this).load("https://ws1.sinaimg.cn/large/006tNbRwly1ffs6l68mx3j30ge0gen08.jpg")
                .bitmapTransform(new ColorFilterTransformation(this, 0x80dfdfdf))
                .into((ImageView) findViewById(R.id.img4));


    }
}
