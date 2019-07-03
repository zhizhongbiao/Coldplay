package com.waterflower.coldplay.my.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.waterflower.coldplay.R;
import com.waterflower.coldplay.my.bean.UserInfoBean;
import com.waterflower.coldplay.my.event.OnUploadAvatarSuccessEvent;
import com.waterflower.coldplay.waterflower.MyApp;
import com.waterflower.coldplay.waterflower.basic.manager.ImageManager;
import com.waterflower.coldplay.waterflower.basic.model.BaseBean;
import com.waterflower.coldplay.waterflower.basic.network.ApiConfig;
import com.waterflower.coldplay.waterflower.basic.presenter.MvpPresenter;
import com.waterflower.coldplay.waterflower.basic.view.MvpFragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Author : WaterFlower.
 * Created on 2017/8/23.
 * Desc :
 */

public class MyFg extends MvpFragment<MvpPresenter> {

    @BindView(R.id.tvAgentName)
    TextView tvAgentName;

    @BindView(R.id.tvSignedMiddleCount)
    TextView tvSignedMiddleCount;
    @BindView(R.id.tvSignedAgentCount)
    TextView tvSignedAgentCount;
    @BindView(R.id.tvProjectCount)
    TextView tvProjectCount;
    @BindView(R.id.ivAvatar)
    ImageView ivAvatar;


    public static MyFg newInstance() {
        MyFg myFg = new MyFg();
        return myFg;
    }


    @Override
    public int getViewLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView(Bundle savedInstanceState, Bundle args) {

    }


    @Override
    protected void loadData(Bundle savedInstanceState) {
        getUserInfo();
    }

    @Override
    public void showContentView(String url, BaseBean baseBean) {

        if (url.contains(ApiConfig.API_USER_INFO)) {
            UserInfoBean userInfoBean = (UserInfoBean) baseBean;
            ((MyApp) getActivity().getApplication()).setUserBean(userInfoBean);
            showUserInfo(userInfoBean);
        }
    }


    public void getUserInfo() {
        presenter.postData(ApiConfig.API_USER_INFO, UserInfoBean.class);
    }


    /**
     * company_name : 测试代理商33
     * company_shortname : 测代理
     * upload_id : []
     * company_id : 10036
     * user_name : 测试代理
     * user_key : 43932!!5TUH2VpNBf
     * user_mobile : 13511111111
     * count_money : 0.00
     * dealers : 6
     * developers : 2
     * companys : 3
     * has_paypass : 1
     */
    private void showUserInfo(UserInfoBean infoBean) {
        if (!infoBean.data.upload_id.isEmpty()) {
            ImageManager.load(this, infoBean.data.upload_id.get(0).upload_url, ivAvatar);

        }

        tvAgentName.setText(infoBean.data.company_shortname+"   "+infoBean.data.user_mobile);
        tvSignedMiddleCount.setText(infoBean.data.companys);
        tvProjectCount.setText(infoBean.data.developers);
        tvSignedAgentCount.setText(infoBean.data.dealers);

    }

    @OnClick({R.id.rlMyWallet, R.id.rlAccountSetting, R.id.rlMyInfo, R.id.rlMyShareStatistics})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.rlMyInfo:

                break;

            case R.id.rlMyWallet:

                break;

            case R.id.rlMyShareStatistics:

                break;
            case R.id.rlAccountSetting:

                break;

        }

        startActivity(intent);
    }


    @Subscribe(threadMode = ThreadMode.MAIN, priority = 10, sticky = false)
    public void onUploadAvatarSuccessEvent(OnUploadAvatarSuccessEvent event) {
        presenter.setNeedDialog(false);
        getUserInfo();
    }

}
