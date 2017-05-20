package com.dotengine.linsir.basedevelop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;

/**
 *  Created by linSir 
 *  date at 2017/5/20.
 *  describe:      
 */

public class LoggerActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("hello");
        Logger.d("hello %s %d", "world", 5);   // String.format
        Logger.d("hello");
        Logger.e("hello");
        Logger.w("hello");
        Logger.v("hello");
        Logger.wtf("hello");

//        Logger.json(JSON_CONTENT);       //打印json
//        Logger.xml(XML_CONTENT);
//        Logger.log(DEBUG, "tag", "message", throwable);
//        Logger.d("hello %s", "world");
//
//        Logger.d(list);                  //打印list
//        Logger.d(map);
//        Logger.d(set);
//        Logger.d(new String[]);
//
//        Logger
//                .init(YOUR_TAG)                 // default PRETTYLOGGER or use just init()
//                .methodCount(3)                 // default 2
//                .hideThreadInfo()               // default shown
//                .logLevel(LogLevel.NONE)        // default LogLevel.FULL
//                .methodOffset(2)                // default 0
//                .logAdapter(new AndroidLogAdapter()); //default AndroidLogAdapter
//
//
//
        Logger.log(5000, "tag", "内容", null);//延时打log
    }


}
