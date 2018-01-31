package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FContactMapper;
import com.zheng.friend.dao.model.FContact;
import com.zheng.friend.dao.model.FContactExample;
import com.zheng.friend.dao.vo.FContactVo;

import java.util.List;

/**
* 降级实现FContactService接口
* Created by shuzheng on 2018/1/27.
*/
public class FContactServiceMock extends BaseServiceMock<FContactMapper, FContact, FContactExample> implements FContactService {


    @Override
    public List<FContactVo> getContactList(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public FContactVo getContactById(Integer cid) {
        return null;
    }
}
