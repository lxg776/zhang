package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FActivity;
import com.zheng.friend.dao.model.FActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FActivityMapper {
    long countByExample(FActivityExample example);

    int deleteByExample(FActivityExample example);

    int deleteByPrimaryKey(Integer activityId);

    int insert(FActivity record);

    int insertSelective(FActivity record);

    List<FActivity> selectByExampleWithBLOBs(FActivityExample example);

    List<FActivity> selectByExample(FActivityExample example);

    FActivity selectByPrimaryKey(Integer activityId);

    int updateByExampleSelective(@Param("record") FActivity record, @Param("example") FActivityExample example);

    int updateByExampleWithBLOBs(@Param("record") FActivity record, @Param("example") FActivityExample example);

    int updateByExample(@Param("record") FActivity record, @Param("example") FActivityExample example);

    int updateByPrimaryKeySelective(FActivity record);

    int updateByPrimaryKeyWithBLOBs(FActivity record);

    int updateByPrimaryKey(FActivity record);
}