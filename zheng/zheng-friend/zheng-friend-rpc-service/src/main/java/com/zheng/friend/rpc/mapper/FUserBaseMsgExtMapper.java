package com.zheng.friend.rpc.mapper;


import com.zheng.friend.dao.vo.FUserMemberRelVo;
import com.zheng.friend.dao.vo.FuserDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章VOMapper
 * Created by shuzheng on 2017/01/07.
 */
public interface FUserBaseMsgExtMapper {



    public FuserDetailVo selectFUserDetailVoByUserId(@Param("userId") Integer userId);



}