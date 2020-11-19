package com.hbxy.ssm.admin.module.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 * 
 */

//应用子系统
public class App implements Serializable {
    private String appId;//id

    private String appName;//名称

    private String appCode;//编码

    private String appIconUrl;//图标url

    private String appUrl;//入口url

    private String appDeveloper;//开发商

    /**
     * 是否管理模块：0-否；1-是
     */
    private String isAdmin;

    private Integer orderIndex;

    private String comments;

    /**
     * 0-正常；1-禁用
     */
    private String currentStatus;

    private Date createdTime;

    private String createdUserLoginId;

    private Date lastUpdatedTime;

    private String lastUpdatedUserLoginId;

    private static final long serialVersionUID = 1L;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppIconUrl() {
        return appIconUrl;
    }

    public void setAppIconUrl(String appIconUrl) {
        this.appIconUrl = appIconUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getAppDeveloper() {
        return appDeveloper;
    }

    public void setAppDeveloper(String appDeveloper) {
        this.appDeveloper = appDeveloper;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
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
}