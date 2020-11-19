package com.hbxy.ssm.app.dorm.service.impl;

import com.hbxy.ssm.app.dorm.mapper.DormMapper;
import com.hbxy.ssm.app.dorm.model.Dorm;
import com.hbxy.ssm.app.dorm.model.DormExample;
import com.hbxy.ssm.app.dorm.service.DormService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormServiceImpl implements DormService {

    @Autowired
    private DormMapper mapper;

    @Override
    public long countByExample(DormExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(DormExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String dormNo) {
        return mapper.deleteByPrimaryKey(dormNo);
    }

    @Override
    public int insert(Dorm record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Dorm record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Dorm> selectByExample(DormExample example) {
        return mapper.selectByExample(example);
    }

//    @Override
//    public Dorm selectByPrimaryKey(String dormNo) {
//        return mapper.selectByPrimaryKey(dormNo);
//    }

    //更新得有记录：record
    @Override
    public int updateByExampleSelective(Dorm record, DormExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Dorm record, DormExample example) {
        return mapper.updateByExample(record, example);
    }

//    @Override
//    public int updateByPrimaryKey(Dorm record) {
//        return mapper.updateByPrimaryKey(record);
//    }
//
//    @Override
//    public int updateByPrimaryKeySelective(Dorm record) {
//        return mapper.updateByPrimaryKeySelective(record) ;
//    }

}
