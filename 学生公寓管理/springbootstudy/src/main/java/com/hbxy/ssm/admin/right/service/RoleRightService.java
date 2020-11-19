package com.hbxy.ssm.admin.right.service;

import com.hbxy.ssm.admin.right.model.RoleRight;
import com.hbxy.ssm.admin.right.model.RoleRightExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleRightService {
    long countByExample(RoleRightExample example);

    int deleteByExample(RoleRightExample example);

    int deleteByPrimaryKey(String roleRightId);

    int insert(RoleRight record);

    int insertSelective(RoleRight record);

    List<RoleRight> selectByExample(RoleRightExample example);

    RoleRight selectByPrimaryKey(String roleRightId);

    int updateByExampleSelective(@Param("record") RoleRight record, @Param("example") RoleRightExample example);

    int updateByExample(@Param("record") RoleRight record, @Param("example") RoleRightExample example);

    int updateByPrimaryKeySelective(RoleRight record);

    int updateByPrimaryKey(RoleRight record);
}
