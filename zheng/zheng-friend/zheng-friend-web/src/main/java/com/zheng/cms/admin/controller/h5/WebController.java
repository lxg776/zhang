package com.zheng.cms.admin.controller.h5;

import com.github.pagehelper.util.StringUtil;
import com.zheng.cms.admin.shiro.UpmsSessionDao;
import com.zheng.cms.common.constant.FriendResult;
import com.zheng.cms.common.constant.FriendResultConstant;
import com.zheng.common.base.BaseController;
import com.zheng.common.util.PropertiesFileUtil;
import com.zheng.friend.dao.model.*;
import com.zheng.friend.dao.vo.FUserViewRecordVo;
import com.zheng.friend.dao.vo.FuserDetailVo;
import com.zheng.friend.dao.vo.RecentMsgVo;
import com.zheng.friend.rpc.api.*;
import com.zheng.ucenter.dao.model.UcenterUser;
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
import java.util.Date;
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


	public final static String imageBase = "http://jxwbb.oss-cn-zhangjiakou.aliyuncs.com/";

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

	@Autowired
	FUserImagesService fUserImagesService;
	@Autowired
	FMemberTypeService fMemberTypeService;

	@Autowired
	FUserSettingService fUserSettingService;


	@Autowired
	FContactService fContactService;

    @Autowired
    FActivityService fActivityService;

	@Autowired
	FGreetingTempService fGreetingTempService;

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
		//个人相册
		FUserImagesExample example = new FUserImagesExample();
		example.createCriteria().andUserIdEqualTo(ucenterUser.getUserId()).andKeywordEqualTo("photo");
		example.setOrderByClause("create_time desc");
		List<FUserImages> userImages = fUserImagesService.selectByExample(example);
		modelMap.put("userImages",userImages);
		modelMap.put("imageBase",imageBase);

		//活动列表
		FActivityExample fActivityExample = new FActivityExample();
		fActivityExample.createCriteria().andShowStatusEqualTo("show");
		fActivityExample.setOrderByClause("ctime desc");
		List<FActivity> fActivityList  = fActivityService.selectByExampleForOffsetPage(fActivityExample,0,pageSize);
		modelMap.put("fActivityList",fActivityList);


		//查询会员的类型
		FMemberTypeExample fMemberTypeExample = new FMemberTypeExample();
		fMemberTypeExample.createCriteria().andShowStatusEqualTo((byte)1);
		fMemberTypeExample.setOrderByClause("level desc");
		List<FMemberType> typeList = fMemberTypeService.selectByExample(fMemberTypeExample);
		modelMap.put("typeList",typeList);

		//用户的权限
		FUserSetting fUserSetting = fUserSettingService.selectByPrimaryKey(ucenterUser.getUserId());
		modelMap.put("fUserSetting",fUserSetting);

		//问候语
		FGreetingTempExample fGreetingTempExample =new FGreetingTempExample();
		fGreetingTempExample.createCriteria().andShowStatusEqualTo((byte)1);
		fGreetingTempExample.setOrderByClause("sort desc");
		List<FGreetingTemp> greetingTempList  = fGreetingTempService.selectByExample(fGreetingTempExample);
		modelMap.put("greetingTempList",greetingTempList);

		//未读记录数
		long unReadCount = fMessageService.selectunReadCountByUserId(ucenterUser.getUserId(),(byte)0);
		modelMap.put("unReadCount",unReadCount);

		return "/content/h5/main.jsp";


	}

	/**
	 * 后台首页
	 * @return
	 */
	@ApiOperation(value = "后台首页")
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(){

		StringBuffer sso_server_url = new StringBuffer(PropertiesFileUtil.getInstance("zheng-upms-client").get("zheng.upms.sso.server.url"));
		sso_server_url.append("/sso/logout");

		return "redirect:"+sso_server_url.toString();
	}

	/**
	 * 首页
	 * @return
	 */
	@ApiOperation(value = "用户详情页面")
	@RequestMapping(value = "/userDetail", method = RequestMethod.GET)
	public String userDetail(@RequestParam(defaultValue = "1") Integer uid,HttpSession session,ModelMap modelMap) {
		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		//个人详情
		UcenterUser ucenterUser = getUctenuser(username,session);
		FuserDetailVo userDetail  = fUserBaseMsgService.selectFUserDetailVoByUserId(uid);
		modelMap.put("modle",userDetail);


		//个人相册
		FUserImagesExample example = new FUserImagesExample();
		example.createCriteria().andUserIdEqualTo(userDetail.getUserId()).andKeywordEqualTo("photo");
		example.setOrderByClause("create_time desc");
		List<FUserImages> userImages = fUserImagesService.selectByExample(example);
		modelMap.put("userImages",userImages);
		modelMap.put("imageBase",imageBase);

		//访问记录加1
		FUserViewRecord viewRecord =new FUserViewRecord();
		viewRecord.setfUserId(ucenterUser.getUserId());
		viewRecord.setbUserId(userDetail.getUserId());
		fUserViewRecordService.insert(viewRecord);


		//问候语
		FGreetingTempExample fGreetingTempExample =new FGreetingTempExample();
		fGreetingTempExample.createCriteria().andShowStatusEqualTo((byte)1);
		fGreetingTempExample.setOrderByClause("sort desc");
		List<FGreetingTemp> greetingTempList  = fGreetingTempService.selectByExample(fGreetingTempExample);
		modelMap.put("greetingTempList",greetingTempList);


		return "/content/h5/user/user_detail.jsp";
	}

	@ApiOperation(value = "更多用户推荐")
	@RequestMapping(value = "/loadActivityList", method = RequestMethod.GET)
	@ResponseBody
	public Object loadActivityList(@RequestParam(defaultValue = "1") Integer pageNum,HttpSession session,ModelMap modelMap) {

		FriendResult result  = new FriendResult(FriendResultConstant.SUCCESS,null);
		//系统推荐人
		//活动列表
		FActivityExample fActivityExample = new FActivityExample();
		fActivityExample.createCriteria().andShowStatusEqualTo("show");
		fActivityExample.setOrderByClause("ctime desc");
		List<FActivity> fActivityList  = fActivityService.selectByExampleForOffsetPage(fActivityExample,(pageNum-1)*pageSize,pageSize);
		HashMap<String,Object> map = new HashMap<>();
		map.put("dataList",fActivityList);
		map.put("pageNum",pageNum);
		result.setData(map);
		return result;
	}


	@ApiOperation(value = "更多用户推荐")
	@RequestMapping(value = "/activityDetail", method = RequestMethod.GET)
	public String activityDetail(@RequestParam(defaultValue = "0") Integer activityId,HttpSession session,ModelMap modelMap) {

		//活动详情
		FActivity fActivity = fActivityService.selectByPrimaryKey(activityId);
		modelMap.put("modle",fActivity);
		return "/content/h5/user/detail_activity.jsp";
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
		map.put("imageBase",imageBase);
		result.setData(map);
		return result;
	}

	@ApiOperation(value = "红娘帮我联系她")
	@RequestMapping(value = "/helpContact", method = RequestMethod.GET)
	@ResponseBody
	public Object helpContact(@RequestParam(defaultValue = "0") Integer tUserId,HttpSession session,ModelMap modelMap) {

		FriendResult result  = new FriendResult(FriendResultConstant.SUCCESS,null);
		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		if(tUserId==0){
			result.setMessage("委托错误！");
			return  result;
		}


		//个人详情
		UcenterUser ucenterUser = getUctenuser(username,session);
		FContact fContact;
		FContactExample example =new FContactExample();
		Integer fuserid = ucenterUser.getUserId();
		example.createCriteria().andFUserIdEqualTo(fuserid).andTUserIdEqualTo(tUserId);
		fContact = fContactService.selectFirstByExample(example);
		if(fContact==null){
			example  = new FContactExample();
			example.createCriteria().andFUserIdEqualTo(tUserId).andTUserIdEqualTo(fuserid);
			fContact = fContactService.selectFirstByExample(example);
			if(fContact!=null){
				fContact.setBothStatus((byte)1);
			}
		}
		if(fContact==null){
			fContact =new FContact();
			fContact.setfUserId(fuserid);
			fContact.settUserId(tUserId);
			fContact.setContactCount(1);
			fContactService.insert(fContact);
		}else{
			fContact.setContactCount(fContact.getContactCount()+1);
			fContactService.updateByPrimaryKey(fContact);
		}

		result.setMessage("已经委托红娘帮您联系！");
		return result;
	}





	/**
	 * 填写个人资料
	 * @return
	 */
	@ApiOperation(value = "填写个人资料")
	@RequestMapping(value = "/txGrzl", method = RequestMethod.GET)
	public String txGrzl(ModelMap modelMap,HttpSession session) {

		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();
		FUserBaseMsg queryObject = fUserBaseMsgService.selectByPrimaryKey(userId);
		if(queryObject!=null){
			modelMap.put("modle",queryObject);
		}
		ucenterUser = ucenterUserService.selectByPrimaryKey(ucenterUser.getUserId());
		modelMap.put("user",ucenterUser);
		modelMap.put("imageBase",imageBase);


		FUserImagesExample example = new FUserImagesExample();
		example.createCriteria().andUserIdEqualTo(ucenterUser.getUserId()).andKeywordEqualTo("photo");
		example.setOrderByClause("create_time desc");
		List<FUserImages> userImages = fUserImagesService.selectByExample(example);
		modelMap.put("userImages",userImages);
		modelMap.put("modle",queryObject);


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
	public String txGrzl(FUserBaseMsg fUserBaseMsg,String avatar,String deletePhoto, String addPhoto,HttpSession session) {

		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();
		//删除相册图片
		if(StringUtil.isNotEmpty(deletePhoto)){
			String pathes[] = deletePhoto.split(",");
			if(pathes!=null){
				for(int i=0;i<pathes.length;i++){
					String itemString = pathes[i];
					FUserImagesExample example = new FUserImagesExample();
					example.createCriteria().andUserIdEqualTo(ucenterUser.getUserId()).andImagePathEqualTo(itemString).andKeywordEqualTo("photo");
					fUserImagesService.deleteByExample(example);
				}
			}
		}

		//添加相册图片
		if(StringUtil.isNotEmpty(addPhoto)){
			String pathes[] = addPhoto.split(",");
			if(pathes!=null){
				for(int i=0;i<pathes.length;i++){
					String itemString = pathes[i];
					FUserImages userImages =new FUserImages();
					userImages.setImagePath(itemString);
					userImages.setUserId(ucenterUser.getUserId());
					userImages.setKeyword("photo");
					fUserImagesService.insert(userImages);
				}
			}
		}



		if(StringUtil.isNotEmpty(avatar)){
			UcenterUser updateUcentUser = new UcenterUser();
			updateUcentUser.setUserId(ucenterUser.getUserId());
			updateUcentUser.setAvatar(avatar);
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
	public String editGrzl(ModelMap modelMap,HttpSession session) {

		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();
		FUserBaseMsg queryObject = fUserBaseMsgService.selectByPrimaryKey(userId);
		if(queryObject!=null){
			modelMap.put("modle",queryObject);
		}
		ucenterUser = ucenterUserService.selectByPrimaryKey(ucenterUser.getUserId());
		modelMap.put("user",ucenterUser);
		modelMap.put("imageBase",imageBase);


		FUserImagesExample example = new FUserImagesExample();
		example.createCriteria().andUserIdEqualTo(ucenterUser.getUserId()).andKeywordEqualTo("photo");
		example.setOrderByClause("create_time desc");
		List<FUserImages> userImages = fUserImagesService.selectByExample(example);
		modelMap.put("userImages",userImages);



		return "/content/h5/user/edit_grzl.jsp";
	}







	/**
	 * 填写个人资料
	 * @return
	 */
	@ApiOperation(value = "填写个人资料")
	@RequestMapping(value = "/editGrzl", method = RequestMethod.POST)
	public String editGrzl(FUserBaseMsg fUserBaseMsg,String avatar,String deletePhoto, String addPhoto,HttpSession session){

		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();
		//删除相册图片
		if(StringUtil.isNotEmpty(deletePhoto)){
			String pathes[] = deletePhoto.split(",");
			if(pathes!=null){
				for(int i=0;i<pathes.length;i++){
					String itemString = pathes[i];
					FUserImagesExample example = new FUserImagesExample();
					example.createCriteria().andUserIdEqualTo(ucenterUser.getUserId()).andImagePathEqualTo(itemString).andKeywordEqualTo("photo");
					fUserImagesService.deleteByExample(example);
				}
			}
		}

		//添加相册图片
		if(StringUtil.isNotEmpty(addPhoto)){
			String pathes[] = addPhoto.split(",");
			if(pathes!=null){
				for(int i=0;i<pathes.length;i++){
					String itemString = pathes[i];
					FUserImages userImages =new FUserImages();
					userImages.setImagePath(itemString);
					userImages.setUserId(ucenterUser.getUserId());
					userImages.setKeyword("photo");
					fUserImagesService.insert(userImages);
				}
			}
		}



		if(StringUtil.isNotEmpty(avatar)){
			UcenterUser updateUcentUser = new UcenterUser();
			updateUcentUser.setUserId(ucenterUser.getUserId());
			updateUcentUser.setAvatar(avatar);
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


	@ApiOperation(value = "活动编辑")
	@RequestMapping(value = "/editPhoto", method = RequestMethod.GET)
	public String editPhoto(ModelMap modelMap,HttpSession session){

		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);


		ucenterUser = ucenterUserService.selectByPrimaryKey(ucenterUser.getUserId());
		modelMap.put("user",ucenterUser);
		modelMap.put("imageBase",imageBase);


		FUserImagesExample example = new FUserImagesExample();
		example.createCriteria().andUserIdEqualTo(ucenterUser.getUserId()).andKeywordEqualTo("photo");
		example.setOrderByClause("create_time desc");
		List<FUserImages> userImages = fUserImagesService.selectByExample(example);
		modelMap.put("userImages",userImages);

		return "/content/h5/user/edit_photo.jsp";
	}



	@ApiOperation(value = "活动编辑")
	@RequestMapping(value = "/editPhoto", method = RequestMethod.POST)
	@ResponseBody
	public Object editPhoto(String imgPath,String keyWord,HttpSession session){

		FriendResult result =new FriendResult(FriendResultConstant.SUCCESS,null);

		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		ucenterUser = ucenterUserService.selectByPrimaryKey(ucenterUser.getUserId());

		if("add".equals(keyWord)){
			FUserImages userImages =new FUserImages();
			userImages.setImagePath(imgPath);
			userImages.setUserId(ucenterUser.getUserId());
			userImages.setKeyword("photo");
			fUserImagesService.insert(userImages);
		}else if("delete".equals(keyWord)){
			FUserImagesExample example = new FUserImagesExample();
			example.createCriteria().andUserIdEqualTo(ucenterUser.getUserId()).andImagePathEqualTo(imgPath).andKeywordEqualTo("photo");
			fUserImagesService.deleteByExample(example);
		}



		return  result;
	}



	/**
	 * 填写个人资料
	 * @return
	 */
	@ApiOperation(value = "编辑个人资料")
	@RequestMapping(value = "/editZobz", method = RequestMethod.GET)
	public String editZobz(ModelMap modelMap,HttpSession session) {

		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();
		FUserRequest queryObject = fUserRequestService.selectByPrimaryKey(userId);

		if(queryObject!=null){
			String height = queryObject.getHeight();
			if(StringUtil.isNotEmpty(height)){
				String heightArray[] = height.split("~");
				if(heightArray.length==2){
					modelMap.put("height_min",heightArray[0]);
					modelMap.put("height_max",heightArray[1]);
				}else if(heightArray.length == 1){
					if(heightArray[0].contains("以上")){
						modelMap.put("height_min",heightArray[0].substring(0,heightArray[0].lastIndexOf("以上")));
					}else if(heightArray[0].contains("以下")){
						modelMap.put("height_max",heightArray[0].substring(0,heightArray[0].lastIndexOf("以下")));
					}
				}

				String age = queryObject.getAge();
				String ageArray[] = age.split("~");
				if(ageArray.length==2){
					modelMap.put("age_min",ageArray[0]);
					modelMap.put("age_max",ageArray[1]);
				}else if(heightArray.length == 1){
					if(heightArray[0].contains("以上")){
						modelMap.put("age_min",ageArray[0].substring(0,heightArray[0].lastIndexOf("以上")));
						modelMap.put("age_max","不限");
					}else if(heightArray[0].contains("以下")){
						modelMap.put("age_min","不限");
						modelMap.put("age_max",ageArray[0].substring(0,heightArray[0].lastIndexOf("以下")));
					}
				}

			}
			modelMap.put("modle",queryObject);

		}

		return "/content/h5/user/edit_zobz.jsp";
	}



	/**
	 * 编辑择偶条件
	 * @return
	 */
	@ApiOperation(value = "编辑择偶条件")
	@RequestMapping(value = "/editZobz", method = RequestMethod.POST)
	public String editZobz(FUserRequest fUserRequest,String age_min,String age_max,String height_min,String height_max,HttpSession session){

		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();

		FUserRequest queryObject = fUserRequestService.selectByPrimaryKey(userId);

		fUserRequest.setAge(getAgeRang(age_min,age_max));
		fUserRequest.setHeight(getHeiRang(height_min,height_max));

		if(queryObject!=null){
			fUserRequest.setUserId(userId);
			fUserRequestService.updateByPrimaryKey(fUserRequest);
		}else{
			fUserRequest.setUserId(userId);
			fUserRequestService.insert(fUserRequest);
		}



		return "redirect:/u/index";
	}


	/**
	 * 填写个人资料
	 * @return
	 */
	@ApiOperation(value = "填写个人生活")
	@RequestMapping(value = "/editShzk", method = RequestMethod.GET)
	public String editShzk(ModelMap modelMa,HttpSession session) {
		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();
		FUserLivingStatus queryObject = fUserLivingStatusService.selectByPrimaryKey(userId);
		if(queryObject!=null){
			modelMa.put("modle",queryObject);
		}

		return "/content/h5/user/edit_shzk.jsp";
	}



	/**
	 * 填写个人资料
	 * @return
	 */
	@ApiOperation(value = "兴趣爱好")
	@RequestMapping(value = "/editXqhh", method = RequestMethod.GET)
	public String editXqhh(ModelMap modelMap,HttpSession session) {
		String  username = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = getUctenuser(username,session);
		Integer userId = ucenterUser.getUserId();
		FUserLivingStatus queryObject = fUserLivingStatusService.selectByPrimaryKey(userId);
		if(queryObject!=null){
			modelMap.put("modle",queryObject);
		}

		return "/content/h5/user/edit_xqhh.jsp";
	}



	/**
	 * 个人生活
	 * @return
	 */
	@ApiOperation(value = "个人生活")
	@RequestMapping(value = "/editShzk", method = RequestMethod.POST)
	public String editShzk(FUserLivingStatus modle,HttpSession session) {

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

	public String redirectByPath(String path){
		long dateString = new Date().getTime();
		return "redirect:"+path+"?d="+dateString;
	}


}