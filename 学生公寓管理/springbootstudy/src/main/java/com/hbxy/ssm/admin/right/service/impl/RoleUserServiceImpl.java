package com.hbxy.ssm.admin.right.service.impl;

import com.hbxy.ssm.admin.right.mapper.RoleUserMapper;
import com.hbxy.ssm.admin.right.model.RoleUser;
import com.hbxy.ssm.admin.right.model.RoleUserExample;
import com.hbxy.ssm.admin.right.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleUserServiceImpl implements RoleUserService {
    @Autowired
    private RoleUserMapper mapper;

    @Override
    public long countByExample(RoleUserExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(RoleUserExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RoleUser record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(RoleUser record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<RoleUser> selectByExample(RoleUserExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public RoleUser selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(RoleUser record, RoleUserExample example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(RoleUser record, RoleUserExample example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(RoleUser record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoleUser record) {
        return mapper.updateByPrimaryKey(record);
    }
}
