package com.lcf.usercenter.ui.presenter;

import android.content.Context;

import com.lcf.kzcfrx.baselibrary.rx.ext.ResultModel;
import com.lcf.kzcfrx.baselibrary.widget.CustomToast;
import com.lcf.kzcfrx.provider.net.BaseObserver;
import com.lcf.kzcfrx.baselibrary.presenter.BasePresenter;
import com.lcf.kzcfrx.provider.net.presenter.BaseNetPresenter;
import com.lcf.kzcfrx.provider.bean.TestLoginBean;
import com.lcf.usercenter.ui.presenter.view.RegisterView;
import com.lcf.usercenter.ui.service.impl.UserServiceImpl;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/28
 * Description:
 **/
public class RegisterPrester extends BasePresenter<RegisterView> {
    public RegisterView mView;
    UserServiceImpl impl = new UserServiceImpl();


//    public void login(final Context mContext, String userName, String pwd) {
//        BaseNetPresenter.doRequest(impl.login(mContext, ParamsCollect.loginMapParams(userName, pwd))
//                , new BaseObserver<>(mContext, true) {
//
//                    @Override
//                    protected void onHandleSuccess(Object s) {
//                        mView.onRegisterResult(s.toString());
//                    }
//
//                }
//        );
//
//    }

    public void testNetInfo(final Context mContext, String phone, String pwd) {
        BaseNetPresenter.doRequest(impl.testNetInfo(mContext, ParamsCollect.testNetInfo(phone, pwd)),
                new BaseObserver<ResultModel<TestLoginBean>>(mContext, true) {

                    @Override
                    public void onSuccess(ResultModel<TestLoginBean> testLoginBean) {
                        mView.onRegisterResult(testLoginBean.getData().toString());

                    }
                });


    }


    @Override
    public void onStart() {

    }
}
