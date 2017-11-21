package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FUserRequest;
import com.zheng.friend.dao.model.FUserRequestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FUserRequestMapper {
    long countByExample(FUserRequestExample example);

    int deleteByExample(FUserRequestExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(FUserRequest record);

    int insertSelective(FUserRequest record);

    List<FUserRequest> selectByExample(FUserRequestExample example);

    FUserRequest selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") FUserRequest record, @Param("example") FUserRequestExample example);

    int updateByExample(@Param("record") FUserRequest record, @Param("example") FUserRequestExample example);

    int updateByPrimaryKeySelective(FUserRequest record);

    int updateByPrimaryKey(FUserRequest record);
}