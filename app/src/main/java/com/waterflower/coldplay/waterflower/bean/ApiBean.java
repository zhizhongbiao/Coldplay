package com.waterflower.coldplay.waterflower.bean;

import com.waterflower.coldplay.waterflower.basic.model.BaseBean;

import java.util.List;



/**
 * Author : WaterFlower.
 * Created on 2017/11/24.
 * Desc :
 */

public class ApiBean extends BaseBean {


    /**
     * status : 1
     * data : {"fang_type":[{"key":0,"value":"不限"},{"key":1,"value":"新房"},{"key":2,"value":"二手房"},{"key":3,"value":"租房"}],"fang_fang_type":[{"key":0,"value":"不限"},{"key":2,"value":"二手房"},{"key":3,"value":"租房"}],"estate_price":[{"key":1,"value":"不限"},{"key":2,"value":"特价待定"},{"key":3,"value":"5000元/m²以下"},{"key":4,"value":"5000-8000元/m²"},{"key":5,"value":"8000-10000元/m²"},{"key":6,"value":"10000-15000元/m²"},{"key":7,"value":"15000-20000元/m²"},{"key":8,"value":"20000元/m²以上"}],"estate_type":[{"key":1,"value":"住宅"},{"key":2,"value":"商铺"},{"key":3,"value":"写字楼"},{"key":4,"value":"别墅"}],"house_price":[{"key":1,"value":"不限"},{"key":2,"value":"50万以下"},{"key":3,"value":"50-100万"},{"key":4,"value":"100-150万"},{"key":5,"value":"150-200万"},{"key":6,"value":"200万以上"}],"house_style":[{"key":0,"value":"不限"},{"key":2,"value":"一房"},{"key":3,"value":"二房"},{"key":4,"value":"三房"},{"key":5,"value":"四房"},{"key":6,"value":"五房"},{"key":7,"value":"五房以上"}],"house_area":[{"key":1,"value":"50m²以下"},{"key":2,"value":"50m²-70m²"},{"key":3,"value":"70m²-90m²"},{"key":4,"value":"90m²-110m²"},{"key":5,"value":"110m²-130m²"},{"key":6,"value":"130m²-150m²"},{"key":7,"value":"150m²-200m²"},{"key":8,"value":"200m²-300m²"},{"key":9,"value":"300m²以上"}],"rent_price":[{"key":1,"value":"不限"},{"key":2,"value":"800元以下"},{"key":3,"value":"800-1500元"},{"key":4,"value":"1500-2000元"},{"key":5,"value":"2000-3000元"},{"key":6,"value":"3000-5000元"},{"key":7,"value":"5000元以上"}],"rent_mode":[{"key":1,"value":"整租"},{"key":2,"value":"合租"}],"fang_decoration":[{"key":1,"value":"毛坯"},{"key":2,"value":"简装"},{"key":3,"value":"中装"},{"key":4,"value":"精装"},{"key":5,"value":"豪装"}],"focus_level":[{"key":1,"value":"培养"},{"key":2,"value":"关注"},{"key":3,"value":"重点"}],"client_tags":[{"key":101,"value":"首套"},{"key":111,"value":"投资"},{"key":121,"value":"一次性付清"},{"key":131,"value":"贷款"},{"key":141,"value":"结婚"},{"key":151,"value":"置换"}],"client_tags_rent":[{"key":101,"value":"投资"},{"key":111,"value":"整租"},{"key":121,"value":"合租"},{"key":131,"value":"自住"}],"fang_view_set":[{"key":101,"value":"公司内部可见"},{"key":102,"value":"公司自由经纪人可见"},{"key":103,"value":"同区域经纪人可见"},{"key":104,"value":"不同区域经纪人可见"},{"key":105,"value":"所有自由经纪人可见"},{"key":106,"value":"全选"}],"fang_cooperate_set":[{"key":101,"value":"提供客源"},{"key":102,"value":"带客成交"},{"key":103,"value":"全选"}],"client_source":[{"key":0,"value":"不限"},{"key":1,"value":"私客"},{"key":2,"value":"抢得"},{"key":3,"value":"托管"}],"client_state":[{"key":0,"value":"不限"},{"key":1,"value":"报备"},{"key":2,"value":"约看"},{"key":3,"value":"下定"},{"key":4,"value":"签约"},{"key":5,"value":"成交"}],"client_state_new":[{"key":0,"value":"不限"},{"key":1,"value":"报备"},{"key":2,"value":"约看"},{"key":3,"value":"下定"},{"key":4,"value":"签约"},{"key":5,"value":"成交"},{"key":6,"value":"无效"}],"refuse_fang_reason":[{"key":101,"value":"号码有误"},{"key":102,"value":"无法接通"},{"key":103,"value":"意向不符"},{"key":104,"value":"实际与描述不符"}],"refuse_ke_reason":[{"key":101,"value":"号码有误"},{"key":102,"value":"无法接通"},{"key":103,"value":"意向不符"},{"key":104,"value":"实际与描述不符"}],"invalid_fang_reason":[{"key":101,"value":"号码有误"},{"key":102,"value":"无法接通"},{"key":103,"value":"业主无意向"},{"key":104,"value":"实际与描述不符"}],"invalid_ke_reason":[{"key":101,"value":"号码有误"},{"key":102,"value":"无法接通"},{"key":103,"value":"客户无意向"},{"key":104,"value":"实际与描述不符"}],"android_register_sms":"/api/userRegister_SmsCode_Az","android_forget_sms":"/api/userForgetPassword_SMS","android_forget_pay_sms":"/api/userForgetPassword_SMS","android_bank_card_sms":"/api/publicSmsCode","android_mobile_bind_sms":"/api/publicSmsCode","ios_register_sms":"/api/userRegister_SmsCode_Ios","ios_forget_sms":"/api/userForgetPassword_SMS","ios_forget_pay_sms":"/api/userForgetPassword_SMS","ios_bank_card_sms":"/api/publicSmsCode","ios_mobile_bind_sms":"/api/publicSmsCode","dealer_android_register_sms":"/api/userRegister_SmsCode_Az","dealer_android_forget_sms":"/api/userForgetPassword_SMS","dealer_android_forget_pay_sms":"/api/userForgetPassword_SMS","dealer_android_bank_card_sms":"/api/publicSmsCode","dealer_ios_register_sms":"/api/userRegister_SmsCode_Ios","dealer_ios_forget_sms":"/api/userForgetPassword_SMS","dealer_ios_forget_pay_sms":"/api/userForgetPassword_SMS","dealer_ios_bank_card_sms":"/api/publicSmsCode"}
     * msg : 请求成功
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
         * fang_type : [{"key":0,"value":"不限"},{"key":1,"value":"新房"},{"key":2,"value":"二手房"},{"key":3,"value":"租房"}]
         * fang_fang_type : [{"key":0,"value":"不限"},{"key":2,"value":"二手房"},{"key":3,"value":"租房"}]
         * estate_price : [{"key":1,"value":"不限"},{"key":2,"value":"特价待定"},{"key":3,"value":"5000元/m²以下"},{"key":4,"value":"5000-8000元/m²"},{"key":5,"value":"8000-10000元/m²"},{"key":6,"value":"10000-15000元/m²"},{"key":7,"value":"15000-20000元/m²"},{"key":8,"value":"20000元/m²以上"}]
         * estate_type : [{"key":1,"value":"住宅"},{"key":2,"value":"商铺"},{"key":3,"value":"写字楼"},{"key":4,"value":"别墅"}]
         * house_price : [{"key":1,"value":"不限"},{"key":2,"value":"50万以下"},{"key":3,"value":"50-100万"},{"key":4,"value":"100-150万"},{"key":5,"value":"150-200万"},{"key":6,"value":"200万以上"}]
         * house_style : [{"key":0,"value":"不限"},{"key":2,"value":"一房"},{"key":3,"value":"二房"},{"key":4,"value":"三房"},{"key":5,"value":"四房"},{"key":6,"value":"五房"},{"key":7,"value":"五房以上"}]
         * house_area : [{"key":1,"value":"50m²以下"},{"key":2,"value":"50m²-70m²"},{"key":3,"value":"70m²-90m²"},{"key":4,"value":"90m²-110m²"},{"key":5,"value":"110m²-130m²"},{"key":6,"value":"130m²-150m²"},{"key":7,"value":"150m²-200m²"},{"key":8,"value":"200m²-300m²"},{"key":9,"value":"300m²以上"}]
         * rent_price : [{"key":1,"value":"不限"},{"key":2,"value":"800元以下"},{"key":3,"value":"800-1500元"},{"key":4,"value":"1500-2000元"},{"key":5,"value":"2000-3000元"},{"key":6,"value":"3000-5000元"},{"key":7,"value":"5000元以上"}]
         * rent_mode : [{"key":1,"value":"整租"},{"key":2,"value":"合租"}]
         * fang_decoration : [{"key":1,"value":"毛坯"},{"key":2,"value":"简装"},{"key":3,"value":"中装"},{"key":4,"value":"精装"},{"key":5,"value":"豪装"}]
         * focus_level : [{"key":1,"value":"培养"},{"key":2,"value":"关注"},{"key":3,"value":"重点"}]
         * client_tags : [{"key":101,"value":"首套"},{"key":111,"value":"投资"},{"key":121,"value":"一次性付清"},{"key":131,"value":"贷款"},{"key":141,"value":"结婚"},{"key":151,"value":"置换"}]
         * client_tags_rent : [{"key":101,"value":"投资"},{"key":111,"value":"整租"},{"key":121,"value":"合租"},{"key":131,"value":"自住"}]
         * fang_view_set : [{"key":101,"value":"公司内部可见"},{"key":102,"value":"公司自由经纪人可见"},{"key":103,"value":"同区域经纪人可见"},{"key":104,"value":"不同区域经纪人可见"},{"key":105,"value":"所有自由经纪人可见"},{"key":106,"value":"全选"}]
         * fang_cooperate_set : [{"key":101,"value":"提供客源"},{"key":102,"value":"带客成交"},{"key":103,"value":"全选"}]
         * client_source : [{"key":0,"value":"不限"},{"key":1,"value":"私客"},{"key":2,"value":"抢得"},{"key":3,"value":"托管"}]
         * client_state : [{"key":0,"value":"不限"},{"key":1,"value":"报备"},{"key":2,"value":"约看"},{"key":3,"value":"下定"},{"key":4,"value":"签约"},{"key":5,"value":"成交"}]
         * client_state_new : [{"key":0,"value":"不限"},{"key":1,"value":"报备"},{"key":2,"value":"约看"},{"key":3,"value":"下定"},{"key":4,"value":"签约"},{"key":5,"value":"成交"},{"key":6,"value":"无效"}]
         * refuse_fang_reason : [{"key":101,"value":"号码有误"},{"key":102,"value":"无法接通"},{"key":103,"value":"意向不符"},{"key":104,"value":"实际与描述不符"}]
         * refuse_ke_reason : [{"key":101,"value":"号码有误"},{"key":102,"value":"无法接通"},{"key":103,"value":"意向不符"},{"key":104,"value":"实际与描述不符"}]
         * invalid_fang_reason : [{"key":101,"value":"号码有误"},{"key":102,"value":"无法接通"},{"key":103,"value":"业主无意向"},{"key":104,"value":"实际与描述不符"}]
         * invalid_ke_reason : [{"key":101,"value":"号码有误"},{"key":102,"value":"无法接通"},{"key":103,"value":"客户无意向"},{"key":104,"value":"实际与描述不符"}]
         * android_register_sms : /api/userRegister_SmsCode_Az
         * android_forget_sms : /api/userForgetPassword_SMS
         * android_forget_pay_sms : /api/userForgetPassword_SMS
         * android_bank_card_sms : /api/publicSmsCode
         * android_mobile_bind_sms : /api/publicSmsCode
         * ios_register_sms : /api/userRegister_SmsCode_Ios
         * ios_forget_sms : /api/userForgetPassword_SMS
         * ios_forget_pay_sms : /api/userForgetPassword_SMS
         * ios_bank_card_sms : /api/publicSmsCode
         * ios_mobile_bind_sms : /api/publicSmsCode
         * dealer_android_register_sms : /api/userRegister_SmsCode_Az
         * dealer_android_forget_sms : /api/userForgetPassword_SMS
         * dealer_android_forget_pay_sms : /api/userForgetPassword_SMS
         * dealer_android_bank_card_sms : /api/publicSmsCode
         * dealer_ios_register_sms : /api/userRegister_SmsCode_Ios
         * dealer_ios_forget_sms : /api/userForgetPassword_SMS
         * dealer_ios_forget_pay_sms : /api/userForgetPassword_SMS
         * dealer_ios_bank_card_sms : /api/publicSmsCode
         */

