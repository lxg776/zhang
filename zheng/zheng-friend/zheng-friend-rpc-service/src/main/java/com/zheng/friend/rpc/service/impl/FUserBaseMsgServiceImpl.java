package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
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
        return fUserBaseMsgExtMapper.selectFUserDetailVoByUserId(userId);


    }

    @Override
    public List<FuserDetailVo> selectRecommendUsers(FuserDetailVo ucenterUser,Integer offset, Integer limit) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("modle", ucenterUser);
        map.put("offset", offset);
        map.put("limit", limit);
        return fUserBaseMsgExtMapper.selectRecommendUsers(map);
    }

    public  List<FUserViewRecordVo> selectViewRecordUsers(Integer userId){

        return fUserBaseMsgExtMapper.selectViewRecordUsers(userId);
    }
}