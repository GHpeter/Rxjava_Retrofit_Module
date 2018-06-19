package com.lcf.kzcfrx.provider.net;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.lcf.kzcfrx.baselibrary.rx.ext.ResultModel;
import com.lcf.kzcfrx.baselibrary.rx.ext.ServerException;
import com.lcf.kzcfrx.baselibrary.tools.NetUtils;
import com.lcf.kzcfrx.baselibrary.widget.CustomToast;
import com.lcf.kzcfrx.baselibrary.widget.material.MaterialProgressDialog;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.atomic.AtomicReference;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import retrofit2.adapter.rxjava2.HttpException;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/29
 * Description:对返回值的封装，以及对请求效果的封装
 **/
public abstract class BaseObserver<T extends ResultModel> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private Context mContext;
    private Disposable disposable;


    private Dialog proDialog;//等待提示框
    private boolean showProgress = true;

    //默认无效果的请求
    protected BaseObserver(Context context) {
        this.mContext = context;
    }

    //带进度条的请求
    protected BaseObserver(Context context, boolean showProgress) {
        this.mContext = context;
        this.showProgress = showProgress;
        if (showProgress && proDialog == null) {
            proDialog = initProgress();
        }
    }


    protected Dialog initProgress() {
        MaterialProgressDialog proDialog = new MaterialProgressDialog(mContext);
        proDialog.setCanceledOnTouchOutside(false);
        return proDialog;
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (showProgress && proDialog != null && !proDialog.isShowing()) {
            proDialog.show();
        }
        disposable = d;


    }

    @Override
    public void onNext(T value) {
        Log.i("value", value.toString());

        if (showProgress && proDialog != null && proDialog.isShowing()) {
            proDialog.dismiss();
        }
        if (mContext == null)
            return;
        if (mContext instanceof Activity && (((Activity) mContext).isDestroyed()
                || ((Activity) mContext).isFinishing())) {
            return;
        }
        if (value instanceof ResultModel) {

            if (value.getCode() == 0) {
                onSuccess(value);
            } else {
                onHandleError(value.getMsg());
            }


        }
    }

    public abstract void onSuccess(T t);

    protected void onHandleError(String msg) {
        CustomToast.showWarnToast(mContext, msg);
    }

    @Override
    public void onError(Throwable e) {
        Log.i("Observer.java", e.toString());
        if (showProgress && proDialog != null && proDialog.isShowing()) {
            proDialog.dismiss();
        }
        if (mContext == null)
            return;
        final ResultModel baseModel = new ResultModel();
        if (e instanceof ServerException) {
            baseModel.setCode(((ServerException) e).getCode());
            baseModel.setMsg(((ServerException) e).getMsg());
        } else if (e instanceof SocketTimeoutException) {
            baseModel.setMsg("网络连接超时，请稍后重试");
        } else if (e instanceof ConnectException) {
            baseModel.setMsg("网络异常，请检查您的网络");
        } else if (e instanceof RuntimeException) {
            baseModel.setMsg("系统异常");
        } else {
//            baseModel.setMessage("未知错误");
            baseModel.setMsg("网络异常，请稍后重试或联系客服");
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                onFailure(baseModel);
            }
        });


        disposeIt();
    }

    protected void onFailure(ResultModel model) {
        CustomToast.showWarnToast(mContext, model.getMsg());

    }

    /**
     * 销毁dispose
     */
    protected void disposeIt() {
        if (showProgress && proDialog != null && proDialog.isShowing()) {
            proDialog.dismiss();
        }
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
            disposable = null;
        }
    }

    @Override
    public void onComplete() {
        disposeIt();
    }

    @Override
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

}
