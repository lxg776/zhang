package com.zheng.friend.rpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 服务启动类
 * Created by ZhangShuzheng on 2017/2/3.
 */
public class ZhengFriendAllServiceApplication {

	private static Logger _log = LoggerFactory.getLogger(ZhengFriendAllServiceApplication.class);

	public static void main(String[] args) {
		_log.info(">>>>> zheng-friends-all-service 正在启动 <<<<<");
		new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
		_log.info(">>>>> zheng-friends-all-service 启动完成 <<<<<");
	}

}