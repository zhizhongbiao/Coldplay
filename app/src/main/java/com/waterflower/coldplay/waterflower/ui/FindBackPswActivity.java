package com.waterflower.coldplay.waterflower.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lzy.okgo.model.HttpHeaders;
import com.waterflower.coldplay.R;
import com.waterflower.coldplay.waterflower.MyApp;
import com.waterflower.coldplay.waterflower.basic.model.BaseBean;
import com.waterflower.coldplay.waterflower.basic.network.ApiConfig;
import com.waterflower.coldplay.waterflower.basic.presenter.MvpPresenter;
import com.waterflower.coldplay.waterflower.basic.utils.CommonTools;
import com.waterflower.coldplay.waterflower.basic.utils.CommonUtil;
import com.waterflower.coldplay.waterflower.basic.utils.SystemUtils;
import com.waterflower.coldplay.waterflower.basic.utils.ToastUtil;
import com.waterflower.coldplay.waterflower.bean.ApiBean;

import java.io.Serializable;
import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.OnClick;



/**
 * Author : WaterFlower.
 * Created on 2017/8/14.
 * Desc :   忘记密码
 */

public class FindBackPswActivity extends WrapperMvpActivity<MvpPresenter> {


    private static final String PSW_TYPE_KEY = "pswTypeKey";
    public static final int PAY_PSW = 0;
    public static final int LOGIN_PSW = 1;

    @BindView(R.id.btnFindImediate)
    Button btnFindImediate;
    @BindView(R.id.btnGetSMSCode)
    Button btnGetSMSCode;

    private int pswType = -1;

    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.etSMSCode)
    EditText etSMSCode;
    @BindView(R.id.etNewPsw)
    EditText etNewPsw;
    @BindView(R.id.etEnsureNewPsw)
    EditText etEnsureNewPsw;
    private String phone;
    private String msmCode;
    private String newPsw_i;
    private String newPsw_ii;
    private String getMsmCodeUrl;

    private int countDown = 60;
    private CountDownHandler countDownHandler;

    private boolean isGetVerifyCode = false;


    public static Intent getIntent(Context context, int pswType) {
        Intent intent = new Intent(context, FindBackPswActivity.class);
        intent.putExtra(PSW_TYPE_KEY, pswType);
        return intent;
    }


    @Override
    protected int getToolBarLayout() {
        return DEFAULT_TOOLBAR;
    }

    @Override
    public int getViewLayout() {
        return R.layout.activity_find_back_psw;
    }


    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent args) {
        pswType = args.getIntExtra(PSW_TYPE_KEY, -1);

        switch (pswType) {
            case PAY_PSW:
                etPhone.setEnabled(false);
                phone = ((MyApp) getApplication()).getUserBean().data.user_mobile.trim();
//                etPhone.setText("请获取手机验证码 :");
                etPhone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(120)});
                String user_mobile = ((MyApp) getApplication()).getUserBean().data.user_mobile;
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("请输入手机 " + user_mobile + " 收到的短信验证码");
                ForegroundColorSpan appColorSpan = new ForegroundColorSpan(Color.parseColor("#ff850b"));
                spannableStringBuilder.setSpan(appColorSpan, 5, 17, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                etPhone.setText(spannableStringBuilder);
                etPhone.setInputType(InputType.TYPE_CLASS_TEXT);
                tbHolder.tvCenterTitle.setText("找回支付密码");
                btnFindImediate.setText("下一步");
                etNewPsw.setVisibility(View.GONE);
                etEnsureNewPsw.setVisibility(View.GONE);
                break;
            case LOGIN_PSW:
                tbHolder.tvCenterTitle.setText("找回登录密码");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (pswType) {
            case PAY_PSW:
                ((MyApp) getApplication()).addActivity(this);
                break;
            case LOGIN_PSW:
                break;
        }

    }

    @Override
    public void showContentView(String url, BaseBean baseBean) {
        super.showContentView(url, baseBean);
        if (url.contains(ApiConfig.API_FIND_BACK_LOGIN_PSW)) {
            ToastUtil.showShort("修改登录密码成功");
            logout();

        } else if (url.contains(ApiConfig.API_FIND_BACK_PAY_PSW)) {
            ToastUtil.showShort("修改支付密码成功");
            onBackPressedSupport();
        } else if (url.contains(ApiConfig.API_API)) {
            ApiBean apiBean = (ApiBean) baseBean;

            switch (pswType) {
                case PAY_PSW:
                    getMsmCodeUrl = apiBean.data.dealer_android_forget_pay_sms;
                    break;
                case LOGIN_PSW:
                    getMsmCodeUrl = apiBean.data.dealer_android_forget_sms;
                    break;
            }
            getSMSCode(getMsmCodeUrl, phone);

        } else if (!TextUtils.isEmpty(getMsmCodeUrl) && getMsmCodeUrl.contains(url)) {
            startCountDown();
            ToastUtil.showShort("验证码已成功发送,请您注意查收");
            switch (pswType) {
                case PAY_PSW:
//                    String user_mobile = ((MyApp) getApplication()).getUserBean().data.user_mobile;
//                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("请输入已发送到 " + user_mobile + " 手机号的验证码");
//                    ForegroundColorSpan appColorSpan = new ForegroundColorSpan(Color.parseColor("#ff850b"));
//                    spannableStringBuilder.setSpan(appColorSpan, 7, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//                    etPhone.setText(spannableStringBuilder);
                    break;
                case LOGIN_PSW:

                    break;
            }

            isGetVerifyCode = true;

        }
    }

    private void startCountDown() {
        countDownHandler = new CountDownHandler(this);
        countDownHandler.sendEmptyMessage(MSG_COUNT_DOWN);
    }


    @OnClick({R.id.btnGetSMSCode, R.id.btnFindImediate})
    public void onViewClicked(View view) {
        CommonTools.hideKeyboard(etSMSCode);


        switch (view.getId()) {
            case R.id.btnGetSMSCode:
                onMsgCodeButtonClick();
                break;
            case R.id.btnFindImediate:
                onBtnClick();
                break;
        }
    }

    private void onMsgCodeButtonClick() {
        switch (pswType) {
            case PAY_PSW:
                getApi();
                break;
            case LOGIN_PSW:
                phone = getTextFromEt(etPhone);
                CommonTools.hideKeyboard(etSMSCode);
                if (isEmpty(phone, "电话号码")) return;

                if (!CommonUtil.isMobileNum(phone)) {

                    ToastUtil.showShort("请输入有效的手机号码");
                    return;
                }
                getApi();
                break;
        }
    }


    private void getApi() {
        presenter.postData(ApiConfig.API_API, ApiBean.class);
    }

    private void onBtnClick() {

        if (!isGetVerifyCode) {
            ToastUtil.showShort("请先获取手机验证码");
            return;
        }
        msmCode = getTextFromEt(etSMSCode);
        if (isEmpty(msmCode, "验证码")) return;
        if (msmCode.length() != 4) {
            ToastUtil.showShort("验证码长度不正确,验证码长度为4");
            return;
        }
        switch (pswType) {
            case PAY_PSW:
//                startActivity(InputOldPayPswActivity.getIntent(this, msmCode, InputNewPayPswActivity.TYPE_FIND_PAYPSW));
                break;
            case LOGIN_PSW:

                newPsw_i = getTextFromEt(etNewPsw);
                newPsw_ii = getTextFromEt(etEnsureNewPsw);
                if (isEmpty(phone, "电话号码")) return;
                if (!CommonUtil.isMobileNum(phone)) {
                    ToastUtil.showShort("请输入有效的手机号码");
                    return;
                }
                if (isEmpty(newPsw_i, "新密码")) return;
                if (!isValidLength(newPsw_i, "新密码")) return;

                if (!newPsw_i.equals(newPsw_ii)) {
                    ToastUtil.showShort("两个密码不一致");
                    return;
                }
                findBackLoginPsw(phone, msmCode, newPsw_i, newPsw_ii);
                break;
        }

    }


