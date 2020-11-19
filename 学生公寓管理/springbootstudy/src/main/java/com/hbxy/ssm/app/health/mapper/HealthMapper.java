package com.hbxy.ssm.app.health.mapper;

import com.hbxy.ssm.app.health.model.Health;
import com.hbxy.ssm.app.health.model.HealthExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HealthMapper {
    long countByExample(HealthExample example);

    int deleteByExample(HealthExample example);

    int deleteByPrimaryKey(Integer healthId);

    int insert(Health record);

    int insertSelective(Health record);

    List<Health> selectByExample(HealthExample example);

    Health selectByPrimaryKey(Integer healthId);

    int updateByExampleSelective(@Param("record") Health record, @Param("example") HealthExample example);

    int updateByExample(@Param("record") Health record, @Param("example") HealthExample example);

    int updateByPrimaryKeySelective(Health record);

    int updateByPrimaryKey(Health record);
}