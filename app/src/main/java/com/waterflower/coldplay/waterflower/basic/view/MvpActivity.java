package com.waterflower.coldplay.waterflower.basic.view;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.waterflower.coldplay.R;
import com.waterflower.coldplay.waterflower.basic.network.ResponseInfo;
import com.waterflower.coldplay.waterflower.basic.presenter.BasePresenter;
import com.waterflower.coldplay.waterflower.basic.presenter.MvpPresenter;
import com.waterflower.coldplay.waterflower.basic.reveiver.NetworkStateEvent;
import com.waterflower.coldplay.waterflower.basic.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.reflect.ParameterizedType;



/**
 * Author : WaterFlower.
 * Created on 2017/8/11.
 * Desc :
 */

public abstract class MvpActivity<P extends MvpPresenter> extends BaseActivity implements MvpView {

    protected P presenter;
//    protected MaterialDialog progressDialog;
    protected Dialog progressDialog;
    private boolean loadSuccess; //数据是否加载成功
    private boolean loadFinish; //请求是否成功
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<? extends BasePresenter> presenterClass = (Class<? extends BasePresenter>) type.getActualTypeArguments()[0];
        try {
            this.presenter = (P) presenterClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        presenter.attachView(this);
        progressDialog=new Dialog(this, R.style.Dialog_Fullscreen);
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog .setContentView(R.layout.layout_load_data_progress);
        progressDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
//        progressDialog = new MaterialDialog.Builder(this)
//                .customView(R.layout.layout_load_data_progress, false)
//                .cancelable(true).build();
//        progressDialog.getWindow().getDecorView().setBackgroundColor(UIUtils.getColor(R.color.transparent));
        EventBus.getDefault().register(this);
        this.savedInstanceState = savedInstanceState;
        loadData(this.savedInstanceState, getIntent());
    }


    /**
     * 从intent中获取请求参数，初始化vo对象，并发送请求
     *
     * @param savedInstanceState
     * @param intent
     */
    protected abstract void loadData(Bundle savedInstanceState, Intent intent);


    @Override
    public void onLoading() {
        if (!progressDialog.isShowing()) {
            progressDialog.show();
            loadSuccess = false;
        }
    }


    @Override
    public void beforeSuccess() {
        loadSuccess = true;
        loadFinish = true;
    }


    @Override
    public void onStopLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onError(ResponseInfo responseInfo) {
        loadFinish = true;
    }


    /**
     * 网络状态改变事件，由子类重写实现相关的逻辑
     *
     * @param networkStateEvent
     */
    @Subscribe
    public void onEvent(NetworkStateEvent networkStateEvent) {
        if (!networkStateEvent.hasNetworkConnected) {
            ToastUtil.showShort("网络连接已断开!");
        } else {
            if (loadFinish && !loadSuccess) {
                //网络已连接数据没有加载成功，重新加载
                loadData(this.savedInstanceState, getIntent());
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
        presenter = null;
        EventBus.getDefault().unregister(this);
    }

}
