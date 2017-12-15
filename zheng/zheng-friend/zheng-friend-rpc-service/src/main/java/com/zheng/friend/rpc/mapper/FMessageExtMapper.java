package com.zheng.friend.rpc.mapper;


import com.zheng.friend.dao.model.FUserViewRecord;
import com.zheng.friend.dao.vo.FuserDetailVo;
import com.zheng.friend.dao.vo.RecentMsgVo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * 聊天记录VOMapper
 * Created by shuzheng on 2017/01/07.
 */
public interface FMessageExtMapper {





    public List<RecentMsgVo> selectRecentMsgByUser(@Param("userId") Integer userId);

    public List<RecentMsgVo> selectMsgRecord(HashMap map);

}