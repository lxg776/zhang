package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FMemberType;
import com.zheng.friend.dao.model.FMemberTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FMemberTypeMapper {
    long countByExample(FMemberTypeExample example);

    int deleteByExample(FMemberTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FMemberType record);

    int insertSelective(FMemberType record);

    List<FMemberType> selectByExampleWithBLOBs(FMemberTypeExample example);

    List<FMemberType> selectByExample(FMemberTypeExample example);

    FMemberType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FMemberType record, @Param("example") FMemberTypeExample example);

    int updateByExampleWithBLOBs(@Param("record") FMemberType record, @Param("example") FMemberTypeExample example);

    int updateByExample(@Param("record") FMemberType record, @Param("example") FMemberTypeExample example);

    int updateByPrimaryKeySelective(FMemberType record);

    int updateByPrimaryKeyWithBLOBs(FMemberType record);

    int updateByPrimaryKey(FMemberType record);
}