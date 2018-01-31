package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FUserOrderMapper;
import com.zheng.friend.dao.model.FUserOrder;
import com.zheng.friend.dao.model.FUserOrderExample;

/**
* 降级实现FUserOrderService接口
* Created by shuzheng on 2018/1/26.
*/
public class FUserOrderServiceMock extends BaseServiceMock<FUserOrderMapper, FUserOrder, FUserOrderExample> implements FUserOrderService {

}
