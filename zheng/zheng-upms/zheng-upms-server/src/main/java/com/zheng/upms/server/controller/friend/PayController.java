package com.zheng.upms.server.controller.friend;


import com.zheng.common.base.BaseController;
import com.zheng.pay.dao.model.PayVendor;
import com.zheng.pay.dao.model.PayVendorExample;
import com.zheng.pay.rpc.api.PayVendorService;
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
@RequestMapping("/manage/payVendor")
@Api(value = "后台控制器", description = "后台管理")
public class PayController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(PayController.class);


	@Autowired
	private PayVendorService payVendorService;

	private int pageSize=15;


	/**
	 * 后台首页
	 * @return
	 */
	@ApiOperation(value = "第三方支付列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String index(@RequestParam(defaultValue = "1") Integer pageNum, ModelMap modelMap) {


		PayVendorExample example = new PayVendorExample();
		example.createCriteria();
		//fActivityExample.setOrderByClause("desc ctime");

		List<PayVendor> rows = payVendorService.selectByExampleForOffsetPage(example, pageSize*(pageNum-1), pageSize);
		long total = payVendorService.countByExample(example);
		modelMap.put("page", PageOnterModle.getInstence(pageNum,total,pageSize,rows));
		return "/content/pay/list_pay_vendor.jsp";
	}



	@ApiOperation(value = "活动编辑")
	@RequestMapping(value = "/editPayVendor", method = RequestMethod.GET)
	public String edit(@RequestParam(defaultValue = "0") Integer payVendorId,ModelMap modelMap){

		if(payVendorId>0){
			PayVendor modle = payVendorService.selectByPrimaryKey(payVendorId);
			modelMap.put("modle",modle);
			modelMap.put("keyword","update");
		}else{
			modelMap.put("keyword","create");
		}

		return "/content/pay/add_pay_vendor.jsp";
	}









	@ApiOperation(value = "活动编辑")
	@RequestMapping(value = "/editPayVendor", method = RequestMethod.POST)
	public String createAndUpdate(@RequestParam(defaultValue = "0") String keyword, PayVendor modle){
		if("del".equals(keyword)){
			if(modle.getPayVendorId()>0){
				payVendorService.deleteByPrimaryKey(modle.getPayVendorId());
			}
		}else if("update".equals(keyword)){
			payVendorService.updateByPrimaryKey(modle);
		}else{
			payVendorService.insert(modle);
		}
		return "redirect:list";
	}

}