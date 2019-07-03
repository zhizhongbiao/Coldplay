package com.waterflower.coldplay.album.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.waterflower.coldplay.album.ui.adapter.PhotoAdapter;
import com.waterflower.coldplay.waterflower.basic.model.BaseBean;
import com.waterflower.coldplay.waterflower.basic.presenter.MvpPresenter;
import com.waterflower.coldplay.waterflower.ui.fragment.MyCommonRvFragment;

/**
 * FileName :  PhotoFg
 * Author   :  zhizhongbiao
 * Date     :  2019/7/1
 * Describe :
 */

public class VideoCommonRvFg extends MyCommonRvFragment<MvpPresenter, PhotoAdapter, BaseBean,LinearLayoutManager> {

    public static final String KEY_DATA_TYPE = "keyDataType";

    public static VideoCommonRvFg newInstance(String type) {
        VideoCommonRvFg newInstance = new VideoCommonRvFg();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_DATA_TYPE, type);
        newInstance.setArguments(bundle);
        return newInstance;
    }

    @Override
    protected int getDataType() {
        return TYPE_ALL;
    }

    @Override
    protected LinearLayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
