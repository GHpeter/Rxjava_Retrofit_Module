package com.lcf.kzcfrx.baselibrary.base;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.lcf.kzcfrx.baselibrary.common.Apps;
import com.lcf.kzcfrx.baselibrary.tools.AppUtils;
import com.socks.library.KLog;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/30
 * Description:
 **/
public class MyApplication extends LifecycleApplication {


    public static Context mContext;
    public static MyApplication mInstance;

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public static Context getContext() {

        return mContext;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initKLogConfig();
        Apps.device = new AppUtils(this).getUniqueID();
    }

    private void initKLogConfig() {
        KLog.init(true, "kzcfRxApplication");
    }
}
