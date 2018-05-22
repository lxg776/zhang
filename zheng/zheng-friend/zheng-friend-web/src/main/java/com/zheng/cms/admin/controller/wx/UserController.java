package com.zheng.cms.admin.controller.wx;

import com.zheng.cms.common.constant.FriendResult;
import com.zheng.cms.common.constant.FriendResultConstant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wx")
@Api(value = "用户控制器", description = "用户控制器")
public class UserController {


    /**
     * 创建订单
     * @return
     */
    @ApiOperation(value = "微信小程序注册")
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    @ResponseBody
    public Object reg() {
        //生成订单
        FriendResult result  = new FriendResult(FriendResultConstant.SUCCESS,null);
        result.setMessage("我日你妹哦");

        //处理回调
        return result;
    }





}
