package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zheng.friend.dao.mapper.FUserImagesMapper;
import com.zheng.friend.dao.model.FUserImages;
import com.zheng.friend.dao.model.FUserImagesExample;

/**
* 降级实现FUserImagesService接口
* Created by shuzheng on 2017/12/22.
*/
public class FUserImagesServiceMock extends BaseServiceMock<FUserImagesMapper, FUserImages, FUserImagesExample> implements FUserImagesService {

}
