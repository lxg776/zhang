package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FSmsMessageMapper;
import com.zheng.friend.dao.model.FSmsMessage;
import com.zheng.friend.dao.model.FSmsMessageExample;

/**
* 降级实现FSmsMessageService接口
* Created by shuzheng on 2018/1/13.
*/
public class FSmsMessageServiceMock extends BaseServiceMock<FSmsMessageMapper, FSmsMessage, FSmsMessageExample> implements FSmsMessageService {

}
