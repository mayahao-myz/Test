package com.hbxy.ssm.app.dorm.model;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class Dorm implements Serializable {
    //属性
    private String dormNo;

    private static final long serialVersionUID = 1L;

    public String getDormNo() {
        return dormNo;
    }

    public void setDormNo(String dormNo) {
        this.dormNo = dormNo;
    }

//    @Override
//    public boolean equals(Object that){
//        if (this == that) {
//            return true;
//        }
//        if (that == null) {
//            return false;
//        }
//        if (getClass() != that.getClass()) {
//            return false;
//        }
//        Dorm other=(Dorm) that;
//        return (this.getDormNo()==null?other.getDormNo()==null:this.getDormNo().equals(other.getDormNo()));
//
//    }
//
//    @Override
//    public int hashCode(){
//        final  int prime=31;
//        int result =1;
//        result = prime * result + ((getDormNo() == null) ? 0 : getDormNo().hashCode());
//        return result;
//    }
//    @Override
//    public String toString(){
//        StringBuilder sb = new StringBuilder();
//        sb.append(getClass().getSimpleName());
//        sb.append(" [");
//        sb.append("Hash = ").append(hashCode());
//        sb.append(", appId=").append(dormNo);
//        sb.append(", serialVersionUID=").append(serialVersionUID);
//        sb.append("]");
//        return sb.toString();
//    }

}