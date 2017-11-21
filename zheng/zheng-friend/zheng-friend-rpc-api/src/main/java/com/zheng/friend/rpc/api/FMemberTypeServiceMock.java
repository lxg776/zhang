package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FMemberTypeMapper;
import com.zheng.friend.dao.model.FMemberType;
import com.zheng.friend.dao.model.FMemberTypeExample;

/**
* 降级实现FMemberTypeService接口
* Created by shuzheng on 2017/11/21.
*/
public class FMemberTypeServiceMock extends BaseServiceMock<FMemberTypeMapper, FMemberType, FMemberTypeExample> implements FMemberTypeService {

}
