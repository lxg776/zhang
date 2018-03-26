package com.zheng.friend.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.friend.dao.mapper.FUserOrderMapper;
import com.zheng.friend.dao.model.FUserOrder;
import com.zheng.friend.dao.model.FUserOrderExample;
import com.zheng.friend.dao.vo.FOrderVo;
import com.zheng.friend.rpc.api.FUserOrderService;
import com.zheng.friend.rpc.mapper.FUserOrderExtMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

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

    @Autowired
    FUserOrderExtMapper fUserOrderExtMapper;

    public List<FOrderVo> getOrderList(int pageNum,int pageSize){
        if(pageNum<1){
            pageNum=1;
        }
        HashMap<String,Object> map = new HashMap<>();
        int offset = (pageNum-1)*pageSize;
        int limit = pageSize;
        map.put("offset",offset);
        map.put("limit",limit);
        List<FOrderVo> list = fUserOrderExtMapper.getOrderList(map);
        return list;
    }

}