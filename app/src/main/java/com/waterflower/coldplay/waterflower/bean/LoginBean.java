package com.waterflower.coldplay.waterflower.bean;


import com.waterflower.coldplay.waterflower.basic.model.BaseBean;

/**
 * Author : WaterFlower.
 * Created on 2017/8/14.
 * Desc :
 */

public class LoginBean extends BaseBean {

    public String psw;
    public String userAccount;

    public LoginBean(String psw, String userAccount) {
        this.psw = psw;
        this.userAccount = userAccount;
    }
}
