package com.waterflower.coldplay.album.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.waterflower.coldplay.R;
import com.waterflower.coldplay.album.listener.OnTbSelectedListener;
import com.waterflower.coldplay.album.listener.OnVpPageChangeListener;
import com.waterflower.coldplay.album.tab.MyTab;
import com.waterflower.coldplay.waterflower.adapter.TabBarAdapter;
import com.waterflower.coldplay.waterflower.basic.model.BaseBean;
import com.waterflower.coldplay.waterflower.basic.presenter.MvpPresenter;
import com.waterflower.coldplay.waterflower.basic.view.MvpFragment;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * FileName :  PhotoFg
 * Author   :  zhizhongbiao
 * Date     :  2019/7/1
 * Describe :
 */

public class VideoFg extends MvpFragment<MvpPresenter> {

    @BindView(R.id.ctTablayout)
    CommonTabLayout ctTablayout;
    @BindView(R.id.btnFilter)
    Button btnFilter;
    @BindView(R.id.vpContainer)
    ViewPager vpContainer;
    @BindView(R.id.btnPreview)
    Button btnPreview;
    @BindView(R.id.btnMultiSelect)
    Button btnMultiSelect;
    @BindView(R.id.btnUpload)
    Button btnUpload;
    @BindView(R.id.btnMove)
    Button btnMove;
    @BindView(R.id.btnDelete)
    Button btnDelete;
    @BindView(R.id.btnCancelPost)
    Button btnCancelPost;
    @BindView(R.id.btnPost)
    Button btnPost;
    @BindView(R.id.btnAI)
    Button btnAI;
    @BindView(R.id.llOptions)
    AutoLinearLayout llOptions;
    @BindView(R.id.llMultiSelect)
    AutoLinearLayout llMultiSelect;

    //上线
    public static final int STATE_ONLINE = 1;
    //未上线
    public static final int STATE_OFFLINE = 0;


    private static final String[] ctTitles = {"全部视频"};


    public static VideoFg newInstance() {
        VideoFg newInstance = new VideoFg();
        return newInstance;
    }

    @Override
    public int getViewLayout() {
        return R.layout.fg_photo;
    }

    @Override
    protected void initView(Bundle savedInstanceState, Bundle args) {
        initCtTab();
    }


    private void initCtTab() {
        ArrayList<CustomTabEntity> tabs = new ArrayList<>();
        for (int i = 0; i < ctTitles.length; i++) {
            tabs.add(new MyTab(ctTitles[i]));
        }

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(VideoCommonRvFg.newInstance("0"));
//        fragments.add(PhotoCommonRvFg.newInstance("1"));

        vpContainer.setAdapter(new TabBarAdapter(getChildFragmentManager(), fragments));
        vpContainer.addOnPageChangeListener(new OnVpPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                ctTablayout.setCurrentTab(position);
            }
        });

        ctTablayout.setTabData(tabs);
        ctTablayout.setOnTabSelectListener(new OnTbSelectedListener() {
            @Override
            public void onTabSelect(int position) {
                vpContainer.setCurrentItem(position, true);
            }
        });

        btnFilter.setVisibility(View.GONE);
    }

    @Override
    protected void loadData(Bundle savedInstanceState) {

    }

    @Override
    public void showContentView(String url, BaseBean baseBean) {

    }

    @OnClick({R.id.btnFilter, R.id.btnPreview, R.id.btnMultiSelect, R.id.btnUpload, R.id.btnMove, R.id.btnDelete, R.id.btnCancelPost, R.id.btnPost, R.id.btnAI})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnFilter:
                break;
            case R.id.btnPreview:
                break;
            case R.id.btnMultiSelect:
                break;
            case R.id.btnUpload:
                break;
            case R.id.btnMove:
                break;
            case R.id.btnDelete:
                break;
            case R.id.btnCancelPost:
                break;
            case R.id.btnPost:
                break;
            case R.id.btnAI:
                break;
        }
    }


}
