package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FUserViewRecordMapper;
import com.zheng.friend.dao.model.FUserViewRecord;
import com.zheng.friend.dao.model.FUserViewRecordExample;

/**
* 降级实现FUserViewRecordService接口
* Created by shuzheng on 2017/12/10.
*/
public class FUserViewRecordServiceMock extends BaseServiceMock<FUserViewRecordMapper, FUserViewRecord, FUserViewRecordExample> implements FUserViewRecordService {

}
