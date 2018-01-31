package com.zheng.friend.rpc.mapper;


import com.zheng.friend.dao.vo.FContactVo;
import com.zheng.friend.dao.vo.RecentMsgVo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * 聊天记录VOMapper
 * Created by shuzheng on 2017/01/07.
 */
public interface FContactExtMapper {






    public List<FContactVo> getContactList(HashMap map);


    public FContactVo getContactById(Integer cid);

}