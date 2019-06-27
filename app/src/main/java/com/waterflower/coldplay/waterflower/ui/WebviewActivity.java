package com.waterflower.coldplay.waterflower.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.waterflower.coldplay.R;
import com.waterflower.coldplay.waterflower.basic.model.BaseBean;
import com.waterflower.coldplay.waterflower.basic.network.ApiConfig;
import com.waterflower.coldplay.waterflower.basic.presenter.MvpPresenter;
import com.waterflower.coldplay.waterflower.basic.utils.LogUtils;
import com.waterflower.coldplay.waterflower.basic.view.SwipeBackMvpActivity;

import butterknife.BindView;


/**
 * Author : WaterFlower.
 * Created on 2017/8/14.
 * Desc :   通用WebView
 */

public class WebviewActivity extends SwipeBackMvpActivity<MvpPresenter> {


    private static final String TYPE_KEY = "typeKey";
    private static final String URL_NEW_HOUSE_SALE_RULE = "app-h5/houseRuleEstate";
    private static final String URL_SALE_RULE = "app-h5/houseRule2";
    private static final String URL_COMMISSION_RULE = "app-h5/houseRule";
    public static final int TYPE_NEW_HOUSE_SALE_RILE = 0;
    public static final int TYPE_SALE_RULE = 1;
    public static final int TYPE_COMMISSION_RULE = 2;
    @BindView(R.id.webview)
    WebView webview;

    private int type = -1;
    private String url;
    private String redirected;


    public static Intent getIntent(Context context, int type) {
        Intent intent = new Intent(context, WebviewActivity.class);
        intent.putExtra(TYPE_KEY, type);
        return intent;
    }

    @Override
    protected int getToolBarLayout() {
        return DEFAULT_TOOLBAR;
    }

    @Override
    public int getViewLayout() {
        return R.layout.activity_webview;
    }


    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent args) {
        type = args.getIntExtra(TYPE_KEY, -1);
        initTitle(tbHolder);

//        initWebView();
        if (!url.startsWith(ApiConfig.HOST)) {
            url = ApiConfig.HOST + url;
        }
        webview.loadUrl(url); //加载地址
        LogUtils.e("url=" + url);

    }

    private void initTitle(ToolbarHolder tbHolder) {
        switch (type) {
            case TYPE_NEW_HOUSE_SALE_RILE:
                tbHolder.tvCenterTitle.setText("新房分销规则");
                url = URL_NEW_HOUSE_SALE_RULE;
                break;
            case TYPE_SALE_RULE:
                tbHolder.tvCenterTitle.setText("分销规则");
                url = URL_SALE_RULE;
                break;
            case TYPE_COMMISSION_RULE:
                tbHolder.tvCenterTitle.setText("佣金规则");
                url = URL_COMMISSION_RULE;
                break;
        }
    }


    private void initWebView() {
        webview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);//默认使用缓存
        webview.getSettings().setAllowFileAccess(true);//可以读取文件缓存(manifest生效)
        webview.getSettings().setAppCacheEnabled(false);//应用可以有缓存
        webview.getSettings().setDefaultTextEncodingName("utf-8"); // 设置编码格式
        webview.getSettings().setUseWideViewPort(true); // 是否将图片调整到适合webview的大小
        webview.setHorizontalScrollBarEnabled(false); // 隐藏水平滚动条
        webview.setVerticalScrollBarEnabled(false); // 隐藏垂直滚动条
        webview.getSettings().setSaveFormData(false);//记住表单内容
        webview.getSettings().setSavePassword(false); //记住密码
        webview.getSettings().setSupportZoom(false);//支持缩放
        webview.getSettings().setJavaScriptEnabled(true);
