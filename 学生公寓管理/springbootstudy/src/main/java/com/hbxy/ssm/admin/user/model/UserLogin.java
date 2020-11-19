package com.hbxy.ssm.admin.user.model;

import java.io.Serializable;
import java.util.Date;

/**
 * mx_user_login
 * @author 
 */
public class UserLogin implements Serializable {
    private String userId;

    private String userLoginId;

    /**
     * 0-人员；1-组织
     */
    private String userType;

    private String currentPassword;

    private Integer passwordHint;

    /**
     * require_password_change：0-不需要；1-需要
     */
    private String passwordRequireChange;

    private String userName;

    private String lastName;

    private String firstName;

    /**
     * 0-否；1-是
     */
    private String isInternal;

    private String email;

    private String mobile;

    private String mobileCountryCode;

    /**
     * is_system：0-否；1-是
     */
    private String isSystem;

    /**
     * has_logged_out：0-否；1-是
     */
    private String hasLoggedOut;

    private String lastLocale;

    private String lastTimeZone;

    /**
     * 0-正常；1-禁用
     */
    private String currentStatus;

    private Date disabledTime;

    /**
     * disabled_by：（user_login_id）
     */
    private String disabledBy;

    private Date createdTime;

    private String createdUserLoginId;
    //数据库类型 timestamp
    private Date lastUpdatedTime;

    private String lastUpdatedUserLoginId;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public Integer getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(Integer passwordHint) {
        this.passwordHint = passwordHint;
    }

    public String getPasswordRequireChange() {
        return passwordRequireChange;
    }

