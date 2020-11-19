package com.hbxy.ssm.app.repair.mapper;

import com.hbxy.ssm.app.repair.model.Repairs;
import com.hbxy.ssm.app.repair.model.RepairsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RepairsMapper {
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