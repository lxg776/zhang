package com.zheng.friend.dao.mapper;

import com.zheng.friend.dao.model.FUserSetting;
import com.zheng.friend.dao.model.FUserSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FUserSettingMapper {
    long countByExample(FUserSettingExample example);

    int deleteByExample(FUserSettingExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(FUserSetting record);

    int insertSelective(FUserSetting record);

    List<FUserSetting> selectByExample(FUserSettingExample example);

    FUserSetting selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") FUserSetting record, @Param("example") FUserSettingExample example);

    int updateByExample(@Param("record") FUserSetting record, @Param("example") FUserSettingExample example);

    int updateByPrimaryKeySelective(FUserSetting record);

    int updateByPrimaryKey(FUserSetting record);
}