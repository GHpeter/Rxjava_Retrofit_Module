package com.lcf.kzcfrx.baselibrary.rx.ext;

import java.io.IOException;

/**
 * https://github.com/whaoming/ASElectricBicycle/blob/master/common/src/main/java/com/wxxiaomi/ming/common/net/ServerException.java
 * http://blog.csdn.net/jdsjlzx/article/details/51882661
 * 用来匹配服务器的数据规则
 */

public class ServerException extends IOException {

    public int code;
    public String msg;

    public ServerException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}