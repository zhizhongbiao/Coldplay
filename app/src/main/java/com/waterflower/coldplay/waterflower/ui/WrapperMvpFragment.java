package com.waterflower.coldplay.waterflower.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import com.waterflower.coldplay.waterflower.basic.presenter.MvpPresenter;
import com.waterflower.coldplay.waterflower.basic.utils.LogUtils;
import com.waterflower.coldplay.waterflower.basic.utils.ToastUtil;
import com.waterflower.coldplay.waterflower.basic.view.MvpFragment;


/**
 * Author : WaterFlower.
 * Created on 2017/8/22.
 * Desc :   只是包裹一下,让一些有些子类用不到的的方法不用传递给子类实现
 */

public abstract class WrapperMvpFragment<P extends MvpPresenter> extends MvpFragment<P> {


    @Override
    protected void loadData(Bundle savedInstanceState) {

    }

    protected String getTextFromEt(EditText et) {
        if (et == null) {
            LogUtils.e("EditText==null");
            return "";
        }

        return et.getText().toString().trim();

    }

    protected boolean isEmpty(String text, String toastMsg) {
        if (TextUtils.isEmpty(text)) {
            if (!TextUtils.isEmpty(toastMsg))
                ToastUtil.showShort("请输入有效的"+toastMsg);
            return false;
        }
        return true;
    }
}
