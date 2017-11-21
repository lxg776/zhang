package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FMemberTypeMapper;
import com.zheng.friend.dao.model.FMemberType;
import com.zheng.friend.dao.model.FMemberTypeExample;
import com.zheng.friend.rpc.api.FMemberTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* FMemberTypeService实现
* Created by shuzheng on 2017/11/21.
*/
@Service
@Transactional
@BaseService
public class FMemberTypeServiceImpl extends BaseServiceImpl<FMemberTypeMapper, FMemberType, FMemberTypeExample> implements FMemberTypeService {

    private static Logger _log = LoggerFactory.getLogger(FMemberTypeServiceImpl.class);

    @Autowired
    FMemberTypeMapper fMemberTypeMapper;

}