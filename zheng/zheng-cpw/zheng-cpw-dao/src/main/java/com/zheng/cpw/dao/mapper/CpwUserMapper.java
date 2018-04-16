package com.zheng.cpw.dao.mapper;

import com.zheng.cpw.dao.model.CpwUser;
import com.zheng.cpw.dao.model.CpwUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpwUserMapper {
    long countByExample(CpwUserExample example);

    int deleteByExample(CpwUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(CpwUser record);

    int insertSelective(CpwUser record);

    List<CpwUser> selectByExample(CpwUserExample example);

    CpwUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") CpwUser record, @Param("example") CpwUserExample example);

    int updateByExample(@Param("record") CpwUser record, @Param("example") CpwUserExample example);

    int updateByPrimaryKeySelective(CpwUser record);

    int updateByPrimaryKey(CpwUser record);
}