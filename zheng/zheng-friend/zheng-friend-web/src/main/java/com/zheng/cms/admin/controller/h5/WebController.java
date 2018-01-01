package com.zheng.cms.admin.controller.h5;

import com.github.pagehelper.util.StringUtil;
import com.zheng.cms.admin.shiro.UpmsSessionDao;
import com.zheng.cms.common.constant.FriendResult;
import com.zheng.cms.common.constant.FriendResultConstant;
import com.zheng.common.base.BaseController;
import com.zheng.friend.dao.model.FUserBaseMsg;
import com.zheng.friend.dao.model.FUserLivingStatus;
import com.zheng.friend.dao.model.FUserRequest;
import com.zheng.friend.dao.vo.FUserViewRecordVo;
import com.zheng.friend.dao.vo.FuserDetailVo;
import com.zheng.friend.dao.vo.RecentMsgVo;
import com.zheng.friend.rpc.api.*;
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

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * 后台controller
 * Created by ZhangShuzheng on 2017/01/12.
 */
@Controller
@RequestMapping("/u")
@Api(value = "后台控制器", description = "后台管理")

public class WebController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(WebController.class);
	private int pageSize=15;


	@Autowired
	FUserBaseMsgService fUserBaseMsgService;
	@Autowired
	UcenterUserService ucenterUserService;
	@Autowired
	UcenterIdentificaionService ucenterIdentificaionService;
	@Autowired
	FUserRequestService fUserRequestService;
	@Autowired
	FUserLivingStatusService fUserLivingStatusService;
	@Autowired
	UpmsSessionDao upmsSessionDao;

	@Autowired
	FMessageService fMessageService;
	@Autowired
	FUserViewRecordService fUserViewRecordService;

	/**
	 * 首页
	 * @return
	 */
	@ApiOperation(value = "后台首页")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(@RequestParam(defaultValue = "1") Integer pageNum,HttpSession session,ModelMap modelMap) {

		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		//个人详情
		UcenterUser ucenterUser = getUctenuser(username,session);
		FuserDetailVo myDetailVo  = fUserBaseMsgService.selectFUserDetailVoByUserId(ucenterUser.getUserId());
		//系统推荐人
		List<FuserDetailVo> recommendUserList = fUserBaseMsgService.selectRecommendUsers(myDetailVo,(pageNum-1)*pageSize,pageSize);
		modelMap.put("recommendUserList",recommendUserList);
		modelMap.put("pageSize",pageSize);
		modelMap.put("modle",myDetailVo);
		//最新消息
		List<RecentMsgVo> msgList = fMessageService.selectRecentMsgByUser(ucenterUser.getUserId());
		modelMap.put("msgList",msgList);
		//访问记录
		List<FUserViewRecordVo> viewRecordList = fUserBaseMsgService.selectViewRecordUsers(ucenterUser.getUserId());
		modelMap.put("viewRecordList",viewRecordList);

		return "/content/h5/main.jsp";
	}





	@ApiOperation(value = "服务器校验")
	@RequestMapping(value = "/loadRecommendUserList", method = RequestMethod.GET)
	@ResponseBody
	public Object loadRecommendUserList(@RequestParam(defaultValue = "1") Integer pageNum,HttpSession session,ModelMap modelMap) {

		FriendResult result  = new FriendResult(FriendResultConstant.SUCCESS,null);
		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		//个人详情
		UcenterUser ucenterUser = getUctenuser(username,session);
		FuserDetailVo myDetailVo  = new FuserDetailVo();
		myDetailVo.setSex(ucenterUser.getSex());
		myDetailVo.setUserId(ucenterUser.getUserId());
				//系统推荐人
		List<FuserDetailVo> recommendUserList = fUserBaseMsgService.selectRecommendUsers(myDetailVo,(pageNum-1)*pageSize,pageSize);
		HashMap<String,Object> map = new HashMap<>();
		map.put("dataList",recommendUserList);
		map.put("pageNum",pageNum);
		result.setData(map);
		return result;
	}





	/**
	 * 填写个人资料
	 * @return
	 */
	@ApiOperation(value = "填写个人资料")
	@RequestMapping(value = "/txGrzl", method = RequestMethod.GET)
	public String txGrzl(ModelMap modelMa,HttpSession session) {

		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();
		FUserBaseMsg queryObject = fUserBaseMsgService.selectByPrimaryKey(userId);
		if(queryObject!=null){
			modelMa.put("modle",queryObject);
		}

		return "/content/h5/user/tx_grzl.jsp";
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
	 * 填写个人资料
	 * @return
	 */
	@ApiOperation(value = "填写个人资料")
	@RequestMapping(value = "/txGrzl", method = RequestMethod.POST)
	public String txGrzl(FUserBaseMsg fUserBaseMsg,HttpSession session) {

		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();
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
	 * 填写择偶条件
	 * @return
	 */
	@ApiOperation(value = "填写择偶条件")
	@RequestMapping(value = "/txZobz", method = RequestMethod.GET)
	public String txZobz(ModelMap modelMa,HttpSession session) {
		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();
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

		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();
		FUserRequest queryObject = fUserRequestService.selectByPrimaryKey(userId);


		modle.setAge(getAgeRang(age_min,age_max));
		modle.setHeight(getHeiRang(height_min,height_max));

		if(queryObject!=null){
			modle.setUserId(userId);
			fUserRequestService.updateByPrimaryKey(modle);
		}else{
			modle.setUserId(userId);
			fUserRequestService.insert(modle);
		}

		return "redirect:txShzk";
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
	 * 填写个人资料
	 * @return
	 */
	@ApiOperation(value = "填写个人生活")
	@RequestMapping(value = "/txShzk", method = RequestMethod.GET)
	public String txShzk(ModelMap modelMa,HttpSession session) {
		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();
		FUserLivingStatus queryObject = fUserLivingStatusService.selectByPrimaryKey(userId);
		if(queryObject!=null){
			modelMa.put("modle",queryObject);
		}

		return "/content/h5/user/tx_shzk.jsp";
	}





	/**
	 * 个人生活
	 * @return
	 */
	@ApiOperation(value = "个人生活")
	@RequestMapping(value = "/txShzk", method = RequestMethod.POST)
	public String txShzk(FUserLivingStatus modle,HttpSession session) {

		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();
		FUserLivingStatus queryObject = fUserLivingStatusService.selectByPrimaryKey(userId);
		if(queryObject!=null){
			modle.setUserId(userId);
			fUserLivingStatusService.updateByPrimaryKeySelective(modle);
		}else{
			modle.setUserId(userId);
			fUserLivingStatusService.insert(modle);
		}
		return "redirect:txXqhh";
	}


	/**
	 * 填写兴趣爱好
	 * @return
	 */
	@ApiOperation(value = "填写兴趣爱好")
	@RequestMapping(value = "/txXqhh", method = RequestMethod.GET)
	public String txXqhh(ModelMap modelMa,HttpSession session) {
		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();
		FUserLivingStatus queryObject = fUserLivingStatusService.selectByPrimaryKey(userId);
		if(queryObject!=null){
			modelMa.put("modle",queryObject);
		}

		return "/content/h5/user/tx_xqhh.jsp";
	}


	/**
	 * 提交兴趣爱好
	 * @return
	 */
	@ApiOperation(value = "兴趣爱好")
	@RequestMapping(value = "/txXqhh", method = RequestMethod.POST)
	public String txXqhh(FUserLivingStatus modle,HttpSession session) {

		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();
		FUserLivingStatus queryObject = fUserLivingStatusService.selectByPrimaryKey(userId);
		if(queryObject!=null){
			modle.setUserId(userId);
			fUserLivingStatusService.updateByPrimaryKeySelective(modle);
		}else{
			modle.setUserId(userId);
			fUserLivingStatusService.insert(modle);
		}
		return "redirect:/u/index";
	}



	/**
	 * 填写个人资料
	 * @return
	 */
	@ApiOperation(value = "编辑个人资料")
	@RequestMapping(value = "/editGrzl", method = RequestMethod.GET)
	public String editGrzl(ModelMap modelMa,HttpSession session) {

		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();
		FUserBaseMsg queryObject = fUserBaseMsgService.selectByPrimaryKey(userId);
		if(queryObject!=null){
			modelMa.put("modle",queryObject);
		}
		modelMa.put("user",ucenterUser);
		return "/content/h5/user/edit_grzl.jsp";
	}


	/**
	 * 填写个人资料
	 * @return
	 */
	@ApiOperation(value = "填写个人资料")
	@RequestMapping(value = "/editGrzl", method = RequestMethod.POST)
	public String editGrzl(FUserBaseMsg fUserBaseMsg,String avatar,HttpSession session){

		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();

		if(StringUtil.isNotEmpty(avatar)){
			UcenterUser updateUcentUser = new UcenterUser();
			updateUcentUser.setUserId(ucenterUser.getUserId());
			ucenterUser.setAvatar(avatar);
			ucenterUserService.updateByPrimaryKeySelective(updateUcentUser);
		}

		FUserBaseMsg queryObject = fUserBaseMsgService.selectByPrimaryKey(userId);
		if(queryObject!=null){
			fUserBaseMsg.setUserId(userId);
			fUserBaseMsgService.updateByPrimaryKey(fUserBaseMsg);
		}else{
			fUserBaseMsg.setUserId(userId);
			fUserBaseMsgService.insert(fUserBaseMsg);
		}

		return "redirect:/u/index";
	}


}