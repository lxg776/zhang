package com.zheng.pay.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.support.dao.mapper.PayOutOrderMapper;
import com.zheng.support.dao.model.PayOutOrder;
import com.zheng.support.dao.model.PayOutOrderExample;

/**
* 降级实现PayOutOrderService接口
* Created by shuzheng on 2017/3/29.
*/
public class PayOutOrderServiceMock extends BaseServiceMock<PayOutOrderMapper, PayOutOrder, PayOutOrderExample> implements PayOutOrderService {

}
