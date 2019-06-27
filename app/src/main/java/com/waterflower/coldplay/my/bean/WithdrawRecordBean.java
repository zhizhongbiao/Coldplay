package com.waterflower.coldplay.my.bean;

import com.waterflower.coldplay.waterflower.basic.model.BaseBean;

import java.util.List;


/**
 * Author : WaterFlower.
 * Created on 2017/8/30.
 * Desc :
 */

public class WithdrawRecordBean extends BaseBean {


    /**
     * status : 1
     * data : {"total":"100.00","cash_total":"3400.00","record":[{"ufr_key":"14730!!e9uIijxIgU","ufr_balance_unit":"","ufr_balance_text":"提现金额（元）","ufr_balance":"100.00","ufr_time":"2017-11-27 10:17","ufr_apply_text":"提交申请","ufr_status":"2","ufr_status_text":"提现失败","ufr_success_time":""},{"ufr_key":"14580!!B7jyeOCIjP","ufr_balance_unit":"","ufr_balance_text":"提现金额（元）","ufr_balance":"100.00","ufr_time":"2017-11-23 17:00","ufr_apply_text":"提交申请","ufr_status":"3","ufr_status_text":"审核中","ufr_success_time":""}]}
     * msg : 提现记录
     * page : 1
     * login_status : 1
     * count : 2
     * page_count : 1
     */

    public int status;
    public DataBean data;
    public String msg;
    public int page;
    public int login_status;
    public int count;
    public int page_count;

    public static class DataBean {
        /**
         * total : 100.00
         * cash_total : 3400.00
         * record : [{"ufr_key":"14730!!e9uIijxIgU","ufr_balance_unit":"","ufr_balance_text":"提现金额（元）","ufr_balance":"100.00","ufr_time":"2017-11-27 10:17","ufr_apply_text":"提交申请","ufr_status":"2","ufr_status_text":"提现失败","ufr_success_time":""},{"ufr_key":"14580!!B7jyeOCIjP","ufr_balance_unit":"","ufr_balance_text":"提现金额（元）","ufr_balance":"100.00","ufr_time":"2017-11-23 17:00","ufr_apply_text":"提交申请","ufr_status":"3","ufr_status_text":"审核中","ufr_success_time":""}]
         */

        public String total;
        public String cash_total;
        public List<RecordBean> record;

        public static class RecordBean {
            /**
             * ufr_key : 14730!!e9uIijxIgU
             * ufr_balance_unit :
             * ufr_balance_text : 提现金额（元）
             * ufr_balance : 100.00
             * ufr_time : 2017-11-27 10:17
             * ufr_apply_text : 提交申请
             * ufr_status : 2
             * ufr_status_text : 提现失败
             * ufr_success_time :
             */

            public String ufr_key;
            public String ufr_balance_unit;
            public String ufr_balance_text;
            public String ufr_balance;
            public String ufr_time;
            public String ufr_apply_text;
            public String ufr_status;
            public String ufr_status_text;
            public String ufr_success_time;
        }
    }
}
