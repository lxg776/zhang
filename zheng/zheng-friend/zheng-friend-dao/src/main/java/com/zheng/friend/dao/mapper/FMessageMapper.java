package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FMessage;
import com.zheng.friend.dao.model.FMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FMessageMapper {
    long countByExample(FMessageExample example);

    int deleteByExample(FMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FMessage record);

    int insertSelective(FMessage record);

    List<FMessage> selectByExample(FMessageExample example);

    FMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FMessage record, @Param("example") FMessageExample example);

    int updateByExample(@Param("record") FMessage record, @Param("example") FMessageExample example);

    int updateByPrimaryKeySelective(FMessage record);

    int updateByPrimaryKey(FMessage record);
}