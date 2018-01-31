package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FContact;
import com.zheng.friend.dao.model.FContactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FContactMapper {
    long countByExample(FContactExample example);

    int deleteByExample(FContactExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FContact record);

    int insertSelective(FContact record);

    List<FContact> selectByExampleWithBLOBs(FContactExample example);

    List<FContact> selectByExample(FContactExample example);

    FContact selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FContact record, @Param("example") FContactExample example);

    int updateByExampleWithBLOBs(@Param("record") FContact record, @Param("example") FContactExample example);

    int updateByExample(@Param("record") FContact record, @Param("example") FContactExample example);

    int updateByPrimaryKeySelective(FContact record);

    int updateByPrimaryKeyWithBLOBs(FContact record);

    int updateByPrimaryKey(FContact record);
}