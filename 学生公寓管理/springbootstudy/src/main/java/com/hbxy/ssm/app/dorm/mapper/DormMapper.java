package com.hbxy.ssm.app.dorm.mapper;

import com.hbxy.ssm.app.dorm.model.Dorm;
import com.hbxy.ssm.app.dorm.model.DormExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DormMapper {
    //数量
    long countByExample(DormExample example);
    //有条件的删除
    int deleteByExample(DormExample example);
    //通过主键删除
    int deleteByPrimaryKey(String dormNo);
//插入一条记录
    int insert(Dorm record);
//有选择的插入
    int insertSelective(Dorm record);
//有条件的查询
    List<Dorm> selectByExample(DormExample example);

//    Dorm selectByPrimaryKey(String dormNo);
//有条件的选择更新
    int updateByExampleSelective(@Param("record") Dorm record, @Param("example") DormExample example);
//有条件的更新
    int updateByExample(@Param("record") Dorm record, @Param("example") DormExample example);

//    int updateByPrimaryKeySelective(Dorm record);

//    int updateByPrimaryKey(Dorm record);

}