package com.zheng.ucenter.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.ucenter.dao.mapper.UcenterIdentificaionMapper;
import com.zheng.ucenter.dao.model.UcenterIdentificaion;
import com.zheng.ucenter.dao.model.UcenterIdentificaionExample;
import com.zheng.ucenter.rpc.api.UcenterIdentificaionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UcenterIdentificaionService实现
* Created by shuzheng on 2017/11/13.
*/
@Service
@Transactional
@BaseService
public class UcenterIdentificaionServiceImpl extends BaseServiceImpl<UcenterIdentificaionMapper, UcenterIdentificaion, UcenterIdentificaionExample> implements UcenterIdentificaionService {

    private static Logger _log = LoggerFactory.getLogger(UcenterIdentificaionServiceImpl.class);

    @Autowired
    UcenterIdentificaionMapper ucenterIdentificaionMapper;

}