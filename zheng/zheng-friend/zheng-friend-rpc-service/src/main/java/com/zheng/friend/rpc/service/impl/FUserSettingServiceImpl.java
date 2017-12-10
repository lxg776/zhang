package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FUserSettingMapper;
import com.zheng.friend.dao.model.FUserSetting;
import com.zheng.friend.dao.model.FUserSettingExample;
import com.zheng.friend.rpc.api.FUserSettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* FUserSettingService实现
* Created by shuzheng on 2017/12/8.
*/
@Service
@Transactional
@BaseService
public class FUserSettingServiceImpl extends BaseServiceImpl<FUserSettingMapper, FUserSetting, FUserSettingExample> implements FUserSettingService {

    private static Logger _log = LoggerFactory.getLogger(FUserSettingServiceImpl.class);

    @Autowired
    FUserSettingMapper fUserSettingMapper;

}