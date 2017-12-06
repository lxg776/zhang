package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FUserBaseMsgMapper;
import com.zheng.friend.dao.model.FUserBaseMsg;
import com.zheng.friend.dao.model.FUserBaseMsgExample;
import com.zheng.friend.rpc.api.FUserBaseMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}