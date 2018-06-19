package com.lcf.kzcfrx.provider.net;


import com.lcf.kzcfrx.baselibrary.common.APIService;
import com.lcf.kzcfrx.baselibrary.rx.ext.ResultModel;
import com.lcf.kzcfrx.provider.bean.TestLoginBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/28
 * Description:
 **/
public interface RetrofitService {

    @FormUrlEncoded
    @POST(APIService.AFTER_URL)
    Observable<Object> login(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST(APIService.AFTER_URL)
    Observable<ResultModel<TestLoginBean>> testNetInfo(@FieldMap Map<String, String> map);


}
