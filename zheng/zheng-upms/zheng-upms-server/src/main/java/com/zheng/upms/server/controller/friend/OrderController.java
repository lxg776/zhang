package com.zheng.upms.server.controller.friend;

import com.zheng.common.base.BaseController;

import com.zheng.friend.dao.vo.FOrderVo;
import com.zheng.friend.rpc.api.FUserOrderService;
import com.zheng.ucenter.dao.model.UcenterUserExample;
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
    public String list(@RequestParam(defaultValue = "1") Integer pageNum, ModelMap modelMap) {

        HashMap<String,Object> map =new HashMap<>();
        List<FOrderVo> rows = fUserOrderService.getOrderList(map,pageNum,pageSize);
        long total = fUserOrderService.getOrderListCount(map);
        modelMap.put("page", PageOnterModle.getInstence(pageNum,total,pageSize,rows));
        return "/content/manage/list_order.jsp";

    }


}
