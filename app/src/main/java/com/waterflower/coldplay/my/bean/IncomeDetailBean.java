package com.waterflower.coldplay.my.bean;


import com.waterflower.coldplay.waterflower.basic.model.BaseBean;

/**
 * Author : WaterFlower.
 * Created on 2017/12/15.
 * Desc :
 */

public class IncomeDetailBean extends BaseBean {


    /**
     * status : 1
     * data : {"uft_id":"43","uft_key":"43!!kvAQ9oafsG","user_id":"0","company_id_zj":"10013","company_id":"0","finance_type":"30","uft_data":"A","uft_type":"1","uft_label":"0","cdr_id":"304","uft_number":"201712141146524644599127","uft_balance":"749.99","uft_time":"1513223248","uft_status":"1","fenrun_success_time":"-","fenrun_status":"待结算","fenrun_money_time":"2017-12-14 11:46:52","fenrun_type":"中介分润","fenrun_name":"乐居地产","fenrun_fang_type":"住宅","fenrun_total":"55555","fenrun_distribute":"1.349995499955%","fenrun_title":"中介分润--乐居地产"}
     * msg : 请求成功！
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
         * uft_id : 43
         * uft_key : 43!!kvAQ9oafsG
         * user_id : 0
         * company_id_zj : 10013
         * company_id : 0
         * finance_type : 30
         * uft_data : A
         * uft_type : 1
         * uft_label : 0
         * cdr_id : 304
         * uft_number : 201712141146524644599127
         * uft_balance : 749.99
         * uft_time : 1513223248
         * uft_status : 1
         * fenrun_success_time : -
         * fenrun_status : 待结算
         * fenrun_money_time : 2017-12-14 11:46:52
         * fenrun_type : 中介分润
         * fenrun_name : 乐居地产
         * fenrun_fang_type : 住宅
         * fenrun_total : 55555
         * fenrun_distribute : 1.349995499955%
         * fenrun_title : 中介分润--乐居地产
         */

        public String uft_id;
        public String uft_key;
        public String user_id;
        public String company_id_zj;
        public String company_id;
        public String finance_type;
        public String uft_data;
        public String uft_type;
        public String uft_label;
        public String cdr_id;
        public String uft_number;
        public String uft_balance;
        public String uft_time;
        public String uft_status;
        public String fenrun_success_time;
        public String fenrun_status;
        public String fenrun_money_time;
        public String fenrun_type;
        public String fenrun_name;
        public String fenrun_fang_type;
        public String fenrun_total;
        public String fenrun_distribute;
        public String fenrun_title;
    }
}
