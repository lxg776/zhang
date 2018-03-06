package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FGreetingTemp;
import com.zheng.friend.dao.model.FGreetingTempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FGreetingTempMapper {
    long countByExample(FGreetingTempExample example);

    int deleteByExample(FGreetingTempExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FGreetingTemp record);

    int insertSelective(FGreetingTemp record);

    List<FGreetingTemp> selectByExample(FGreetingTempExample example);

    FGreetingTemp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FGreetingTemp record, @Param("example") FGreetingTempExample example);

    int updateByExample(@Param("record") FGreetingTemp record, @Param("example") FGreetingTempExample example);

    int updateByPrimaryKeySelective(FGreetingTemp record);

    int updateByPrimaryKey(FGreetingTemp record);
}