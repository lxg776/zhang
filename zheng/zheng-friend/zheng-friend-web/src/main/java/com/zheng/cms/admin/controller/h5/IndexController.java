package com.zheng.cms.admin.controller.h5;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.zheng.cms.admin.shiro.UpmsSessionDao;
import com.zheng.cms.admin.util.SmsUtil;
import com.zheng.cms.common.constant.FriendResult;
import com.zheng.cms.common.constant.FriendResultConstant;
import com.zheng.common.base.BaseController;
import com.zheng.common.util.MD5Util;
import com.zheng.common.util.PropertiesFileUtil;
import com.zheng.common.util.RedisUtil;
import com.zheng.friend.dao.model.*;
import com.zheng.friend.rpc.api.*;
import com.zheng.ucenter.dao.model.UcenterIdentificaion;
import com.zheng.ucenter.dao.model.UcenterIdentificaionExample;
import com.zheng.ucenter.dao.model.UcenterUser;
import com.zheng.ucenter.dao.model.UcenterUserExample;
import com.zheng.ucenter.rpc.api.UcenterIdentificaionService;
import com.zheng.ucenter.rpc.api.UcenterUserService;
import com.zheng.upms.client.shiro.session.UpmsSession;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import org.apache.commons.lang.math.RandomUtils;
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

import java.util.Date;
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

	@Autowired
	FUserSettingService fUserSettingService;

	@Autowired
	FSmsMessageService fSmsMessageService;

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
	 * 获取验证码
	 * @return
	 */
	@ApiOperation(value = "给其他人发送信息")
	@RequestMapping(value = "/gegSms", method = RequestMethod.POST)
	@ResponseBody
	public Object gegSms(FSmsMessage fSmsMessage) {

		String code = SmsUtil.randomCheckCode(4);
		fSmsMessage.setSmsCode(code);
		fSmsMessage.setAppid("friends");
		fSmsMessage.setOperation("register");

		FriendResult result =new FriendResult(FriendResultConstant.SUCCESS,null);
		result.setMessage("短信获取成功");
		try {
			int returnCode =SmsUtil.getSMS(fSmsMessage.getPhoneNo(),fSmsMessage.getSmsCode());
			if(returnCode==200){
				fSmsMessageService.insert(fSmsMessage);
			}else{
				result.setCode(FriendResultConstant.FAILED.code);
				result.setMessage("短信获取失败");
			}
		} catch (Exception e) {
			result.setCode(FriendResultConstant.FAILED.code);
			result.setMessage("短信获取失败");
			return result;
		}

		return result;
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

			//随机一个昵称
			FUserBaseMsg fUserBaseMsg = new FUserBaseMsg();
			fUserBaseMsg.setNikename(SmsUtil.randomCheckCode(7));
			fUserBaseMsg.setUserId(modle.getUserId());
			fUserBaseMsgService.insert(fUserBaseMsg);

			//设置显示选项
			FUserSetting fUserSetting =new FUserSetting();
			fUserSetting.setUserId(modle.getUserId());
			fUserSetting.setShowIndexPage((byte)0);
			fUserSetting.setShowBaseMsg((byte)0);
			fUserSetting.setShowFavorite((byte)0);
			fUserSetting.setShowFriendRequest((byte)0);
			fUserSetting.setShowLivingStatus((byte)0);
			fUserSetting.setMsgReadStatus((byte)0);
			fUserSetting.setMsgSendStatus((byte)0);
			fUserSetting.setHistoryviewStatus((byte)1);

			fUserSettingService.insert(fUserSetting);

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
	public Object checkUserName(String userName,String idCard,String code) {

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

		FSmsMessage fSmsMessage = new FSmsMessage();
		fSmsMessage.setPhoneNo(userName);
		fSmsMessage.setSmsCode(code);
		FSmsMessageExample example =new FSmsMessageExample();
		example.createCriteria().andPhoneNoEqualTo(fSmsMessage.getPhoneNo()).andAppidEqualTo("friends").andOperationEqualTo("register");
		example.setOrderByClause("create_time desc");
		FSmsMessage queryModle = fSmsMessageService.selectFirstByExample(example);
		if(queryModle==null||queryModle.getSmsCode().equals("")){
				result.setCode(FriendResultConstant.FAILED.code);
				result.setMessage("短信验证码不正确!");
				return result;
		}

		int  distance = (int) SmsUtil.differentDateByMillisecond(queryModle.getCreateTime(),new Date());

		if(!queryModle.getSmsCode().equals(fSmsMessage.getSmsCode())){
			result.setCode(FriendResultConstant.FAILED.code);
			result.setMessage("短信验证码不正确!");
			return result;
		}

		if(distance>1000*60*2){
			result.setCode(FriendResultConstant.FAILED.code);
			result.setMessage("短信验证码超过有效期，请重新获取！");
			return result;
		}

		return result;
	}










}