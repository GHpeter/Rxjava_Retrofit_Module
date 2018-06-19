package com.lcf.usercenter.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lcf.kzcfrx.baselibrary.ui.activity.BaseActivity;
import com.lcf.kzcfrx.baselibrary.ui.activity.BaseMvpActivity;
import com.lcf.kzcfrx.baselibrary.widget.CustomToast;
import com.lcf.usercenter.R;
import com.lcf.usercenter.ui.presenter.RegisterPrester;
import com.lcf.usercenter.ui.presenter.view.RegisterView;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/28
 * Description:
 **/
public class RegisterActivity extends BaseMvpActivity<RegisterPrester> implements RegisterView, View.OnClickListener {
    private Button mRegisterBtn;
    private RegisterPrester prester = new RegisterPrester();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prester.mView = this;
        setContentView(R.layout.act_register);
        initView();
    }

    private void initView() {
        mRegisterBtn = (Button) findViewById(R.id.mRegisterBtn);
        mRegisterBtn.setOnClickListener(this);
    }

    @Override
    public void showLoading() {
        super.showLoading();
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
    }

    @Override
    public void onError(String text) {
        super.onError(text);
    }

    @Override
    public void onRegisterResult(String result) {
        CustomToast.showWarnToast(RegisterActivity.this,result);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.mRegisterBtn) {
//            prester.register(RegisterActivity.this,"红楼梦", "","");
            prester.testNetInfo(RegisterActivity.this, "1002", "test123");
        }
    }
}
