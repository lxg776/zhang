package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FUserMemberRelMapper;
import com.zheng.friend.dao.model.FUserMemberRel;
import com.zheng.friend.dao.model.FUserMemberRelExample;
import com.zheng.friend.dao.vo.FUserMemberRelVo;
import com.zheng.friend.rpc.api.FUserMemberRelService;
import com.zheng.friend.rpc.mapper.FUserMemberRelExtMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* FUserMemberRelService实现
* Created by shuzheng on 2017/11/21.
*/
@Service
@Transactional
@BaseService
public class FUserMemberRelServiceImpl extends BaseServiceImpl<FUserMemberRelMapper, FUserMemberRel, FUserMemberRelExample> implements FUserMemberRelService {

    private static Logger _log = LoggerFactory.getLogger(FUserMemberRelServiceImpl.class);

    @Autowired
    FUserMemberRelMapper fUserMemberRelMapper;

    @Autowired
    FUserMemberRelExtMapper fUserMemberRelExtMapper;





    @Override
    public List<FUserMemberRelVo> selectFUserMemberRelVoByUserId(Integer userId) {
        return fUserMemberRelExtMapper.selectFUserMemberRelVoByUserId(userId);
    }
}