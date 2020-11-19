package com.hbxy.ssm.app.repair.service.impl;

import com.hbxy.ssm.app.repair.mapper.RepairsMapper;
import com.hbxy.ssm.app.repair.model.Repairs;
import com.hbxy.ssm.app.repair.model.RepairsExample;
import com.hbxy.ssm.app.repair.service.RepairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RepairsServiceImpl implements RepairsService {
        @Autowired
        RepairsMapper mapper ;

    @Override
    public long countByExample(RepairsExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(RepairsExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String repairsId) {
        return mapper.deleteByPrimaryKey(repairsId);
    }

    @Override
    public int insert(Repairs record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Repairs record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Repairs> selectByExample(RepairsExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Repairs selectByPrimaryKey(String repairsId) {
        return mapper.selectByPrimaryKey(repairsId);
    }

    @Override
    public int updateByExampleSelective(Repairs record, RepairsExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Repairs record, RepairsExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Repairs record) {
        return updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Repairs record) {
        return updateByPrimaryKey(record);
    }
}
