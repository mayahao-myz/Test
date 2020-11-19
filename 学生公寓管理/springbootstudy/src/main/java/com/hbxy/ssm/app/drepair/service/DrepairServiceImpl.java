package com.hbxy.ssm.app.drepair.service;

import com.hbxy.ssm.app.drepair.mapper.DrepairMapper;
import com.hbxy.ssm.app.drepair.model.Drepair;
import com.hbxy.ssm.app.drepair.model.DrepairExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrepairServiceImpl implements DrepairService{
    @Autowired
    private DrepairMapper mapper;
    @Override
    public long countByExample(DrepairExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(DrepairExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer drepairId) {
        return mapper.deleteByPrimaryKey(drepairId);
    }

    @Override
    public int insert(Drepair record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Drepair record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Drepair> selectByExample(DrepairExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Drepair selectByPrimaryKey(Integer drepairId) {
        return mapper.selectByPrimaryKey(drepairId);
    }

    @Override
    public int updateByExampleSelective(Drepair record, DrepairExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Drepair record, DrepairExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Drepair record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Drepair record) {
        return mapper.updateByPrimaryKey(record);
    }
}
