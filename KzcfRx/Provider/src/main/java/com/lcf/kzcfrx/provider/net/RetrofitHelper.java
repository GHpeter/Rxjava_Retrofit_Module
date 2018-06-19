package com.lcf.kzcfrx.provider.net;


import android.content.Context;

import com.lcf.kzcfrx.baselibrary.common.APIService;
import com.lcf.kzcfrx.baselibrary.data.net.TokenInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/28
 * Description:
 **/
public class RetrofitHelper {
    private static final int DEFAULT_TIMEOUT = 30;
    private static RetrofitHelper instance = null;
    private static String baseUrl = APIService.URL_BASE;
    private Context mContext;
    private Retrofit mRetorfit = null;

    public RetrofitHelper(Context context) {
        mContext = context;
        init();
    }

    private void init() {
        resetApp();
    }

    private void resetApp() {
        mRetorfit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(initOkhttpClien().build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private OkHttpClient.Builder initOkhttpClien() {
        //日志显示级别
        OkHttpClient.Builder httpclient = new OkHttpClient().newBuilder();
        httpclient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpclient.addInterceptor(new TokenInterceptor());
        //添加 token 过期拦截,和日志打印
        return httpclient;
    }

    public static RetrofitHelper getInstance(Context context) {
        if (instance == null) {
            instance = new RetrofitHelper(context);
        }
        return instance;
    }

    public RetrofitService getService() {
        return mRetorfit.create(RetrofitService.class);
    }


}
