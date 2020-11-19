package com.hbxy.ssm.admin.user.service.impl;

import com.hbxy.ssm.admin.user.mapper.UserLoginMapper;
import com.hbxy.ssm.admin.user.model.UserLogin;
import com.hbxy.ssm.admin.user.model.UserLoginExample;
import com.hbxy.ssm.admin.user.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserLoginMapper mapper;

    @Override
    public long countByExample(UserLoginExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserLoginExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String userId) {
        return mapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(UserLogin record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(UserLogin record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<UserLogin> selectByExample(UserLoginExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public UserLogin selectByPrimaryKey(String userId) {
        return mapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByExampleSelective(UserLogin record, UserLoginExample example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UserLogin record, UserLoginExample example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UserLogin record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserLogin record) {
        return mapper.updateByPrimaryKey(record);
    }
}
