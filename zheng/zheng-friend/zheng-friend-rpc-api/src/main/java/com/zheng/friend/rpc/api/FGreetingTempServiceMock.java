package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FGreetingTempMapper;
import com.zheng.friend.dao.model.FGreetingTemp;
import com.zheng.friend.dao.model.FGreetingTempExample;

/**
* 降级实现FGreetingTempService接口
* Created by shuzheng on 2018/3/5.
*/
public class FGreetingTempServiceMock extends BaseServiceMock<FGreetingTempMapper, FGreetingTemp, FGreetingTempExample> implements FGreetingTempService {

}
