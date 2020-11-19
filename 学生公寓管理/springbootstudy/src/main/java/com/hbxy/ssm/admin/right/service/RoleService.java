package com.hbxy.ssm.admin.right.service;

import com.hbxy.ssm.admin.right.model.Role;
import com.hbxy.ssm.admin.right.model.RoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}