        public String android_register_sms;
        public String android_forget_sms;
        public String android_forget_pay_sms;
        public String android_bank_card_sms;
        public String android_mobile_bind_sms;
        public String ios_register_sms;
        public String ios_forget_sms;
        public String ios_forget_pay_sms;
        public String ios_bank_card_sms;
        public String ios_mobile_bind_sms;
        public String dealer_android_register_sms;
        public String dealer_android_forget_sms;
        public String dealer_android_forget_pay_sms;
        public String dealer_android_bank_card_sms;
        public String dealer_ios_register_sms;
        public String dealer_ios_forget_sms;
        public String dealer_ios_forget_pay_sms;
        public String dealer_ios_bank_card_sms;
        public List<FangTypeBean> fang_type;
        public List<FangFangTypeBean> fang_fang_type;
        public List<EstatePriceBean> estate_price;
        public List<EstateTypeBean> estate_type;
        public List<HousePriceBean> house_price;
        public List<HouseStyleBean> house_style;
        public List<HouseAreaBean> house_area;
        public List<RentPriceBean> rent_price;
        public List<RentModeBean> rent_mode;
        public List<FangDecorationBean> fang_decoration;
        public List<FocusLevelBean> focus_level;
        public List<ClientTagsBean> client_tags;
        public List<ClientTagsRentBean> client_tags_rent;
        public List<FangViewSetBean> fang_view_set;
        public List<FangCooperateSetBean> fang_cooperate_set;
        public List<ClientSourceBean> client_source;
        public List<ClientStateBean> client_state;
        public List<ClientStateNewBean> client_state_new;
        public List<RefuseFangReasonBean> refuse_fang_reason;
        public List<RefuseKeReasonBean> refuse_ke_reason;
        public List<InvalidFangReasonBean> invalid_fang_reason;
        public List<InvalidKeReasonBean> invalid_ke_reason;

