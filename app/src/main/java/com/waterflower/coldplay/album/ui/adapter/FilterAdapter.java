package com.waterflower.coldplay.album.ui.adapter;

import com.chad.library.adapter.base.BaseViewHolder;
import com.waterflower.coldplay.R;
import com.waterflower.coldplay.waterflower.adapter.MyBaseAdapter;


/**
 * Author : WaterFlower.
 * Created on 2017/8/24.
 * Desc :  新房适配器
 */

public class FilterAdapter extends MyBaseAdapter<String> {

    @Override
    protected int getLayoutResId() {
        return R.layout.item_album_list_filter;
    }

    public FilterAdapter() {
        super();
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tvSubjectName, item);
    }

}
