package com.waterflower.coldplay.waterflower.ui;

import android.text.TextUtils;
import android.widget.TextView;

import com.waterflower.coldplay.waterflower.basic.presenter.MvpPresenter;
import com.waterflower.coldplay.waterflower.basic.utils.LogUtils;
import com.waterflower.coldplay.waterflower.basic.utils.ToastUtil;
import com.waterflower.coldplay.waterflower.basic.view.SwipeBackMvpActivity;


/**
 * Author : WaterFlower.
 * Created on 2017/9/26.
 * Desc : SwipeBackMvpActivity包装类
 */

public abstract class WrapperSwipeBackMvpActivity<P extends MvpPresenter> extends SwipeBackMvpActivity<P> {


    protected String getTextFromEt(TextView tv) {

        if (tv == null) {
            LogUtils.e("EditText==null");
            return "";
        }

        return tv.getText().toString().trim();

    }

    protected boolean isEmpty(String text, TextView tv, String errorMsg) {
        if (TextUtils.isEmpty(text)) {
            tv.setFocusable(true);
            tv.setFocusableInTouchMode(true);
            tv.requestFocusFromTouch();
            tv.requestFocus();
            tv.setError("请输入有效的" + errorMsg);
//                ToastUtil.showShort("请输入有效的" + toastMsg);
            return true;
        }
        return false;
    }


    protected boolean isEmpty(String text, String toastMsg) {
        if (TextUtils.isEmpty(text)) {
            if (!TextUtils.isEmpty(toastMsg))
                ToastUtil.showShort("请输入有效的" + toastMsg);
            return true;
        }
        return false;
    }


    protected boolean isValidLength(String text, String msg, int lengthRange) {
        if (!TextUtils.isEmpty(text) && text.length() >= 6 && text.length() <= 16) return true;
        ToastUtil.showShort(msg + "长度不对,请输入" + lengthRange + "个字符的" + msg);
        return false;
    }
}
