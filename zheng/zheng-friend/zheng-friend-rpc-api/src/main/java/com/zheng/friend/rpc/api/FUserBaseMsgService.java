package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseService;
import com.zheng.friend.dao.model.FUserBaseMsg;
import com.zheng.friend.dao.model.FUserBaseMsgExample;
import com.zheng.friend.dao.vo.FUserMemberRelVo;
import com.zheng.friend.dao.vo.FUserViewRecordVo;
import com.zheng.friend.dao.vo.FuserDetailVo;

import java.util.HashMap;
import java.util.List;

/**
* FUserBaseMsgService接口
* Created by shuzheng on 2017/11/18.
*/
public interface FUserBaseMsgService extends BaseService<FUserBaseMsg, FUserBaseMsgExample> {




    /**
     * 选择访问记录
     */
    public  List<FUserViewRecordVo> selectViewRecordUsers(Integer userId);

    /**
     * 根据用户id获取用户详情
     */
    public FuserDetailVo selectFUserDetailVoByUserId(Integer userId);

    /**
     * 根据用户获取推荐用户
      */
    public List<FuserDetailVo> selectRecommendUsers(FuserDetailVo modle,Integer offset, Integer limit);


    /**
     * 查询用户
     */
    public List<FuserDetailVo> queryUsers(HashMap<String, Object> map, int offset, int pageSize);



    public Long queryUsersCount(HashMap<String,Object> map);

}