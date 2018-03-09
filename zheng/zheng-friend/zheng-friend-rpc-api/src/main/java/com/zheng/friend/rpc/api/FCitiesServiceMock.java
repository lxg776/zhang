package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FCitiesMapper;
import com.zheng.friend.dao.model.FCities;
import com.zheng.friend.dao.model.FCitiesExample;

/**
* 降级实现FCitiesService接口
* Created by shuzheng on 2018/3/8.
*/
public class FCitiesServiceMock extends BaseServiceMock<FCitiesMapper, FCities, FCitiesExample> implements FCitiesService {

}
