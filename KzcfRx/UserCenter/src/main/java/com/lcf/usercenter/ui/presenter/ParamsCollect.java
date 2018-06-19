package com.lcf.usercenter.ui.presenter;

import com.lcf.kzcfrx.baselibrary.tools.MapParamsCollectUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/30
 * Description:
 **/
public class ParamsCollect {


    public static Map<String, String> loginMapParams(String userName, String pwd) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("username", userName);
        map.put("password", pwd);

        map.put("tradeCode", "applogin");


        HashMap<String, String> m1 = MapParamsCollectUtil.getMap(map);
        map.putAll(m1);
        return m1;
    }

    public static Map<String, String> testNetInfo(String phone, String pwd) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("phone", phone);
        map.put("pwd", pwd);

        return map;
    }
}
