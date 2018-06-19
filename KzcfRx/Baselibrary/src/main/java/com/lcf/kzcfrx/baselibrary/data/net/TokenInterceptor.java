package com.lcf.kzcfrx.baselibrary.data.net;


import android.util.Log;

import com.lcf.kzcfrx.baselibrary.BuildConfig;
import com.lcf.kzcfrx.baselibrary.common.APIService;
import com.socks.library.KLog;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/29
 * 拦截器，打印参数以及返回值，还可以设置token刷新
 */
public class TokenInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        String body = null;
        if (APIService.DEBUG) {

//            request.newBuilder()
//                    .addHeader("Cookie","")
//                    .build();


            RequestBody requestBody = request.body();
            if (requestBody != null) {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                Charset charset = UTF8;
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    charset = contentType.charset(UTF8);
                }
                body = buffer.readString(charset);
            }
            KLog.w("发送的请求\\nmethod：%s\\nurl：%s\\nheaders: %sbody：%s", request.method() , request.url(), request.headers(), body);
        }
        long startNs = System.nanoTime();
        Response response = chain.proceed(request);

        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
        ResponseBody responseBody = response.body();
        if (BuildConfig.DEBUG) {
            String rBody = null;
            if (responseBody != null) {
                BufferedSource source = responseBody.source();
                source.request(Long.MAX_VALUE); // Buffer the entire body.
                Buffer buffer = source.buffer();

                Charset charset = UTF8;
                MediaType contentType = responseBody.contentType();
                if (contentType != null) {
                    try {
                        charset = contentType.charset(UTF8);
                    } catch (UnsupportedCharsetException e) {
                        e.printStackTrace();
                    }
                }
                rBody = buffer.clone().readString(charset);

            }
            KLog.w("收到响应 %s%s %ss\n请求url：%s\n请求body：%s\n响应body：%s",
                    response.code(), response.message(), tookMs, response.request().url(), body, rBody);
        }
        return response;

  /*      *通过如下的办法曲线取到请求完成的数据
         * 原本想通过  originalResponse.body().string()
         * 去取到请求完成的数据,但是一直报错,不知道是okhttp的bug还是操作不当
         * 然后去看了okhttp的源码,找到了这个曲线方法,取到请求完成的数据后,根据特定的判断条件去判断token过期

        ResponseBody responseBody = originalResponse.body();
        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();
        Charset charset = UTF8;
        MediaType contentType = responseBody.contentType();
        if (contentType != null) {
            charset = contentType.charset(UTF8);
        }
        String bodyString = buffer.clone().readString(charset);
        System.out.println(bodyString);

        **************************************/
/*
        if (response shows expired token){//根据和服务端的约定判断token过期

            //取出本地的refreshToken
            String refreshToken = "sssgr122222222";

             通过一个特定的接口获取新的token，此处要用到同步的retrofit请求
            ApiService service = ServiceManager.getService(ApiService.class);
            Call<String> call = service.refreshToken(refreshToken);

            要用retrofit的同步方式
            String newToken = call.execute().body();


             create a new request and modify it accordingly using the new token
            Request newRequest = request.newBuilder().header("token", newToken)
                    .build();

            // retry the request

            originalResponse.body().close();
            return chain.proceed(newRequest);
        }*/
    }
}