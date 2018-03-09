package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FAreasMapper;
import com.zheng.friend.dao.model.FAreas;
import com.zheng.friend.dao.model.FAreasExample;

/**
* 降级实现FAreasService接口
* Created by shuzheng on 2018/3/8.
*/
public class FAreasServiceMock extends BaseServiceMock<FAreasMapper, FAreas, FAreasExample> implements FAreasService {

}
