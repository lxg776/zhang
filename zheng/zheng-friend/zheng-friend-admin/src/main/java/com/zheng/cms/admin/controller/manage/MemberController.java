package com.zheng.cms.admin.controller.manage;

import com.zheng.cms.admin.modle.PageOnterModle;
import com.zheng.common.base.BaseController;

import com.zheng.common.util.MD5Util;
import com.zheng.common.util.StringUtil;
import com.zheng.friend.dao.model.*;
import com.zheng.friend.dao.vo.FUserMemberRelVo;
import com.zheng.friend.dao.vo.FuserDetailVo;
import com.zheng.friend.rpc.api.*;
import com.zheng.ucenter.dao.model.UcenterIdentificaion;
import com.zheng.ucenter.dao.model.UcenterUser;
import com.zheng.ucenter.dao.model.UcenterUserExample;
import com.zheng.ucenter.rpc.api.UcenterIdentificaionService;
import com.zheng.ucenter.rpc.api.UcenterUserService;
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


@Controller
@RequestMapping("/manage/member")
@Api(value = "会员控制器", description = "会员管理")
public class MemberController extends BaseController{



    private static Logger _log = LoggerFactory.getLogger(ActivityController.class);
    public static String imageBase = "http://jxwbb.oss-cn-zhangjiakou.aliyuncs.com/";

    @Autowired
    private UcenterIdentificaionService ucenterIdentificaionService;

    @Autowired
    private UcenterUserService ucenterUserService;

    @Autowired
    private FUserBaseMsgService fUserBaseMsgService;


    @Autowired
    private FUserRequestService fUserRequestService;

    @Autowired
    private FUserMemberRelService fUserMemberRelService;


    @Autowired
    private FMemberTypeService fMemberTypeService;

    @Autowired
    private FUserLivingStatusService fUserLivingStatusService;

    @Autowired
    private FUserSettingService fUserSettingService;



    private int pageSize=15;


    /**
     * 后台首页
     * @return
     */
    @ApiOperation(value = "后台首页")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String index(@RequestParam(defaultValue = "1") Integer pageNum, ModelMap modelMap) {


        UcenterUserExample example = new UcenterUserExample();
        example.createCriteria();
        //fActivityExample.setOrderByClause("desc ctime");

        List<UcenterUser> rows = ucenterUserService.selectByExampleForOffsetPage(example, pageSize*(pageNum-1), pageSize);
        long total = ucenterUserService.countByExample(example);
        modelMap.put("page", PageOnterModle.getInstence(pageNum,total,pageSize,rows));
        return "/content/manage/list_member.jsp";
    }


    /**
     * 用户详情
     * @return
     */
    @ApiOperation(value = "后台首页")
    @RequestMapping(value = "/userDetail", method = RequestMethod.GET)
    public String userDetail(@RequestParam(defaultValue = "0") Integer userId,ModelMap modelMap){



        FuserDetailVo fuserDetailVo = fUserBaseMsgService.selectFUserDetailVoByUserId(userId);

        modelMap.put("modle",fuserDetailVo);

        return "/content/manage/detail_user.jsp";
    }



    @ApiOperation(value = "活动编辑")
    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String edit(@RequestParam(defaultValue = "0") Integer id,ModelMap modelMap){

        if(id>0){
            UcenterUser ucenterUser = ucenterUserService.selectByPrimaryKey(id);
            modelMap.put("modle",ucenterUser);
            modelMap.put("keyword","update");
        }else{
            modelMap.put("keyword","create");
        }

        return "/content/manage/add_member.jsp";
    }









    @ApiOperation(value = "活动编辑")
    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String createAndUpdate(@RequestParam(defaultValue = "0") String keyword, UcenterUser modle){
        if("del".equals(keyword)){
            if(modle.getUserId()>0){
                ucenterUserService.deleteByPrimaryKey(modle.getUserId());
            }
        }else if("update".equals(keyword)){
            if(null==modle.getPassword()||"".equals(modle.getPassword())){

            }else{
                String password =  MD5Util.MD5(modle.getSalt()+modle.getPassword());
                modle.setPassword(password);
            }
            ucenterUserService.updateByPrimaryKeySelective(modle);
        }else{
            modle.setSalt("friend");
            String password =  MD5Util.MD5(modle.getSalt()+modle.getPassword());
            modle.setPassword(password);
            ucenterUserService.insert(modle);
        }
        return "redirect:list";
    }

