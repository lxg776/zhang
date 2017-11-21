package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FUserRequestMapper;
import com.zheng.friend.dao.model.FUserRequest;
import com.zheng.friend.dao.model.FUserRequestExample;

/**
* 降级实现FUserRequestService接口
* Created by shuzheng on 2017/11/19.
*/
public class FUserRequestServiceMock extends BaseServiceMock<FUserRequestMapper, FUserRequest, FUserRequestExample> implements FUserRequestService {

}
