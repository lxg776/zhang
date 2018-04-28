package com.zheng.cpw.controller.app;

import com.zheng.cms.common.constant.CpwResult;
import com.zheng.cms.common.constant.CpwResultConstant;
import com.zheng.common.base.BaseController;
import com.zheng.cpw.dao.model.*;
import com.zheng.cpw.rpc.api.CpwSystemService;
import com.zheng.cpw.rpc.api.CpwUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 后台controller
 * Created by ZhangShuzheng on 2017/01/12.
 */
@Controller
@RequestMapping("/cpw")
@Api(value = "后台控制器", description = "后台管理")

public class CpwController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(CpwController.class);
	private int pageSize=15;

	@Autowired
	CpwUserService ucenterUserService;
	@Autowired
	CpwSystemService cpwSystemServicel;

	/**
	 * 首页
	 * @return
	 */
	@ApiOperation(value = "后台首页")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public Object login(@RequestParam(defaultValue = "") String userName,@RequestParam(defaultValue = "") String password,@RequestParam(defaultValue = "") String sysKey,ModelMap modelMap) {



		CpwResult result =new CpwResult(CpwResultConstant.SUCCESS,null);
		CpwUserExample cpwUserExample =new CpwUserExample();
		cpwUserExample.createCriteria().andUserNameEqualTo(userName).andSysKeyEqualTo(sysKey);
		CpwUser  user = ucenterUserService.selectFirstByExample(cpwUserExample);

		if(user!=null){
			if(user.getPassword().equals(password)){
				result.setMessage("登录成功!");
				user.setPassword("");
				result.setData(user);
			}else{
				result.setMessage("密码错误!");
				result.setCode(CpwResultConstant.FAILED.code);
			}
		}else{
			result.setMessage("用户不存在!");
			result.setCode(CpwResultConstant.FAILED.code);
		}
		return result;
	}





	/**
	 * 首页
	 * @return
	 */
	@ApiOperation(value = "后台首页")
	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	@ResponseBody
	public Object reg(@RequestParam(defaultValue = "") String userName,@RequestParam(defaultValue = "") String password,@RequestParam(defaultValue = "") String sysKey,ModelMap modelMap) {


		CpwUserExample cpwUserExample =new CpwUserExample();
		cpwUserExample.createCriteria().andUserNameEqualTo(userName).andSysKeyEqualTo(sysKey);
		CpwUser  queryUser = ucenterUserService.selectFirstByExample(cpwUserExample);

		CpwResult result =new CpwResult(CpwResultConstant.SUCCESS,null);

		if(queryUser!=null){
			result.setMessage("用户已经存在!");
			result.setCode(CpwResultConstant.FAILED.code);
			return  result;
		}


		CpwUser  user = new CpwUser();
		user.setPassword(password);
		user.setUserName(userName);
		user.setSysKey(sysKey);
		ucenterUserService.insert(user);

		user.setPassword("");
		result.setData(user);
		result.setMessage("注册成功！");


		return result;
	}



	/**
	 * 首页
	 * @return
	 */
	@ApiOperation(value = "后台首页")
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	@ResponseBody
	public Object changePassword(@RequestParam(defaultValue = "") String userName,@RequestParam(defaultValue = "") String password,@RequestParam(defaultValue = "") String sysKey,ModelMap modelMap) {


		CpwUserExample cpwUserExample =new CpwUserExample();
		cpwUserExample.createCriteria().andUserNameEqualTo(userName).andSysKeyEqualTo(sysKey);
		CpwUser  queryUser = ucenterUserService.selectFirstByExample(cpwUserExample);

		CpwResult result =new CpwResult(CpwResultConstant.SUCCESS,null);

		if(queryUser==null){
			result.setMessage("用户不存在!");
			result.setCode(CpwResultConstant.FAILED.code);
			return  result;
		}


		queryUser.setPassword(password);
		ucenterUserService.updateByPrimaryKey(queryUser);
		result.setMessage("密码修改成功！");
		return result;
	}


	/**
	 * 首页
	 * @return
	 */
	@ApiOperation(value = "后台首页")
	@RequestMapping(value = "/getAppByKey", method = RequestMethod.GET)
	@ResponseBody
	public Object getAppByKey(@RequestParam(defaultValue = "") String sysKey,ModelMap modelMap) {


		CpwSystemExample cpwSystemExample =new CpwSystemExample();
		cpwSystemExample.createCriteria().andSysKeyEqualTo(sysKey);
		CpwSystem  queryUser = cpwSystemServicel.selectFirstByExample(cpwSystemExample);

		CpwResult result =new CpwResult(CpwResultConstant.SUCCESS,null);

		if(queryUser==null){
			result.setMessage("查询不到数据!");
			result.setCode(CpwResultConstant.FAILED.code);

		}else{
			result.setData(queryUser);
			result.setMessage("获取成功！");
		}



		return result;
	}








	/**
	 * 后台首页
	 * @return
	 */
	@ApiOperation(value = "后台首页")
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public String userlist(@RequestParam(defaultValue = "1") Integer pageNum,ModelMap modelMap) {


		CpwUserExample fActivityExample = new CpwUserExample();
		fActivityExample.createCriteria();
		//fActivityExample.setOrderByClause("desc ctime");

		List<CpwUser> rows = ucenterUserService.selectByExampleForOffsetPage(fActivityExample, pageSize*(pageNum-1), pageSize);
		long total = ucenterUserService.countByExample(fActivityExample);
		modelMap.put("page", PageOnterModle.getInstence(pageNum,total,pageSize,rows));
		return "/content/manage/list_user.jsp";
	}



	@ApiOperation(value = "用户编辑")
	@RequestMapping(value = "/userEdit", method = RequestMethod.POST)
	public String edit(@RequestParam(defaultValue = "0") String keyword, CpwUser modle){


		if("del".equals(keyword)){
			if(modle.getUserId()>0){
				ucenterUserService.deleteByPrimaryKey(modle.getUserId());
			}
		}else if("update".equals(keyword)){
			ucenterUserService.updateByPrimaryKeySelective(modle);
		}else{
			ucenterUserService.insert(modle);
		}
		return "redirect:userlist";
	}

	@ApiOperation(value = "用户编辑")
	@RequestMapping(value = "/userEdit", method = RequestMethod.GET)
	public String edit(@RequestParam(defaultValue = "0") Integer id,ModelMap modelMap){

		if(id>0){
			CpwUser modle = ucenterUserService.selectByPrimaryKey(id);
			modelMap.put("modle",modle);
			modelMap.put("keyword","update");
		}else{
			modelMap.put("keyword","create");
		}


		return "/content/manage/add_user.jsp";
	}




	/**
	 * 后台首页
	 * @return
	 */
	@ApiOperation(value = "后台首页")
	@RequestMapping(value = "/applist", method = RequestMethod.GET)
	public String applist(@RequestParam(defaultValue = "1") Integer pageNum,ModelMap modelMap) {


		CpwSystemExample fActivityExample = new CpwSystemExample();
		fActivityExample.createCriteria();
		//fActivityExample.setOrderByClause("desc ctime");

		List<CpwSystem> rows = cpwSystemServicel.selectByExampleForOffsetPage(fActivityExample, pageSize*(pageNum-1), pageSize);
		long total = cpwSystemServicel.countByExample(fActivityExample);
		modelMap.put("page", PageOnterModle.getInstence(pageNum,total,pageSize,rows));
		return "/content/manage/list_app.jsp";
	}



	@ApiOperation(value = "用户编辑")
	@RequestMapping(value = "/appEdit", method = RequestMethod.POST)
	public String appEdit(@RequestParam(defaultValue = "0") String keyword, CpwSystem modle){


		if("del".equals(keyword)){
			if(modle.getId()>0){
				cpwSystemServicel.deleteByPrimaryKey(modle.getId());
			}
		}else if("update".equals(keyword)){
			cpwSystemServicel.updateByPrimaryKeySelective(modle);
		}else{
			cpwSystemServicel.insert(modle);
		}
		return "redirect:applist";
	}

	@ApiOperation(value = "用户编辑")
	@RequestMapping(value = "/appEdit", method = RequestMethod.GET)
	public String appEdit(@RequestParam(defaultValue = "0") Integer id,ModelMap modelMap){

		if(id>0){
			CpwSystem modle = cpwSystemServicel.selectByPrimaryKey(id);
			modelMap.put("modle",modle);
			modelMap.put("keyword","update");
		}else{
			modelMap.put("keyword","create");
		}


		return "/content/manage/add_app.jsp";
	}



}