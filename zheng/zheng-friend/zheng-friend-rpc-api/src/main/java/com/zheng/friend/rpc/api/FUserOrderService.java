package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseService;
import com.zheng.friend.dao.model.FUserOrder;
import com.zheng.friend.dao.model.FUserOrderExample;
import com.zheng.friend.dao.vo.FOrderVo;

import java.util.List;

/**
* FUserOrderService接口
* Created by shuzheng on 2018/1/26.
*/
public interface FUserOrderService extends BaseService<FUserOrder, FUserOrderExample> {

    public List<FOrderVo> getOrderList(int pageNum, int pageSize);

}