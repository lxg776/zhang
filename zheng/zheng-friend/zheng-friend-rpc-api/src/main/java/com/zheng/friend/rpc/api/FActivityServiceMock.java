package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FActivityMapper;
import com.zheng.friend.dao.model.FActivity;
import com.zheng.friend.dao.model.FActivityExample;

/**
* 降级实现FActivityService接口
* Created by shuzheng on 2017/11/6.
*/
public class FActivityServiceMock extends BaseServiceMock<FActivityMapper, FActivity, FActivityExample> implements FActivityService {

}
