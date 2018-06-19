package com.lcf.kzcfrx.baselibrary.presenter;

import android.app.Activity;

import com.lcf.kzcfrx.baselibrary.presenter.view.BaseView;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/28
 * Description:
 **/
public abstract  class BasePresenter<T extends BaseView> {
    private T mView;



    protected Activity mContext;

    public BasePresenter() {
    }

    public void onAttach(T view, Activity context) {
        this.mView = view;
        this.mContext = context;
    }

    public void onDetach() {
        this.mView = null;
        this.mContext = null;
    }

    public abstract void onStart();



}
