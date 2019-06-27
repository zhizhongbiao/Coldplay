package com.waterflower.coldplay.my.bean;


import com.waterflower.coldplay.waterflower.basic.model.BaseBean;

/**
 * Author : WaterFlower.
 * Created on 2017/11/28.
 * Desc :
 */

public class WithdrawDetailBean extends BaseBean {


    /**
     * status : 1
     * data : {"card_bank_name":"中国建设银行","card_name":"坚果","card_number":"8341","card_logo":"http://dongguan.huifang.cn/u/default_images/bank_ico/jianshe.png","ufr_balance":"100.00","ufr_status":"2","ufr_time":"2017-11-27","ufr_number":"2017112710175405968","ufr_success_time":"","ufr_status_text":"提现失败"}
     * msg : 提现详情
     * page : 1
     * login_status : 1
     * count : 0
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
         * card_bank_name : 中国建设银行
         * card_name : 坚果
         * card_number : 8341
         * card_logo : http://dongguan.huifang.cn/u/default_images/bank_ico/jianshe.png
         * ufr_balance : 100.00
         * ufr_status : 2
         * ufr_time : 2017-11-27
         * ufr_number : 2017112710175405968
         * ufr_success_time :
         * ufr_status_text : 提现失败
         */

        public String card_bank_name;
        public String card_name;
        public String card_number;
        public String card_logo;
        public String ufr_balance;
        public String ufr_status;
        public String ufr_time;
        public String ufr_number;
        public String ufr_success_time;
        public String ufr_status_text;
    }
}
