package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseService;
import com.zheng.friend.dao.model.FMessage;
import com.zheng.friend.dao.model.FMessageExample;
import com.zheng.friend.dao.vo.RecentMsgVo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
* FMessageService接口
* Created by shuzheng on 2017/12/12.
*/
public interface FMessageService extends BaseService<FMessage, FMessageExample> {

    public List<RecentMsgVo> selectRecentMsgByUser(@Param("userId") Integer userId);

    public List<RecentMsgVo> selectMsgRecord(@Param("fromUserId") Integer fromUserId,@Param("toUserId") Integer toUserId);
}