package com.hbxy.ssm.admin.user.model;

import java.io.Serializable;
import java.util.Date;

/**
 * mx_org
 * @author 
 */
public class Org implements Serializable {
    private String orgId;

    private String userId;

    private String orgName;

    private String orgShortName;

    private String orgCode;

    private Integer orderIndex;

    private String parentOrgId;

    private String managerId;

    private String contactAddress;

    private String officeAddress;

    private Integer numEmployees;

    private String tickerSymbol;

    private String currentStatus;

    private String comments;

    private Date createdTime;

    private String createdUserLoginId;

    private Date lastUpdatedTime;

    private String lastUpdatedUserLoginId;

    private static final long serialVersionUID = 1L;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgShortName() {
        return orgShortName;
    }

    public void setOrgShortName(String orgShortName) {
        this.orgShortName = orgShortName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public Integer getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(Integer numEmployees) {
        this.numEmployees = numEmployees;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedUserLoginId() {
        return createdUserLoginId;
    }

    public void setCreatedUserLoginId(String createdUserLoginId) {
        this.createdUserLoginId = createdUserLoginId;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getLastUpdatedUserLoginId() {
        return lastUpdatedUserLoginId;
    }

    public void setLastUpdatedUserLoginId(String lastUpdatedUserLoginId) {
        this.lastUpdatedUserLoginId = lastUpdatedUserLoginId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Org other = (Org) that;
        return (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getOrgShortName() == null ? other.getOrgShortName() == null : this.getOrgShortName().equals(other.getOrgShortName()))
            && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
            && (this.getOrderIndex() == null ? other.getOrderIndex() == null : this.getOrderIndex().equals(other.getOrderIndex()))
            && (this.getParentOrgId() == null ? other.getParentOrgId() == null : this.getParentOrgId().equals(other.getParentOrgId()))
            && (this.getManagerId() == null ? other.getManagerId() == null : this.getManagerId().equals(other.getManagerId()))
            && (this.getContactAddress() == null ? other.getContactAddress() == null : this.getContactAddress().equals(other.getContactAddress()))
            && (this.getOfficeAddress() == null ? other.getOfficeAddress() == null : this.getOfficeAddress().equals(other.getOfficeAddress()))
            && (this.getNumEmployees() == null ? other.getNumEmployees() == null : this.getNumEmployees().equals(other.getNumEmployees()))
            && (this.getTickerSymbol() == null ? other.getTickerSymbol() == null : this.getTickerSymbol().equals(other.getTickerSymbol()))
            && (this.getCurrentStatus() == null ? other.getCurrentStatus() == null : this.getCurrentStatus().equals(other.getCurrentStatus()))
            && (this.getComments() == null ? other.getComments() == null : this.getComments().equals(other.getComments()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatedUserLoginId() == null ? other.getCreatedUserLoginId() == null : this.getCreatedUserLoginId().equals(other.getCreatedUserLoginId()))
            && (this.getLastUpdatedTime() == null ? other.getLastUpdatedTime() == null : this.getLastUpdatedTime().equals(other.getLastUpdatedTime()))
            && (this.getLastUpdatedUserLoginId() == null ? other.getLastUpdatedUserLoginId() == null : this.getLastUpdatedUserLoginId().equals(other.getLastUpdatedUserLoginId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getOrgShortName() == null) ? 0 : getOrgShortName().hashCode());
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getOrderIndex() == null) ? 0 : getOrderIndex().hashCode());
        result = prime * result + ((getParentOrgId() == null) ? 0 : getParentOrgId().hashCode());
        result = prime * result + ((getManagerId() == null) ? 0 : getManagerId().hashCode());
        result = prime * result + ((getContactAddress() == null) ? 0 : getContactAddress().hashCode());
        result = prime * result + ((getOfficeAddress() == null) ? 0 : getOfficeAddress().hashCode());
        result = prime * result + ((getNumEmployees() == null) ? 0 : getNumEmployees().hashCode());
        result = prime * result + ((getTickerSymbol() == null) ? 0 : getTickerSymbol().hashCode());
        result = prime * result + ((getCurrentStatus() == null) ? 0 : getCurrentStatus().hashCode());
        result = prime * result + ((getComments() == null) ? 0 : getComments().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatedUserLoginId() == null) ? 0 : getCreatedUserLoginId().hashCode());
        result = prime * result + ((getLastUpdatedTime() == null) ? 0 : getLastUpdatedTime().hashCode());
        result = prime * result + ((getLastUpdatedUserLoginId() == null) ? 0 : getLastUpdatedUserLoginId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orgId=").append(orgId);
        sb.append(", userId=").append(userId);
        sb.append(", orgName=").append(orgName);
        sb.append(", orgShortName=").append(orgShortName);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", orderIndex=").append(orderIndex);
        sb.append(", parentOrgId=").append(parentOrgId);
        sb.append(", managerId=").append(managerId);
        sb.append(", contactAddress=").append(contactAddress);
        sb.append(", officeAddress=").append(officeAddress);
        sb.append(", numEmployees=").append(numEmployees);
        sb.append(", tickerSymbol=").append(tickerSymbol);
        sb.append(", currentStatus=").append(currentStatus);
        sb.append(", comments=").append(comments);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", createdUserLoginId=").append(createdUserLoginId);
        sb.append(", lastUpdatedTime=").append(lastUpdatedTime);
        sb.append(", lastUpdatedUserLoginId=").append(lastUpdatedUserLoginId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}