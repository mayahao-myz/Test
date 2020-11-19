package com.hbxy.ssm.app.hydr.mapper;

import com.hbxy.ssm.app.hydr.model.ApHydr;
import com.hbxy.ssm.app.hydr.model.ApHydrExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ApHydrMapper {
    long countByExample(ApHydrExample example);

    int deleteByExample(ApHydrExample example);

    int deleteByPrimaryKey(Integer hydrId);

    int insert(ApHydr record);

    int insertSelective(ApHydr record);

    List<ApHydr> selectByExample(ApHydrExample example);

    ApHydr selectByPrimaryKey(Integer hydrId);

    int updateByExampleSelective(@Param("record") ApHydr record, @Param("example") ApHydrExample example);

    int updateByExample(@Param("record") ApHydr record, @Param("example") ApHydrExample example);

    int updateByPrimaryKeySelective(ApHydr record);

    int updateByPrimaryKey(ApHydr record);
}