package com.waterflower.coldplay.my.bean;

import com.waterflower.coldplay.waterflower.basic.model.BaseBean;

import java.util.List;

/**
 * Author : WaterFlower.
 * Created on 2017/8/30.
 * Desc :
 */

public class IncomeRecordListBean extends BaseBean {


    /**
     * status : 1
     * data : [{"count":"10191.74","mtime":"2017年12月","list":[{"fenrun_id":"175","fenrun_key":"175!!Yjg8HBOGkh","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-18 14:33","fenrun_money":"1234.50","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"176","fenrun_key":"176!!C6YpaToogY","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-18 14:33","fenrun_money":"617.25","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"168","fenrun_key":"168!!Lr9t0KtUj4","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-18 14:31","fenrun_money":"123.40","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"169","fenrun_key":"169!!gehTKLI3jY","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-18 14:31","fenrun_money":"61.70","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"154","fenrun_key":"154!!HSsXPk1GtF","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-18 10:22","fenrun_money":"1422.08","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"155","fenrun_key":"155!!2b8SeHO5Jn","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-18 10:22","fenrun_money":"0.00","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"147","fenrun_key":"147!!iqAxJUGFh5","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-18 00:27","fenrun_money":"150.00","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"148","fenrun_key":"148!!yxcXKdKrVZ","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-18 00:27","fenrun_money":"20.00","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"140","fenrun_key":"140!!JeOZ94dSeT","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-17 23:50","fenrun_money":"150.00","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"141","fenrun_key":"141!!gc1ylkSc7y","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-17 23:50","fenrun_money":"20.00","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"}]}]
     * msg : 请求成功
     * page : 1
     * login_status : 1
     * count : 22
     * page_count : 3
     */

    public int status;
    public String msg;
    public int page;
    public int login_status;
    public int count;
    public int page_count;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * count : 10191.74
         * mtime : 2017年12月
         * list : [{"fenrun_id":"175","fenrun_key":"175!!Yjg8HBOGkh","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-18 14:33","fenrun_money":"1234.50","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"176","fenrun_key":"176!!C6YpaToogY","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-18 14:33","fenrun_money":"617.25","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"168","fenrun_key":"168!!Lr9t0KtUj4","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-18 14:31","fenrun_money":"123.40","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"169","fenrun_key":"169!!gehTKLI3jY","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-18 14:31","fenrun_money":"61.70","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"154","fenrun_key":"154!!HSsXPk1GtF","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-18 10:22","fenrun_money":"1422.08","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"155","fenrun_key":"155!!2b8SeHO5Jn","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-18 10:22","fenrun_money":"0.00","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"147","fenrun_key":"147!!iqAxJUGFh5","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-18 00:27","fenrun_money":"150.00","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"148","fenrun_key":"148!!yxcXKdKrVZ","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-18 00:27","fenrun_money":"20.00","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"140","fenrun_key":"140!!JeOZ94dSeT","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-17 23:50","fenrun_money":"150.00","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"},{"fenrun_id":"141","fenrun_key":"141!!gc1ylkSc7y","fenrun_title":"中介--乐居地产","fenrun_time":"2017-12-17 23:50","fenrun_money":"20.00","fenrun_status":"待结算","mtime":"2017年12月","count":"10191.74"}]
         */

        public String count;
        public String mtime;
        public List<ListBean> list;

        public static class ListBean {
            /**
             * fenrun_id : 175
             * fenrun_key : 175!!Yjg8HBOGkh
             * fenrun_title : 中介--乐居地产
             * fenrun_time : 2017-12-18 14:33
             * fenrun_money : 1234.50
             * fenrun_status : 待结算
             * mtime : 2017年12月
             * count : 10191.74
             */

            public String fenrun_id;
            public String fenrun_key;
            public String fenrun_title;
            public String fenrun_time;
            public String fenrun_money;
            public String fenrun_status;
            public String mtime;
            public String count;
        }
    }
}
