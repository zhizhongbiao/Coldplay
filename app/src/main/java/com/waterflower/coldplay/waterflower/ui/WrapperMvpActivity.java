package com.waterflower.coldplay.waterflower.ui;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.waterflower.coldplay.waterflower.basic.model.BaseBean;
import com.waterflower.coldplay.waterflower.basic.network.ApiConfig;
import com.waterflower.coldplay.waterflower.basic.presenter.MvpPresenter;
import com.waterflower.coldplay.waterflower.basic.utils.LogUtils;
import com.waterflower.coldplay.waterflower.basic.utils.ToastUtil;


/**
 * Author : WaterFlower.
 * Created on 2017/8/11.
 * Desc :   只是包裹一下,让一些有些子类用不到的的方法不用传递给子类实现
 */

public abstract class WrapperMvpActivity<P extends MvpPresenter> extends WrapperSwipeBackMvpActivity<P> {

    @Override
    protected void loadData(Bundle savedInstanceState, Intent intent) {

    }


    @Override
    public void showContentView(String url, BaseBean baseBean) {
        if (url.contains(ApiConfig.API_LOGOUT)) {
            startActivity(LoginActivity.getIntent(this));
            finish();
        }
    }




    protected void logout() {
        presenter.postData(ApiConfig.API_LOGOUT, BaseBean.class);
    }



    protected String getTextFromEt(TextView tv) {
        if (tv == null) {
            LogUtils.e("EditText==null");
            return "";
        }

        return tv.getText().toString().trim();

    }

    protected boolean isEmpty(String text, String toastMsg) {
        if (TextUtils.isEmpty(text)) {
            if (!TextUtils.isEmpty(toastMsg))
                ToastUtil.showShort("请输入有效的" + toastMsg);
            return true;
        }
        return false;
    }

    protected boolean isValidLength(String text, String msg) {
        if (!TextUtils.isEmpty(text) && text.length() >= 6 && text.length() <= 16) return true;
        ToastUtil.showShort(msg + "长度不对,请输入6-16个字符的" + msg);
        return false;
    }

}
