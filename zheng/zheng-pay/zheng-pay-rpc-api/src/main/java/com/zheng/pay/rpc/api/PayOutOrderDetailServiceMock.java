package com.zheng.pay.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.pay.dao.mapper.PayOutOrderDetailMapper;
import com.zheng.pay.dao.model.PayOutOrderDetail;
import com.zheng.pay.dao.model.PayOutOrderDetailExample;

/**
* 降级实现PayOutOrderDetailService接口
* Created by shuzheng on 2018/1/16.
*/
public class PayOutOrderDetailServiceMock extends BaseServiceMock<PayOutOrderDetailMapper, PayOutOrderDetail, PayOutOrderDetailExample> implements PayOutOrderDetailService {

}
