package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FProvincesMapper;
import com.zheng.friend.dao.model.FProvinces;
import com.zheng.friend.dao.model.FProvincesExample;

/**
* 降级实现FProvincesService接口
* Created by shuzheng on 2018/3/8.
*/
public class FProvincesServiceMock extends BaseServiceMock<FProvincesMapper, FProvinces, FProvincesExample> implements FProvincesService {

}
