package com.lcf.kzcfrx.baselibrary.data.protocol;

public class ApiException extends Exception {
    public int code;
    public String msg;

    public ApiException(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }
}
