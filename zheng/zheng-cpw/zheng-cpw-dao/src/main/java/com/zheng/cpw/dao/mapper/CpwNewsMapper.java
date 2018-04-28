package com.zheng.cpw.dao.mapper;

import com.zheng.cpw.dao.model.CpwNews;
import com.zheng.cpw.dao.model.CpwNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpwNewsMapper {
    long countByExample(CpwNewsExample example);

    int deleteByExample(CpwNewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CpwNews record);

    int insertSelective(CpwNews record);

    List<CpwNews> selectByExampleWithBLOBs(CpwNewsExample example);

    List<CpwNews> selectByExample(CpwNewsExample example);

    CpwNews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CpwNews record, @Param("example") CpwNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") CpwNews record, @Param("example") CpwNewsExample example);

    int updateByExample(@Param("record") CpwNews record, @Param("example") CpwNewsExample example);

    int updateByPrimaryKeySelective(CpwNews record);

    int updateByPrimaryKeyWithBLOBs(CpwNews record);

    int updateByPrimaryKey(CpwNews record);
}