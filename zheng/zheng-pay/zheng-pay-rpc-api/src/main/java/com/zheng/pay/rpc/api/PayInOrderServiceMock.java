package com.zheng.pay.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.support.dao.mapper.PayInOrderMapper;
import com.zheng.support.dao.model.PayInOrder;
import com.zheng.support.dao.model.PayInOrderExample;

/**
* 降级实现PayInOrderService接口
* Created by shuzheng on 2017/3/29.
*/
public class PayInOrderServiceMock extends BaseServiceMock<PayInOrderMapper, PayInOrder, PayInOrderExample> implements PayInOrderService {

}
