package com.waterflower.coldplay.waterflower.basic.presenter;


import com.waterflower.coldplay.waterflower.basic.network.ResponseInfo;

public interface Callback {

    /**
     * 请求成功回调方法
     */
    void onSuccess(ResponseInfo resoponseInfo);

    /**
     * 请求失败回调方法
     */
    void onError(ResponseInfo resoponseInfo);
}
