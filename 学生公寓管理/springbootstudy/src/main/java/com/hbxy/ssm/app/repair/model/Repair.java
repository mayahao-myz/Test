package com.hbxy.ssm.app.repair.model;

import java.io.Serializable;
//import java.util.String;

/**
 * @author
 *
 */
public class Repair implements Serializable {
//    报修编号
    private Integer repairId;
//宿舍号
    private String dormNo;
//报修日期
    private String repairData;
//报修内容
    private String repairContent;

    private static final long serialVersionUID = 1L;

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

    public String getRepairData() {
        return repairData;
    }

    public void setRepairData(String repairData) {
        this.repairData = repairData;
    }

    public String getRepairContent() {
        return repairContent;
    }

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
    }
}