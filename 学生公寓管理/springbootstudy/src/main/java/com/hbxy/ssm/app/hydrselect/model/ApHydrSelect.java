package com.hbxy.ssm.app.hydrselect.model;

import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 * 
 */

public class ApHydrSelect implements Serializable {
    private Integer hydrId;

    private String dromNo;

    private Date hydrData;

    private String hydrFree;

    private String hydrFreeState;

    private static final long serialVersionUID = 1L;

    public Integer getHydrId() {
        return hydrId;
    }

    public void setHydrId(Integer hydrId) {
        this.hydrId = hydrId;
    }

    public String getDromNo() {
        return dromNo;
    }

    public void setDromNo(String dromNo) {
        this.dromNo = dromNo;
    }

    public Date getHydrData() {
        return hydrData;
    }

    public void setHydrData(Date hydrData) {
        this.hydrData = hydrData;
    }

    public String getHydrFree() {
        return hydrFree;
    }

    public void setHydrFree(String hydrFree) {
        this.hydrFree = hydrFree;
    }

    public String getHydrFreeState() {
        return hydrFreeState;
    }

    public void setHydrFreeState(String hydrFreeState) {
        this.hydrFreeState = hydrFreeState;
    }
}