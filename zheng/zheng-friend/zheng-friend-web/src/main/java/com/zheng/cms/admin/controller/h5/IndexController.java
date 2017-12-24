package com.zheng.cms.admin.controller.h5;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.zheng.cms.admin.shiro.UpmsSessionDao;
import com.zheng.cms.common.constant.FriendResult;
import com.zheng.cms.common.constant.FriendResultConstant;
import com.zheng.common.base.BaseController;
import com.zheng.common.util.MD5Util;
import com.zheng.common.util.PropertiesFileUtil;
import com.zheng.common.util.RedisUtil;
import com.zheng.friend.dao.model.FUserBaseMsg;
import com.zheng.friend.dao.model.FUserLivingStatus;
import com.zheng.friend.dao.model.FUserRequest;
import com.zheng.friend.rpc.api.FUserBaseMsgService;
import com.zheng.friend.rpc.api.FUserLivingStatusService;
import com.zheng.friend.rpc.api.FUserRequestService;
import com.zheng.ucenter.dao.model.UcenterIdentificaion;
import com.zheng.ucenter.dao.model.UcenterIdentificaionExample;
import com.zheng.ucenter.dao.model.UcenterUser;
import com.zheng.ucenter.dao.model.UcenterUserExample;
import com.zheng.ucenter.rpc.api.UcenterIdentificaionService;
import com.zheng.ucenter.rpc.api.UcenterUserService;
import com.zheng.upms.client.shiro.session.UpmsSession;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import org.apache.shiro.SecurityUtils;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.UUID;

/**
 * 后台controller
 * Created by ZhangShuzheng on 2017/01/12.
 */
@Controller
@RequestMapping("/h5")
@Api(value = "后台控制器", description = "后台管理")

public class IndexController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(IndexController.class);
	private int pageSize=15;

	// 全局会话key
	private final static String ZHENG_UPMS_SERVER_SESSION_ID = "zheng-ucenter-server-session-id";
	// 全局会话key列表
	private final static String ZHENG_UPMS_SERVER_SESSION_IDS = "zheng-ucenter-server-session-ids";
	// code key
	private final static String ZHENG_UPMS_SERVER_CODE = "zheng-ucenter-server-code";


	@Autowired
	UcenterUserService ucenterUserService;
	@Autowired
	UcenterIdentificaionService ucenterIdentificaionService;
	@Autowired
	FUserBaseMsgService fUserBaseMsgService;
	@Autowired
	FUserRequestService fUserRequestService;
	@Autowired
	FUserLivingStatusService fUserLivingStatusService;
	@Autowired
	UpmsSessionDao upmsSessionDao;

	/**
	 * 首页
	 * @return
	 */
	@ApiOperation(value = "后台首页")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(@RequestParam(defaultValue = "1") Integer pageNum,ModelMap modelMap) {


		return "/content/h5/first.jsp";
	}


	/**
	 * 首页
	 * @return
	 */
	@ApiOperation(value = "后台首页")
	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public String reg(ModelMap modelMap) {


		return "/content/h5/user/regiter.jsp";
	}

	private UcenterUser getUctenuser(String userName,HttpSession session){

		UcenterUser ucenterUser = (UcenterUser) session.getAttribute(userName);
		if(ucenterUser==null){
			ucenterUser	= ucenterUserService.selectUpmsUserByUsername(userName);
			ucenterUser.setPassword("");
		}
		session.setAttribute(userName,ucenterUser);
		return ucenterUser;
	}


	/**
	 * 首页
	 * @return
	 */
	@ApiOperation(value = "后台首页")
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String reg(HttpServletRequest request, Byte sex,String userName, String password, String idCard, String idCardImgs, String realName, String msgCode, HttpSession session) {

		UcenterUser ucenterUser =null;

		if(null!=SecurityUtils.getSubject().getPrincipal()){
			String  username = (String)SecurityUtils.getSubject().getPrincipal();
			ucenterUser= getUctenuser(username,session);
		}





		String remoteAddr="";

		if (request != null) {
			remoteAddr = request.getHeader("X-FORWARDED-FOR");
			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = request.getRemoteAddr();
			}
		}

		UcenterUser modle =new UcenterUser();
		modle.setSalt("friend");

		String md5Password =  MD5Util.MD5(modle.getSalt()+password);
		modle.setPassword(md5Password);
		modle.setUserName(userName);
		modle.setCreateIp(remoteAddr);
		modle.setSex(sex);

		if(null!=ucenterUser){
			modle.setUserId(ucenterUser.getUserId());
			ucenterUserService.updateByPrimaryKey(modle);
		}else{
			ucenterUserService.insert(modle);
		}

		UcenterUserExample example = new UcenterUserExample();
		example.createCriteria().andUserNameEqualTo(userName);
		modle=ucenterUserService.selectFirstByExample(example);

		String upms_code="";
		//登录
		if(ucenterUser==null){
			upms_code = login(userName);
		}


		UcenterIdentificaion ucenterIdentificaion = new UcenterIdentificaion();
		ucenterIdentificaion.setUserId(modle.getUserId());
		ucenterIdentificaion.setCellphone(userName);
		ucenterIdentificaion.setIdcardImgs(idCardImgs);
		ucenterIdentificaion.setIdcardNo(idCard);
		ucenterIdentificaion.setRealName(realName);


		if(null!=ucenterUser){
			ucenterIdentificaionService.updateByPrimaryKey(ucenterIdentificaion);
			return "redirect:/u/txGrzl";
		}else{
			ucenterIdentificaionService.insert(ucenterIdentificaion);
			return "redirect:/u/txGrzl?upms_code="+upms_code+"&upms_username="+userName;
		}
	}


	private String login(String username){
		//后台登录
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String sessionId = session.getId().toString();

		// 全局会话sessionId列表，供会话管理
		RedisUtil.lpush(ZHENG_UPMS_SERVER_SESSION_IDS, sessionId.toString());
		// 默认验证帐号密码正确，创建code
		String code = UUID.randomUUID().toString();
		// 全局会话的code
		RedisUtil.set(ZHENG_UPMS_SERVER_SESSION_ID + "_" + sessionId, code, (int) subject.getSession().getTimeout() / 1000);
		// code校验值
		RedisUtil.set(ZHENG_UPMS_SERVER_CODE + "_" + code, code, (int) subject.getSession().getTimeout() / 1000);

		return  code;
	}





	@ApiOperation(value = "服务器校验")
	@RequestMapping(value = "/checkUserName", method = RequestMethod.POST)
	@ResponseBody
	public Object checkUserName(String userName,String idCard) {

		FriendResult result  = new FriendResult(FriendResultConstant.SUCCESS,null);
		UcenterUserExample ucExample  =  new UcenterUserExample();
		ucExample.createCriteria().andUserNameEqualTo(userName);
		int ucCount = ucenterUserService.countByExample(ucExample);

		if(ucCount>0){
			result.setCode(FriendResultConstant.FAILED.code);
			result.setMessage("该手机号码已经被注册过了");
			return result;

		}


		UcenterIdentificaionExample idCardExample = new UcenterIdentificaionExample();
		idCardExample.createCriteria().andIdcardNoEqualTo(idCard);
		int idCount = ucenterIdentificaionService.countByExample(idCardExample);

		if(idCount>0){
			result.setCode(FriendResultConstant.FAILED.code);
			result.setMessage("身份证已经被使用过了");
			return result;

		}



		return result;
	}










}