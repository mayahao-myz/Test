package com.hbxy.ssm.app.studentquery.service;

import com.hbxy.ssm.app.studentquery.model.StudentQuery;
import com.hbxy.ssm.app.studentquery.model.StudentQueryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentQueryService {
    long countByExample(StudentQueryExample example);

    int deleteByExample(StudentQueryExample example);

    int deleteByPrimaryKey(Integer stuNo);

    int insert(StudentQuery record);

    int insertSelective(StudentQuery record);

    List<StudentQuery> selectByExample(StudentQueryExample example);
    //通过学号进行模糊查询
    StudentQuery selectByPrimaryKey(Integer stuNo);

    int updateByExampleSelective(@Param("record") StudentQuery record, @Param("example") StudentQueryExample example);

    int updateByExample(@Param("record") StudentQuery record, @Param("example") StudentQueryExample example);

    int updateByPrimaryKeySelective(StudentQuery record);

    int updateByPrimaryKey(StudentQuery record);
}
