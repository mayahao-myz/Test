package com.hbxy.ssm.admin.right.model;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class RoleUser implements Serializable {
    private String roleUserId;

    private String roleId;

    private String roleName;

    private String userId;

    private static final long serialVersionUID = 1L;

    public String getRoleUserId() {
        return roleUserId;
    }

    public void setRoleUserId(String roleUserId) {
        this.roleUserId = roleUserId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}