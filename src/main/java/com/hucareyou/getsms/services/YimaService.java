package com.hucareyou.getsms.services;

import com.alibaba.fastjson.JSON;
import com.hucareyou.getsms.properties.YimaProperties;
import com.hucareyou.getsms.utils.NewHttpCilentUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.hucareyou.getsms.bean.constans.YIMA.*;

/**
 * @Description 调易码接口
 * @Author hukui
 * @Date 2018/09/21 下午2:51
 */
@Slf4j
@Service
public class YimaService {

    @Autowired
    private YimaProperties yimaProperties;

    /**
     * 获取指定项目的手机号
     * @param projectCode   项目编码
     * @return
     */
    public String getMobile(String projectCode){
        String mobile = null;
        Map<String,String> map = new HashMap<>();
        String token = yimaProperties.getToken();
        String url = yimaProperties.getUrl();
        map.put("action",GET_MOBILE);
        map.put("token",token);
        map.put("itemid",projectCode);
        String response = NewHttpCilentUtil.doGet(url, map);
        log.info("调用易码获取手机号码接口===>> 项目：{}，传参：{}，返回结果：{}",projectCode,JSON.toJSONString(map),response);
        if(StringUtils.isNotBlank(response)){
            String[] strings = response.split("\\|");
            if(StringUtils.equals(SUCCESS,strings[0])){
                mobile = strings[1];
                log.info("获取号码成功。");
            }else{
                log.info("获取号码失败。");
            }
        }
        return mobile;
    }


    /**
     * 释放对应项目的手机号
     * @param projectCode   项目编码
     * @param mobile    要释放的手机号码
     * @return
     */
    public String releaseMobile(String projectCode,String mobile){
        Map<String,String> map = new HashMap<>();
        String token = yimaProperties.getToken();
        String url = yimaProperties.getUrl();
        map.put("action",RELEASE_MOBILE);
        map.put("token",token);
        map.put("itemid",projectCode);
        map.put("mobile",mobile);
        String response = NewHttpCilentUtil.doGet(url, map);
        log.info("调用易码释放手机号码接口===>> 项目：{}，传参：{}，返回结果：{}",projectCode,JSON.toJSONString(map),response);
        return response;
    }


    /**
     * 获取短信
     * @param projectCode  项目编码
     * @param mobile    要获取短信的手机号码
     * @param releaseFlag   自动释放号码标识符 0：不释放；1：释放
     * @return
     */
    public String getsms(String projectCode,String mobile,String releaseFlag){
        if(StringUtils.isNotBlank(releaseFlag)){
            releaseFlag = "1";
        }
        Map<String,String> map = new HashMap<>();
        String token = yimaProperties.getToken();
        String url = yimaProperties.getUrl();
        map.put("action",GET_SMS);
        map.put("token",token);
        map.put("itemid",projectCode);
        map.put("mobile",mobile);
        map.put("release",releaseFlag);
        map.put("getsendno","1");
        String response = NewHttpCilentUtil.doGet(url, map);
        log.info("调用易码获取短信接口===>> 项目：{}，传参：{}，返回结果：{}",projectCode,JSON.toJSONString(map),response);
        return response;
    }

}
