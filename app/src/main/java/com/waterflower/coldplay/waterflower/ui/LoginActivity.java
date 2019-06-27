package com.waterflower.coldplay.waterflower.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.waterflower.coldplay.MainActivity;
import com.waterflower.coldplay.R;
import com.waterflower.coldplay.waterflower.MyApp;
import com.waterflower.coldplay.waterflower.basic.model.BaseBean;
import com.waterflower.coldplay.waterflower.basic.network.ApiConfig;
import com.waterflower.coldplay.waterflower.basic.presenter.MvpPresenter;
import com.waterflower.coldplay.waterflower.basic.utils.SystemUtils;
import com.waterflower.coldplay.waterflower.basic.utils.ToastUtil;
import com.waterflower.coldplay.waterflower.bean.LoginBean;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Author : WaterFlower.
 * Created on 2017/8/14.
 * Desc :   登录密码
 */

public class LoginActivity extends WrapperMvpActivity<MvpPresenter> {


    @BindView(R.id.etLoginPhone)
    EditText etLoginPhone;
    @BindView(R.id.etLoginPsw)
    EditText etLoginPsw;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.tvForgetPsw)
    TextView tvForgetPsw;
    private String loginPhone;
    private String loginPsw;


    public static Intent getIntent(Context context) {
        return new Intent(context, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    }

    @Override
    protected int getToolBarLayout() {
        return DEFAULT_TOOLBAR;
    }

    @Override
    public int getViewLayout() {
        return R.layout.activity_login;
    }


    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent args) {
        tbHolder.ivBack.setVisibility(View.GONE);
        tbHolder.tvCenterTitle.setText("登录");
        if (SystemUtils.isApkInDebug(this))
        {
            init();
        }
    }

    private void init() {
        etLoginPhone.setText("13511111111");
        etLoginPsw.setText("888888");
    }


    @Override
    public void showContentView(String url, BaseBean baseBean) {
        if (url.contains(ApiConfig.API_LOGIN)) {
            ((MyApp) getApplication()).setLoginBean(new LoginBean(loginPsw,loginPhone));
            ToastUtil.showShort("登录成功");
            startActivity(MainActivity.getIntent(this));
            finish();
        }

    }


    @OnClick({R.id.btnLogin, R.id.tvForgetPsw, R.id.ivAccountClear, R.id.ivPswClear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                loginPhone = getTextFromEt(etLoginPhone);
                loginPsw = getTextFromEt(etLoginPsw);
                if (TextUtils.isEmpty(loginPhone)) {
//                    ToastUtil.showLong("账号和密码不符");
                    etLoginPhone.setFocusableInTouchMode(true);
                    etLoginPhone.setFocusable(true);
                    etLoginPhone.requestFocus();
                    etLoginPhone.requestFocusFromTouch();
                    etLoginPhone.setError("账号不能为空");
                    return;
                }

                if (TextUtils.isEmpty(loginPsw)) {
                    etLoginPsw.setFocusableInTouchMode(true);
                    etLoginPsw.setFocusable(true);
                    etLoginPsw.requestFocus();
                    etLoginPsw.requestFocusFromTouch();
                    etLoginPsw.setError("密码不能为空");
                    return;
                }
                login(loginPhone, loginPsw);
                break;

            case R.id.tvForgetPsw:
                startActivity(FindBackPswActivity.getIntent(this, FindBackPswActivity.LOGIN_PSW));
                break;
            case R.id.ivAccountClear:
                etLoginPhone.setText("");
                requestFocus(etLoginPhone);

                break;
            case R.id.ivPswClear:
                etLoginPsw.setText("");
                requestFocus(etLoginPsw);
                break;
        }
    }


    private void requestFocus(View view)
    {
        view.setFocusableInTouchMode(true);
        view.requestFocusFromTouch();
        view.setFocusable(true);
        view.requestFocus();
    }

    private void login(String loginPhone, String loginPsw) {
        ArrayMap<String, Serializable> params = new ArrayMap<>();
        params.put("username", loginPhone);
        params.put("password", loginPsw);
        presenter.postData(ApiConfig.API_LOGIN, params);
    }



}
