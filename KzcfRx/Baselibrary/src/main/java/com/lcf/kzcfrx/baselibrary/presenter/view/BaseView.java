package com.lcf.kzcfrx.baselibrary.presenter.view;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/28
 * Description:
 **/
public interface BaseView {
    void showLoading();

    void hideLoading();

    void onError(String text);
}
