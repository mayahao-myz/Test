package com.hbxy.ssm.app.drepair.mapper;

import com.hbxy.ssm.app.drepair.model.Drepair;
import com.hbxy.ssm.app.drepair.model.DrepairExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DrepairMapper {
    long countByExample(DrepairExample example);

    int deleteByExample(DrepairExample example);

    int deleteByPrimaryKey(Integer drepairId);

    int insert(Drepair record);

    int insertSelective(Drepair record);

    List<Drepair> selectByExample(DrepairExample example);

    Drepair selectByPrimaryKey(Integer drepairId);

    int updateByExampleSelective(@Param("record") Drepair record, @Param("example") DrepairExample example);

    int updateByExample(@Param("record") Drepair record, @Param("example") DrepairExample example);

    int updateByPrimaryKeySelective(Drepair record);

    int updateByPrimaryKey(Drepair record);
}