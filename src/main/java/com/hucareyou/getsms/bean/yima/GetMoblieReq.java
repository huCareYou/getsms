package com.hucareyou.getsms.bean.yima;

import lombok.Data;
import lombok.NonNull;

/**
 * @Description 易码-获取手机号的请求信息
 * @Author hukui
 * @Date 2018/09/21 下午2:14
 */
@Data
public class GetMoblieReq {

    /**
     * 接口类型
     * 必填
     * 固定值：getmobile
     */
    @NonNull
    private String action;
    /**
     * 令牌
     * 必填
     * 登录接口获取的token值
     */
    @NonNull
    private String token;
    /**
     * 项目编号
     * 必填
     * 项目对应的数字编号
     */
    @NonNull
    private String itemid;
    /**
     * 运营商代码
     * 号码所属运营商代码。1:移动，2:联通，3:电信
     */
    private String isp;
    /**
     * 省代码
     * 号码归属地的省份代码，省市代码表。
     */
    private String province;
    /**
     * 市代码
     * 号码归属地的市代码，省市代码表。
     */
    private String city;
    /**
     * 指定号码
     * 要指定获取的号码，该号码必须是本平台的号码。
     */
    private String mobile;
    /**
     * 排除号段
     * 不获取170、171和188号段的号码，则该参数为170.171.180，每个号段必须是前三位，用小数点分隔。
     */
    private String excludeno;
}