        public static class FangTypeBean {
            /**
             * key : 0
             * value : 不限
             */

            public int key;
            public String value;
        }

        public static class FangFangTypeBean {
            /**
             * key : 0
             * value : 不限
             */

            public int key;
            public String value;
        }

        public static class EstatePriceBean {
            /**
             * key : 1
             * value : 不限
             */

            public int key;
            public String value;
        }

        public static class EstateTypeBean {
            /**
             * key : 1
             * value : 住宅
             */

            public int key;
            public String value;
        }

        public static class HousePriceBean {
            /**
             * key : 1
             * value : 不限
             */

            public int key;
            public String value;
        }

        public static class HouseStyleBean {
            /**
             * key : 0
             * value : 不限
             */

            public int key;
            public String value;
        }

        public static class HouseAreaBean {
            /**
             * key : 1
             * value : 50m²以下
             */

            public int key;
            public String value;
        }

        public static class RentPriceBean {
            /**
             * key : 1
             * value : 不限
             */

            public int key;
            public String value;
        }

        public static class RentModeBean {
            /**
             * key : 1
             * value : 整租
             */

            public int key;
            public String value;
        }

        public static class FangDecorationBean {
            /**
             * key : 1
             * value : 毛坯
             */

            public int key;
            public String value;
        }

