package com.hbxy.ssm.app.hydr.service;

import com.hbxy.ssm.app.hydr.model.ApHydr;
import com.hbxy.ssm.app.hydr.model.ApHydrExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApHyService {
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
