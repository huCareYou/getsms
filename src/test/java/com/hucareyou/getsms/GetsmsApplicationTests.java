package com.hucareyou.getsms;

import com.hucareyou.getsms.properties.YimaProperties;
import com.hucareyou.getsms.services.YimaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.hucareyou.getsms.bean.constans.YIMA.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class GetsmsApplicationTests {

	@Autowired
	private YimaService yimaService;

	@Autowired
	private YimaProperties yimaProperties;

	@Test
	public void getMobileTest() {
		String fmeiemiCode = yimaProperties.getFmeiemiCode();
		log.info("项目编码：{}",fmeiemiCode);
		String mobile = yimaService.getMobile(fmeiemiCode);
		log.info("获取的号码是：{}",mobile);
		if(StringUtils.isNotBlank(mobile)){
			log.info("开始释放号码：{}",mobile);
			String result = yimaService.releaseMobile(fmeiemiCode, mobile);
			if(StringUtils.equals(SUCCESS,result)){
				log.info("释放成功");
			}else{
				log.info("释放失败");
			}
		}
	}

	@Test
	public void getSMSTest() {
		String fmeiemiCode = yimaProperties.getFmeiemiCode();
		log.info("项目编码：{}",fmeiemiCode);
		String mobile = yimaService.getMobile(fmeiemiCode);
		log.info("获取手机号：{}",mobile);
		String respCode = null;
		String smsContent = null;
		//不成功一直调，每10秒调一次
		while (!StringUtils.equals(SUCCESS,respCode)){
			String response = yimaService.getsms(fmeiemiCode,mobile,"0");
			if(StringUtils.isNotBlank(response)){
				String[] strings = response.split("\\|");
				respCode = strings[0];
				if(StringUtils.equals(SUCCESS,respCode)){
					smsContent = strings[1];
					log.info("获取短信成功.");
					break;
				}else if (StringUtils.equals(GET_SMS_STARTING,respCode)){
					log.info("尚未收到短信,睡眠10秒后继续调用。");
					try {
						Thread.sleep(10*1000L);
					} catch (InterruptedException e) {
						log.info("进程睡眠异常",e);
					}
				}else if (StringUtils.equals(GET_SMS_WAITING,respCode)){
					log.info("等待发送短信,睡眠10秒后继续调用。");
					try {
						Thread.sleep(10*1000L);
					} catch (InterruptedException e) {
						log.info("进程睡眠异常",e);
					}
				}else if (StringUtils.equals(GET_SMS_SENDING,respCode)){
					log.info("正在发送短信,睡眠10秒后继续调用。");
					try {
						Thread.sleep(10*1000L);
					} catch (InterruptedException e) {
						log.info("进程睡眠异常",e);
					}
				}else if (StringUtils.equals(GET_SMS_SENDING,respCode)){
					log.info("短信发送失败,睡眠10秒后继续调用。");
					try {
						Thread.sleep(10*1000L);
					} catch (InterruptedException e) {
						log.info("进程睡眠异常",e);
					}
				}else{
					log.info("未知返回编码,睡眠10秒后继续调用。");
				}
			}else{
				log.info("接口未响应，再次调用。");
			}
		}
		log.info("获取到的短信内容为：{}",smsContent);
	}


}
