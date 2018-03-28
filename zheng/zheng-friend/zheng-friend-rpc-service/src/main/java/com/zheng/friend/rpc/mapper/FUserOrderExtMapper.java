package com.zheng.friend.rpc.mapper;

import com.zheng.friend.dao.vo.FOrderVo;
import java.util.HashMap;
import java.util.List;

/**
 * 聊天记录VOMapper
 * Created by shuzheng on 2017/01/07.
 */
public interface FUserOrderExtMapper {






    public List<FOrderVo> getOrderList(HashMap map);


    public long getOrderListCount(HashMap map);


}