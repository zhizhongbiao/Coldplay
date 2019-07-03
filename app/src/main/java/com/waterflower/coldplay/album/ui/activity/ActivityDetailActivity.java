package com.waterflower.coldplay.album.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.waterflower.coldplay.R;
import com.waterflower.coldplay.album.ui.adapter.FilterAdapter;
import com.waterflower.coldplay.album.ui.fragment.PhotoFg;
import com.waterflower.coldplay.album.ui.fragment.VideoFg;
import com.waterflower.coldplay.waterflower.basic.model.BaseBean;
import com.waterflower.coldplay.waterflower.basic.presenter.MvpPresenter;
import com.waterflower.coldplay.waterflower.basic.utils.LogUtils;
import com.waterflower.coldplay.waterflower.basic.utils.UIUtils;
import com.waterflower.coldplay.waterflower.basic.utils.WindowUtil;
import com.waterflower.coldplay.waterflower.basic.view.BaseFragment;
import com.waterflower.coldplay.waterflower.basic.view.MvpActivity;
import com.waterflower.coldplay.waterflower.basic.widget.popup.PopupWindowAdaptAndroidN;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * FileName :  ActivityDetailActivity
 * Author   :  zhizhongbiao
 * Date     :  2019/6/28
 * Describe :
 */

public class ActivityDetailActivity extends MvpActivity<MvpPresenter>
        implements View.OnClickListener
        , BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.flContainer)
    FrameLayout flContainer;

    private List<String> dataTypes = Arrays.asList("图片管理", "视频管理");
    private PopupWindowAdaptAndroidN popupWindow;
    private BaseFragment lastFragemnt;
    private FragmentManager fm;
    private PhotoFg photoFg;
    private VideoFg videoFg;

    public static Intent getIntent(Context context) {
        return new Intent(context, ActivityDetailActivity.class);
    }

    @Override
    protected int getToolBarLayout() {
        return DEFAULT_TOOLBAR;
    }

    @Override
    public int getViewLayout() {
        return R.layout.activity_activity_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent args) {
        initToolbar(tbHolder);
        initFg();
    }

    private void initFg() {
        fm = getSupportFragmentManager();
        photoFg = PhotoFg.newInstance();
        videoFg = VideoFg.newInstance();
        showFg(photoFg);
    }

    private void initToolbar(ToolbarHolder tbHolder) {
        tbHolder.tvCenterTitle.setText(dataTypes.get(0));
        tbHolder.ivRight.setVisibility(View.VISIBLE);
        tbHolder.ivMiddleRight.setVisibility(View.VISIBLE);
        tbHolder.ivRight.setImageResource(R.mipmap.setting);
        tbHolder.ivMiddleRight.setImageResource(R.mipmap.share_link);
        tbHolder.ivRight.setOnClickListener(this);
        tbHolder.ivMiddleRight.setOnClickListener(this);
        tbHolder.tvCenterTitle.setOnClickListener(this);
    }


    @Override
    protected void loadData(Bundle savedInstanceState, Intent intent) {

    }


    @Override
    public void showContentView(String url, BaseBean baseBean) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvCenterTitle:
                ifShowFilterDialog();
                break;
            case R.id.ivRight:
                break;
            case R.id.ivMiddleRight:
                break;
        }
    }

    private void ifShowFilterDialog() {
        if (popupWindow != null && popupWindow.isShowing()) {
            WindowUtil.closePopWin(popupWindow);
        } else {
            showPw(dataTypes);
        }
    }


    private void showPw(List<String> data) {
        LinearLayout root = (LinearLayout) UIUtils.inflate(R.layout.popup_window_subject_filter_list);
        RecyclerView rvSubject = UIUtils.findView(root, R.id.rvSubject);
        rvSubject.setLayoutManager(new LinearLayoutManager(this));
        FilterAdapter adapter = new FilterAdapter();
        adapter.bindToRecyclerView(rvSubject);
        adapter.setEnableLoadMore(false);
        adapter.setNewData(data);
        adapter.setOnItemClickListener(this);
        popupWindow = WindowUtil.showPw(root, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, getToolbarHolder().rlToobar);

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        getToolbarHolder().tvCenterTitle.setText(dataTypes.get(position));
        switch (position) {
            case 0:
                showFg(photoFg);
                break;
            case 1:
                showFg(videoFg);
                break;
        }
        WindowUtil.closePopWin(popupWindow);
    }

    private void showFg(BaseFragment fragment) {
        LogUtils.e("showFg     fragment=" + fragment);

        if (fragment == null || lastFragemnt == fragment) {
            return;
        }
        FragmentTransaction transaction = fm.beginTransaction();

        if (lastFragemnt != null) {
            transaction.hide(lastFragemnt);
        }

        String myTag = fragment.getMyTag();
        if (!fragment.isAdded() && null == fm.findFragmentByTag(myTag)) {
            transaction.add(R.id.flContainer, fragment, myTag);
        }

        //调用commitAllowingStateLoss是为了防止，fragment在错误的时间切换导致的状态异常：
        transaction.show(fragment).commitAllowingStateLoss();
        lastFragemnt = fragment;


    }
}
