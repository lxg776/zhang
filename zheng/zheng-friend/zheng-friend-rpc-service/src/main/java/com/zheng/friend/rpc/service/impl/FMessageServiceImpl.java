package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FMessageMapper;
import com.zheng.friend.dao.model.FMessage;
import com.zheng.friend.dao.model.FMessageExample;
import com.zheng.friend.dao.vo.FuserDetailVo;
import com.zheng.friend.dao.vo.RecentMsgVo;
import com.zheng.friend.rpc.api.FMessageService;
import com.zheng.friend.rpc.mapper.FMessageExtMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
* FMessageService实现
* Created by shuzheng on 2017/12/12.
*/
@Service
@Transactional
@BaseService
public class FMessageServiceImpl extends BaseServiceImpl<FMessageMapper, FMessage, FMessageExample> implements FMessageService {

    private static Logger _log = LoggerFactory.getLogger(FMessageServiceImpl.class);

    @Autowired
    FMessageMapper fMessageMapper;
    @Autowired
    FMessageExtMapper fMessageExtMapper;


    @Override
    public List<RecentMsgVo> selectRecentMsgByUser(Integer userId) {
        List<RecentMsgVo> msgList = fMessageExtMapper.selectRecentMsgByUser(userId);
        List<RecentMsgVo> returnList  = new ArrayList<>();
        Set<Integer> idsSet  = new HashSet();
        if(null!=msgList&&msgList.size()>0){
            for(RecentMsgVo item :msgList){
                if(!idsSet.contains(item.getFromUserId())){
                    idsSet.add(item.getFromUserId());
                    returnList.add(item);
                }
            }
        }else{
            return null;
        }

        if(null!=returnList&&returnList.size()>0){
            for(RecentMsgVo vo:returnList){
                if(null!=vo.getfUserBaseMsg()){
                    String brithDay = vo.getfUserBaseMsg().getBirthDate();
                    if(null!=brithDay&&!brithDay.equals("")){
                        String age = getAgeByString(brithDay,"");
                        vo.setAge(age);
                    }
                }
            }

        }


        return returnList;
    }

    @Override
    public List<RecentMsgVo> selectMsgRecord(Integer fromUserId, Integer toUserId) {
        HashMap<String,Object> map  = new HashMap<>();
        map.put("f_userId",fromUserId);
        map.put("t_userId",toUserId);
       return fMessageExtMapper.selectMsgRecord(map);

    }



    @Override
    public long selectunReadCountByUserId( Integer toUserId,byte state){

        FMessageExample messageExample =new FMessageExample();
        messageExample.createCriteria().andToUserIdEqualTo(toUserId).andMsgStateEqualTo(state);

        return fMessageMapper.countByExample(messageExample);
    }

    //根据字符串计算年龄
    public String getAgeByString(String strDate,String dateFormat){

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