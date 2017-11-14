package com.zheng.ucenter.dao.mapper;

import com.zheng.ucenter.dao.model.UcenterIdentificaion;
import com.zheng.ucenter.dao.model.UcenterIdentificaionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcenterIdentificaionMapper {
    long countByExample(UcenterIdentificaionExample example);

    int deleteByExample(UcenterIdentificaionExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UcenterIdentificaion record);

    int insertSelective(UcenterIdentificaion record);

    List<UcenterIdentificaion> selectByExample(UcenterIdentificaionExample example);

    UcenterIdentificaion selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UcenterIdentificaion record, @Param("example") UcenterIdentificaionExample example);

    int updateByExample(@Param("record") UcenterIdentificaion record, @Param("example") UcenterIdentificaionExample example);

    int updateByPrimaryKeySelective(UcenterIdentificaion record);

    int updateByPrimaryKey(UcenterIdentificaion record);
}