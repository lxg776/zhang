package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseService;
import com.zheng.friend.dao.model.FUserMemberRel;
import com.zheng.friend.dao.model.FUserMemberRelExample;
import com.zheng.friend.dao.vo.FUserMemberRelVo;

import java.util.List;

/**
* FUserMemberRelService接口
* Created by shuzheng on 2017/11/21.
*/
public interface FUserMemberRelService extends BaseService<FUserMemberRel, FUserMemberRelExample> {

    // 根据类目获取文章列表
    List<FUserMemberRelVo> selectFUserMemberRelVoByUserId(Integer userId);
}