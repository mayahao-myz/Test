package com.hbxy.ssm.app.hydr.model;

import java.io.Serializable;


/**
 * @author 
 * 
 */
public class ApHydr implements Serializable {
    private Integer hydrId;

    private String dromNo;

    private String hydrData;

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

    public String getHydrData() {
        return hydrData;
    }

    public void setHydrData(String hydrData) {
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