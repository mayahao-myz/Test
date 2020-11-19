package com.hbxy.ssm.admin.module.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 * 
 */

//功能模块分组
public class Module implements Serializable {
    private String moduleId;//功能模块id

    private String appId;//应用子系统id

    private String appName;//应用子系统名称

    private String moduleName;//功能模块名称

    private String moduleCode;//功能模块编码

    private String moduleIconUrl;//功能模块图标url

    private String moduleUrl;//功能模块url

    /**
     * 是否管理模块：0-否；1-是
     */
    private String isAdmin;

    /**
     * 是否需要权限：0-否；1-是
     */
    private String needRight;

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

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

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

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleIconUrl() {
        return moduleIconUrl;
    }

    public void setModuleIconUrl(String moduleIconUrl) {
        this.moduleIconUrl = moduleIconUrl;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getNeedRight() {
        return needRight;
    }

    public void setNeedRight(String needRight) {
        this.needRight = needRight;
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