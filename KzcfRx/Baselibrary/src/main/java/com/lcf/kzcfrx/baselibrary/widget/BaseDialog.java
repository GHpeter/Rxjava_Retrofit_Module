package com.lcf.kzcfrx.baselibrary.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.lcf.kzcfrx.baselibrary.R;

import butterknife.ButterKnife;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/30
 * Description:
 **/
public abstract class BaseDialog extends Dialog {


    public BaseDialog(Context context) {
        this(context, R.style.CustomDialog);
    }

    public BaseDialog(Context context, int theme) {
        super(context, theme);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(initLayoutId(), null);
        setContentView(view, new ViewGroup.LayoutParams((int) (getContext().getResources().getDisplayMetrics().widthPixels*0.8), ViewGroup.LayoutParams.WRAP_CONTENT));
        ButterKnife.bind(this);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        window.setGravity(Gravity.CENTER);  //此处可以设置dialog显示的位置
        window.setBackgroundDrawableResource(R.color.transparent);
        initView(view);
    }

    @Override
    public void show() {
        beforeShow();
        super.show();
    }

    /**
     * 获取布局ID
     * @return
     */
    public abstract int initLayoutId();

    /**
     * 初始化视图控件
     * @param view
     */
    public abstract void initView(View view);

    /**
     * 对话框展示之前的操作
     */
    public abstract void beforeShow();
}
