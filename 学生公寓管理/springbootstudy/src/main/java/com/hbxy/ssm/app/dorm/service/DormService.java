package com.hbxy.ssm.app.dorm.service;

import com.hbxy.ssm.app.dorm.model.Dorm;
import com.hbxy.ssm.app.dorm.model.DormExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//业务逻辑
//接口不是有明确得关系，类是有明确得关系
//接口是一个特殊的抽象3类，只有抽象操作，没有属性
public interface DormService {
    //与mapper里的方法一样，直接复制过来
    long countByExample(DormExample example);

    int deleteByExample(DormExample example);

    int deleteByPrimaryKey(String dormNo);

    int  insert(Dorm record);

    int insertSelective(Dorm record);

    //有条件的查
    List<Dorm> selectByExample(DormExample example);

//    Dorm selectByPrimaryKey(String dormNo);

    int updateByExampleSelective(@Param("record") Dorm record, @Param("example") DormExample example);

    int updateByExample(@Param("record") Dorm record, @Param("example") DormExample example);

//    int updateByPrimaryKey(Dorm record);

//    int updateByExampleSelective(Dorm record);

//    int updateByPrimaryKeySelective(Dorm record);

}
