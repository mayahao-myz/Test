package com.hbxy.ssm.app.hydrselect.service.impl;

import com.hbxy.ssm.app.hydrselect.mapper.ApHydrSelectMapper;
import com.hbxy.ssm.app.hydrselect.model.ApHydrSelect;
import com.hbxy.ssm.app.hydrselect.model.ApHydrSelectExample;
import com.hbxy.ssm.app.hydrselect.service.ApHydrSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApHydrSelectServiceImpl implements ApHydrSelectService {
    @Autowired
    private  ApHydrSelectMapper mapper;
    @Override
    public long countByExample(ApHydrSelectExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ApHydrSelectExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer hydrId) {
        return mapper.deleteByPrimaryKey(hydrId);
    }

    @Override
    public int insert(ApHydrSelect record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(ApHydrSelect record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<ApHydrSelect> selectByExample(ApHydrSelectExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public ApHydrSelect selectByPrimaryKey(Integer hydrId) {
        return mapper.selectByPrimaryKey(hydrId);
    }

    @Override
    public int updateByExampleSelective(ApHydrSelect record, ApHydrSelectExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(ApHydrSelect record, ApHydrSelectExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ApHydrSelect record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ApHydrSelect record) {
        return mapper.updateByPrimaryKey(record);
    }
}
