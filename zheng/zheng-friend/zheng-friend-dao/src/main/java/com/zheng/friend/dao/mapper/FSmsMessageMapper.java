package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FSmsMessage;
import com.zheng.friend.dao.model.FSmsMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FSmsMessageMapper {
    long countByExample(FSmsMessageExample example);

    int deleteByExample(FSmsMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FSmsMessage record);

    int insertSelective(FSmsMessage record);

    List<FSmsMessage> selectByExample(FSmsMessageExample example);

    FSmsMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FSmsMessage record, @Param("example") FSmsMessageExample example);

    int updateByExample(@Param("record") FSmsMessage record, @Param("example") FSmsMessageExample example);

    int updateByPrimaryKeySelective(FSmsMessage record);

    int updateByPrimaryKey(FSmsMessage record);
}