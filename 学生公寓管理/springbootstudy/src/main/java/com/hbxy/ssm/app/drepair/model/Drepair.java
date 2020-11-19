package com.hbxy.ssm.app.drepair.model;

import java.io.Serializable;
//import java.util.String;

/**
 * @author 
 * 
 */
public class Drepair implements Serializable {
    private Integer drepairId;

    private Integer repairId;

    private String dormNo;

    private String drepairData;

    private String repairContent;

    private String drepairState;

    private static final long serialVersionUID = 1L;

    public Integer getDrepairId() {
        return drepairId;
    }

    public void setDrepairId(Integer drepairId) {
        this.drepairId = drepairId;
    }

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public String getDormNo() {
        return dormNo;
    }

    public void setDormNo(String dormNo) {
        this.dormNo = dormNo;
    }

    public String getDrepairData() {
        return drepairData;
    }

    public void setDrepairData(String drepairData) {
        this.drepairData = drepairData;
    }

    public String getRepairContent() {
        return repairContent;
    }

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
    }

    public String getDrepairState() {
        return drepairState;
    }

    public void setDrepairState(String drepairState) {
        this.drepairState = drepairState;
    }
}