package com.zheng.cpw.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.cpw.dao.mapper.CpwNewsMapper;
import com.zheng.cpw.dao.model.CpwNews;
import com.zheng.cpw.dao.model.CpwNewsExample;
import com.zheng.cpw.rpc.api.CpwNewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CpwNewsService实现
* Created by shuzheng on 2018/4/25.
*/
@Service
@Transactional
@BaseService
public class CpwNewsServiceImpl extends BaseServiceImpl<CpwNewsMapper, CpwNews, CpwNewsExample> implements CpwNewsService {

    private static Logger _log = LoggerFactory.getLogger(CpwNewsServiceImpl.class);

    @Autowired
    CpwNewsMapper cpwNewsMapper;

}