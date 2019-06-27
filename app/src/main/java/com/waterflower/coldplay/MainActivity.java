package com.waterflower.coldplay;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.jpeng.jptabbar.JPTabBar;
import com.jpeng.jptabbar.OnTabSelectListener;
import com.jpeng.jptabbar.anno.NorIcons;
import com.jpeng.jptabbar.anno.SeleIcons;
import com.jpeng.jptabbar.anno.Titles;
import com.waterflower.coldplay.album.ui.fragment.FgHome;
import com.waterflower.coldplay.my.ui.fragment.MyFragment;
import com.waterflower.coldplay.waterflower.basic.utils.ToastUtil;
import com.waterflower.coldplay.waterflower.basic.view.BaseActivity;
import com.waterflower.coldplay.waterflower.basic.view.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity
        implements OnTabSelectListener
        , View.OnClickListener {


    @BindView(R.id.tabbar)
    JPTabBar tabbar;
    private long lastClick;

    @Titles
    private static final String[] mTitles = {"首页", "我的"};

    @NorIcons
    private static final int[] mNormalIcons = {R.mipmap.home_false, R.mipmap.my_false};

    @SeleIcons
    private static final int[] mSeleIcons = {R.mipmap.home_true, R.mipmap.my_true};

    private BaseFragment currentFragment;
    private int currentIndex = -1;
    private ArrayList<BaseFragment> fragments;

    private FragmentManager manager;
    private Dialog plusDialog;

    /**
     * 清空栈顶 进入主页
     *
     * @param context
     * @return
     */
    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
    }

    @Override
    public int getViewLayout() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent args) {
        initTab();
        initPlusDialog();
    }

    private void initTab() {
//        tabbar  .setTabTextSize(DisplayUtil.px2sp(this,24f));
        tabbar
                .setTitles(mTitles)
                .setNormalIcons(mNormalIcons)
                .setSelectedIcons(mSeleIcons)
                .generate();
        tabbar.setTabListener(this);

        fragments = new ArrayList<>();
        fragments.add(FgHome.newInstance());
        fragments.add(MyFragment.newInstance());

        manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        for (int i = 0; i < fragments.size(); i++) {
            BaseFragment fragment = fragments.get(i);
            String fgName = fragment.getClass().getName();
            if (manager.findFragmentByTag(fgName) == null) {
                ft.add(R.id.fragmentContainer, fragment, fgName);
            }
        }
        ft.commit();


        tabbar.setSelectTab(0);


    }

    private void initPlusDialog() {
        plusDialog = new Dialog(this, R.style.Dialog_Fullscreen);
        plusDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_plus, null);
        inflate.findViewById(R.id.llCreateAlbum).setOnClickListener(this);
        inflate.findViewById(R.id.ivCancel).setOnClickListener(this);
        plusDialog.setContentView(inflate);
        plusDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
    }

    private void showPlusDialog() {
        if (plusDialog == null) {
            initPlusDialog();
        }
        if (!plusDialog.isShowing()) {
            plusDialog.show();
        }
    }


    private void dismissDialog() {
        if (plusDialog != null && plusDialog.isShowing()) {
            plusDialog.dismiss();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.llCreateAlbum:
                break;
            case R.id.ivCancel:
                dismissDialog();
                break;
        }
    }

    @Override
    public void onTabSelect(int index) {
        switchFragment(index, fragments.get(index));
    }

    @OnClick(R.id.ivPlus)
    public void onViewClicked() {
        showPlusDialog();
    }

    private void switchFragment(int index, BaseFragment fragment) {

        if (index == currentIndex || currentFragment == fragment || fragment == null) return;
        FragmentTransaction ft = manager.beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            if (index != i) {
                ft.hide(fragments.get(i));
            }
        }

        ft.show(fragment)
          .commit();

        currentFragment = fragment;
        currentIndex = index;
    }

    @Override
    public void onBackPressedSupport() {

        long clickTimeStamp = System.currentTimeMillis();
        if (clickTimeStamp - lastClick > 2500) {
            ToastUtil.showShort("再按一次退出应用");
            return;
        }
        lastClick = clickTimeStamp;
        super.onBackPressedSupport();
    }

}
