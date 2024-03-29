package com.waterflower.coldplay.waterflower.basic.utils;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;

/**
 * Author : WaterFlower.
 * Created on 2017/8/25.
 * Desc :
 */

public class StringUtils {

    public static String formatPhoneNumber(String phoneNo, int start, int replaceLength) {
        if (TextUtils.isEmpty(phoneNo) || phoneNo.length() < (start + replaceLength)) {
            return phoneNo;
        }

        StringBuilder stringBuilder = new StringBuilder(phoneNo);
        return stringBuilder.replace(start, start + replaceLength, "****").toString();
    }

    public static Spanned getValueText(String color, String key, String value) {
        StringBuilder string = new StringBuilder();
        string.append(key);
        string.append("<font color=\"" + color + "\">");
        string.append(value);
        string.append("</font>");
        return Html.fromHtml(string.toString());
    }

}
