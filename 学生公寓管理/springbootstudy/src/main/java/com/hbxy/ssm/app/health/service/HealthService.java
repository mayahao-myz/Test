package com.hbxy.ssm.app.health.service;

import com.hbxy.ssm.app.health.model.Health;
import com.hbxy.ssm.app.health.model.HealthExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface HealthService {
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
