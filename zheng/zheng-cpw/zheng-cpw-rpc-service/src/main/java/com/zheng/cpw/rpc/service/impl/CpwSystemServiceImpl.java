package com.zheng.cpw.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.cpw.dao.mapper.CpwSystemMapper;
import com.zheng.cpw.dao.model.CpwSystem;
import com.zheng.cpw.dao.model.CpwSystemExample;
import com.zheng.cpw.rpc.api.CpwSystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CpwSystemService实现
* Created by shuzheng on 2018/4/15.
*/
@Service
@Transactional
@BaseService
public class CpwSystemServiceImpl extends BaseServiceImpl<CpwSystemMapper, CpwSystem, CpwSystemExample> implements CpwSystemService {

    private static Logger _log = LoggerFactory.getLogger(CpwSystemServiceImpl.class);

    @Autowired
    CpwSystemMapper cpwSystemMapper;

}