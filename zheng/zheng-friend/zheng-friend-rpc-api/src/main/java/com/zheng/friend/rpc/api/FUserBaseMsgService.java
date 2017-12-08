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



    /**
     * 根据用户id获取用户详情
     */
    public FuserDetailVo selectFUserDetailVoByUserId(Integer userId);

    /**
     * 根据用户获取推荐用户
      */
    public List<FuserDetailVo> selectRecommendUsers(FuserDetailVo ucenterUser,Integer offset, Integer limit);

}