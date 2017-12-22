package com.zheng.cms.admin.controller.h5;

import com.github.pagehelper.util.StringUtil;
import com.zheng.cms.common.constant.FriendResult;
import com.zheng.cms.common.constant.FriendResultConstant;
import com.zheng.common.base.BaseController;
import com.zheng.common.util.MD5Util;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
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


	/**
	 * 首页
	 * @return
	 */
	@ApiOperation(value = "后台首页")
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String reg(HttpServletRequest request, String userName, String password, String idCard, String idCardImgs, String realName, String msgCode, HttpSession session) {

		String remoteAddr="";

		if (request != null) {
			remoteAddr = request.getHeader("X-FORWARDED-FOR");
			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = request.getRemoteAddr();
			}
		}


		UcenterUser modle =new UcenterUser();
		modle.setSalt("friend");
		password =  MD5Util.MD5(modle.getSalt()+password);
		modle.setPassword(password);
		modle.setUserName(userName);
		modle.setCreateIp(remoteAddr);
		ucenterUserService.insert(modle);

		UcenterUserExample example = new UcenterUserExample();
		example.createCriteria().andUserNameEqualTo(userName);
		modle=ucenterUserService.selectFirstByExample(example);

		UcenterIdentificaion ucenterIdentificaion = new UcenterIdentificaion();
		ucenterIdentificaion.setUserId(modle.getUserId());
		ucenterIdentificaion.setCellphone(userName);
		ucenterIdentificaion.setIdcardImgs(idCardImgs);
		ucenterIdentificaion.setIdcardNo(idCard);
		ucenterIdentificaion.setRealName(realName);

		ucenterIdentificaionService.insert(ucenterIdentificaion);

		session.setAttribute("userId",modle.getUserId());


		return "redirect:txGrzl";
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


	/**
	 * 填写个人资料
	 * @return
	 */
	@ApiOperation(value = "填写个人资料")
	@RequestMapping(value = "/txGrzl", method = RequestMethod.GET)
	public String txGrzl(ModelMap modelMa,HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		FUserBaseMsg queryObject = fUserBaseMsgService.selectByPrimaryKey(userId);
		if(queryObject!=null){
			modelMa.put("modle",queryObject);
		}

		return "/content/h5/user/tx_grzl.jsp";
	}


	/**
	 * 填写个人资料
	 * @return
	 */
	@ApiOperation(value = "填写个人资料")
	@RequestMapping(value = "/txGrzl", method = RequestMethod.POST)
	public String txGrzl(FUserBaseMsg fUserBaseMsg,HttpSession session) {

		Integer userId = (Integer) session.getAttribute("userId");
		FUserBaseMsg queryObject = fUserBaseMsgService.selectByPrimaryKey(userId);
		if(queryObject!=null){
			fUserBaseMsg.setUserId(userId);
			fUserBaseMsgService.updateByPrimaryKey(fUserBaseMsg);
		}else{
			fUserBaseMsg.setUserId(userId);
			fUserBaseMsgService.insert(fUserBaseMsg);
		}

		return "redirect:txZobz";
	}


	/**
	 * 填写个人资料
	 * @return
	 */
	@ApiOperation(value = "填写个人资料")
	@RequestMapping(value = "/txZobz", method = RequestMethod.GET)
	public String txZobz(ModelMap modelMa,HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		FUserRequest queryObject = fUserRequestService.selectByPrimaryKey(userId);
		if(queryObject!=null){
			modelMa.put("modle",queryObject);
		}

		return "/content/h5/user/tx_zobz.jsp";
	}


	/**
	 * 择偶信息
	 * @return
	 */
	@ApiOperation(value = "择偶信息")
	@RequestMapping(value = "/txZobz", method = RequestMethod.POST)
	public String txZobz(FUserRequest modle,String age_min,String age_max,String height_min,String height_max,HttpSession session) {

		Integer userId = (Integer) session.getAttribute("userId");

		FUserRequest queryObject = fUserRequestService.selectByPrimaryKey(userId);
		queryObject.setAge(getAgeRang(age_min,age_max));
		queryObject.setHeight(getHeiRang(height_min,height_max));

		if(queryObject!=null){
			modle.setUserId(userId);
			fUserRequestService.updateByPrimaryKey(modle);
		}else{
			modle.setUserId(userId);
			fUserRequestService.insert(modle);
		}

		return "/content/h5/user/tx_zobz.jsp";
	}


	public String getAgeRang(String age_min,String age_max){
		if("不限".equals(age_min)&&"不限".equals(age_max)){
			return "不限";
		}else if("不限".equals(age_min)){
			return age_max+"以下";
		}else if("不限".equals(age_max)){
			return age_min+"以上";
		}else{
			return  age_min+"~"+age_max;
		}

	}

	public String getHeiRang(String height_min, String height_max){
		if(("不限".equals(height_min)|| StringUtil.isEmpty(height_min))&&("不限".equals(height_max)||StringUtil.isEmpty(height_max))){
			return "不限";
		}else if("不限".equals(height_min)|| StringUtil.isEmpty(height_min)){
			return height_max +"以下";
		}else if("不限".equals(height_max)||StringUtil.isEmpty(height_max)){
			return height_min +"以上";
		}else{
			return  height_min +"~"+ height_max;
		}

	}

	/**
	 * 个人生活
	 * @return
	 */
	@ApiOperation(value = "个人生活")
	@RequestMapping(value = "/txXqhh", method = RequestMethod.POST)
	public String txXqhh(FUserLivingStatus modle) {

		Integer userId  = (Integer) SecurityUtils.getSubject().getPrincipal();

		FUserLivingStatus queryObject = fUserLivingStatusService.selectByPrimaryKey(userId);
		if(queryObject!=null){
			modle.setUserId(userId);
			fUserLivingStatusService.updateByPrimaryKeySelective(modle);
		}else{
			modle.setUserId(userId);
			fUserLivingStatusService.insert(modle);
		}
		return "/content/h5/user/tx_xqhh.jsp";
	}




}