package com.waterflower.coldplay.my.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author : WaterFlower.
 * Created on 2017/8/30.
 * Desc :
 */

public class BindBankCardInfoBean implements Parcelable {

//    参数	说明
//    card_number	银行卡号
//    card_name	银行卡账号名
//    phone	手机号码
//    code	短信验证码

    public String cardHostName;
    public String cardNum;
    public String phone;
    public String msmCode;

    public BindBankCardInfoBean(String cardHostName, String cardNum, String phone, String msmCode) {
        this.cardHostName = cardHostName;
        this.cardNum = cardNum;
        this.phone = phone;
        this.msmCode = msmCode;
    }

    protected BindBankCardInfoBean(Parcel in) {
        cardHostName = in.readString();
        cardNum = in.readString();
        phone = in.readString();
        msmCode = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cardHostName);
        dest.writeString(cardNum);
        dest.writeString(phone);
        dest.writeString(msmCode);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BindBankCardInfoBean> CREATOR = new Creator<BindBankCardInfoBean>() {
        @Override
        public BindBankCardInfoBean createFromParcel(Parcel in) {
            return new BindBankCardInfoBean(in);
        }

        @Override
        public BindBankCardInfoBean[] newArray(int size) {
            return new BindBankCardInfoBean[size];
        }
    };
}
