package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FUserLivingStatusMapper;
import com.zheng.friend.dao.model.FUserLivingStatus;
import com.zheng.friend.dao.model.FUserLivingStatusExample;
import com.zheng.friend.rpc.api.FUserLivingStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* FUserLivingStatusService实现
* Created by shuzheng on 2017/12/6.
*/
@Service
@Transactional
@BaseService
public class FUserLivingStatusServiceImpl extends BaseServiceImpl<FUserLivingStatusMapper, FUserLivingStatus, FUserLivingStatusExample> implements FUserLivingStatusService {

    private static Logger _log = LoggerFactory.getLogger(FUserLivingStatusServiceImpl.class);

    @Autowired
    FUserLivingStatusMapper fUserLivingStatusMapper;

}