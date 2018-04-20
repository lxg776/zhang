package com.zheng.cms.admin.controller.h5;

import com.zheng.cms.common.constant.FriendResult;
import com.zheng.cms.common.constant.FriendResultConstant;
import com.zheng.common.util.MD5Util;
import com.zheng.friend.dao.model.FMemberType;
import com.zheng.friend.dao.model.FUserMemberRel;
import com.zheng.friend.rpc.api.FMemberTypeService;
import com.zheng.friend.rpc.api.FUserMemberRelService;
import com.zheng.friend.rpc.api.FUserOrderService;
import com.zheng.pay.dao.model.PayInOrder;
import com.zheng.pay.dao.model.PayVendor;
import com.zheng.pay.rpc.api.PayInOrderDetailService;
import com.zheng.pay.rpc.api.PayInOrderService;
import com.zheng.pay.rpc.api.PayVendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/cb")
@Api(value = "回调控制器", description = "回调控制器")
public class CallBackCpntroller {


    public final static String DATE_FORMAT = "yyyy年MM月dd日 HH:mm:SS";

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

    @Autowired
    FUserMemberRelService fUserMemberRelService;

    /**
     * 创建订单
     * @return
     */
    @ApiOperation(value = "支付成功回调")
    @RequestMapping(value = "/payCallBack", method = RequestMethod.GET)
    @ResponseBody
    public String payCallBack(@RequestParam(defaultValue = "0") String oid, @RequestParam(defaultValue = "0") String money, String key, HttpSession session) {
        //生成订单
        FriendResult result  = new FriendResult(FriendResultConstant.SUCCESS,null);
        PayInOrder payInOrder = payInOrderService.selectByPrimaryKey(Integer.parseInt(oid));

        String callBack = payInOrder.getCallBack();
        //处理回调
        return handleByCallback(callBack,oid,money,key);
    }


    private String handleByCallback(String callBack,String oid,String money,String backKey){
        String args[] = callBack.split("&");
        if(null!=args){

            if(args[0].equals("u")&&args.length==4){
                //更新会员等级

                String uid=args[1];
                String payVendorId = args[2];
                String mTypeId = args[3];

                PayVendor payVendor = payVendorService.selectByPrimaryKey(Integer.parseInt(payVendorId));
                String appsecret =payVendor.getAppsecret();

                StringBuffer sb =new StringBuffer();

                String state = "1";
                sb.append(oid);
                sb.append(state);

                try {
                    String  setKey = MD5Util.getMD5(payVendor.getAppid()+MD5Util.getMD5(sb.toString())+money+appsecret);
                    if(backKey.equals(setKey)){
                        //更新订单状态
                        PayInOrder payInOrder = payInOrderService.selectByPrimaryKey(Integer.parseInt(oid));
                        payInOrder.setStatus(ORDER_FINISH);
                        payInOrderService.updateByPrimaryKey(payInOrder);
                        //设置会员关系
                        FMemberType fMemberType = fMemberTypeService.selectByPrimaryKey(Integer.parseInt(mTypeId));
                        FUserMemberRel fUserMemberRel =new FUserMemberRel();
                        fUserMemberRel.setUserId(Integer.parseInt(uid));
                        fUserMemberRel.setMemberTypeId(Integer.parseInt(mTypeId));
                        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                        String begDate = sdf.format(new Date());
                        fUserMemberRel.setBegTime(begDate);

                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.DATE, 100);
                        Date endDate = calendar.getTime();
                        String endDateString = sdf.format(endDate);
                        fUserMemberRel.setBegTime(endDateString);
                        fUserMemberRel.setEndStatus((byte)0);
                        fUserMemberRelService.insert(fUserMemberRel);
                        return "success";
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    return "fail";
                }

            }

        }
        return "fail";
    }
}
