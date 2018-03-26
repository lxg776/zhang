package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FUserOrderMapper;
import com.zheng.friend.dao.model.FUserOrder;
import com.zheng.friend.dao.model.FUserOrderExample;
import com.zheng.friend.dao.vo.FOrderVo;

import java.util.List;

/**
* 降级实现FUserOrderService接口
* Created by shuzheng on 2018/1/26.
*/
public class FUserOrderServiceMock extends BaseServiceMock<FUserOrderMapper, FUserOrder, FUserOrderExample> implements FUserOrderService {

    @Override
    public List<FOrderVo> getOrderList(int pageNum, int pageSize) {
        return null;
    }

}
