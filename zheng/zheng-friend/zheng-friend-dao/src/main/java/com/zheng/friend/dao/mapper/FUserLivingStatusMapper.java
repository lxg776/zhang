package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FUserLivingStatus;
import com.zheng.friend.dao.model.FUserLivingStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FUserLivingStatusMapper {
    long countByExample(FUserLivingStatusExample example);

    int deleteByExample(FUserLivingStatusExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(FUserLivingStatus record);

    int insertSelective(FUserLivingStatus record);

    List<FUserLivingStatus> selectByExample(FUserLivingStatusExample example);

    FUserLivingStatus selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") FUserLivingStatus record, @Param("example") FUserLivingStatusExample example);

    int updateByExample(@Param("record") FUserLivingStatus record, @Param("example") FUserLivingStatusExample example);

    int updateByPrimaryKeySelective(FUserLivingStatus record);

    int updateByPrimaryKey(FUserLivingStatus record);
}