//    user_phone
//            手机号码
//    password
//            密码
//    password2
//            确认密码
//    code
//            验证码

    private void findBackLoginPsw(String user_phone, String code, String password, String password2) {
        ArrayMap<String, Serializable> params = new ArrayMap<>();
        params.put("user_phone", user_phone);
        params.put("code", code);
        params.put("password", password);
        params.put("password2", password2);
        presenter.postData(ApiConfig.API_FIND_BACK_LOGIN_PSW, params, BaseBean.class);
    }


    /**
     * 获取验证码
     */
    public void getSMSCode(String url, String user_mobile) {
        if (url.startsWith("/")) {
            url = url.substring(1, url.length()).trim();
        }
        HttpHeaders.setUserAgent("Dalvik " + SystemUtils.getUserAgent(this));
        ArrayMap<String, Serializable> params = new ArrayMap<>();
        params.put("user_mobile", user_mobile);
        presenter.postData(url, params, BaseBean.class);
    }


    private static final int MSG_COUNT_DOWN = 999;

    private static class CountDownHandler extends Handler {
        private WeakReference<FindBackPswActivity> reference;

        CountDownHandler(FindBackPswActivity activity) {
            reference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            FindBackPswActivity findBackPswActivity = reference.get();
            if (findBackPswActivity == null) return;
            switch (msg.what) {
                case MSG_COUNT_DOWN:
                    findBackPswActivity.countDownTask();
                    break;
            }
        }
    }

    private void countDownTask() {
        if (countDown > 0) {
            btnGetSMSCode.setEnabled(false);
            btnGetSMSCode.setText(countDown + "");
            countDown--;
            countDownHandler.sendEmptyMessageDelayed(MSG_COUNT_DOWN, 1200);
        } else {
            btnGetSMSCode.setText("获取验证码");
            btnGetSMSCode.setEnabled(true);
            countDown = 60;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownHandler != null) {
            countDownHandler.removeMessages(MSG_COUNT_DOWN);
            countDownHandler = null;
        }
        switch (pswType) {
            case PAY_PSW:
                ((MyApp) getApplication()).removeActivity(this);
                break;
            case LOGIN_PSW:
                break;
        }
    }


}
