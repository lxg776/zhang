package com.zheng.ucenter.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.ucenter.dao.mapper.UcenterUserMapper;
import com.zheng.ucenter.dao.model.UcenterUser;
import com.zheng.ucenter.dao.model.UcenterUserExample;
import com.zheng.ucenter.rpc.api.UcenterUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* UcenterUserService实现
* Created by shuzheng on 2017/4/27.
*/
@Service
@Transactional
@BaseService
public class UcenterUserServiceImpl extends BaseServiceImpl<UcenterUserMapper, UcenterUser, UcenterUserExample> implements UcenterUserService {

    private static Logger _log = LoggerFactory.getLogger(UcenterUserServiceImpl.class);

    @Autowired
    UcenterUserMapper ucenterUserMapper;

    @Override
    public UcenterUser selectUpmsUserByUsername(String username) {

        UcenterUserExample uenterUserExample = new UcenterUserExample();
        uenterUserExample.createCriteria().andUserNameEqualTo(username);

        List<UcenterUser> ucenterUsers = ucenterUserMapper.selectByExample(uenterUserExample);
        if (null !=  ucenterUsers &&  ucenterUsers.size() > 0) {
            return  ucenterUsers.get(0);
        }
        return null;
    }
}