    @ApiOperation(value = "编辑身份验证")
    @RequestMapping(value = "/editIdentific", method = RequestMethod.GET)
    public String editIdentific(@RequestParam(defaultValue = "0") Integer userId,ModelMap modelMap){

        UcenterIdentificaion modle = ucenterIdentificaionService.selectByPrimaryKey(userId);

        if(null!=modle.getIdcardImgs()&&modle.getIdcardImgs().length()>0){
            String [] imgs =  modle.getIdcardImgs().split(",");
            modelMap.put("imgs",imgs);
            modelMap.put("imageBase",imageBase);
        }

        if(modle==null){
            modle =new UcenterIdentificaion();
            modle.setUserId(userId);
            modelMap.put("keyword","create");
        }else{
            modelMap.put("keyword","update");
        }
        modelMap.put("modle",modle);
        return "/content/manage/add_identification.jsp";

    }



    @ApiOperation(value = "编辑身份验证")
    @RequestMapping(value = "/editIdentific", method = RequestMethod.POST)
    public String editIdentific(@RequestParam(defaultValue = "0") String keyword, UcenterIdentificaion modle){

       if("update".equals(keyword)){
           ucenterIdentificaionService.updateByPrimaryKeySelective(modle);
        }else{
           ucenterIdentificaionService.insert(modle);
        }
        return "redirect:list";
    }


    @ApiOperation(value = "编辑")
    @RequestMapping(value = "/editBaseMsg", method = RequestMethod.GET)
    public String editBaseMsg(@RequestParam(defaultValue = "0") Integer userId,ModelMap modelMap){

        FUserBaseMsg modle = fUserBaseMsgService.selectByPrimaryKey(userId);
        if(modle==null){
            modle =new FUserBaseMsg();
            modle.setUserId(userId);
            modelMap.put("keyword","create");
        }else{
            modelMap.put("keyword","update");
        }
        modelMap.put("modle",modle);
        return "/content/manage/add_base_msg.jsp";


    }



    @ApiOperation(value = "操作基本资料")
    @RequestMapping(value = "/editBaseMsg", method = RequestMethod.POST)
    public String editBaseMsg(@RequestParam(defaultValue = "0") String keyword, FUserBaseMsg modle){
        if("update".equals(keyword)){
            fUserBaseMsgService.updateByPrimaryKeySelective(modle);
        }else{
            fUserBaseMsgService.insert(modle);
        }
        return "redirect:list";
    }



    @ApiOperation(value = "编辑")
    @RequestMapping(value = "/editRequestMsg", method = RequestMethod.GET)
    public String editRequestMsg(@RequestParam(defaultValue = "0") Integer userId,ModelMap modelMap){

        FUserRequest modle = fUserRequestService.selectByPrimaryKey(userId);
        if(modle==null){
            modle =new FUserRequest();
            modle.setUserId(userId);
            modelMap.put("keyword","create");
        }else{
            modelMap.put("keyword","update");
        }
        modelMap.put("modle",modle);
        return "/content/manage/add_requirements.jsp";


    }



    @ApiOperation(value = "操作基本资料")
    @RequestMapping(value = "/editRequestMsg", method = RequestMethod.POST)
    public String editRequestMsg(@RequestParam(defaultValue = "0") String keyword, FUserRequest modle){
        if("update".equals(keyword)){
            fUserRequestService.updateByPrimaryKeySelective(modle);
        }else{
            fUserRequestService.insert(modle);
        }
        return "redirect:list";
    }


