package com.zheng.cpw.dao.mapper;

import com.zheng.cpw.dao.model.CpwSystem;
import com.zheng.cpw.dao.model.CpwSystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpwSystemMapper {
    long countByExample(CpwSystemExample example);

    int deleteByExample(CpwSystemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CpwSystem record);

    int insertSelective(CpwSystem record);

    List<CpwSystem> selectByExample(CpwSystemExample example);

    CpwSystem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CpwSystem record, @Param("example") CpwSystemExample example);

    int updateByExample(@Param("record") CpwSystem record, @Param("example") CpwSystemExample example);

    int updateByPrimaryKeySelective(CpwSystem record);

    int updateByPrimaryKey(CpwSystem record);
}