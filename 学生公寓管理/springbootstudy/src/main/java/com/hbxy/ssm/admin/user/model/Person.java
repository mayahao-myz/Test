package com.hbxy.ssm.admin.user.model;

import java.io.Serializable;
import java.util.Date;

/**
 * mx_person
 * @author 
 */
public class Person implements Serializable {
    private String personId;

    private String userId;

    private String fullName;

    /**
     * salutation：0-先生；1-女士；2-小姐；4-太太；8-...
     */
    private String salutation;

    private String lastName;

    private String firstName;

    private String midName;

    private String nickname;

    /**
     * gender：0-男；1-女；2-...；4-...
     */
    private String gender;

    /**
     * personal_title-头衔、职务、职称
     */
    private String personalTitle;

    private Date birthDate;

    private Long height;

    private Long weight;

    /**
     * marital_status：0-未婚；1-已婚；2-...；4-...
     */
    private String maritalStatus;

    private String occupation;

    private String comments;

    /**
     * 0-身份证、1-护照、2-- 、4-- 
     */
    private String cardType;

    private String cardId;

    /**
     * 入职时间
     */
    private Date entryDate;

    /**
     * 0-正常；1-删除
     */
    private String currentStatus;

    private String isSystem;

    private Integer orderIndex;

    private Date createdTime;

    private String createdUserLoginId;

    private Date lastUpdatedTime;

    private String lastUpdatedUserLoginId;

    private static final long serialVersionUID = 1L;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
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

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPersonalTitle() {
        return personalTitle;
    }

    public void setPersonalTitle(String personalTitle) {
        this.personalTitle = personalTitle;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(String isSystem) {
        this.isSystem = isSystem;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
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
        Person other = (Person) that;
        return (this.getPersonId() == null ? other.getPersonId() == null : this.getPersonId().equals(other.getPersonId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()))
            && (this.getSalutation() == null ? other.getSalutation() == null : this.getSalutation().equals(other.getSalutation()))
            && (this.getLastName() == null ? other.getLastName() == null : this.getLastName().equals(other.getLastName()))
            && (this.getFirstName() == null ? other.getFirstName() == null : this.getFirstName().equals(other.getFirstName()))
            && (this.getMidName() == null ? other.getMidName() == null : this.getMidName().equals(other.getMidName()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getPersonalTitle() == null ? other.getPersonalTitle() == null : this.getPersonalTitle().equals(other.getPersonalTitle()))
            && (this.getBirthDate() == null ? other.getBirthDate() == null : this.getBirthDate().equals(other.getBirthDate()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getMaritalStatus() == null ? other.getMaritalStatus() == null : this.getMaritalStatus().equals(other.getMaritalStatus()))
            && (this.getOccupation() == null ? other.getOccupation() == null : this.getOccupation().equals(other.getOccupation()))
            && (this.getComments() == null ? other.getComments() == null : this.getComments().equals(other.getComments()))
            && (this.getCardType() == null ? other.getCardType() == null : this.getCardType().equals(other.getCardType()))
            && (this.getCardId() == null ? other.getCardId() == null : this.getCardId().equals(other.getCardId()))
            && (this.getEntryDate() == null ? other.getEntryDate() == null : this.getEntryDate().equals(other.getEntryDate()))
            && (this.getCurrentStatus() == null ? other.getCurrentStatus() == null : this.getCurrentStatus().equals(other.getCurrentStatus()))
            && (this.getIsSystem() == null ? other.getIsSystem() == null : this.getIsSystem().equals(other.getIsSystem()))
            && (this.getOrderIndex() == null ? other.getOrderIndex() == null : this.getOrderIndex().equals(other.getOrderIndex()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatedUserLoginId() == null ? other.getCreatedUserLoginId() == null : this.getCreatedUserLoginId().equals(other.getCreatedUserLoginId()))
            && (this.getLastUpdatedTime() == null ? other.getLastUpdatedTime() == null : this.getLastUpdatedTime().equals(other.getLastUpdatedTime()))
            && (this.getLastUpdatedUserLoginId() == null ? other.getLastUpdatedUserLoginId() == null : this.getLastUpdatedUserLoginId().equals(other.getLastUpdatedUserLoginId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPersonId() == null) ? 0 : getPersonId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
        result = prime * result + ((getSalutation() == null) ? 0 : getSalutation().hashCode());
        result = prime * result + ((getLastName() == null) ? 0 : getLastName().hashCode());
        result = prime * result + ((getFirstName() == null) ? 0 : getFirstName().hashCode());
        result = prime * result + ((getMidName() == null) ? 0 : getMidName().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getPersonalTitle() == null) ? 0 : getPersonalTitle().hashCode());
        result = prime * result + ((getBirthDate() == null) ? 0 : getBirthDate().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getMaritalStatus() == null) ? 0 : getMaritalStatus().hashCode());
        result = prime * result + ((getOccupation() == null) ? 0 : getOccupation().hashCode());
        result = prime * result + ((getComments() == null) ? 0 : getComments().hashCode());
        result = prime * result + ((getCardType() == null) ? 0 : getCardType().hashCode());
        result = prime * result + ((getCardId() == null) ? 0 : getCardId().hashCode());
        result = prime * result + ((getEntryDate() == null) ? 0 : getEntryDate().hashCode());
        result = prime * result + ((getCurrentStatus() == null) ? 0 : getCurrentStatus().hashCode());
        result = prime * result + ((getIsSystem() == null) ? 0 : getIsSystem().hashCode());
        result = prime * result + ((getOrderIndex() == null) ? 0 : getOrderIndex().hashCode());
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
        sb.append(", personId=").append(personId);
        sb.append(", userId=").append(userId);
        sb.append(", fullName=").append(fullName);
        sb.append(", salutation=").append(salutation);
        sb.append(", lastName=").append(lastName);
        sb.append(", firstName=").append(firstName);
        sb.append(", midName=").append(midName);
        sb.append(", nickname=").append(nickname);
        sb.append(", gender=").append(gender);
        sb.append(", personalTitle=").append(personalTitle);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", maritalStatus=").append(maritalStatus);
        sb.append(", occupation=").append(occupation);
        sb.append(", comments=").append(comments);
        sb.append(", cardType=").append(cardType);
        sb.append(", cardId=").append(cardId);
        sb.append(", entryDate=").append(entryDate);
        sb.append(", currentStatus=").append(currentStatus);
        sb.append(", isSystem=").append(isSystem);
        sb.append(", orderIndex=").append(orderIndex);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", createdUserLoginId=").append(createdUserLoginId);
        sb.append(", lastUpdatedTime=").append(lastUpdatedTime);
        sb.append(", lastUpdatedUserLoginId=").append(lastUpdatedUserLoginId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}