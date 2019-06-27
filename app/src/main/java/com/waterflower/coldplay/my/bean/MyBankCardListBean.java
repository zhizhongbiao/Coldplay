package com.waterflower.coldplay.my.bean;

import com.waterflower.coldplay.waterflower.basic.model.BaseBean;

import java.io.Serializable;
import java.util.List;


/**
 * Author : WaterFlower.
 * Created on 2017/8/30.
 * Desc :
 */

public class MyBankCardListBean extends BaseBean {


    /**
     * status : 1
     * data : [{"card_id":"58","card_key":"58!!Y4phKpWB1X","card_number":"6212262010009428341","card_name":"坚果","card_bank":"01050000","card_bank_name":"中国建设银行","card_type":"储蓄卡","card_status":"1","bank_logo":"http://dongguan.huifang.cn/u/default_images/bank_ico/jianshe.png"}]
     * msg : 请求成功
     * page : 1
     * login_status : 1
     * count : 1
     */

    public int status;
    public String msg;
    public int page;
    public int login_status;
    public int count;
    public List<DataBean> data;

    public static class DataBean implements Serializable {
        /**
         * card_id : 58
         * card_key : 58!!Y4phKpWB1X
         * card_number : 6212262010009428341
         * card_name : 坚果
         * card_bank : 01050000
         * card_bank_name : 中国建设银行
         * card_type : 储蓄卡
         * card_status : 1
         * bank_logo : http://dongguan.huifang.cn/u/default_images/bank_ico/jianshe.png
         */

        public String card_id;
        public String card_key;
        public String card_number;
        public String card_name;
        public String card_bank;
        public String card_bank_name;
        public String card_type;
        public String card_status;
        public String bank_logo;
    }
}
