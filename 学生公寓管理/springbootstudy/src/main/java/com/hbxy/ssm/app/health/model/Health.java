package com.hbxy.ssm.app.health.model;

import java.io.Serializable;
//import java.util.String;

/**
 * @author 
 * 
 */
public class Health implements Serializable {
    private Integer healthId;

    private String dormNo;

    private String healthData;

    private Integer healthGrade;

    private String healthRemark;

    private static final long serialVersionUID = 1L;

    public Integer getHealthId() {
        return healthId;
    }

    public void setHealthId(Integer healthId) {
        this.healthId = healthId;
    }

    public String getDormNo() {
        return dormNo;
    }

    public void setDormNo(String dormNo) {
        this.dormNo = dormNo;
    }

    public String getHealthData() {
        return healthData;
    }

    public void setHealthData(String healthData) {
        this.healthData = healthData;
    }

    public Integer getHealthGrade() {
        return healthGrade;
    }

    public void setHealthGrade(Integer healthGrade) {
        this.healthGrade = healthGrade;
    }

    public String getHealthRemark() {
        return healthRemark;
    }

    public void setHealthRemark(String healthRemark) {
        this.healthRemark = healthRemark;
    }
}