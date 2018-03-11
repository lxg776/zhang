package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FMessageMapper;
import com.zheng.friend.dao.model.FMessage;
import com.zheng.friend.dao.model.FMessageExample;
import com.zheng.friend.dao.vo.RecentMsgVo;

import java.util.List;

/**
* 降级实现FMessageService接口
* Created by shuzheng on 2017/12/12.
*/
public class FMessageServiceMock extends BaseServiceMock<FMessageMapper, FMessage, FMessageExample> implements FMessageService {

    @Override
    public List<RecentMsgVo> selectRecentMsgByUser(Integer userId) {
        return null;
    }

    @Override
    public List<RecentMsgVo> selectMsgRecord(Integer fromUserId, Integer toUserId) {
        return null;
    }

    @Override
    public long selectunReadCountByUserId(Integer userId, byte state) {
        return 0;
    }
}
