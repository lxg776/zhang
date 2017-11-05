package com.zheng.pay.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.support.dao.mapper.PayVendorMapper;
import com.zheng.support.dao.model.PayVendor;
import com.zheng.support.dao.model.PayVendorExample;

/**
* 降级实现PayVendorService接口
* Created by shuzheng on 2017/3/29.
*/
public class PayVendorServiceMock extends BaseServiceMock<PayVendorMapper, PayVendor, PayVendorExample> implements PayVendorService {

}
