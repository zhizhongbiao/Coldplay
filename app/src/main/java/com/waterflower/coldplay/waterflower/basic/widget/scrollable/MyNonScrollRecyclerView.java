package com.waterflower.coldplay.waterflower.basic.widget.scrollable;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Author : WaterFlower.
 * Created on 2017/8/24.
 *
 */
public class MyNonScrollRecyclerView extends RecyclerView {
    public MyNonScrollRecyclerView(Context context) {
        super(context);
    }

    public MyNonScrollRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyNonScrollRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 不对触摸时间做事件,只交给父布局来处理
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev){

        return false;
    }
}
