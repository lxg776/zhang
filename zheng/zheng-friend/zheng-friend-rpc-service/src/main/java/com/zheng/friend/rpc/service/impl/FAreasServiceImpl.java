package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FAreasMapper;
import com.zheng.friend.dao.model.FAreas;
import com.zheng.friend.dao.model.FAreasExample;
import com.zheng.friend.rpc.api.FAreasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* FAreasService实现
* Created by shuzheng on 2018/3/8.
*/
@Service
@Transactional
@BaseService
public class FAreasServiceImpl extends BaseServiceImpl<FAreasMapper, FAreas, FAreasExample> implements FAreasService {

    private static Logger _log = LoggerFactory.getLogger(FAreasServiceImpl.class);

    @Autowired
    FAreasMapper fAreasMapper;

}