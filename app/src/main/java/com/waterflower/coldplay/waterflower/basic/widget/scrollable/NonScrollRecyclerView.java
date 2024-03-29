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
public class NonScrollRecyclerView extends RecyclerView {
    public NonScrollRecyclerView(Context context) {
        super(context);
    }

    public NonScrollRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NonScrollRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev){

        if(ev.getAction() == MotionEvent.ACTION_MOVE)
            return true;

        return super.dispatchTouchEvent(ev);
    }
}
