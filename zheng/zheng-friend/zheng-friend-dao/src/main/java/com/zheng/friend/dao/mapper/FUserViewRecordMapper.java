package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FUserViewRecord;
import com.zheng.friend.dao.model.FUserViewRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FUserViewRecordMapper {
    long countByExample(FUserViewRecordExample example);

    int deleteByExample(FUserViewRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FUserViewRecord record);

    int insertSelective(FUserViewRecord record);

    List<FUserViewRecord> selectByExample(FUserViewRecordExample example);

    FUserViewRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FUserViewRecord record, @Param("example") FUserViewRecordExample example);

    int updateByExample(@Param("record") FUserViewRecord record, @Param("example") FUserViewRecordExample example);

    int updateByPrimaryKeySelective(FUserViewRecord record);

    int updateByPrimaryKey(FUserViewRecord record);
}