package com.dotengine.linsir.basedevelop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;

/**
 *  Created by linSir 
 *  date at 2017/5/20.
 *  describe: noHttp的demo
 */

public class NoHttpActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nohttp);

        //同步请求，结果直接存储在了response
        Request<String> request = NoHttp.createStringRequest("自己的url", RequestMethod.POST);
        Response<String> response = NoHttp.startRequestSync(request);
        String result = response.get();
        //可以直接将结果取出，并且内置了Gson，fastJson，可以直接将结果转换成对应的model




        //异步请求，可以构建请求队列，默认同时三个请求一起，参数可调
        RequestQueue requestQueue = NoHttp.newRequestQueue();

        OnResponseListener<String> listener = new OnResponseListener<String>() {
            @Override public void onStart(int what) {

            }

            @Override public void onSucceed(int what, Response response) {

            }

            @Override public void onFailed(int what, Response response) {

            }

            @Override public void onFinish(int what) {

            }
        };

        //请求String
        Request<String> request2 = NoHttp.createStringRequest("自己的url", RequestMethod.GET);
        requestQueue.add(0, request2, listener);

        //可以自定义请求类型

/*
        // JsonObject
        Request<JSONObject> objRequest = NoHttp.createJsonObjectRequest("自己的url", RequestMethod.POST);
        requestQueue.add(0, objRequest, listener);

        // JsonArray
        Request<JSONArray> arrayRequest = NoHttp.createJsonArrayRequest("自己的url", RequestMethod.PUT);
        requestQueue.add(0, arrayRequest, listener);


        Request<JSONObject> request = new FastJsonRequest(url, RequestMethod.POST);
        requestQueue.add(0, request, listener);

        // 内部使用Gson、FastJson解析成JavaBean
        Request<UserInfo> request = new JavaBeanRequest(url, RequestMethod.GET);
        requestQueue.add(0, request, listener);

        Request<JSONObject> request = new JavaBeanRequest(url, RequestMethod.POST);
           .add("name", "yoldada") // String类型
           .add("age", 18) // int类型
           .add("sex", '0') // char类型
           .add("time", 16346468473154) // long类型

           // 添加Bitmap
           .add("head", new BitmapBinary(bitmap))
           // 添加File
           .add("head", new FileBinary(file))
           // 添加ByteArray
           .add("head", new ByteArrayBinary(byte[]))
           // 添加InputStream
           .add("head", new InputStreamBinary(inputStream));

*/


        //nohttp同时有非常完备的缓存的策略，同时对文件上传，请求包体都有非常好的兼容，并且全都是中文文档~



    }
}
