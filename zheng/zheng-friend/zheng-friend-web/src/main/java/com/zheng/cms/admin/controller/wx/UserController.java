package com.zheng.cms.admin.controller.wx;

import com.zheng.cms.admin.controller.h5.IndexController;
import com.zheng.cms.admin.shiro.UpmsSessionDao;
import com.zheng.cms.admin.util.SmsUtil;
import com.zheng.cms.common.constant.FriendResult;
import com.zheng.cms.common.constant.FriendResultConstant;
import com.zheng.common.util.MD5Util;
import com.zheng.common.util.RedisUtil;
import com.zheng.friend.dao.model.*;
import com.zheng.friend.rpc.api.*;
import com.zheng.ucenter.dao.model.UcenterIdentificaion;
import com.zheng.ucenter.dao.model.UcenterUser;
import com.zheng.ucenter.dao.model.UcenterUserExample;
import com.zheng.ucenter.rpc.api.UcenterIdentificaionService;
import com.zheng.ucenter.rpc.api.UcenterUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("/wx")
@Api(value = "用户控制器", description = "用户控制器")
public class UserController {



    private static Logger _log = LoggerFactory.getLogger(IndexController.class);
    private int pageSize=15;

    // 全局会话key
    private final static String ZHENG_UPMS_SERVER_SESSION_ID = "zheng-ucenter-server-session-id";
    // 全局会话key列表
    private final static String ZHENG_UPMS_SERVER_SESSION_IDS = "zheng-ucenter-server-session-ids";
    // code key
    private final static String ZHENG_UPMS_SERVER_CODE = "zheng-ucenter-server-code";



    @Autowired
    UcenterUserService ucenterUserService;



    @Autowired
    UcenterIdentificaionService ucenterIdentificaionService;
    @Autowired
    FUserBaseMsgService fUserBaseMsgService;
    @Autowired
    FUserRequestService fUserRequestService;
    @Autowired
    FUserLivingStatusService fUserLivingStatusService;
    @Autowired
    UpmsSessionDao upmsSessionDao;

    @Autowired
    FUserSettingService fUserSettingService;

    @Autowired
    FSmsMessageService fSmsMessageService;


    @Autowired
    FCitiesService fCitiesService;

    @Autowired
    FAreasService fAreasService;


    /**
     * 创建订单
     * @return
     */
    @ApiOperation(value = "测试")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Object test(){
        //生成订单
        FriendResult result  = new FriendResult(FriendResultConstant.SUCCESS,null);
        result.setMessage("测试成功");
        return  result;
    }




