package com.zheng.upms.server.controller.friend;


import com.zheng.common.base.BaseController;
import com.zheng.friend.dao.model.FContact;
import com.zheng.friend.dao.model.FContactExample;
import com.zheng.friend.dao.vo.FContactVo;
import com.zheng.friend.rpc.api.FContactService;
import com.zheng.upms.server.controller.modle.PageOnterModle;
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

import java.util.List;

/**
 * 后台controller
 * Created by ZhangShuzheng on 2017/01/12.
 */
@Controller
@RequestMapping("/manage/contact")
@Api(value = "后台控制器", description = "后台管理")
public class ContactController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(ContactController.class);


	@Autowired
	private FContactService fContactService;

	private int pageSize=15;


	/**
	 * 后台首页
	 * @return
	 */
	@ApiOperation(value = "第三方支付列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String index(@RequestParam(defaultValue = "1") Integer pageNum, ModelMap modelMap) {

		List<FContactVo> rows = fContactService.getContactList(pageNum,pageSize);
		FContactExample example =new FContactExample();
		example.createCriteria();
		long total = fContactService.countByExample(example);
		modelMap.put("page", PageOnterModle.getInstence(pageNum,total,pageSize,rows));
		return "/content/manage/contact/list_contact.jsp";

	}



	@ApiOperation(value = "活动编辑")
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(defaultValue = "0") Integer id,ModelMap modelMap){

		if(id>0){
			FContactVo modle = fContactService.getContactById(id);
			modelMap.put("modle",modle);
			modelMap.put("keyword","update");
		}else{
			modelMap.put("keyword","create");
		}

		return "/content/manage/contact/add_contact.jsp";
	}


	@ApiOperation(value = "活动编辑")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@RequestParam(defaultValue = "0") String keyword, FContact modle){

		if("update".equals(keyword)){
			fContactService.updateByPrimaryKeySelective(modle);
		}else{
			fContactService.insert(modle);
		}
		return "redirect:list";
	}





}