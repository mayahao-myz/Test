package com.hbxy.ssm.admin.module.service;

import com.hbxy.ssm.admin.module.model.App;
import com.hbxy.ssm.admin.module.model.AppExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//业务逻辑层 接口
public interface AppService {
    //按条件计数
    long countByExample(AppExample example);

    int deleteByExample(AppExample example);

    int deleteByPrimaryKey(String appId);

    int insert(App record);

    int insertSelective(App record);

    List<App> selectByExample(AppExample example);

    App selectByPrimaryKey(String appId);

    int updateByExampleSelective(@Param("record") App record, @Param("example") AppExample example);

    int updateByExample(@Param("record") App record, @Param("example") AppExample example);

    int updateByPrimaryKeySelective(App record);

    int updateByPrimaryKey(App record);
}
