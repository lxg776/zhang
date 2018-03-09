package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FProvincesMapper;
import com.zheng.friend.dao.model.FProvinces;
import com.zheng.friend.dao.model.FProvincesExample;
import com.zheng.friend.rpc.api.FProvincesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* FProvincesService实现
* Created by shuzheng on 2018/3/8.
*/
@Service
@Transactional
@BaseService
public class FProvincesServiceImpl extends BaseServiceImpl<FProvincesMapper, FProvinces, FProvincesExample> implements FProvincesService {

    private static Logger _log = LoggerFactory.getLogger(FProvincesServiceImpl.class);

    @Autowired
    FProvincesMapper fProvincesMapper;

}