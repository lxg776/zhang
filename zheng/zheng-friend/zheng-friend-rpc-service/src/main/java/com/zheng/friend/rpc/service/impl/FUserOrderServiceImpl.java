package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FUserOrderMapper;
import com.zheng.friend.dao.model.FUserOrder;
import com.zheng.friend.dao.model.FUserOrderExample;
import com.zheng.friend.rpc.api.FUserOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* FUserOrderService实现
* Created by shuzheng on 2018/1/26.
*/
@Service
@Transactional
@BaseService
public class FUserOrderServiceImpl extends BaseServiceImpl<FUserOrderMapper, FUserOrder, FUserOrderExample> implements FUserOrderService {

    private static Logger _log = LoggerFactory.getLogger(FUserOrderServiceImpl.class);

    @Autowired
    FUserOrderMapper fUserOrderMapper;

}