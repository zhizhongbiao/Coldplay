package com.waterflower.coldplay.waterflower.basic.view;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.waterflower.coldplay.R;
import com.waterflower.coldplay.waterflower.basic.network.ResponseInfo;
import com.waterflower.coldplay.waterflower.basic.presenter.BasePresenter;
import com.waterflower.coldplay.waterflower.basic.presenter.MvpPresenter;
import com.waterflower.coldplay.waterflower.basic.reveiver.NetworkStateEvent;
import com.waterflower.coldplay.waterflower.basic.utils.LogUtils;
import com.waterflower.coldplay.waterflower.basic.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.reflect.ParameterizedType;




/**
 * Author : WaterFlower.
 * Created on 2017/8/11.
 * Desc :
 */

public abstract class MvpFragment<P extends MvpPresenter> extends BaseFragment implements MvpView {

    protected P presenter;
//    protected MaterialDialog progressDialog;
    protected Dialog progressDialog;
    private boolean loadSuccess;
    private boolean loadFinish; //请求是否成功
    private Bundle savedInstanceState;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<? extends BasePresenter> presenterClass = (Class<? extends BasePresenter>) type.getActualTypeArguments()[0];
        try {
            this.presenter = (P) presenterClass.newInstance();
            LogUtils.e("init presenter successfully");
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("init presenter failed  e="+e.getMessage());
        }

        presenter.attachView(this);
        progressDialog=new Dialog(getActivity(), R.style.Dialog_Fullscreen);
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog .setContentView(R.layout.layout_load_data_progress);
        progressDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
//        progressDialog = new MaterialDialog.Builder(getActivity())
//                .customView(R.layout.layout_load_data_progress, false)
//                .cancelable(true).build();
//        progressDialog.getWindow().getDecorView().setBackgroundColor(UIUtils.getColor(android.R.color.transparent));
        EventBus.getDefault().register(this);
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        loadData(this.savedInstanceState);
    }

    /**
     * 获取请求参数，初始化vo对象，并发送请求
     *
     * @param savedInstanceState
     */
    protected abstract void loadData(Bundle savedInstanceState);

    @Override
    public void onLoading() {
        if (!progressDialog.isShowing()) {
            loadSuccess = false;
            progressDialog.show();
        }
    }

    @Override
    public void beforeSuccess() {
        loadSuccess = true;
        loadFinish = true;
    }


    @Override
    public void onError(ResponseInfo responseInfo) {
        loadFinish = true;
        switch (responseInfo.getState()) {
            case ResponseInfo.TIME_OUT:
                showTimeOutDialog(responseInfo);
                break;
            case ResponseInfo.NO_INTERNET_ERROR:
                showOpenNetworkDialog(responseInfo);
                break;
        }

    }

    private void showOpenNetworkDialog(ResponseInfo responseInfo) {
        ToastUtil.showLong("网络连接不可用，请打开网络！");
    }

    protected void showTimeOutDialog(ResponseInfo responseInfo) {
        ToastUtil.showLong("连接网络超时！");
    }


    @Subscribe
    public void onEvent(NetworkStateEvent networkStateEvent) {
        if (!networkStateEvent.hasNetworkConnected) {
            ToastUtil.showShort("网络连接已断开");
        } else {
            if (loadFinish && !loadSuccess) {
                //网络已连接数据没有加载成功，重新加载
                loadData(this.savedInstanceState);
            }
        }
    }

    @Override
    public void onStopLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog = null;
        presenter.detachView();
        presenter = null;
        EventBus.getDefault().unregister(this);
    }


}
