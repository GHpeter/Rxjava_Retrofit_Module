package com.lcf.kzcfrx.baselibrary.data.entity;

import java.io.Serializable;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/29
 * Description:
 **/
public class ResponseBean<T>  implements Serializable{
    private int code;
    private String message;
    private T data;

    public ResponseBean(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message == null ? "" : message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    /**
     * 根据返回码确定API是否请求返回失败
     *
     * @return 失败返回true, 成功返回false
     */
    public boolean isCodeValid() {
        return code == 0;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
