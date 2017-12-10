package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FUserViewRecordMapper;
import com.zheng.friend.dao.model.FUserViewRecord;
import com.zheng.friend.dao.model.FUserViewRecordExample;
import com.zheng.friend.rpc.api.FUserViewRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* FUserViewRecordService实现
* Created by shuzheng on 2017/12/10.
*/
@Service
@Transactional
@BaseService
public class FUserViewRecordServiceImpl extends BaseServiceImpl<FUserViewRecordMapper, FUserViewRecord, FUserViewRecordExample> implements FUserViewRecordService {

    private static Logger _log = LoggerFactory.getLogger(FUserViewRecordServiceImpl.class);

    @Autowired
    FUserViewRecordMapper fUserViewRecordMapper;

}