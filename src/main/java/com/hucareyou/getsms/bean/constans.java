package com.hucareyou.getsms.bean;

/**
 * @Description 常量
 * @Author hukui
 * @Date 2018/09/21 下午4:26
 */
public class constans {

    /**
     * 易码-常量
     */
    public static class YIMA{

        /**
         * 接口类型：获取手机号
         */
        public static final String GET_MOBILE = "getmobile";
        /**
         * 接口类型:释放手机号
         */
        public static final String RELEASE_MOBILE = "release";
        /**
         * 接口类型:获取短信
         */
        public static final String GET_SMS = "getsms";


        /**
         * 接口成功返回标识
         */
        public static final String SUCCESS = "success";


        /**
         * 短信获取中
         */
        public static final String GET_SMS_STARTING = "3001";
        /**
         * 等待发送
         */
        public static final String GET_SMS_WAITING = "3002";
        /**
         * 正在发送
         */
        public static final String GET_SMS_SENDING = "3003";
        /**
         * 发送失败
         */
        public static final String GET_SMS_FAIL = "3004";
    }
}
