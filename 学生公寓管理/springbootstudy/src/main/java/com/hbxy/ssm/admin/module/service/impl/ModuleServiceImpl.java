package com.hbxy.ssm.admin.module.service.impl;
import com.hbxy.ssm.admin.module.model.Module;
import com.hbxy.ssm.admin.module.mapper.ModuleMapper;
import com.hbxy.ssm.admin.module.model.ModuleExample;
import com.hbxy.ssm.admin.module.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    private ModuleMapper mapper;

    @Override
    public long countByExample(ModuleExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ModuleExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Module record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Module record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Module> selectByExample(ModuleExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Module selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Module record, ModuleExample example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Module record, ModuleExample example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Module record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Module record) {
        return mapper.updateByPrimaryKey(record);
    }

}
