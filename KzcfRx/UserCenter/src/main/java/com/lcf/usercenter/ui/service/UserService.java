package com.lcf.usercenter.ui.service;

import android.content.Context;

import com.lcf.kzcfrx.baselibrary.rx.ext.ResultModel;
import com.lcf.kzcfrx.provider.bean.TestLoginBean;

import java.util.Map;

import io.reactivex.Observable;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/29
 * Description:
 **/
public interface UserService {

    Observable<Object> login(Context mContext,Map<String, String> map);

    Observable<ResultModel<TestLoginBean>> testNetInfo(Context mContext, Map<String, String> map);
}
