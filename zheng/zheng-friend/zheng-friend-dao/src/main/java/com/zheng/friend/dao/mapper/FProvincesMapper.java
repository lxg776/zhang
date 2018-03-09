package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FProvinces;
import com.zheng.friend.dao.model.FProvincesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FProvincesMapper {
    long countByExample(FProvincesExample example);

    int deleteByExample(FProvincesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FProvinces record);

    int insertSelective(FProvinces record);

    List<FProvinces> selectByExample(FProvincesExample example);

    FProvinces selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FProvinces record, @Param("example") FProvincesExample example);

    int updateByExample(@Param("record") FProvinces record, @Param("example") FProvincesExample example);

    int updateByPrimaryKeySelective(FProvinces record);

    int updateByPrimaryKey(FProvinces record);
}