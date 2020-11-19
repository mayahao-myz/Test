package com.hbxy.ssm.app.studentquery.service.impl;

import com.hbxy.ssm.app.studentquery.mapper.StudentQueryMapper;
import com.hbxy.ssm.app.studentquery.model.StudentQuery;
import com.hbxy.ssm.app.studentquery.model.StudentQueryExample;
import com.hbxy.ssm.app.studentquery.service.StudentQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.awt.image.ImageAccessException;

import java.util.List;

@Service
public class StudentQueryServiceImpl implements StudentQueryService {

    @Autowired
    private StudentQueryMapper mapper;

    @Override
    public long countByExample(StudentQueryExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(StudentQueryExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer stuNo) {
        return mapper.deleteByPrimaryKey(stuNo);
    }

    @Override
    public int insert(StudentQuery record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(StudentQuery record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<StudentQuery> selectByExample(StudentQueryExample example) {
        return mapper.selectByExample(example);
    }

    //通过主键：学号查询
    @Override
    public StudentQuery selectByPrimaryKey(Integer stuNo) {
        return mapper.selectByPrimaryKey(stuNo);
    }

    @Override
    public int updateByExampleSelective(StudentQuery record, StudentQueryExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(StudentQuery record, StudentQueryExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(StudentQuery record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(StudentQuery record) {
        return mapper.updateByPrimaryKey(record);
    }
}
