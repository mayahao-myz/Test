package com.hbxy.ssm.app.repair.service;

import com.hbxy.ssm.app.repair.model.Repair;
import com.hbxy.ssm.app.repair.model.RepairExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepairService {
    long countByExample(RepairExample example);

    int deleteByExample(RepairExample example);

    int deleteByPrimaryKey(Integer repairId);

    int insert(Repair record);

    int insertSelective(Repair record);

    List<Repair> selectByExample(RepairExample example);

    Repair selectByPrimaryKey(Integer repairId);

    int updateByExampleSelective(@Param("record") Repair record, @Param("example") RepairExample example);

    int updateByExample(@Param("record") Repair record, @Param("example") RepairExample example);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKey(Repair record);
}
