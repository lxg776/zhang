package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FUserBaseMsg;
import com.zheng.friend.dao.model.FUserBaseMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FUserBaseMsgMapper {
    long countByExample(FUserBaseMsgExample example);

    int deleteByExample(FUserBaseMsgExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(FUserBaseMsg record);

    int insertSelective(FUserBaseMsg record);

    List<FUserBaseMsg> selectByExample(FUserBaseMsgExample example);

    FUserBaseMsg selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") FUserBaseMsg record, @Param("example") FUserBaseMsgExample example);

    int updateByExample(@Param("record") FUserBaseMsg record, @Param("example") FUserBaseMsgExample example);

    int updateByPrimaryKeySelective(FUserBaseMsg record);

    int updateByPrimaryKey(FUserBaseMsg record);
}