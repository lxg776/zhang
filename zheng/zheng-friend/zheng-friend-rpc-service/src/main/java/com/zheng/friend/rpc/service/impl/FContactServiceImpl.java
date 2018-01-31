package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FContactMapper;
import com.zheng.friend.dao.model.FContact;
import com.zheng.friend.dao.model.FContactExample;
import com.zheng.friend.dao.vo.FContactVo;
import com.zheng.friend.rpc.api.FContactService;
import com.zheng.friend.rpc.mapper.FContactExtMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
* FContactService实现
* Created by shuzheng on 2018/1/27.
*/
@Service
@Transactional
@BaseService
public class FContactServiceImpl extends BaseServiceImpl<FContactMapper, FContact, FContactExample> implements FContactService {

    private static Logger _log = LoggerFactory.getLogger(FContactServiceImpl.class);

    @Autowired
    FContactMapper fContactMapper;

    @Autowired
    FContactExtMapper fContactExtMapper;

    @Override
    public List<FContactVo> getContactList(Integer pageNum, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        int offset = (pageNum-1)*pageSize;
        map.put("offset", offset);
        map.put("limit", pageSize);
        return fContactExtMapper.getContactList(map);
    }

    @Override
    public FContactVo getContactById(Integer cid) {

        return fContactExtMapper.getContactById(cid);

    }
}