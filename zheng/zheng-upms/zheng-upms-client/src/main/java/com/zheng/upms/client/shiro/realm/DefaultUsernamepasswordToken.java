package com.zheng.upms.client.shiro.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

public class DefaultUsernamepasswordToken extends UsernamePasswordToken {

	/**
	 * 判断登录类型
	 */
	private String loginType;

	public String getLoginType() {
		return this.loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	/**
	 * Shiro 构造方法
	 * 
	 * @author : tanzhen
	 * @date ：2016年7月28日
	 */
	public DefaultUsernamepasswordToken(String username, String password) {
		super(username, password);
	}

	public DefaultUsernamepasswordToken() {

	}
}