package com.lcf.kzcfrx.provider.bean;

import java.io.Serializable;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/29
 * Description:
 **/
public class BaseBean<T> implements Serializable {
    //用来模仿resultCode和resultMessage
    private int count;
    private int start;
    private int total;
    private String title;

    //用来模仿Data
    private T subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public T getSubject() {
        return subjects;
    }

    public void setSubjects(T subjects) {
        this.subjects = subjects;
    }
}