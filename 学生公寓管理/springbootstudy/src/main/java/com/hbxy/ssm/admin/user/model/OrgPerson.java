package com.hbxy.ssm.admin.user.model;

import java.io.Serializable;
import java.util.Date;

/**
 * mx_org_person
 * @author 
 */
public class OrgPerson implements Serializable {
    private String orgPersonId;

    private String orgId;

    private String personId;

    private Date fromDate;

    private Date thruDate;

    private static final long serialVersionUID = 1L;

    public String getOrgPersonId() {
        return orgPersonId;
    }

    public void setOrgPersonId(String orgPersonId) {
        this.orgPersonId = orgPersonId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getThruDate() {
        return thruDate;
    }

    public void setThruDate(Date thruDate) {
        this.thruDate = thruDate;
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
        OrgPerson other = (OrgPerson) that;
        return (this.getOrgPersonId() == null ? other.getOrgPersonId() == null : this.getOrgPersonId().equals(other.getOrgPersonId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getPersonId() == null ? other.getPersonId() == null : this.getPersonId().equals(other.getPersonId()))
            && (this.getFromDate() == null ? other.getFromDate() == null : this.getFromDate().equals(other.getFromDate()))
            && (this.getThruDate() == null ? other.getThruDate() == null : this.getThruDate().equals(other.getThruDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrgPersonId() == null) ? 0 : getOrgPersonId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getPersonId() == null) ? 0 : getPersonId().hashCode());
        result = prime * result + ((getFromDate() == null) ? 0 : getFromDate().hashCode());
        result = prime * result + ((getThruDate() == null) ? 0 : getThruDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orgPersonId=").append(orgPersonId);
        sb.append(", orgId=").append(orgId);
        sb.append(", personId=").append(personId);
        sb.append(", fromDate=").append(fromDate);
        sb.append(", thruDate=").append(thruDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}