package com.hbxy.ssm.admin.right.model;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class RoleRight implements Serializable {
    private String roleRightId;

    private String resourceId;

    private String roleId;

    private static final long serialVersionUID = 1L;

    public String getRoleRightId() {
        return roleRightId;
    }

    public void setRoleRightId(String roleRightId) {
        this.roleRightId = roleRightId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}