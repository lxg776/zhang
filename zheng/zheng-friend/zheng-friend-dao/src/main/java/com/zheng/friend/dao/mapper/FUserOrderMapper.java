package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FUserOrder;
import com.zheng.friend.dao.model.FUserOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FUserOrderMapper {
    long countByExample(FUserOrderExample example);

    int deleteByExample(FUserOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FUserOrder record);

    int insertSelective(FUserOrder record);

    List<FUserOrder> selectByExample(FUserOrderExample example);

    FUserOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FUserOrder record, @Param("example") FUserOrderExample example);

    int updateByExample(@Param("record") FUserOrder record, @Param("example") FUserOrderExample example);

    int updateByPrimaryKeySelective(FUserOrder record);

    int updateByPrimaryKey(FUserOrder record);
}