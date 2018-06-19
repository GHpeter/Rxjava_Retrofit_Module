package com.lcf.kzcfrx.baselibrary.widget;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lcf.kzcfrx.baselibrary.R;
import com.lcf.kzcfrx.baselibrary.tools.ScreenUtil;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/30
 * Description:
 **/
public class CustomToast extends Toast {

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public CustomToast(Context context) {
        super(context);
    }


    public static Toast makeToastWithIcon(Context context, CharSequence text, int iconId) {
        CustomToast result = new CustomToast(context);
        TextView view = new TextView(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        view.setMinWidth(ScreenUtil.dip2px(context, 155));
        view.setGravity(Gravity.CENTER);
        view.setTextColor(Color.WHITE);
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX,ScreenUtil.dip2px(context, 17));
        view.setBackgroundResource(R.drawable.bg_toast);
        view.setPadding(ScreenUtil.dip2px(context, 20),ScreenUtil.dip2px(context, 16),
                ScreenUtil.dip2px(context, 20),ScreenUtil.dip2px(context, 16));
        result.setGravity(Gravity.CENTER, 0, 0);
        result.setView(view);
        view.setText(text);
        if(iconId != -1) {
            view.setCompoundDrawablePadding(ScreenUtil.dip2px(context, 5));
            Drawable drawable = ContextCompat.getDrawable(context, iconId);
            drawable.setBounds(0, 0, ScreenUtil.dip2px(context, 30),
                    ScreenUtil.dip2px(context, 30));
            view.setCompoundDrawables(null, drawable, null, null);
        } else {
            view.setCompoundDrawables(null, null, null, null);
        }
        return result;
    }

    public static Toast makeWarnToast(Context context, CharSequence text) {
        return makeToastWithIcon(context, text, R.mipmap.toast_ic_warn);
    }

    public static Toast makeToastWithOutIcon(Context context, CharSequence text) {
        return makeToastWithIcon(context, text, -1);
    }

    public static void showWarnToast(Context context, CharSequence text) {
        makeToastWithIcon(context, text, R.mipmap.toast_ic_warn).show();
    }

    public static void showSuccessToast(Context context, CharSequence text) {
        makeToastWithIcon(context, text, R.mipmap.toast_ic_sucess).show();
    }

    public static void showIconToast(Context context, CharSequence text, int iconId) {
        makeToastWithIcon(context, text, iconId).show();
    }

    public static void showNonIconToast(Context context, CharSequence text) {
        makeToastWithIcon(context, text, -1).show();
    }

}
