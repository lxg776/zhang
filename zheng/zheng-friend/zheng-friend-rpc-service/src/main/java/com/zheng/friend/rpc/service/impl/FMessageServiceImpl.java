package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FMessageMapper;
import com.zheng.friend.dao.model.FMessage;
import com.zheng.friend.dao.model.FMessageExample;
import com.zheng.friend.dao.vo.RecentMsgVo;
import com.zheng.friend.rpc.api.FMessageService;
import com.zheng.friend.rpc.mapper.FMessageExtMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}