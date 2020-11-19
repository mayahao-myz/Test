package com.hbxy.ssm.app.studentquery.mapper;

import com.hbxy.ssm.app.studentquery.model.StudentQuery;
import com.hbxy.ssm.app.studentquery.model.StudentQueryExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentQueryMapper {
    long countByExample(StudentQueryExample example);

    int deleteByExample(StudentQueryExample example);

    int deleteByPrimaryKey(Integer stuNo);

    int insert(StudentQuery record);

    int insertSelective(StudentQuery record);

    List<StudentQuery> selectByExample(StudentQueryExample example);

    StudentQuery selectByPrimaryKey(Integer stuNo);

    int updateByExampleSelective(@Param("record") StudentQuery record, @Param("example") StudentQueryExample example);

    int updateByExample(@Param("record") StudentQuery record, @Param("example") StudentQueryExample example);

    int updateByPrimaryKeySelective(StudentQuery record);

    int updateByPrimaryKey(StudentQuery record);
}