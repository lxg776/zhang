package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FUserMemberRelMapper;
import com.zheng.friend.dao.model.FUserMemberRel;
import com.zheng.friend.dao.model.FUserMemberRelExample;
import com.zheng.friend.dao.vo.FUserMemberRelVo;

import java.util.List;

/**
* 降级实现FUserMemberRelService接口
* Created by shuzheng on 2017/11/21.
*/
public class FUserMemberRelServiceMock extends BaseServiceMock<FUserMemberRelMapper, FUserMemberRel, FUserMemberRelExample> implements FUserMemberRelService {


    @Override
    public List<FUserMemberRelVo> selectFUserMemberRelVoByUserId(Integer userId) {
        return null;
    }
}