    /**
     * 创建订单
     * @return
     */
    @ApiOperation(value = "微信小程序注册")
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    @ResponseBody
    public Object reg(HttpServletRequest request, Byte sex, String userName, String password, String idCard, String idCardImgs, String realName, String msgCode, Integer fromCityId, Integer fAreasId, String birthDay, HttpSession session) {
        //生成订单
        FriendResult result  = new FriendResult(FriendResultConstant.SUCCESS,null);



        UcenterUser ucenterUser =null;

        if(null!= SecurityUtils.getSubject().getPrincipal()){
            String  username = (String)SecurityUtils.getSubject().getPrincipal();
            ucenterUser= getUctenuser(username,session);
        }





        String remoteAddr="";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        UcenterUser modle =new UcenterUser();
        modle.setSalt("friend");

        String md5Password =  MD5Util.MD5(modle.getSalt()+password);
        modle.setPassword(md5Password);
        modle.setUserName(userName);
        modle.setCreateIp(remoteAddr);
        modle.setSex(sex);

        if(null!=ucenterUser){
            ucenterUser=ucenterUserService.selectByPrimaryKey(ucenterUser.getUserId());
            if(null!=ucenterUser){
                modle.setUserId(ucenterUser.getUserId());
                ucenterUserService.updateByPrimaryKey(modle);
            }else{
                SecurityUtils.getSubject().logout();
                ucenterUserService.insert(modle);
            }

        }else{
            ucenterUserService.insert(modle);
        }
        UcenterUserExample example = new UcenterUserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        modle=ucenterUserService.selectFirstByExample(example);



        String upms_code="";
        //登录
        if(ucenterUser==null){
            upms_code = login(userName);
        }


        UcenterIdentificaion ucenterIdentificaion = new UcenterIdentificaion();
        ucenterIdentificaion.setUserId(modle.getUserId());
        ucenterIdentificaion.setCellphone(userName);
        ucenterIdentificaion.setIdcardImgs(idCardImgs);
        ucenterIdentificaion.setIdcardNo(idCard);
        ucenterIdentificaion.setRealName(realName);

        if(null!=ucenterUser){
            ucenterIdentificaionService.updateByPrimaryKey(ucenterIdentificaion);
            return "redirect:/u/txGrzl";


        }else{
            ucenterIdentificaionService.insert(ucenterIdentificaion);
            //随机一个昵称
            FUserBaseMsg fUserBaseMsg = new FUserBaseMsg();
            fUserBaseMsg.setNikename(SmsUtil.randomCheckCode(7));
            fUserBaseMsg.setUserId(modle.getUserId());
            fUserBaseMsg.setBirthDate(birthDay);

            FCitiesExample fCitiesExample =new FCitiesExample();
            fCitiesExample.createCriteria().andCityidEqualTo(fromCityId+"");
            FCities cities = fCitiesService.selectFirstByExample(fCitiesExample);

            if(cities!=null){
                fUserBaseMsg.setFromCity(cities.getCity());
                fUserBaseMsg.setFromCityId(Integer.parseInt(cities.getCityid()));
            }


            FAreasExample fAreasExample =new FAreasExample();
            fAreasExample.createCriteria().andAreaidEqualTo(fAreasId+"");
            FAreas fAreas = fAreasService.selectFirstByExample(fAreasExample);
            if(fAreas!=null){
                fUserBaseMsg.setFromArea(fAreas.getArea());
                fUserBaseMsg.setFromAreaId(Integer.parseInt(fAreas.getAreaid()));
            }

            //设置显示选项
            FUserSetting fUserSetting =new FUserSetting();
            fUserSetting.setUserId(modle.getUserId());
            fUserSetting.setShowIndexPage((byte)0);
            fUserSetting.setShowBaseMsg((byte)0);
            fUserSetting.setShowFavorite((byte)0);
            fUserSetting.setShowFriendRequest((byte)0);
            fUserSetting.setShowLivingStatus((byte)0);
            fUserSetting.setMsgReadStatus((byte)0);
            fUserSetting.setMsgSendStatus((byte)0);
            fUserSetting.setHistoryviewStatus((byte)1);
            fUserSetting.setIdcardStatus((byte)1);
            fUserBaseMsgService.insert(fUserBaseMsg);
            fUserSettingService.insert(fUserSetting);

            result.setMessage("注册成功!");

            return result;
        }


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


    private String login(String username){
        //后台登录
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String sessionId = session.getId().toString();

        // 全局会话sessionId列表，供会话管理
        RedisUtil.lpush(ZHENG_UPMS_SERVER_SESSION_IDS, sessionId.toString());
        // 默认验证帐号密码正确，创建code
        String code = UUID.randomUUID().toString();
        // 全局会话的code
        RedisUtil.set(ZHENG_UPMS_SERVER_SESSION_ID + "_" + sessionId, code, (int) subject.getSession().getTimeout() / 1000);
        // code校验值
        RedisUtil.set(ZHENG_UPMS_SERVER_CODE + "_" + code, code, (int) subject.getSession().getTimeout() / 1000);

        return  code;
    }





    public Object wxLogin(String code){
        //生成订单
        FriendResult result  = new FriendResult(FriendResultConstant.SUCCESS,null);


        return result;
    }


    /**
     * 通过appId和appsecret 获取OpenId
     * @param appId
     * @param appsecret
     * @param code
     * @return
     */
    public String getOpenIdFromWx(String appId,String appsecret,String code){

            return "abcdefg";
    }


    /**
     * 获取token
     * @param openId
     * @return
     */
    public String getTokenByOpenId(String openId){

        return "abcdef666";
    }


}
