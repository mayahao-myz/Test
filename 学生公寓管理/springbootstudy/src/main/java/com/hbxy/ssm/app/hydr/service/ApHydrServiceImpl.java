package com.hbxy.ssm.app.hydr.service;

import com.hbxy.ssm.app.hydr.mapper.ApHydrMapper;
import com.hbxy.ssm.app.hydr.model.ApHydr;
import com.hbxy.ssm.app.hydr.model.ApHydrExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApHydrServiceImpl implements ApHyService{
    @Autowired
    private ApHydrMapper mapper;
    @Override
    public long countByExample(ApHydrExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ApHydrExample example) {
        return  mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer hydrId) {
        return mapper.deleteByPrimaryKey(hydrId);
    }

    @Override
    public int insert(ApHydr record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(ApHydr record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<ApHydr> selectByExample(ApHydrExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public ApHydr selectByPrimaryKey(Integer hydrId) {
        return mapper.selectByPrimaryKey(hydrId);
    }

    @Override
    public int updateByExampleSelective(ApHydr record, ApHydrExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(ApHydr record, ApHydrExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ApHydr record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ApHydr record) {
        return mapper.updateByPrimaryKey(record);
    }
}
