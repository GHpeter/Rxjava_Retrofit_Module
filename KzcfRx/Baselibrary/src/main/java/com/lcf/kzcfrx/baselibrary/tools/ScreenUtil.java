package com.lcf.kzcfrx.baselibrary.tools;

import android.content.Context;
import android.util.TypedValue;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/30
 * Description:
 **/
public class ScreenUtil {

    public static int dip2px(Context context, float f) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, f, context.getResources().getDisplayMetrics());
        //return (int) (0.5D + (double) (f * getDensity(context)));
    }

    public static int dip2px(Context context, int i) {
        return dip2px(context, (float) i);
    }


    public static int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int getScreenDensityDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }


    public static float getXdpi(Context context) {
        return context.getResources().getDisplayMetrics().xdpi;
    }

    public static float getYdpi(Context context) {
        return context.getResources().getDisplayMetrics().ydpi;
    }

    public static int px2dip(Context context, float f) {
        float f1 = getDensity(context);
        return (int) (((double) f - 0.5D) / (double) f1);
    }

    public static int px2dip(Context context, int i) {
        float f = getDensity(context);
        return (int) (((double) i - 0.5D) / (double) f);
    }

    public static int getDimensionPixel(Context context, int dimId) {
        return context.getResources().getDimensionPixelSize(dimId);
    }

    public static float getDimension(Context context, int dimId) {
        return context.getResources().getDimension(dimId);
    }
    public static int getStatusBarHeight(Context context) {
        // 获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }
}
