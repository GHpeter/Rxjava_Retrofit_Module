package com.lcf.kzcfrx.baselibrary.ui.activity;

import com.lcf.kzcfrx.baselibrary.presenter.BasePresenter;
import com.lcf.kzcfrx.baselibrary.presenter.view.BaseView;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/28
 * Description:
 **/
public class BaseMvpActivity<T extends BasePresenter> extends BaseActivity
        implements BaseView {

    private T presenter;


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String text) {

    }
}
