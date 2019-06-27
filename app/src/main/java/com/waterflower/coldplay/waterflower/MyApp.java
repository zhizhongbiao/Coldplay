package com.waterflower.coldplay.waterflower;

import android.text.TextUtils;

import com.waterflower.coldplay.my.bean.UserInfoBean;
import com.waterflower.coldplay.waterflower.basic.MainApplication;
import com.waterflower.coldplay.waterflower.basic.manager.TaskManager;
import com.waterflower.coldplay.waterflower.basic.view.BaseActivity;
import com.waterflower.coldplay.waterflower.bean.LoginBean;

import java.util.ArrayList;


/**
 * Author : WaterFlower.
 * Created on 2017/8/23.
 * Desc :
 */

public class MyApp extends MainApplication {

    private UserInfoBean userBean;
    private LoginBean loginBean;
    private static final String KEY_PSW = "keyPsw";
    private static final String KEY_ACCOUNT = "keyAccount";

    public UserInfoBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserInfoBean userBean) {
        this.userBean = userBean;
    }

    public LoginBean getLoginBean() {
        String psw = getMainPreferences().getString(KEY_PSW, null);
        String account = getMainPreferences().getString(KEY_ACCOUNT, null);
        if (TextUtils.isEmpty(psw) || TextUtils.isEmpty(account)) return null;
        return new LoginBean(psw, account);
    }

    public void setLoginBean(final LoginBean loginBean) {
        this.loginBean = loginBean;
        TaskManager.getDefault().post(new Runnable() {
            @Override
            public void run() {
                getMainPreferences().edit()
                        .putString(KEY_ACCOUNT, loginBean.userAccount)
                        .putString(KEY_PSW, loginBean.psw)
                        .commit();
            }
        });
    }


    private ArrayList<BaseActivity> activities = new ArrayList<>();

    public void removeActivity(BaseActivity activity) {
        if (activities.contains(activity))
            activities.remove(activity);
    }

    public void addActivity(BaseActivity activity) {
        activities.add(activity);
    }

    public void finishActivity() {
        for (BaseActivity activity : activities) {
            activity.finish();
        }
    }


}
