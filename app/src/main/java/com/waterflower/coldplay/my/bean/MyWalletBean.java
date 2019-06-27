package com.waterflower.coldplay.my.bean;

import com.waterflower.coldplay.waterflower.basic.model.BaseBean;

import java.util.List;



/**
 * Author : WaterFlower.
 * Created on 2017/9/4.
 * Desc :
 */

public class MyWalletBean extends BaseBean {


    /**
     * status : 1
     * data : {"Cash":"3300.00","bank_card":[{"card_id":"58","card_key":"58!!Y4phKpWB1X","user_id":"43932","card_number":"6212262010009428341","card_name":"坚果","card_bank":"01050000","card_bank_name":"中国建设银行","card_type":"2","card_status":"1","bank_logo":"http://dongguan.huifang.cn/u/default_images/bank_ico/jianshe.png"}],"count_card":1}
     * msg : 用户财务信息
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
         * Cash : 3300.00
         * bank_card : [{"card_id":"58","card_key":"58!!Y4phKpWB1X","user_id":"43932","card_number":"6212262010009428341","card_name":"坚果","card_bank":"01050000","card_bank_name":"中国建设银行","card_type":"2","card_status":"1","bank_logo":"http://dongguan.huifang.cn/u/default_images/bank_ico/jianshe.png"}]
         * count_card : 1
         */

        public String Cash;
        public int count_card;
        public List<BankCardBean> bank_card;

        public static class BankCardBean {
            /**
             * card_id : 58
             * card_key : 58!!Y4phKpWB1X
             * user_id : 43932
             * card_number : 6212262010009428341
             * card_name : 坚果
             * card_bank : 01050000
             * card_bank_name : 中国建设银行
             * card_type : 2
             * card_status : 1
             * bank_logo : http://dongguan.huifang.cn/u/default_images/bank_ico/jianshe.png
             */

            public String card_id;
            public String card_key;
            public String user_id;
            public String card_number;
            public String card_name;
            public String card_bank;
            public String card_bank_name;
            public String card_type;
            public String card_status;
            public String bank_logo;
        }
    }
}
