package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FCities;
import com.zheng.friend.dao.model.FCitiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FCitiesMapper {
    long countByExample(FCitiesExample example);

    int deleteByExample(FCitiesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FCities record);

    int insertSelective(FCities record);

    List<FCities> selectByExample(FCitiesExample example);

    FCities selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FCities record, @Param("example") FCitiesExample example);

    int updateByExample(@Param("record") FCities record, @Param("example") FCitiesExample example);

    int updateByPrimaryKeySelective(FCities record);

    int updateByPrimaryKey(FCities record);
}