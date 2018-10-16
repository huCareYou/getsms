package com.hucareyou.getsms.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description 易码平台相关配置参数
 * @Author hukui
 * @Date 2018/09/21 下午2:32
 */
@Component
@ConfigurationProperties(prefix = "yima")
@Data
public class YimaProperties {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * token
     */
    private String token;
    /**
     * 接口地址
     */
    private String url;
    /**
     * 饭美美项目编码
     */
    private String fmeiemiCode;
}
