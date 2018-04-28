package com.zheng.cpw.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.cpw.dao.mapper.CpwNewsMapper;
import com.zheng.cpw.dao.model.CpwNews;
import com.zheng.cpw.dao.model.CpwNewsExample;

/**
* 降级实现CpwNewsService接口
* Created by shuzheng on 2018/4/25.
*/
public class CpwNewsServiceMock extends BaseServiceMock<CpwNewsMapper, CpwNews, CpwNewsExample> implements CpwNewsService {

}
