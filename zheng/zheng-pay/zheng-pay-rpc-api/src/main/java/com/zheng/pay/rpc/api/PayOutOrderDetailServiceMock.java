package com.zheng.pay.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.support.dao.mapper.PayOutOrderDetailMapper;
import com.zheng.support.dao.model.PayOutOrderDetail;
import com.zheng.support.dao.model.PayOutOrderDetailExample;

/**
* 降级实现PayOutOrderDetailService接口
* Created by shuzheng on 2017/3/29.
*/
public class PayOutOrderDetailServiceMock extends BaseServiceMock<PayOutOrderDetailMapper, PayOutOrderDetail, PayOutOrderDetailExample> implements PayOutOrderDetailService {

}
