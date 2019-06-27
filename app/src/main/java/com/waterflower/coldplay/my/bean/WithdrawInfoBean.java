package com.waterflower.coldplay.my.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author : WaterFlower.
 * Created on 2017/9/5.
 * Desc :
 */

public class WithdrawInfoBean implements Parcelable {

    public double money;
    public String cardNum;
    public String cardCode;
    public String cardHostName;

    public WithdrawInfoBean(double money, String cardNum, String cardCode, String cardHostName) {
        this.money = money;
        this.cardNum = cardNum;
        this.cardCode = cardCode;
        this.cardHostName = cardHostName;
    }

    protected WithdrawInfoBean(Parcel in) {
        money = in.readInt();
        cardNum = in.readString();
        cardCode = in.readString();
        cardHostName = in.readString();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(money);
        dest.writeString(cardNum);
        dest.writeString(cardCode);
        dest.writeString(cardHostName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WithdrawInfoBean> CREATOR = new Creator<WithdrawInfoBean>() {
        @Override
        public WithdrawInfoBean createFromParcel(Parcel in) {
            return new WithdrawInfoBean(in);
        }

        @Override
        public WithdrawInfoBean[] newArray(int size) {
            return new WithdrawInfoBean[size];
        }
    };
}
