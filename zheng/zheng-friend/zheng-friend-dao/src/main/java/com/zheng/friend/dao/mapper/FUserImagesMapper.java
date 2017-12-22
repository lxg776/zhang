package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FUserImages;
import com.zheng.friend.dao.model.FUserImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FUserImagesMapper {
    long countByExample(FUserImagesExample example);

    int deleteByExample(FUserImagesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FUserImages record);

    int insertSelective(FUserImages record);

    List<FUserImages> selectByExample(FUserImagesExample example);

    FUserImages selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FUserImages record, @Param("example") FUserImagesExample example);

    int updateByExample(@Param("record") FUserImages record, @Param("example") FUserImagesExample example);

    int updateByPrimaryKeySelective(FUserImages record);

    int updateByPrimaryKey(FUserImages record);
}