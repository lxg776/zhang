package com.zheng.cms.admin.controller.h5;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.zheng.cms.common.constant.FriendResult;
import com.zheng.cms.common.constant.FriendResultConstant;
import com.zheng.common.base.BaseController;
import com.zheng.common.util.MD5Util;
import com.zheng.common.validator.LengthValidator;
import com.zheng.ucenter.dao.model.UcenterIdentificaion;
import com.zheng.ucenter.dao.model.UcenterIdentificaionExample;
import com.zheng.ucenter.dao.model.UcenterUser;
import com.zheng.ucenter.dao.model.UcenterUserExample;
import com.zheng.ucenter.rpc.api.UcenterIdentificaionService;
import com.zheng.ucenter.rpc.api.UcenterUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.Ref;

import javax.servlet.http.HttpServletRequest;

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
	public String reg(HttpServletRequest request, String userName, String password, String idCard, String idCardImgs, String realName, String msgCode) {

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

		UcenterIdentificaion ucenterIdentificaion = new UcenterIdentificaion();
		ucenterIdentificaion.setUserId(modle.getUserId());
		ucenterIdentificaion.setCellphone(userName);
		ucenterIdentificaion.setIdcardImgs(idCardImgs);
		ucenterIdentificaion.setIdcardNo(idCard);
		ucenterIdentificaion.setRealName(realName);

		ucenterIdentificaionService.insert(ucenterIdentificaion);

		return "/content/h5/user/tx_grzl.jsp";
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