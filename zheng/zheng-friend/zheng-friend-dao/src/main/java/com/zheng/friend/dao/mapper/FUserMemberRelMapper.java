package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FUserMemberRel;
import com.zheng.friend.dao.model.FUserMemberRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FUserMemberRelMapper {
    long countByExample(FUserMemberRelExample example);

    int deleteByExample(FUserMemberRelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FUserMemberRel record);

    int insertSelective(FUserMemberRel record);

    List<FUserMemberRel> selectByExample(FUserMemberRelExample example);

    FUserMemberRel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FUserMemberRel record, @Param("example") FUserMemberRelExample example);

    int updateByExample(@Param("record") FUserMemberRel record, @Param("example") FUserMemberRelExample example);

    int updateByPrimaryKeySelective(FUserMemberRel record);

    int updateByPrimaryKey(FUserMemberRel record);
}