package com.zheng.cms.admin.controller.h5;


import com.zheng.cms.common.constant.FriendResult;
import com.zheng.cms.common.constant.FriendResultConstant;
import com.zheng.common.base.BaseController;
import com.zheng.common.util.MD5Util;
import com.zheng.friend.dao.model.*;

import com.zheng.friend.rpc.api.*;
import com.zheng.pay.dao.model.PayInOrder;
import com.zheng.pay.dao.model.PayInOrderDetail;
import com.zheng.pay.dao.model.PayInOrderExample;
import com.zheng.pay.dao.model.PayVendor;
import com.zheng.pay.rpc.api.PayInOrderDetailService;
import com.zheng.pay.rpc.api.PayInOrderService;
import com.zheng.pay.rpc.api.PayVendorService;
import com.zheng.ucenter.dao.model.UcenterUser;

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


/**
 * 后台controller
 * Created by ZhangShuzheng on 2017/01/12.
 */
@Controller
@RequestMapping("/u")
@Api(value = "后台控制器", description = "后台管理")

public class PayController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(PayController.class);
	private int pageSize=15;


	public final static String imageBase = "http://jxwbb.oss-cn-zhangjiakou.aliyuncs.com/";


	public final static byte STATUS_CREATE = '1';//订单创建
	public final static byte STATUS_PAY = '2';//订单支付，但未完成更改资料
	public final static byte ORDER_FINISH = '2';//订单完成，未完成更改资料
	public final static byte ORDER_CANCEL = '3';//订单取消


	@Autowired
	FUserOrderService fUserOrderService;

	@Autowired
	PayVendorService payVendorService;

	@Autowired
	PayInOrderService payInOrderService;

	@Autowired
	FMemberTypeService fMemberTypeService;

	@Autowired
	PayInOrderDetailService payInOrderDetailService;


	/**
	 * 创建订单
	 * @return
	 */
	@ApiOperation(value = "后台首页")
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	@ResponseBody
	public Object createOrdery(@RequestParam(defaultValue = "0") Integer mTypeId,@RequestParam(defaultValue = "0") Integer payVendorId,HttpSession session,ModelMap modelMap) {
		//生成订单

		FriendResult result  = new FriendResult(FriendResultConstant.SUCCESS,null);

		//第三方支付信息
		PayVendor payVendor = payVendorService.selectByPrimaryKey(payVendorId);
		String  userName = (String) SecurityUtils.getSubject().getPrincipal();
		UcenterUser ucenterUser = (UcenterUser) session.getAttribute(userName);
		//获取会员的类型
		FMemberType fMemberType = fMemberTypeService.selectByPrimaryKey(mTypeId);
		//生成订单
		PayInOrder payInOrder = new PayInOrder();
		payInOrder.setPayVendorId(payVendorId);
		payInOrder.setStatus(STATUS_CREATE);
		long ctime = new Date().getTime();
		payInOrder.setCtime(ctime);
		long total = (long) (fMemberType.getPrice()*100);
		payInOrder.setAmount(total);
		payInOrderService.insert(payInOrder);

		PayInOrderExample payInOrderExample  = new PayInOrderExample();
		payInOrderExample.createCriteria().andCtimeEqualTo(ctime);
		payInOrder = payInOrderService.selectFirstByExample(payInOrderExample);
		Integer orderId  = payInOrder.getPayInOrderId();
		//生成订单详情
		PayInOrderDetail payInOrderDetail  = new PayInOrderDetail();
		payInOrderDetail.setPayInOrderId(orderId);
		String productName = fMemberType.getName()+fMemberType.getServiceDays()+"天";
		payInOrderDetail.setProductName(productName);
		payInOrderDetail.setProductCount(1);
		payInOrderDetail.setProductPrice((long) (fMemberType.getPrice()*100));
		payInOrderDetail.setRemark("member");
		payInOrderDetailService.insert(payInOrderDetail);
	//	payVendor.setAppsecret("245638e9e5a8d0fcf175304a27e771a3");
		//orderId=10005;
		String payUrl = xiWangPay(orderId+"",payVendor.getAppid(),payVendor.getAppsecret(),productName,total+"");

		HashMap<String,String> data = new HashMap<>();
		data.put("payUrl",payUrl);
		result.setData(data);

		return result;


	}



	//917245638e9e5a8d0fcf175304a27e771a310005720000http://www.baidu.comhttp://127.0.0.1:9991/u/userDetail
	//https://user.xiweb.cn/run.php?item=app&a=pay_h5&oid=10025&type=weixin&uid=917&money=720000&otid=10025&key=e88938bc227c8491a0352362aebaf376&subject=砖石会员180天&notify_url=http://www.baidu.com&return_url=http://127.0.0.1:9991/u/userDetail
	//https://user.xiweb.cn/run.php?item=app&a=pay_h5&oid=10005&type=weixin&uid=917&money=720000&otid=10005&key=e88938bc227c8491a0352362aebaf376&subject=砖石会员180天&notify_url=http://www.baidu.com&return_url=http://127.0.0.1:9991/u/userDetail

	//917245638e9e5a8d0fcf175304a27e771a31000572000010005720000http://www.baidu.comhttp://127.0.0.1:9991/u/userDetail
	//https://user.xiweb.cn/run.php?item=app&a=pay_h5&oid=10005&type=weixin&uid=917&money=720000&otid=10005&key=30d2c8a6c55fa8052c7a7ae251b23083&subject=砖石会员180天&notify_url=http://www.baidu.com&return_url=http://127.0.0.1:9991/u/userDetail


	//https://user.xiweb.cn/run.php?item=app&a=pay_h5&oid=10027&type=weixin&uid=917&money=720000&otid=10027&key=f78358118d37cc75a7e323578cfa459d&subject=砖石会员180天&notify_url=http://www.baidu.com&return_url=http://127.0.0.1:9991/u/userDetail
	//917321245638e9e5a8d0fcf175304a27e771a310027720000http://www.baidu.comhttp://127.0.0.1:9991/u/userDetail

	private String xiWangPay(String oid,String appid,String key,String produceName,String money){
		String xiweb_payurl = "https://user.xiweb.cn/run.php";
		String notify_url = "http://www.baidu.com";
		String return_url = "http://127.0.0.1:9991/u/userDetail";


		StringBuffer sb = new StringBuffer();
		sb.append(xiweb_payurl+"?");
		sb.append("item=app&a=pay_h5");
		sb.append("&oid="+oid);
		sb.append("&type="+"weixin");
		sb.append("&uid="+appid);
		sb.append("&money="+money);
		sb.append("&otid="+oid);

		//String setKey = appid + key + oid+""+ money + notify_url +return_url;
		StringBuffer sbKey =new StringBuffer();
		sbKey.append(appid);
		sbKey.append(key);
		sbKey.append(oid);
		sbKey.append(money);
		sbKey.append(notify_url);
		sbKey.append(return_url);

		String setKey="";

		try {
			setKey = MD5Util.getMD5(sbKey.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		sb.append("&key="+setKey);
		sb.append("&subject="+produceName);
		sb.append("&notify_url="+notify_url);
		sb.append("&return_url="+return_url);

		return  sb.toString();
	}

	private void callback(){

	}



}