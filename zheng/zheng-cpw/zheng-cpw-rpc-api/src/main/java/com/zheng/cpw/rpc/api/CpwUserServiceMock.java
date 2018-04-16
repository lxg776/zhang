package com.zheng.cpw.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.cpw.dao.mapper.CpwUserMapper;
import com.zheng.cpw.dao.model.CpwUser;
import com.zheng.cpw.dao.model.CpwUserExample;

/**
* 降级实现CpwUserService接口
* Created by shuzheng on 2018/4/14.
*/
public class CpwUserServiceMock extends BaseServiceMock<CpwUserMapper, CpwUser, CpwUserExample> implements CpwUserService {

}
