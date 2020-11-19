package com.hbxy.ssm.app.hydrselect.service;

import com.hbxy.ssm.app.hydrselect.model.ApHydrSelect;
import com.hbxy.ssm.app.hydrselect.model.ApHydrSelectExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApHydrSelectService {
    long countByExample(ApHydrSelectExample example);

    int deleteByExample(ApHydrSelectExample example);

    int deleteByPrimaryKey(Integer hydrId);

    int insert(ApHydrSelect record);

    int insertSelective(ApHydrSelect record);

    List<ApHydrSelect> selectByExample(ApHydrSelectExample example);

    ApHydrSelect selectByPrimaryKey(Integer hydrId);

    int updateByExampleSelective(@Param("record") ApHydrSelect record, @Param("example") ApHydrSelectExample example);

    int updateByExample(@Param("record") ApHydrSelect record, @Param("example") ApHydrSelectExample example);

    int updateByPrimaryKeySelective(ApHydrSelect record);

    int updateByPrimaryKey(ApHydrSelect record);
}
