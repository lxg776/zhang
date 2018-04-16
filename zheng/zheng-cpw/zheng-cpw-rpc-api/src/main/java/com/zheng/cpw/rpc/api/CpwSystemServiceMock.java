package com.zheng.cpw.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.cpw.dao.mapper.CpwSystemMapper;
import com.zheng.cpw.dao.model.CpwSystem;
import com.zheng.cpw.dao.model.CpwSystemExample;

/**
* 降级实现CpwSystemService接口
* Created by shuzheng on 2018/4/15.
*/
public class CpwSystemServiceMock extends BaseServiceMock<CpwSystemMapper, CpwSystem, CpwSystemExample> implements CpwSystemService {

}
