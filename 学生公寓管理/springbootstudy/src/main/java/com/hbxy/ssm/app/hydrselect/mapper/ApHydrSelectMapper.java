package com.hbxy.ssm.app.hydrselect.mapper;

import com.hbxy.ssm.app.hydrselect.model.ApHydrSelect;
import com.hbxy.ssm.app.hydrselect.model.ApHydrSelectExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApHydrSelectMapper {
    long countByExample(ApHydrSelectExample example);

    int deleteByExample(ApHydrSelectExample example);

    int deleteByPrimaryKey(Integer hydrId);

    int insert(ApHydrSelect record);

    int insertSelective(ApHydrSelect record);

    List<ApHydrSelect> selectByExample(ApHydrSelectExample example);

    ApHydrSelect selectByPrimaryKey(Integer hydrId);

    int updateByExampleSelective(@Param("record") ApHydrSelect record, @Param("example") ApHydrSelectExample example);

    int updateByExample(@Param("record") ApHydrSelect record, @Param("example") ApHydrSelectExample example);

    int updateByPrimaryKeySelective(ApHydrSelect record);

    int updateByPrimaryKey(ApHydrSelect record);
}