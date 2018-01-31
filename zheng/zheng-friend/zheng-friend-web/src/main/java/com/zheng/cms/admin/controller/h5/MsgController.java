package com.zheng.cms.admin.controller.h5;

import com.zheng.cms.common.constant.FriendResult;
import com.zheng.cms.common.constant.FriendResultConstant;
import com.zheng.common.base.BaseController;
import com.zheng.friend.dao.model.FMessage;
import com.zheng.friend.dao.model.FMessageExample;
import com.zheng.friend.dao.model.FUserBaseMsg;
import com.zheng.friend.dao.vo.FuserDetailVo;
import com.zheng.friend.dao.vo.RecentMsgVo;
import com.zheng.friend.rpc.api.FMessageService;
import com.zheng.friend.rpc.api.FUserBaseMsgService;
import com.zheng.ucenter.dao.model.UcenterUser;
import com.zheng.ucenter.rpc.api.UcenterUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/m")
@Api(value = "信息控制器", description = "信息管理")
public class MsgController extends BaseController {


    public final static String imageBase = "http://jxwbb.oss-cn-zhangjiakou.aliyuncs.com/";

    @Autowired
    UcenterUserService ucenterUserService;

    @Autowired
    FUserBaseMsgService fUserBaseMsgService;

    @Autowired
    FMessageService fMessageService;


    /**
     * 给其他人发送信息
     * @return
     */
    @ApiOperation(value = "给其他人发送信息")
    @RequestMapping(value = "/sendMsg", method = RequestMethod.GET)
    public String sendMsg(ModelMap modelMap, Integer uid,String backUrl,HttpSession session) {

        String  username = (String) SecurityUtils.getSubject().getPrincipal();
        UcenterUser ucenterUser = getUctenuser(username,session);
        Integer userId = ucenterUser.getUserId();

        FUserBaseMsg queryObject = fUserBaseMsgService.selectByPrimaryKey(userId);
        FuserDetailVo toUser = fUserBaseMsgService.selectFUserDetailVoByUserId(uid);

        modelMap.put("fromUser",queryObject);
        modelMap.put("toUser",toUser);
        modelMap.put("backUrl",backUrl);

        modelMap.put("imageBase",imageBase);
        return "/content/h5/message/send_msg.jsp";
    }

    /**
     * 给其他人发送信息
     * @return
     */
    @ApiOperation(value = "消息列表")
    @RequestMapping(value = "/msgList", method = RequestMethod.GET)
    public String msgList(ModelMap modelMap,int fromUserId,HttpSession session) {

        String  username = (String) SecurityUtils.getSubject().getPrincipal();
        UcenterUser ucenterUser = getUctenuser(username,session);
        Integer userId = ucenterUser.getUserId();


        FUserBaseMsg baseMsg = fUserBaseMsgService.selectByPrimaryKey(userId);

        if(null!=baseMsg){
            modelMap.put("fromUser",baseMsg);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String currentDate = simpleDateFormat.format(new Date());
        modelMap.put("currentDate",currentDate);

        //设置已读
        FMessageExample fMessageExample =new FMessageExample();
        fMessageExample.createCriteria().andFromUserIdEqualTo(fromUserId).andToUserIdEqualTo(userId);
        FMessage message = new FMessage();
        message.setMsgState((byte)1);
        fMessageService.updateByExampleSelective(message,fMessageExample);
        List<RecentMsgVo> tempMsgList = new ArrayList<>();
        //消息列表
        List<RecentMsgVo> msgList = fMessageService.selectMsgRecord(userId,fromUserId);
        if(null!=msgList){


            for(int i = 0;i<msgList.size();i++){
                tempMsgList.add(msgList.get(msgList.size()-i-1));
            }


            String tempDate = "";
            for(RecentMsgVo recentMsgVo :tempMsgList){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

                String itemDate = sdf.format(recentMsgVo.getCreateTime());

                if(recentMsgVo.getFromUserId().equals(userId)){
                    recentMsgVo.setShowFla(1);
                }else{
                    recentMsgVo.setShowFla(0);
                }
                if(!itemDate.equals(tempDate)){
                    recentMsgVo.setShowDate(itemDate);
                    tempDate = itemDate;
                }
            }
        }

        modelMap.put("msgList",tempMsgList);
        FuserDetailVo toUser = fUserBaseMsgService.selectFUserDetailVoByUserId(fromUserId);
        modelMap.put("toUser",toUser);
        return "/content/h5/message/msg_list.jsp";
    }



    /**
     * 给其他人发送信息
     * @return
     */
    @ApiOperation(value = "给其他人发送信息")
    @RequestMapping(value = "/sendMsg", method = RequestMethod.POST)
    @ResponseBody
    public Object sendMsg(FMessage fMessage,String backUrl,HttpSession session) {

        String  username = (String) SecurityUtils.getSubject().getPrincipal();
        UcenterUser ucenterUser = getUctenuser(username,session);
        Integer userId = ucenterUser.getUserId();
        fMessage.setFromUserId(userId);


        byte state = 0;
        fMessage.setMsgState(state);
        fMessageService.insert(fMessage);
        FriendResult result =new FriendResult(FriendResultConstant.SUCCESS,null);
        result.setMessage("发送成功");

        return result;
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
