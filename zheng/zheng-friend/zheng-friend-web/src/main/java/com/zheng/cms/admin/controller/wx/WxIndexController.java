package com.zheng.cms.admin.controller.wx;

import com.zheng.cms.admin.util.CommonUtil;
import com.zheng.cms.admin.util.Config;
import com.zheng.cms.common.constant.FriendResult;
import com.zheng.cms.common.constant.FriendResultConstant;
import com.zheng.friend.dao.vo.FuserDetailVo;
import com.zheng.friend.rpc.api.FUserBaseMsgService;
import com.zheng.ucenter.dao.model.UcenterUser;
import com.zheng.ucenter.rpc.api.UcenterUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/wx")
public class WxIndexController {


    public final static String imageBase = Config.imageBase;

    @Autowired
    FUserBaseMsgService fUserBaseMsgService;
    @Autowired
    UcenterUserService ucenterUserService;



    private static int pageSize=15;

    @ApiOperation(value = "后台首页")
    @RequestMapping(value = "/getRecommendUserList", method = RequestMethod.GET)
    @ResponseBody
    public Object selectRecommendUsers(@RequestParam(defaultValue = "1") Integer pageNum, HttpServletRequest request, HttpSession session){



        FriendResult result  = new FriendResult(FriendResultConstant.SUCCESS,null);
        String userName = (String) request.getAttribute("userName");
        UcenterUser ucenterUser = getUctenuser(userName,session);
        FuserDetailVo myDetailVo  = fUserBaseMsgService.selectFUserDetailVoByUserId(ucenterUser.getUserId());
        Map<String,Object> modelMap = new HashMap<>();
        //系统推荐人
        List<FuserDetailVo> recommendUserList = fUserBaseMsgService.selectRecommendUsers(myDetailVo,(pageNum-1)*pageSize,pageSize);
        modelMap.put("recommendUserList",recommendUserList);
        modelMap.put("pageSize",pageSize);
        modelMap.put("imageBase",imageBase);


        result.setData(modelMap);

        return CommonUtil.handResult(result,request);

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
}
