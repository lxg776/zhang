package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FUserLivingStatusMapper;
import com.zheng.friend.dao.model.FUserLivingStatus;
import com.zheng.friend.dao.model.FUserLivingStatusExample;

/**
* 降级实现FUserLivingStatusService接口
* Created by shuzheng on 2017/12/6.
*/
public class FUserLivingStatusServiceMock extends BaseServiceMock<FUserLivingStatusMapper, FUserLivingStatus, FUserLivingStatusExample> implements FUserLivingStatusService {

}
