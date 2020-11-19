package com.hbxy.ssm.admin.user.service;

import com.hbxy.ssm.admin.user.model.UserLogin;
import com.hbxy.ssm.admin.user.model.UserLoginExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserLoginService {
    long countByExample(UserLoginExample example);

    int deleteByExample(UserLoginExample example);

    int deleteByPrimaryKey(String userId);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    List<UserLogin> selectByExample(UserLoginExample example);

    UserLogin selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") UserLogin record, @Param("example") UserLoginExample example);

    int updateByExample(@Param("record") UserLogin record, @Param("example") UserLoginExample example);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);
}
