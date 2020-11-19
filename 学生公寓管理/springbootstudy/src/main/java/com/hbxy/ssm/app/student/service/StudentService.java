package com.hbxy.ssm.app.student.service;

import com.hbxy.ssm.app.student.model.Student;
import com.hbxy.ssm.app.student.model.StudentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//定义抽象方法
public interface StudentService {

    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(String stuNo);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    //通过学号去查询
    Student selectByPrimaryKey(Integer stuNo);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

}
