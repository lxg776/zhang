package com.zheng.upms.server.controller.friend;

import com.github.pagehelper.util.StringUtil;
import com.zheng.common.base.BaseController;

import com.zheng.friend.dao.vo.FOrderVo;
import com.zheng.friend.rpc.api.FUserOrderService;
import com.zheng.upms.server.controller.modle.PageOnterModle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/manage/order")
@Api(value = "订单控制器", description = "订单管理")
public class OrderController  extends BaseController {



    @Autowired
    FUserOrderService fUserOrderService;


    static final int pageSize=15;

    /**
     * 后台首页
     * @return
     */
    @ApiOperation(value = "后台首页")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "") String payInOrderId  ,@RequestParam(defaultValue = "") String userName,@RequestParam(defaultValue = "") String productName,@RequestParam(defaultValue = "0") Byte status ,ModelMap modelMap) {


        HashMap<String,Object> map =new HashMap<>();
        String dataSearch = "";

        if(StringUtil.isNotEmpty(payInOrderId)){
            modelMap.put("payInOrderId",payInOrderId);
            map.put("payInOrderId","%"+payInOrderId+"%");
            dataSearch = "payInOrderId="+payInOrderId;
        }
        if(StringUtil.isNotEmpty(userName)){
            modelMap.put("userName",userName);
            map.put("userName","%"+userName+"%");
            if(StringUtil.isNotEmpty(dataSearch)){
                dataSearch = dataSearch+"&userName="+userName;
            }else{
                dataSearch = "userName="+userName;
            }

        }
        if(StringUtil.isNotEmpty(productName)){
            modelMap.put("productName",productName);
            map.put("productName","%"+productName+"%");
            if(StringUtil.isNotEmpty(dataSearch)){
                dataSearch = dataSearch+"&productName="+productName;
            }else{
                dataSearch = "productName="+productName;
            }
        }
        if(status != '0'){
            modelMap.put("status",status);
            map.put("status",status);

            if(StringUtil.isNotEmpty(dataSearch)){
                dataSearch = dataSearch+"&status="+status;
            }else{
                dataSearch = "status="+status;
            }
        }

        map.put("dataSearch",dataSearch);
        List<FOrderVo> rows = fUserOrderService.getOrderList(map,pageNum,pageSize);
        long total = fUserOrderService.getOrderListCount(map);
        modelMap.put("page", PageOnterModle.getInstence(pageNum,total,pageSize,rows));
        return "/content/manage/list_order.jsp";

    }


}
