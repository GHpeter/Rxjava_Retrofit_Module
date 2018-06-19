package com.lcf.kzcfrx.baselibrary.data.protocol;

import android.net.ParseException;
import android.util.Log;

import com.google.gson.JsonParseException;
import com.lcf.kzcfrx.baselibrary.rx.ext.ServerException;

import org.json.JSONException;

import java.net.ConnectException;

import retrofit2.adapter.rxjava2.HttpException;


/**
 * http://blog.csdn.net/mq2553299/article/details/70244529
 * http://blog.csdn.net/jdsjlzx/article/details/51882661
 * https://github.com/qingmei2/Samples-Android/blob/master/SampleNetErrorUtil/app/src/main/java/com/mei_husky/sampleneterrorutil/model/util/ExceptionHandle.java
 */

public class ExceptionHandle {

    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    public static ApiException handleException(Throwable e) {
        ApiException ex;
        Log.i("tag", "e.toString = " + e.toString());
        if (e instanceof HttpException) { //HTTP错误
            HttpException httpException = (HttpException) e;
            ex = new ApiException(e, ERROR.HTTP_ERROR);
            switch (httpException.code()) {
                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    ex.code = httpException.code();
//                    ex.msg = "网络错误";
                    ex.msg = httpException.message();
                    break;
            }
            return ex;
        } else if (e instanceof ServerException) {//服务器返回的错误
            ServerException resultException = (ServerException) e;
            ex = new ApiException(resultException, resultException.code);
            ex.msg = resultException.msg;
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            ex = new ApiException(e, ERROR.PARSE_ERROR);
            ex.msg = "解析错误";//均视为解析错误
            return ex;
        } else if (e instanceof ConnectException) { //均视为网络错误
            ex = new ApiException(e, ERROR.NETWORD_ERROR);
            ex.msg = "网络连接失败";
            return ex;
        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            ex = new ApiException(e, ERROR.SSL_ERROR);
            ex.msg = "证书验证失败";
            return ex;
        } else { //未知错误
            ex = new ApiException(e, ERROR.UNKNOWN);
            ex.msg = "未知错误:" + e.getMessage();
            return ex;
        }
    }

    /**
     * 约定异常
     */
    public static final class ERROR {
        /**
         * 未知错误
         */
        public static final int UNKNOWN = 1000;
        /**
         * 解析错误
         */
        public static final int PARSE_ERROR = 1001;
        /**
         * 网络错误
         */
        public static final int NETWORD_ERROR = 1002;
        /**
         * 协议出错
         */
        public static final int HTTP_ERROR = 1003;

        /**
         * 证书出错
         */
        public static final int SSL_ERROR = 1005;
    }
}
