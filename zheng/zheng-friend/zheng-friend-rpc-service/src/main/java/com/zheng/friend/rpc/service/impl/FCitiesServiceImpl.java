package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FCitiesMapper;
import com.zheng.friend.dao.model.FCities;
import com.zheng.friend.dao.model.FCitiesExample;
import com.zheng.friend.rpc.api.FCitiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* FCitiesService实现
* Created by shuzheng on 2018/3/8.
*/
@Service
@Transactional
@BaseService
public class FCitiesServiceImpl extends BaseServiceImpl<FCitiesMapper, FCities, FCitiesExample> implements FCitiesService {

    private static Logger _log = LoggerFactory.getLogger(FCitiesServiceImpl.class);

    @Autowired
    FCitiesMapper fCitiesMapper;

}