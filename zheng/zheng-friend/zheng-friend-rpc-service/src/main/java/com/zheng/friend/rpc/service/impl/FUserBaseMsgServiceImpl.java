package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.common.util.StringUtil;
import com.zheng.friend.dao.mapper.FUserBaseMsgMapper;
import com.zheng.friend.dao.model.FUserBaseMsg;
import com.zheng.friend.dao.model.FUserBaseMsgExample;
import com.zheng.friend.dao.vo.FUserViewRecordVo;
import com.zheng.friend.dao.vo.FuserDetailVo;
import com.zheng.friend.rpc.api.FUserBaseMsgService;
import com.zheng.friend.rpc.mapper.FUserBaseMsgExtMapper;
import com.zheng.ucenter.dao.model.UcenterUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
* FUserBaseMsgService实现
* Created by shuzheng on 2017/11/18.
*/
@Service
@Transactional
@BaseService
public class FUserBaseMsgServiceImpl extends BaseServiceImpl<FUserBaseMsgMapper, FUserBaseMsg, FUserBaseMsgExample> implements FUserBaseMsgService {

    private static Logger _log = LoggerFactory.getLogger(FUserBaseMsgServiceImpl.class);

    @Autowired
    FUserBaseMsgMapper fUserBaseMsgMapper;
    @Autowired
    FUserBaseMsgExtMapper fUserBaseMsgExtMapper;
    @Override
    public FuserDetailVo selectFUserDetailVoByUserId(Integer userId) {

        FuserDetailVo vo =fUserBaseMsgExtMapper.selectFUserDetailVoByUserId(userId);

        if(null!=vo&&null!=vo.getfUserBaseMsg()){
            String brithDay = vo.getfUserBaseMsg().getBirthDate();
            if(com.github.pagehelper.util.StringUtil.isNotEmpty(brithDay)){
                String age = getAgeByString(brithDay,"");
                vo.setAge(age);
            }

        }
        return vo;
    }


    @Override
    public List<FuserDetailVo> queryUsers(  HashMap<String, Object> map,int offset,int pageSize) {



        //Integer offset = (pageNum-1)*pageSize;
        map.put("offset", offset);
        map.put("limit", pageSize);

        List<FuserDetailVo>  userList = fUserBaseMsgExtMapper.queryUsers(map);
        if(null!=userList&&userList.size()>0){
            for(FuserDetailVo vo:userList){
                if(null!=vo.getfUserBaseMsg()){
                    String brithDay = vo.getfUserBaseMsg().getBirthDate();
                    String age = getAgeByString(brithDay,"");
                    vo.setAge(age);
                }
            }

        }
        return userList;
    }

    @Override
    public Long queryUsersCount(HashMap<String, Object> map) {

        return fUserBaseMsgExtMapper.queryUsersCount(map);

    }


    @Override
    public List<FuserDetailVo> selectRecommendUsers(FuserDetailVo ucenterUser,Integer offset, Integer limit) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("modle", ucenterUser);
        map.put("offset", offset);
        map.put("limit", limit);

        List<FuserDetailVo>  userList = fUserBaseMsgExtMapper.selectRecommendUsers(map);
        if(null!=userList&&userList.size()>0){
            for(FuserDetailVo vo:userList){
                if(null!=vo.getfUserBaseMsg()){
                    String brithDay = vo.getfUserBaseMsg().getBirthDate();
                    String age = getAgeByString(brithDay,"");
                    vo.setAge(age);
                }
                if(null!=vo.getUcenterIdentificaion()&&null!=vo.getUcenterIdentificaion().getIdcardImgs()&&vo.getUcenterIdentificaion().getIdcardImgs().length()>0){
                    String [] imgs =  vo.getUcenterIdentificaion().getIdcardImgs().split(",");
                    vo.setIdcardImgs(imgs);
                }

            }

        }
        return userList;
    }

    public  List<FUserViewRecordVo> selectViewRecordUsers(Integer userId){


        List<FUserViewRecordVo>  userList = fUserBaseMsgExtMapper.selectViewRecordUsers(userId);
        if(null!=userList&&userList.size()>0){
            for(FUserViewRecordVo vo:userList){
                if(null!=vo.getFwUserBaseMsg()){
                    String brithDay = vo.getFwUserBaseMsg().getBirthDate();
                    String age = getAgeByString(brithDay,"");
                    vo.setAge(age);
                }
            }

        }

        return userList;
    }



    //根据字符串计算年龄
    public String getAgeByString(String strDate,String dateFormat){

        if(strDate==null){
            return "";
        }

        if(null==dateFormat||dateFormat.equals("")){
            dateFormat = "yyyy-MM-dd";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        Date birthDay = null;
        try {
            birthDay=sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int age = 0 ;

        if(birthDay!=null){
            Calendar cal = Calendar.getInstance();

            if (cal.before(birthDay)) {
                throw new IllegalArgumentException(
                        "The birthDay is before Now.It's unbelievable!");
            }
            int yearNow = cal.get(Calendar.YEAR);
            int monthNow = cal.get(Calendar.MONTH);
            int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
            cal.setTime(birthDay);

            int yearBirth = cal.get(Calendar.YEAR);
            int monthBirth = cal.get(Calendar.MONTH);
            int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

            age = yearNow - yearBirth;

            if (monthNow <= monthBirth) {
                if (monthNow == monthBirth) {
                    if (dayOfMonthNow < dayOfMonthBirth) age--;
                }else{
                    age--;
                }
            }
        }

        if(age==0){
            return "";
        }
        return age+"";

    }
}