package com.hbxy.ssm.app.repair.service.impl;

import com.hbxy.ssm.app.repair.mapper.RepairMapper;
import com.hbxy.ssm.app.repair.mapper.RepairsMapper;
import com.hbxy.ssm.app.repair.model.Repair;
import com.hbxy.ssm.app.repair.model.RepairExample;
import com.hbxy.ssm.app.repair.model.Repairs;
import com.hbxy.ssm.app.repair.model.RepairsExample;
import com.hbxy.ssm.app.repair.service.RepairService;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairMapper mapper;


    @Override
    public long countByExample(RepairExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(RepairExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer repairId) {
        return mapper.deleteByPrimaryKey(repairId);
    }

    @Override
    public int insert(Repair record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Repair record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Repair> selectByExample(RepairExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Repair selectByPrimaryKey(Integer repairId) {
        return mapper.selectByPrimaryKey(repairId);
    }

    @Override
    public int updateByExampleSelective(Repair record, RepairExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Repair record, RepairExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Repair record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Repair record) {
        return mapper.updateByPrimaryKey(record);
    }
}
