package com.hbxy.ssm.admin.right.service.impl;

import com.hbxy.ssm.admin.right.mapper.RoleRightMapper;
import com.hbxy.ssm.admin.right.model.RoleRight;
import com.hbxy.ssm.admin.right.model.RoleRightExample;
import com.hbxy.ssm.admin.right.service.RoleRightService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleRightServiceImpl implements RoleRightService {
    @Autowired
    private RoleRightMapper mapper;

    @Override
    public long countByExample(RoleRightExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(RoleRightExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RoleRight record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(RoleRight record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<RoleRight> selectByExample(RoleRightExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public RoleRight selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(RoleRight record, RoleRightExample example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(RoleRight record, RoleRightExample example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(RoleRight record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoleRight record) {
        return mapper.updateByPrimaryKey(record);
    }

}
