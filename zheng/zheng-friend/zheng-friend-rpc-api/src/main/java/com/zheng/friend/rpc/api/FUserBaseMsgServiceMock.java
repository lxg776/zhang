package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FUserBaseMsgMapper;
import com.zheng.friend.dao.model.FUserBaseMsg;
import com.zheng.friend.dao.model.FUserBaseMsgExample;
import com.zheng.friend.dao.vo.FuserDetailVo;

import java.util.List;

/**
* 降级实现FUserBaseMsgService接口
* Created by shuzheng on 2017/11/18.
*/
public class FUserBaseMsgServiceMock extends BaseServiceMock<FUserBaseMsgMapper, FUserBaseMsg, FUserBaseMsgExample> implements FUserBaseMsgService {

    @Override
    public FuserDetailVo selectFUserDetailVoByUserId(Integer userId) {
        return null;
    }

    @Override
    public List<FuserDetailVo> selectRecommendUsers(FuserDetailVo ucenterUser, Integer offset, Integer limit) {
        return null;
    }
}
