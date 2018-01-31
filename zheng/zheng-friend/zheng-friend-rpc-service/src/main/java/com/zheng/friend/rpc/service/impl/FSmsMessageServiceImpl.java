package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FSmsMessageMapper;
import com.zheng.friend.dao.model.FSmsMessage;
import com.zheng.friend.dao.model.FSmsMessageExample;
import com.zheng.friend.rpc.api.FSmsMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* FSmsMessageService实现
* Created by shuzheng on 2018/1/13.
*/
@Service
@Transactional
@BaseService
public class FSmsMessageServiceImpl extends BaseServiceImpl<FSmsMessageMapper, FSmsMessage, FSmsMessageExample> implements FSmsMessageService {

    private static Logger _log = LoggerFactory.getLogger(FSmsMessageServiceImpl.class);

    @Autowired
    FSmsMessageMapper fSmsMessageMapper;

}