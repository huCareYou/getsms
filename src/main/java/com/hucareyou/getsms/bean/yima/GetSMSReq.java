package com.hucareyou.getsms.bean.yima;

import lombok.Data;
import lombok.NonNull;

/**
 * @Description 易码-获取短信验证内容
 * @Author hukui
 * @Date 2018/09/21 下午2:24
 */
@Data
public class GetSMSReq {

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
     * 手机号码
     * 要获取短信的手机号码。
     */
    @NonNull
    private String mobile;
    /**
     * 自动释放号码标识符
     * 若该参数值为1时，获取到短信的同时系统将自己释放该手机号码。若要继续使用该号码，请勿带入该参数。
     */
    private String release;
    /**
     * 是否返回发送号码 	若该参数值为1时，则将短信发送号码附加在短信最后用#分隔。
     */
    private String getsendno;

}
