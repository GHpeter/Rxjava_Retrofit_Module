package com.lcf.kzcfrx.baselibrary.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.multidex.MultiDexApplication;

import com.lcf.kzcfrx.baselibrary.common.ConstantValue;
import com.socks.library.KLog;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/6/12
 * Description:
 **/
@SuppressWarnings("unused")
public class LifecycleApplication extends MultiDexApplication {
    protected static final String TAG = "LifecycleApplication";
    /**
     * 当前活动的Activity数量
     */
    private int count = ConstantValue.NUMBER0;

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ActivityManager.push(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
                ActivityManager.setTopActivity(activity);
                if (count++ == ConstantValue.NUMBER0) {
                    KLog.i(TAG, ">>>>>>>>>>>>>>>>>>> 切到前台 <<<<<<<<<<<<<<<<<<<");

                }
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
                count--;
                if (count == ConstantValue.NUMBER0) {
                    KLog.i(TAG, ">>>>>>>>>>>>>>>>>>> 切到后台 <<<<<<<<<<<<<<<<<<<");
                }
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                ActivityManager.remove(activity);
            }
        });
    }

}

