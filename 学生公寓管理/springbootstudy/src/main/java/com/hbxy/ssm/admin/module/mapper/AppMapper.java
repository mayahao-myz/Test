package com.hbxy.ssm.admin.module.mapper;

import com.hbxy.ssm.admin.module.model.App;
import com.hbxy.ssm.admin.module.model.AppExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//为了把mapper这个DAO交給Spring管理;为了不再写mapper映射文件;为了给mapper接口 自动根据添加@Mapper注解的接口,生成一个实现类
@Mapper

public interface AppMapper {
//按条件计数
    long countByExample(AppExample example);
//按条件查询并删除
    int deleteByExample(AppExample example);
//按主键删除
    int deleteByPrimaryKey(String appId);
//插入数据（返回值为ID）
    int insert(App record);
//有选择的插入
    int insertSelective(App record);
//按条件查询
    List<App> selectByExample(AppExample example);
//按主键查询
    App selectByPrimaryKey(String appId);
//按条件更新值不为null的字段
    int updateByExampleSelective(@Param("record") App record, @Param("example") AppExample example);
//按条件更新
    int updateByExample(@Param("record") App record, @Param("example") AppExample example);
//按主键更新值不为null的字段
    int updateByPrimaryKeySelective(App record);
//按主键更新
    int updateByPrimaryKey(App record);
}