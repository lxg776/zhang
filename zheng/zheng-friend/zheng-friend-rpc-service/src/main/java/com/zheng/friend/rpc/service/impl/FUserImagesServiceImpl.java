package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FUserImagesMapper;
import com.zheng.friend.dao.model.FUserImages;
import com.zheng.friend.dao.model.FUserImagesExample;
import com.zheng.friend.rpc.api.FUserImagesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* FUserImagesService实现
* Created by shuzheng on 2017/12/22.
*/
@Service
@Transactional
@BaseService
public class FUserImagesServiceImpl extends BaseServiceImpl<FUserImagesMapper, FUserImages, FUserImagesExample> implements FUserImagesService {

    private static Logger _log = LoggerFactory.getLogger(FUserImagesServiceImpl.class);

    @Autowired
    FUserImagesMapper fUserImagesMapper;

}