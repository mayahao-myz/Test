package com.hbxy.ssm.admin.right.service;

import com.hbxy.ssm.admin.right.model.RoleUser;
import com.hbxy.ssm.admin.right.model.RoleUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleUserService {
    long countByExample(RoleUserExample example);

    int deleteByExample(RoleUserExample example);

    int deleteByPrimaryKey(String roleUserId);

    int insert(RoleUser record);

    int insertSelective(RoleUser record);

    List<RoleUser> selectByExample(RoleUserExample example);

    RoleUser selectByPrimaryKey(String roleUserId);

    int updateByExampleSelective(@Param("record") RoleUser record, @Param("example") RoleUserExample example);

    int updateByExample(@Param("record") RoleUser record, @Param("example") RoleUserExample example);

    int updateByPrimaryKeySelective(RoleUser record);

    int updateByPrimaryKey(RoleUser record);
}
