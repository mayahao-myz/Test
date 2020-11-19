package com.hbxy.ssm.admin.right.service.impl;

import com.hbxy.ssm.admin.right.mapper.RoleMapper;
import com.hbxy.ssm.admin.right.model.Role;
import com.hbxy.ssm.admin.right.model.RoleExample;
import com.hbxy.ssm.admin.right.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper mapper;

    @Override
    public long countByExample(RoleExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(RoleExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Role> selectByExample(RoleExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Role selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Role record, RoleExample example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Role record, RoleExample example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return mapper.updateByPrimaryKey(record);
    }

}
