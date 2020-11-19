package com.hbxy.ssm.admin.module.service;
import com.hbxy.ssm.admin.module.model.Module;
import com.hbxy.ssm.admin.module.model.ModuleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleService {
    long countByExample(ModuleExample example);

    int deleteByExample(ModuleExample example);

    int deleteByPrimaryKey(String moduleId);

    int insert(Module record);

    int insertSelective(Module record);

    List<Module> selectByExample(ModuleExample example);

    Module selectByPrimaryKey(String moduleId);

    int updateByExampleSelective(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByExample(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
}
