package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FActivityMapper;
import com.zheng.friend.dao.model.FActivity;
import com.zheng.friend.dao.model.FActivityExample;
import com.zheng.friend.rpc.api.FActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* FActivityService实现
* Created by shuzheng on 2017/11/6.
*/
@Service
@Transactional
@BaseService
public class FActivityServiceImpl extends BaseServiceImpl<FActivityMapper, FActivity, FActivityExample> implements FActivityService {

    private static Logger _log = LoggerFactory.getLogger(FActivityServiceImpl.class);

    @Autowired
    FActivityMapper fActivityMapper;

}