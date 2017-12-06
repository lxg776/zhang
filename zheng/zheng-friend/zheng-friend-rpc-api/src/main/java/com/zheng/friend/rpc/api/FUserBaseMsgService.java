package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseService;
import com.zheng.friend.dao.model.FUserBaseMsg;
import com.zheng.friend.dao.model.FUserBaseMsgExample;
import com.zheng.friend.dao.vo.FUserMemberRelVo;
import com.zheng.friend.dao.vo.FuserDetailVo;

import java.util.List;

/**
* FUserBaseMsgService接口
* Created by shuzheng on 2017/11/18.
*/
public interface FUserBaseMsgService extends BaseService<FUserBaseMsg, FUserBaseMsgExample> {



    // 根据类目获取文章列表
    public FuserDetailVo selectFUserDetailVoByUserId(Integer userId);

}