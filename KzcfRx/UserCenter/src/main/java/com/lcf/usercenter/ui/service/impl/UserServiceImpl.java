package com.lcf.usercenter.ui.service.impl;

import android.content.Context;

import com.lcf.kzcfrx.baselibrary.rx.ext.ResultModel;
import com.lcf.kzcfrx.provider.bean.TestLoginBean;
import com.lcf.kzcfrx.provider.net.RetrofitHelper;
import com.lcf.usercenter.ui.service.UserService;

import java.util.Map;

import io.reactivex.Observable;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/29
 * Description:
 **/
public class UserServiceImpl  implements UserService {



    @Override
    public Observable<Object> login(Context mContext,Map<String, String> map) {
        return RetrofitHelper.getInstance(mContext).getService().login(map);
    }

    @Override
    public Observable<ResultModel<TestLoginBean>> testNetInfo(Context mContext, Map<String,String> map){
        return RetrofitHelper.getInstance(mContext).getService().testNetInfo(map);
    }


}
