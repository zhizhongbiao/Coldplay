package com.waterflower.coldplay.waterflower.ui;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.widget.ImageView;

import com.waterflower.coldplay.MainActivity;
import com.waterflower.coldplay.R;
import com.waterflower.coldplay.waterflower.MyApp;
import com.waterflower.coldplay.waterflower.basic.model.BaseBean;
import com.waterflower.coldplay.waterflower.basic.network.ApiConfig;
import com.waterflower.coldplay.waterflower.basic.network.ResponseInfo;
import com.waterflower.coldplay.waterflower.basic.presenter.MvpPresenter;
import com.waterflower.coldplay.waterflower.basic.utils.ToastUtil;
import com.waterflower.coldplay.waterflower.basic.view.MvpActivity;
import com.waterflower.coldplay.waterflower.bean.LoginBean;

import java.io.Serializable;

import butterknife.BindView;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

/**
 * Author : WaterFlower.
 * Created on 2017/8/14.
 * Desc :   通用WebView
 */

@RuntimePermissions
public class SplashActivity extends MvpActivity<MvpPresenter> {


    @BindView(R.id.ivSplash)
    ImageView ivSplash;

    @Override
    public int getViewLayout() {
        return R.layout.activity_splash;

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //设置沉浸式状态栏, 设置全屏,与防止白屏的主题保持一致,避免产生闪屏的错觉
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent args) {
        SplashActivityPermissionsDispatcher.onAllowedWithCheck(this);
    }

    @Override
    protected void loadData(Bundle savedInstanceState, Intent intent) {

    }

    @Override
    public void showContentView(String url, BaseBean baseBean) {
        if (url.contains(ApiConfig.API_LOGIN)) {
            startActivity(MainActivity.getIntent(this));
            finish();
        }
    }


    private void nextStep() {
        ivSplash.postDelayed(new Runnable() {
            @Override
            public void run() {
                LoginBean loginBean = ((MyApp) getApplication()).getLoginBean();
                if (loginBean == null) {
                    toLoginManually();
                } else {
                    login(loginBean.userAccount, loginBean.psw);
                }

            }
        }, 100);
    }

    private void login(String loginPhone, String loginPsw) {
        presenter.setNeedDialog(false);
        ArrayMap<String, Serializable> params = new ArrayMap<>();
        params.put("username", loginPhone);
        params.put("password", loginPsw);
        presenter.postData(ApiConfig.API_LOGIN, params);
    }


    @Override
    public void onError(ResponseInfo responseInfo) {
        super.onError(responseInfo);
        toLoginManually();

    }

    private void toLoginManually() {
        startActivity(LoginActivity.getIntent(SplashActivity.this));
        SplashActivity.this.finish();
    }


    @NeedsPermission({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void onAllowed() {
        nextStep();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        SplashActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnPermissionDenied({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void onDenied() {
        nextStep();
        ToastUtil.showShort("拒绝应用的读写权限有可能影响到相关用户体验");
    }

}
