package com.zheng.cpw.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.cpw.dao.mapper.CpwUserMapper;
import com.zheng.cpw.dao.model.CpwUser;
import com.zheng.cpw.dao.model.CpwUserExample;
import com.zheng.cpw.rpc.api.CpwUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CpwUserService实现
* Created by shuzheng on 2018/4/14.
*/
@Service
@Transactional
@BaseService
public class CpwUserServiceImpl extends BaseServiceImpl<CpwUserMapper, CpwUser, CpwUserExample> implements CpwUserService {

    private static Logger _log = LoggerFactory.getLogger(CpwUserServiceImpl.class);


}