    public void setPasswordRequireChange(String passwordRequireChange) {
        this.passwordRequireChange = passwordRequireChange;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getIsInternal() {
        return isInternal;
    }

    public void setIsInternal(String isInternal) {
        this.isInternal = isInternal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileCountryCode() {
        return mobileCountryCode;
    }

    public void setMobileCountryCode(String mobileCountryCode) {
        this.mobileCountryCode = mobileCountryCode;
    }

    public String getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(String isSystem) {
        this.isSystem = isSystem;
    }

    public String getHasLoggedOut() {
        return hasLoggedOut;
    }

    public void setHasLoggedOut(String hasLoggedOut) {
        this.hasLoggedOut = hasLoggedOut;
    }

    public String getLastLocale() {
        return lastLocale;
    }

    public void setLastLocale(String lastLocale) {
        this.lastLocale = lastLocale;
    }

    public String getLastTimeZone() {
        return lastTimeZone;
    }

    public void setLastTimeZone(String lastTimeZone) {
        this.lastTimeZone = lastTimeZone;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Date getDisabledTime() {
        return disabledTime;
    }

    public void setDisabledTime(Date disabledTime) {
        this.disabledTime = disabledTime;
    }

    public String getDisabledBy() {
        return disabledBy;
    }

    public void setDisabledBy(String disabledBy) {
        this.disabledBy = disabledBy;
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
        UserLogin other = (UserLogin) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserLoginId() == null ? other.getUserLoginId() == null : this.getUserLoginId().equals(other.getUserLoginId()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getCurrentPassword() == null ? other.getCurrentPassword() == null : this.getCurrentPassword().equals(other.getCurrentPassword()))
            && (this.getPasswordHint() == null ? other.getPasswordHint() == null : this.getPasswordHint().equals(other.getPasswordHint()))
            && (this.getPasswordRequireChange() == null ? other.getPasswordRequireChange() == null : this.getPasswordRequireChange().equals(other.getPasswordRequireChange()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getLastName() == null ? other.getLastName() == null : this.getLastName().equals(other.getLastName()))
            && (this.getFirstName() == null ? other.getFirstName() == null : this.getFirstName().equals(other.getFirstName()))
            && (this.getIsInternal() == null ? other.getIsInternal() == null : this.getIsInternal().equals(other.getIsInternal()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getMobileCountryCode() == null ? other.getMobileCountryCode() == null : this.getMobileCountryCode().equals(other.getMobileCountryCode()))
            && (this.getIsSystem() == null ? other.getIsSystem() == null : this.getIsSystem().equals(other.getIsSystem()))
            && (this.getHasLoggedOut() == null ? other.getHasLoggedOut() == null : this.getHasLoggedOut().equals(other.getHasLoggedOut()))
            && (this.getLastLocale() == null ? other.getLastLocale() == null : this.getLastLocale().equals(other.getLastLocale()))
            && (this.getLastTimeZone() == null ? other.getLastTimeZone() == null : this.getLastTimeZone().equals(other.getLastTimeZone()))
            && (this.getCurrentStatus() == null ? other.getCurrentStatus() == null : this.getCurrentStatus().equals(other.getCurrentStatus()))
            && (this.getDisabledTime() == null ? other.getDisabledTime() == null : this.getDisabledTime().equals(other.getDisabledTime()))
            && (this.getDisabledBy() == null ? other.getDisabledBy() == null : this.getDisabledBy().equals(other.getDisabledBy()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatedUserLoginId() == null ? other.getCreatedUserLoginId() == null : this.getCreatedUserLoginId().equals(other.getCreatedUserLoginId()))
            && (this.getLastUpdatedTime() == null ? other.getLastUpdatedTime() == null : this.getLastUpdatedTime().equals(other.getLastUpdatedTime()))
            && (this.getLastUpdatedUserLoginId() == null ? other.getLastUpdatedUserLoginId() == null : this.getLastUpdatedUserLoginId().equals(other.getLastUpdatedUserLoginId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserLoginId() == null) ? 0 : getUserLoginId().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getCurrentPassword() == null) ? 0 : getCurrentPassword().hashCode());
        result = prime * result + ((getPasswordHint() == null) ? 0 : getPasswordHint().hashCode());
        result = prime * result + ((getPasswordRequireChange() == null) ? 0 : getPasswordRequireChange().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getLastName() == null) ? 0 : getLastName().hashCode());
        result = prime * result + ((getFirstName() == null) ? 0 : getFirstName().hashCode());
        result = prime * result + ((getIsInternal() == null) ? 0 : getIsInternal().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getMobileCountryCode() == null) ? 0 : getMobileCountryCode().hashCode());
        result = prime * result + ((getIsSystem() == null) ? 0 : getIsSystem().hashCode());
        result = prime * result + ((getHasLoggedOut() == null) ? 0 : getHasLoggedOut().hashCode());
        result = prime * result + ((getLastLocale() == null) ? 0 : getLastLocale().hashCode());
        result = prime * result + ((getLastTimeZone() == null) ? 0 : getLastTimeZone().hashCode());
        result = prime * result + ((getCurrentStatus() == null) ? 0 : getCurrentStatus().hashCode());
        result = prime * result + ((getDisabledTime() == null) ? 0 : getDisabledTime().hashCode());
        result = prime * result + ((getDisabledBy() == null) ? 0 : getDisabledBy().hashCode());
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
        sb.append(", userId=").append(userId);
        sb.append(", userLoginId=").append(userLoginId);
        sb.append(", userType=").append(userType);
        sb.append(", currentPassword=").append(currentPassword);
        sb.append(", passwordHint=").append(passwordHint);
        sb.append(", passwordRequireChange=").append(passwordRequireChange);
        sb.append(", userName=").append(userName);
        sb.append(", lastName=").append(lastName);
        sb.append(", firstName=").append(firstName);
        sb.append(", isInternal=").append(isInternal);
        sb.append(", email=").append(email);
        sb.append(", mobile=").append(mobile);
        sb.append(", mobileCountryCode=").append(mobileCountryCode);
        sb.append(", isSystem=").append(isSystem);
        sb.append(", hasLoggedOut=").append(hasLoggedOut);
        sb.append(", lastLocale=").append(lastLocale);
        sb.append(", lastTimeZone=").append(lastTimeZone);
        sb.append(", currentStatus=").append(currentStatus);
        sb.append(", disabledTime=").append(disabledTime);
        sb.append(", disabledBy=").append(disabledBy);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", createdUserLoginId=").append(createdUserLoginId);
        sb.append(", lastUpdatedTime=").append(lastUpdatedTime);
        sb.append(", lastUpdatedUserLoginId=").append(lastUpdatedUserLoginId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}