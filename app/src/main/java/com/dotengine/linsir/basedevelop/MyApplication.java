package com.dotengine.linsir.basedevelop;

import android.app.Application;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.squareup.leakcanary.LeakCanary;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.OkHttpNetworkExecutor;
import com.yanzhenjie.nohttp.cookie.DBCookieStore;

/**
 *  Created by linSir 
 *  date at 2017/5/16.
 *  describe:      
 */

public class MyApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();

        /*
         * LeakCanary用来专注分析系统的进程
         */

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }

        TypefaceProvider.registerDefaultIconSets();

        LeakCanary.install(this);

        NoHttp.initialize(this, new NoHttp.Config()
                // 默认保存数据库DBCookieStore，开发者也可以自己实现CookieStore接口。
                .setCookieStore(
                        new DBCookieStore(this).setEnable(false) // 如果不维护cookie，设置false禁用。

                )
                .setNetworkExecutor(new OkHttpNetworkExecutor())
        );

        Logger.setDebug(true);// 开启NoHttp的调试模式, 配置后可看到请求过程、日志和错误信息。
        Logger.setTag("NoHttpSample");// 设置NoHttp打印Log的tag。

    }
}
