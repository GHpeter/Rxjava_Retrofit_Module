package com.lcf.kzcfrx.provider.net.presenter;

import android.app.Dialog;

import com.lcf.kzcfrx.baselibrary.presenter.BasePresenter;
import com.lcf.kzcfrx.baselibrary.presenter.view.BaseView;
import com.lcf.kzcfrx.baselibrary.widget.CustomToast;
import com.lcf.kzcfrx.baselibrary.widget.material.MaterialProgressDialog;
import com.lcf.kzcfrx.provider.net.BaseObserver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/30
 * Description:
 **/
public abstract class BaseNetPresenter<T extends BaseView> extends BasePresenter<T>  {

    private static List<Disposable> disposableList = new ArrayList<>();

    public List<Disposable> getDisposableList() {
        return disposableList;
    }

    private Dialog proDialog;//等待提示框

    @Override
    public void onDetach() {
        if (disposableList != null && !disposableList.isEmpty()) {
            for (Disposable disposable : disposableList) {
                if (disposable.isDisposed()) {
                    continue;
                }
                disposable.dispose();
            }
            disposableList.clear();
            disposableList = null;
        }

        if (proDialog != null && proDialog.isShowing()) {
            proDialog.dismiss();
            proDialog = null;
        }
        super.onDetach();
    }

    /**
     * 请求数据
     *
     * @param observable
     * @param observer
     */
    public static  void doRequest(final Observable observable, final BaseObserver observer) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        if (disposableList != null) {
            disposableList.add(observer);
        }
    }

    /**
     * 获取图片上传请求
     *
     * @param filePath
     * @return
     */
    protected MultipartBody.Part getImageUploadPart(String filePath) {
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        File file = new File(filePath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), file);
        return MultipartBody.Part.createFormData("image", fileName, requestBody);
    }

    protected void showProDialog() {
        if (proDialog == null) {
            proDialog = new MaterialProgressDialog(mContext);
            proDialog.setCanceledOnTouchOutside(false);
        }
        if (!proDialog.isShowing()) {
            proDialog.show();
        }
    }

    protected void dismissProDialog() {
        if (proDialog != null && proDialog.isShowing()) {
            proDialog.dismiss();
        }
    }

    protected void showWarnToast(String msg) {
        if (mContext != null) {
            CustomToast.showWarnToast(mContext, msg);
        }
    }

    protected void showSuccessToast(String msg) {
        if (mContext != null) {
            CustomToast.showSuccessToast(mContext, msg);
        }
    }



}
