package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FUserSettingMapper;
import com.zheng.friend.dao.model.FUserSetting;
import com.zheng.friend.dao.model.FUserSettingExample;

/**
* 降级实现FUserSettingService接口
* Created by shuzheng on 2017/12/8.
*/
public class FUserSettingServiceMock extends BaseServiceMock<FUserSettingMapper, FUserSetting, FUserSettingExample> implements FUserSettingService {

}