//        webview.addJavascriptInterface(new MyJavascript(), "tianyu_app");
        //方法就是告诉WebView先不要自动加载图片，等页面finish后再发起图片加载。
        if (Build.VERSION.SDK_INT >= 19) {
            webview.getSettings().setLoadsImagesAutomatically(true);
        } else {
            webview.getSettings().setLoadsImagesAutomatically(false);
        }
        webview.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onReceivedTitle(WebView view, String title) {
//                tbHolder.tvCenterTitle.setText(title);
//                LogUtils.d("bj===" + title);
            }
        });
        webview.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                showProgress();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (!"about:blank".equals(url)) {
                    redirected = url;
                }

                if (!webview.getSettings().getLoadsImagesAutomatically()) {
                    webview.getSettings().setLoadsImagesAutomatically(true);
                }
                hideProgress();
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                //页面发生错误
                webview.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);

            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                boolean override = false;
                if (url.startsWith("tel:")) {
                    //用intent启动拨打电话
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
                    startActivity(intent);
                    override = true;
                }
                if (url.contains("mobile/product/index")) {
                    int beginIndex = url.lastIndexOf("/") + 1;
                    String id = url.substring(beginIndex);
                    if (!TextUtils.isEmpty(id)) {


                    }
                    override = true;
                } else if (url.contains("member_order/pay")) {
                    int beginIndex = url.indexOf("=") + 1;
                    String paramStr;
                    if (url.contains("&")) {
                        paramStr = url.substring(beginIndex, url.indexOf("&"));
                    } else {
                        paramStr = url.substring(beginIndex, url.length());
                    }


                    finish();
                    override = true;
                }
                return override;
            }
        });
    }


    @Override
    protected void loadData(Bundle savedInstanceState, Intent intent) {
//        if (NetworkManager.isNetWorkConnected()) {
//            CookieStore cookieStore = OkGo.getInstance().getCookieJar().getCookieStore();
//            List<Cookie> allCookie = cookieStore.getCookie(HttpUrl.parse(ApiConfig.HOST));
//            CookieSyncManager.createInstance(this);
//            CookieManager cookieManager = CookieManager.getInstance();
//            cookieManager.setAcceptCookie(true);
//            cookieManager.removeSessionCookie();//移除
//            for (Cookie cookie : allCookie) {
//                cookieManager.setCookie(ApiConfig.HOST, String.format("%s=%s", cookie.name(), cookie.value()));//cookies是在HttpClient中获得的cookie
//            }
//            CookieSyncManager.getInstance().sync();
//            if (!url.startsWith(ApiConfig.HOST)) {
//                url =ApiConfig.HOST+url;
//            }
//            webview.loadUrl(url); //加载地址
//            LogUtils.e("url=" + url);
//        }
    }

    @Override
    public void showContentView(String url, BaseBean baseBean) {

    }


    private boolean lock = false;//限制某些进度窗特定开关

    public void showProgress() {
        showProgress(false);
    }

    private void showProgress(boolean lockup) {
        if (lockup) {
            lock = lockup;//对进度窗上锁，上锁后不能随便关闭
            onLoading();
        }
    }

    public void hideProgress() {
        hideProgress(false);
    }

    private void hideProgress(boolean deblock) {
        if (lock && deblock) {
            lock = false;
        }
        //进度窗没有上锁才能取消
        if (!lock) {
            onStopLoading();
        }
    }


    @Override
    public void onBackPressedSupport() {
        if (webview.canGoBack()) {
            webview.goBack();//返回上一页面
        } else {
            webview.stopLoading();
            super.onBackPressedSupport();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        hideProgress();
    }


    @Override
    protected void onDestroy() {

//     防止WebView造成的内存泄漏
        if (webview != null) {
            // 如果先调用destroy()方法，则会命中if (isDestroyed()) return;这一行代码，需要先onDetachedFromWindow()，再 destory()
            ViewParent parent = webview.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(webview);
            }

            webview.stopLoading();
            // 退出时调用此方法，移除绑定的服务，否则某些特定系统会报错
            webview.getSettings().setJavaScriptEnabled(false);
            webview.clearHistory();
//            webview.clearView();  该方法已过期,使用下面方法与该方法功能一致
            webview.loadUrl("about:blank");
            webview.removeAllViews();

            try {
                webview.destroy();
                webview = null;
            } catch (Throwable ex) {
                LogUtils.e("WebviewActivity  e= " + ex.getMessage());
            }
        }


        super.onDestroy();
    }


}
