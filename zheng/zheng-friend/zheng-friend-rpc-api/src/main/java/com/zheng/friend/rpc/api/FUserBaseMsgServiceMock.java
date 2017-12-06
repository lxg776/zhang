package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FUserBaseMsgMapper;
import com.zheng.friend.dao.model.FUserBaseMsg;
import com.zheng.friend.dao.model.FUserBaseMsgExample;

/**
* 降级实现FUserBaseMsgService接口
* Created by shuzheng on 2017/11/18.
*/
public class FUserBaseMsgServiceMock extends BaseServiceMock<FUserBaseMsgMapper, FUserBaseMsg, FUserBaseMsgExample> implements FUserBaseMsgService {

}