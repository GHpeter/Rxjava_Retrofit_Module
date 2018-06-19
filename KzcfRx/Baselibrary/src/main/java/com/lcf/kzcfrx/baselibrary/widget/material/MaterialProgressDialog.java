package com.lcf.kzcfrx.baselibrary.widget.material;

import android.content.Context;
import android.view.View;

import com.lcf.kzcfrx.baselibrary.R;
import com.lcf.kzcfrx.baselibrary.widget.BaseDialog;

/**
 * .
 */

public class MaterialProgressDialog extends BaseDialog {

    public MaterialProgressDialog(Context context) {
        super(context, R.style.LoadingDialog);
    }

    @Override
    public int initLayoutId() {
        return R.layout.view_material_progress_bar;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void beforeShow() {

    }
}
