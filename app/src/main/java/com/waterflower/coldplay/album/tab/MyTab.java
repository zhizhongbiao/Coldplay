package com.waterflower.coldplay.album.tab;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Author : WaterFlower.
 * Created on 2017/8/24.
 * Desc :
 */

public class MyTab implements CustomTabEntity {

    String title;

    public MyTab(String title) {
        this.title = title;
    }

    @Override
    public String getTabTitle() {
        return this.title;
    }

    @Override
    public int getTabSelectedIcon() {
        return 0;
    }

    @Override
    public int getTabUnselectedIcon() {
        return 0;
    }
}
