package com.zheng.pay.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.support.dao.mapper.PayVestMapper;
import com.zheng.support.dao.model.PayVest;
import com.zheng.support.dao.model.PayVestExample;

/**
* 降级实现PayVestService接口
* Created by shuzheng on 2017/3/29.
*/
public class PayVestServiceMock extends BaseServiceMock<PayVestMapper, PayVest, PayVestExample> implements PayVestService {

}
