package com.zheng.cms.admin.Interceptor;

import com.zheng.cms.admin.util.TokenUtil;
import com.zheng.common.util.RedisUtil;
import com.zheng.common.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台过滤器
 * Created by ZhangShuzheng on 2017/01/12.
 */
public class WxInterceptor extends HandlerInterceptorAdapter {

	private static Logger _log = LoggerFactory.getLogger(WxInterceptor.class);


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


		String token = (String) request.getParameter("token");
	 	String userName = RedisUtil.get(TokenUtil.ZHENG_WX_CLIENT_SESSION_ID + "_" + token);
		if(com.github.pagehelper.util.StringUtil.isNotEmpty(userName)){
			request.setAttribute("userName",userName);
			return true;
		}else{
			String newsToken = (String) request.getAttribute("newsToken");
			if(com.github.pagehelper.util.StringUtil.isNotEmpty(newsToken)){
				userName = RedisUtil.get(TokenUtil.ZHENG_WX_CLIENT_SESSION_ID + "_" + newsToken);
				request.setAttribute("userName",userName);
				return true;
			}

		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		String token = (String) request.getAttribute("token");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		String token = (String) request.getAttribute("token");
	}

}