    @ApiOperation(value = "编辑生活状态")
    @RequestMapping(value = "/editLivingStatus", method = RequestMethod.GET)
    public String editLivingStatus(@RequestParam(defaultValue = "0") Integer userId,ModelMap modelMap){

        FUserLivingStatus modle = fUserLivingStatusService.selectByPrimaryKey(userId);
        if(modle==null){
            modle =new FUserLivingStatus();
            modle.setUserId(userId);
            modelMap.put("keyword","create");
        }else{
            modelMap.put("keyword","update");
        }
        modelMap.put("modle",modle);
        return "/content/manage/add_living_status.jsp";


    }



    @ApiOperation(value = "操作基本资料")
    @RequestMapping(value = "/editLivingStatus", method = RequestMethod.POST)
    public String editLivingStatus(@RequestParam(defaultValue = "0") String keyword, FUserLivingStatus modle){
        if("update".equals(keyword)){
            fUserLivingStatusService.updateByPrimaryKeySelective(modle);
        }else{
            fUserLivingStatusService.insert(modle);
        }
        return "redirect:list";
    }


    @ApiOperation(value = "编辑用户设置")
    @RequestMapping(value = "/editUserSetting", method = RequestMethod.GET)
    public String editUserSetting(@RequestParam(defaultValue = "0") Integer userId,ModelMap modelMap){

        FUserSetting modle = fUserSettingService.selectByPrimaryKey(userId);
        if(modle==null){
            modle =new FUserSetting();
            modle.setUserId(userId);
            modelMap.put("keyword","create");
        }else{
            modelMap.put("keyword","update");
        }
        modelMap.put("modle",modle);
        return "/content/manage/add_u_setting.jsp";
    }



    @ApiOperation(value = "编辑用户设置")
    @RequestMapping(value = "/editUserSetting", method = RequestMethod.POST)
    public String editUserSetting(@RequestParam(defaultValue = "0") String keyword, FUserSetting modle){
        if("update".equals(keyword)){
            fUserSettingService.updateByPrimaryKeySelective(modle);
        }else{
            fUserSettingService.insert(modle);
        }
        return "redirect:list";
    }




    @ApiOperation(value = "编辑")
    @RequestMapping(value = "/userMemberList", method = RequestMethod.GET)
    public String userMemberList(@RequestParam(defaultValue = "0") Integer userId,ModelMap modelMap){

        List<FUserMemberRelVo> dataList = fUserMemberRelService.selectFUserMemberRelVoByUserId(userId);

        modelMap.put("dataList",dataList);
        modelMap.put("userId",userId);
        return "/content/manage/list_u_member_type.jsp";
    }

    @ApiOperation(value = "编辑")
    @RequestMapping(value = "/editUserMember", method = RequestMethod.GET)
    public String editUserMember(@RequestParam(defaultValue = "0") Integer id,Integer userId,ModelMap modelMap){

        List<FUserMemberRelVo> dataList = fUserMemberRelService.selectFUserMemberRelVoByUserId(userId);
        FMemberTypeExample  example = new FMemberTypeExample();
        example.createCriteria();
        List<FMemberType>  typeList = fMemberTypeService.selectByExample(example);
        UcenterUser ucenterUser = ucenterUserService.selectByPrimaryKey(userId);
        FUserMemberRel modle = fUserMemberRelService.selectByPrimaryKey(id);
        if(modle==null){
            modle =new FUserMemberRel();
            modle.setUserId(userId);
            modelMap.put("keyword","create");
        }else{
            modelMap.put("keyword","update");
        }
        modelMap.put("user",ucenterUser);
        modelMap.put("modle",modle);
        modelMap.put("typeList",typeList);


        return "/content/manage/add_user_member_type.jsp";


    }


    @ApiOperation(value = "操作基本资料")
    @RequestMapping(value = "/editUserMember", method = RequestMethod.POST)
    public String editUserMember(@RequestParam(defaultValue = "0") String keyword, FUserMemberRel modle){


        if("update".equals(keyword)){
            fUserMemberRelService.updateByPrimaryKeySelective(modle);
        }else{
            fUserMemberRelService.insert(modle);
        }
        return "redirect:userMemberList?userId="+modle.getUserId();
    }

}