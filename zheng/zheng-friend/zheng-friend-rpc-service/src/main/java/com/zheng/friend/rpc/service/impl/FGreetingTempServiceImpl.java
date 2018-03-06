package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FGreetingTempMapper;
import com.zheng.friend.dao.model.FGreetingTemp;
import com.zheng.friend.dao.model.FGreetingTempExample;
import com.zheng.friend.rpc.api.FGreetingTempService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* FGreetingTempService实现
* Created by shuzheng on 2018/3/5.
*/
@Service
@Transactional
@BaseService
public class FGreetingTempServiceImpl extends BaseServiceImpl<FGreetingTempMapper, FGreetingTemp, FGreetingTempExample> implements FGreetingTempService {

    private static Logger _log = LoggerFactory.getLogger(FGreetingTempServiceImpl.class);

    @Autowired
    FGreetingTempMapper fGreetingTempMapper;

}