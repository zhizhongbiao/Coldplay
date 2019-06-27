package com.waterflower.coldplay.my.bean;

import com.waterflower.coldplay.waterflower.basic.model.BaseBean;

import java.util.List;


/**
 * Author : WaterFlower.
 * Created on 2017/12/15.
 * Desc :
 */

public class MyShareListBean extends BaseBean {


    /**
     * status : 1
     * data : [{"uft_id":"11","uft_key":"11!!p7r021uuD7","user_id":"0","company_id_zj":"10013","company_id":"0","finance_type":"130","uft_data":"M","uft_type":"1","uft_label":"450","cdr_id":"300","uft_number":"201712121726359594489220","uft_balance":"3000.00","uft_time":"1513077937","uft_status":"2","fenrun_title":"中介--乐居地产","fenrun_money":"3000.00"},{"uft_id":"12","uft_key":"12!!fIzbbY27ag","user_id":"0","company_id_zj":"10013","company_id":"0","finance_type":"130","uft_data":"M","uft_type":"1","uft_label":"400","cdr_id":"300","uft_number":"201712121726356463071468","uft_balance":"-3000.00","uft_time":"1513077937","uft_status":"2","fenrun_title":"中介--乐居地产","fenrun_money":"-3000.00"},{"uft_id":"13","uft_key":"13!!y4efsiYEJD","user_id":"0","company_id_zj":"10013","company_id":"0","finance_type":"130","uft_data":"M","uft_type":"1","uft_label":"80","cdr_id":"300","uft_number":"201712121726350203191426","uft_balance":"750.00","uft_time":"1512046000","uft_status":"2","fenrun_title":"中介--乐居地产","fenrun_money":"750.00"},{"uft_id":"43","uft_key":"43!!kvAQ9oafsG","user_id":"0","company_id_zj":"10013","company_id":"0","finance_type":"30","uft_data":"A","uft_type":"1","uft_label":"0","cdr_id":"304","uft_number":"201712141146524644599127","uft_balance":"749.99","uft_time":"1513223248","uft_status":"1","fenrun_title":"中介--乐居地产","fenrun_money":"749.99"},{"uft_id":"65","uft_key":"65!!c84e0x0mjI","user_id":"0","company_id_zj":"10013","company_id":"0","finance_type":"30","uft_data":"M","uft_type":"1","uft_label":"0","cdr_id":"306","uft_number":"201712141508297399517998","uft_balance":"186.30","uft_time":"1513235384","uft_status":"1","fenrun_title":"中介--乐居地产","fenrun_money":"186.30"},{"uft_id":"66","uft_key":"66!!wSurN1Dy0D","user_id":"0","company_id_zj":"10013","company_id":"0","finance_type":"30","uft_data":"N","uft_type":"1","uft_label":"0","cdr_id":"306","uft_number":"201712141508292195711190","uft_balance":"745.20","uft_time":"1513235384","uft_status":"1","fenrun_title":"中介--乐居地产","fenrun_money":"745.20"},{"uft_id":"67","uft_key":"67!!vVYqsJwzRu","user_id":"0","company_id_zj":"10013","company_id":"0","finance_type":"30","uft_data":"A","uft_type":"1","uft_label":"0","cdr_id":"306","uft_number":"201712141508292841925746","uft_balance":"372.60","uft_time":"1513235384","uft_status":"1","fenrun_title":"中介--乐居地产","fenrun_money":"372.60"},{"uft_id":"68","uft_key":"68!!suuTDrb9eF","user_id":"0","company_id_zj":"10013","company_id":"0","finance_type":"30","uft_data":"B","uft_type":"1","uft_label":"0","cdr_id":"306","uft_number":"201712141508294007376804","uft_balance":"558.90","uft_time":"1513235384","uft_status":"1","fenrun_title":"中介--乐居地产","fenrun_money":"558.90"},{"uft_id":"69","uft_key":"69!!oDKCoUsxZk","user_id":"0","company_id_zj":"10013","company_id":"0","finance_type":"60","uft_data":"F","uft_type":"1","uft_label":"500","cdr_id":"306","uft_number":"201712141509394233580656","uft_balance":"-2070.00","uft_time":"1513235384","uft_status":"1","fenrun_title":"中介--乐居地产","fenrun_money":"-2070.00"},{"uft_id":"84","uft_key":"84!!4vgT3OKvUr","user_id":"0","company_id_zj":"10013","company_id":"0","finance_type":"30","uft_data":"A","uft_type":"1","uft_label":"0","cdr_id":"307","uft_number":"201712141621058688824431","uft_balance":"2138.40","uft_time":"1513239722","uft_status":"1","fenrun_title":"中介--乐居地产","fenrun_money":"2138.40"}]
     * msg : 请求成功
     * page : 1
     * login_status : 1
     * count : 15
     * page_count : 2
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
         * uft_id : 11
         * uft_key : 11!!p7r021uuD7
         * user_id : 0
         * company_id_zj : 10013
         * company_id : 0
         * finance_type : 130
         * uft_data : M
         * uft_type : 1
         * uft_label : 450
         * cdr_id : 300
         * uft_number : 201712121726359594489220
         * uft_balance : 3000.00
         * uft_time : 1513077937
         * uft_status : 2
         * fenrun_title : 中介--乐居地产
         * fenrun_money : 3000.00
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
        public String fenrun_title;
        public String fenrun_money;
    }
}
