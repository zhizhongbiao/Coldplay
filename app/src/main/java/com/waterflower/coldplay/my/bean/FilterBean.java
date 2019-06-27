package com.waterflower.coldplay.my.bean;


import com.waterflower.coldplay.waterflower.basic.model.BaseBean;

/**
 * Author : WaterFlower.
 * Created on 2017/8/30.
 * Desc :
 */

public class FilterBean extends BaseBean {
    public FilterBean(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public  int key=-1;
    public  int selectedPos=-1;
    public String value;
}
