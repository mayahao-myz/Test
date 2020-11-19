package com.hbxy.ssm.app.repair.service;

import com.hbxy.ssm.app.repair.model.Repairs;
import com.hbxy.ssm.app.repair.model.RepairsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepairsService {
    long countByExample(RepairsExample example);

    int deleteByExample(RepairsExample example);

    int deleteByPrimaryKey(String repairsId);

    int insert(Repairs record);

    int insertSelective(Repairs record);

    List<Repairs> selectByExample(RepairsExample example);

    Repairs selectByPrimaryKey(String repairsId);

    int updateByExampleSelective(@Param("record") Repairs record, @Param("example") RepairsExample example);

    int updateByExample(@Param("record") Repairs record, @Param("example") RepairsExample example);

    int updateByPrimaryKeySelective(Repairs record);

    int updateByPrimaryKey(Repairs record);
}
