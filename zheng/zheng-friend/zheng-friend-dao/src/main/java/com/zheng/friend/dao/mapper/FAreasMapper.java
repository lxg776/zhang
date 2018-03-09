package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FAreas;
import com.zheng.friend.dao.model.FAreasExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FAreasMapper {
    long countByExample(FAreasExample example);

    int deleteByExample(FAreasExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FAreas record);

    int insertSelective(FAreas record);

    List<FAreas> selectByExample(FAreasExample example);

    FAreas selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FAreas record, @Param("example") FAreasExample example);

    int updateByExample(@Param("record") FAreas record, @Param("example") FAreasExample example);

    int updateByPrimaryKeySelective(FAreas record);

    int updateByPrimaryKey(FAreas record);
}