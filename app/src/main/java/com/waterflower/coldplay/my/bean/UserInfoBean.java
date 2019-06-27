package com.waterflower.coldplay.my.bean;

import com.waterflower.coldplay.waterflower.basic.model.BaseBean;

import java.util.List;



/**
 * Author : WaterFlower.
 * Created on 2017/8/30.
 * Desc :
 */

public class UserInfoBean extends BaseBean {


    /**
     * status : 1
     * data : {"company_name":"测试代理商33","company_shortname":"测代理","upload_id":[{"upload_id":"1301","upload_url":"http://static2.huifang.cn/u/441900/20171129/16/2633/43932/201711291626338xwkMLB64m87850.jpeg","upload_type":"101"}],"company_id":"10036","user_name":"测试代理","user_key":"43932!!5TUH2VpNBf","user_mobile":"13511111111","count_money":"0.00","dealers":6,"developers":6,"companys":3,"has_paypass":1}
     * msg : 个人信息
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
         * company_name : 测试代理商33
         * company_shortname : 测代理
         * upload_id : [{"upload_id":"1301","upload_url":"http://static2.huifang.cn/u/441900/20171129/16/2633/43932/201711291626338xwkMLB64m87850.jpeg","upload_type":"101"}]
         * company_id : 10036
         * user_name : 测试代理
         * user_key : 43932!!5TUH2VpNBf
         * user_mobile : 13511111111
         * count_money : 0.00
         * dealers : 6
         * developers : 6
         * companys : 3
         * has_paypass : 1
         */

        public String company_name;
        public String company_shortname;
        public String company_id;
        public String user_name;
        public String user_key;
        public String user_mobile;
        public String count_money;
        public String dealers;
        public String developers;
        public String companys;
        public int has_paypass;
        public List<UploadIdBean> upload_id;

        public static class UploadIdBean {
            /**
             * upload_id : 1301
             * upload_url : http://static2.huifang.cn/u/441900/20171129/16/2633/43932/201711291626338xwkMLB64m87850.jpeg
             * upload_type : 101
             */

            public String upload_id;
            public String upload_url;
            public String upload_type;
        }
    }
}
