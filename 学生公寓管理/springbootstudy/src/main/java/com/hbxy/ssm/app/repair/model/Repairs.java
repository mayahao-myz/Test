package com.hbxy.ssm.app.repair.model;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class Repairs implements Serializable {
    private String repairsId;

    private String repairsNo;

    private String repairsPrice;

    private String repairsName;

    private Integer repairsNumber;

    private static final long serialVersionUID = 1L;

    public String getRepairsId() {
        return repairsId;
    }

    public void setRepairsId(String repairsId) {
        this.repairsId = repairsId;
    }

    public String getRepairsNo() {
        return repairsNo;
    }

    public void setRepairsNo(String repairsNo) {
        this.repairsNo = repairsNo;
    }

    public String getRepairsPrice() {
        return repairsPrice;
    }

    public void setRepairsPrice(String repairsPrice) {
        this.repairsPrice = repairsPrice;
    }

    public String getRepairsName() {
        return repairsName;
    }

    public void setRepairsName(String repairsName) {
        this.repairsName = repairsName;
    }

    public Integer getRepairsNumber() {
        return repairsNumber;
    }

    public void setRepairsNumber(Integer repairsNumber) {
        this.repairsNumber = repairsNumber;
    }
}