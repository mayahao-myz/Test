package com.hbxy.ssm.app.health.service;

import com.hbxy.ssm.app.health.mapper.HealthMapper;
import com.hbxy.ssm.app.health.model.Health;
import com.hbxy.ssm.app.health.model.HealthExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthServiceImpl implements HealthService {
    @Autowired
    private HealthMapper mapper;

    @Override
    public long countByExample(HealthExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(HealthExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer healthId) {
        return mapper.deleteByPrimaryKey(healthId);
    }

    @Override
    public int insert(Health record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Health record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Health> selectByExample(HealthExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Health selectByPrimaryKey(Integer healthId) {
        return mapper.selectByPrimaryKey(healthId);
    }

    @Override
    public int updateByExampleSelective(Health record, HealthExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Health record, HealthExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Health record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Health record) {
        return mapper.updateByPrimaryKey(record);
    }

}
