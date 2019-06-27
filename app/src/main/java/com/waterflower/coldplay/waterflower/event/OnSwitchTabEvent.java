package com.waterflower.coldplay.waterflower.event;

/**
 * Author : WaterFlower.
 * Created on 2017/8/29.
 * Desc :   MainActivity切换Fragment的时间
 */

public class OnSwitchTabEvent {

    public OnSwitchTabEvent(int index) {
        this.index = index;
    }

    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
