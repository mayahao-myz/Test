package com.hbxy.ssm.app.student.model;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class Student implements Serializable {
    //小驼峰命名
    //学号
    private Integer stuNo;
   //专业
    private String stuMajor;
    //学生姓名
    private String stuName;
    //性别
    private String stuSex;
    //宿舍号
    private String dormNo;
    //水电缴费情况
    private String stuPhone;
    //卫生评分
    private Integer healthGrade;

    private static final long serialVersionUID = 1L;

    public Integer getStuNo() {
        return stuNo;
    }

    public void setStuNo(Integer stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuMajor() {
        return stuMajor;
    }

    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getDormNo() {
        return dormNo;
    }

    public void setDormNo(String dormNo) {
        this.dormNo = dormNo;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public Integer getHealthGrade() {
        return healthGrade;
    }

    public void setHealthGrade(Integer healthGrade) {
        this.healthGrade = healthGrade;
    }

}