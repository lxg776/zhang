package com.zheng.cms.admin.controller.wx;

import com.github.pagehelper.util.StringUtil;
import com.zheng.cms.admin.controller.h5.IndexController;
import com.zheng.cms.admin.shiro.UpmsSessionDao;
import com.zheng.cms.admin.util.CommonUtil;
import com.zheng.cms.common.constant.FriendResult;
import com.zheng.cms.common.constant.FriendResultConstant;
import com.zheng.friend.dao.model.*;
import com.zheng.friend.rpc.api.*;
import com.zheng.ucenter.dao.model.UcenterUser;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/wx")
@Api(value = "用户控制器", description = "用户控制器")
public class WxUserServiceController {



    private static Logger _log = LoggerFactory.getLogger(IndexController.class);
    private int pageSize=15;


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

    @Autowired
    FUserImagesService fUserImagesService;

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









    private UcenterUser getUctenuser(String userName,HttpSession session){

        UcenterUser ucenterUser = (UcenterUser) session.getAttribute(userName);
        if(ucenterUser==null){
            ucenterUser	= ucenterUserService.selectUpmsUserByUsername(userName);
            ucenterUser.setPassword("");
        }
        session.setAttribute(userName,ucenterUser);
        return ucenterUser;
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


    /**
     * 填写个人资料
     * @return
     */
    @ApiOperation(value = "填写个人资料")
    @RequestMapping(value = "/txGrzl", method = RequestMethod.POST)
    @ResponseBody
    public Object txGrzl(FUserBaseMsg fUserBaseMsg,String avatar, String deletePhoto, String addPhoto, HttpServletRequest request, HttpSession session) {

        FriendResult result  = new FriendResult(FriendResultConstant.SUCCESS,null);
        String userName = (String) request.getAttribute("userName");

        UcenterUser ucenterUser = getUctenuser(userName,session);
        Integer userId = ucenterUser.getUserId();
        //删除相册图片
        if(StringUtil.isNotEmpty(deletePhoto)){
            String pathes[] = deletePhoto.split(",");
            if(pathes!=null){
                for(int i=0;i<pathes.length;i++){
                    String itemString = pathes[i];
                    FUserImagesExample example = new FUserImagesExample();
                    example.createCriteria().andUserIdEqualTo(ucenterUser.getUserId()).andImagePathEqualTo(itemString).andKeywordEqualTo("photo");
                    fUserImagesService.deleteByExample(example);
                }
            }
        }

        //添加相册图片
        if(StringUtil.isNotEmpty(addPhoto)){
            String pathes[] = addPhoto.split(",");
            if(pathes!=null){
                for(int i=0;i<pathes.length;i++){
                    String itemString = pathes[i];
                    FUserImages userImages =new FUserImages();
                    userImages.setImagePath(itemString);
                    userImages.setUserId(ucenterUser.getUserId());
                    userImages.setKeyword("photo");
                    fUserImagesService.insert(userImages);
                }
            }
        }



        if(StringUtil.isNotEmpty(avatar)){
            UcenterUser updateUcentUser = new UcenterUser();
            updateUcentUser.setUserId(ucenterUser.getUserId());
            updateUcentUser.setAvatar(avatar);
            ucenterUserService.updateByPrimaryKeySelective(updateUcentUser);
        }

        FUserBaseMsg queryObject = fUserBaseMsgService.selectByPrimaryKey(userId);
        if(queryObject!=null){
            fUserBaseMsg.setUserId(userId);
            fUserBaseMsgService.updateByPrimaryKeySelective(fUserBaseMsg);
        }else{
            fUserBaseMsg.setUserId(userId);
            fUserBaseMsgService.insert(fUserBaseMsg);
        }

        result.setMessage("修改成功!");

        return result;
    }


    public String getAgeRang(String age_min,String age_max){
        if("不限".equals(age_min)&&"不限".equals(age_max)){
            return "不限";
        }else if("不限".equals(age_min)){
            return age_max+"以下";
        }else if("不限".equals(age_max)){
            return age_min+"以上";
        }else{
            return  age_min+"~"+age_max;
        }

    }

    public String getHeiRang(String height_min, String height_max){
        if(("不限".equals(height_min)|| StringUtil.isEmpty(height_min))&&("不限".equals(height_max)||StringUtil.isEmpty(height_max))){
            return "不限";
        }else if("不限".equals(height_min)|| StringUtil.isEmpty(height_min)){
            return height_max +"以下";
        }else if("不限".equals(height_max)||StringUtil.isEmpty(height_max)){
            return height_min +"以上";
        }else{
            return  height_min +"~"+ height_max;
        }

    }



    /**
     * 编辑择偶条件
     * @return
     */
    @ApiOperation(value = "编辑择偶条件")
    @RequestMapping(value = "/editZobz", method = RequestMethod.POST)
    @ResponseBody
    public Object editZobz(FUserRequest fUserRequest,String age_min,String age_max,String height_min,String height_max,HttpServletRequest request,HttpSession session){

        FriendResult result  = new FriendResult(FriendResultConstant.SUCCESS,null);

        String username = (String) request.getAttribute("userName");
        UcenterUser ucenterUser = getUctenuser(username,session);
        Integer userId = ucenterUser.getUserId();

        FUserRequest queryObject = fUserRequestService.selectByPrimaryKey(userId);


        FCitiesExample fCitiesExample =new FCitiesExample();
        String fromCityId = fUserRequest.getFromCityId();
        fCitiesExample.createCriteria().andCityidEqualTo(fromCityId+"");
        FCities cities = fCitiesService.selectFirstByExample(fCitiesExample);

        if(cities!=null){
            fUserRequest.setFromCity(cities.getCity());
            //fUserRequest.setFromCityId(Integer.parseInt(cities.getCityid()));
        }


        FAreasExample fAreasExample =new FAreasExample();
        String fAreasId = fUserRequest.getFromAreaId();


        if(null==fAreasId||fAreasId.equals("0")){
            fUserRequest.setFromAreaId("0");
            fUserRequest.setFromArea("不限");
        }else{
            fAreasExample.createCriteria().andAreaidEqualTo(fAreasId+"");
            FAreas fAreas = fAreasService.selectFirstByExample(fAreasExample);
            if(fAreas!=null){
                fUserRequest.setFromArea(fAreas.getArea());
                fUserRequest.setFromAreaId(fAreasId);
            }
        }


        fUserRequest.setAge(getAgeRang(age_min,age_max));
        fUserRequest.setHeight(getHeiRang(height_min,height_max));

        if(queryObject!=null){
            fUserRequest.setUserId(userId);
            fUserRequestService.updateByPrimaryKeySelective(fUserRequest);
        }else{
            fUserRequest.setUserId(userId);
            fUserRequestService.insert(fUserRequest);
        }
        result.setMessage("修改成功");


        return result;
    }

    /**
     * 个人生活
     * @return
     */
    @ApiOperation(value = "个人生活")
    @RequestMapping(value = "/editShzk", method = RequestMethod.POST)
    @ResponseBody
    public Object editShzk( FUserLivingStatus modle, HttpServletRequest request,HttpSession session) {

        FriendResult result  = new FriendResult(FriendResultConstant.SUCCESS,null);

        String username = (String) request.getAttribute("userName");
        UcenterUser ucenterUser = getUctenuser(username,session);
        Integer userId = ucenterUser.getUserId();

        FUserLivingStatus queryObject = fUserLivingStatusService.selectByPrimaryKey(userId);
        if(queryObject!=null){
            modle.setUserId(userId);
            fUserLivingStatusService.updateByPrimaryKeySelective(modle);
        }else{
            modle.setUserId(userId);
            fUserLivingStatusService.insert(modle);
        }

        result.setMessage("修改完成");

        return CommonUtil.handResult(result,request);
    }











}
