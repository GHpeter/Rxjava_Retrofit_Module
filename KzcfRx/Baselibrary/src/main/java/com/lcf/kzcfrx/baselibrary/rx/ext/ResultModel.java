package com.lcf.kzcfrx.baselibrary.rx.ext;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/6/19
 * Description:
 **/
public class ResultModel<T> implements Serializable {
    @SerializedName("data")
    public T data;
    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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

    @Override
    public String toString() {
        return "ResultModel{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
