package com.hbxy.ssm.app.student.service.impl;

import com.hbxy.ssm.app.student.mapper.StudentMapper;
import com.hbxy.ssm.app.student.model.Student;
import com.hbxy.ssm.app.student.model.StudentExample;
import com.hbxy.ssm.app.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper mapper;
    //重写service的方法，实现，通过mapper sql语句,前端与数据库相连
    //重写service的方法，实现，通过mapper sql语句,前端与数据库
    @Override
    public long countByExample(StudentExample example) {
        return mapper.countByExample(example);
    }
//删
    @Override
    public int deleteByExample(StudentExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String stuNo) {
        return mapper.deleteByPrimaryKey(Integer.parseInt(stuNo));
    }
//增，record记录，example全部
    @Override
    public int insert(Student record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return mapper.insertSelective(record);
    }
//查，全部的
    @Override
    public List<Student> selectByExample(StudentExample example) {
        return mapper.selectByExample(example);
    }
//据学号去查询
    @Override
    public Student selectByPrimaryKey(Integer stuNo) {
        return mapper.selectByPrimaryKey(stuNo);
    }
//改
    @Override
    public int updateByExampleSelective(Student record, StudentExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Student record, StudentExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return mapper.updateByPrimaryKey(record);
    }
}