        public static class FocusLevelBean {
            /**
             * key : 1
             * value : 培养
             */

            public int key;
            public String value;
        }

        public static class ClientTagsBean {
            /**
             * key : 101
             * value : 首套
             */

            public int key;
            public String value;
        }

        public static class ClientTagsRentBean {
            /**
             * key : 101
             * value : 投资
             */

            public int key;
            public String value;
        }

        public static class FangViewSetBean {
            /**
             * key : 101
             * value : 公司内部可见
             */

            public int key;
            public String value;
        }

        public static class FangCooperateSetBean {
            /**
             * key : 101
             * value : 提供客源
             */

            public int key;
            public String value;
        }

        public static class ClientSourceBean {
            /**
             * key : 0
             * value : 不限
             */

            public int key;
            public String value;
        }

        public static class ClientStateBean {
            /**
             * key : 0
             * value : 不限
             */

            public int key;
            public String value;
        }

        public static class ClientStateNewBean {
            /**
             * key : 0
             * value : 不限
             */

            public int key;
            public String value;
        }

        public static class RefuseFangReasonBean {
            /**
             * key : 101
             * value : 号码有误
             */

            public int key;
            public String value;
        }

        public static class RefuseKeReasonBean {
            /**
             * key : 101
             * value : 号码有误
             */

            public int key;
            public String value;
        }

        public static class InvalidFangReasonBean {
            /**
             * key : 101
             * value : 号码有误
             */

            public int key;
            public String value;
        }

        public static class InvalidKeReasonBean {
            /**
             * key : 101
             * value : 号码有误
             */

            public int key;
            public String value;
        }
    }
}
