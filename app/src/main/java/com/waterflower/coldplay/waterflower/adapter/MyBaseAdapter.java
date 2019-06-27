package com.waterflower.coldplay.waterflower.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * FileName :  MyBaseAdapter
 * Author   :  zhizhongbiao
 * Date     :  2019/6/27
 * Describe :
 */

public abstract class MyBaseAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {


    public MyBaseAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);
        return new BaseViewHolder(view);
    }


}
