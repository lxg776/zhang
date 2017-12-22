package com.zheng.friend.dao.model;

import java.io.Serializable;

public class FUserRequest implements Serializable {
    /**
     * 用户编号
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * 性别
     *
     * @mbg.generated
     */
    private String sex;

    /**
     * 身高要求
     *
     * @mbg.generated
     */
    private String height;

    /**
     * 体型要求
     *
     * @mbg.generated
     */
    private String shape;

    /**
     * 年龄要求
     *
     * @mbg.generated
     */
    private String age;

    /**
     * 月收入
     *
     * @mbg.generated
     */
    private String incomeMonthly;

    /**
     * 年收入
     *
     * @mbg.generated
     */
    private String incomeYear;

    /**
     * 房屋状况
     *
     * @mbg.generated
     */
    private String houseState;

    /**
     * 学历
     *
     * @mbg.generated
     */
    private String education;

    /**
     * 婚姻状况
     *
     * @mbg.generated
     */
    private String maritalStatus;

    /**
     * 房屋状况
     *
     * @mbg.generated
     */
    private String houseStatus;

    /**
     * 车辆状况
     *
     * @mbg.generated
     */
    private String carStatus;

    /**
     * 工作状况
     *
     * @mbg.generated
     */
    private String job;

    /**
     * 对另一半得要求
     *
     * @mbg.generated
     */
    private String friendRequire;

    /**
     * 饮酒情况
     *
     * @mbg.generated
     */
    private String drinkStatus;

    /**
     * 孩子情况
     *
     * @mbg.generated
     */
    private String childStatus;

    /**
     * 抽烟情况
     *
     * @mbg.generated
     */
    private String smokeStatus;

    /**
     * 是否与父母同住
     *
     * @mbg.generated
     */
    private String livingStatus;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIncomeMonthly() {
        return incomeMonthly;
    }

    public void setIncomeMonthly(String incomeMonthly) {
        this.incomeMonthly = incomeMonthly;
    }

    public String getIncomeYear() {
        return incomeYear;
    }

    public void setIncomeYear(String incomeYear) {
        this.incomeYear = incomeYear;
    }

    public String getHouseState() {
        return houseState;
    }

    public void setHouseState(String houseState) {
        this.houseState = houseState;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getFriendRequire() {
        return friendRequire;
    }

    public void setFriendRequire(String friendRequire) {
        this.friendRequire = friendRequire;
    }

    public String getDrinkStatus() {
        return drinkStatus;
    }

    public void setDrinkStatus(String drinkStatus) {
        this.drinkStatus = drinkStatus;
    }

    public String getChildStatus() {
        return childStatus;
    }

    public void setChildStatus(String childStatus) {
        this.childStatus = childStatus;
    }

    public String getSmokeStatus() {
        return smokeStatus;
    }

    public void setSmokeStatus(String smokeStatus) {
        this.smokeStatus = smokeStatus;
    }

    public String getLivingStatus() {
        return livingStatus;
    }

    public void setLivingStatus(String livingStatus) {
        this.livingStatus = livingStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", sex=").append(sex);
        sb.append(", height=").append(height);
        sb.append(", shape=").append(shape);
        sb.append(", age=").append(age);
        sb.append(", incomeMonthly=").append(incomeMonthly);
        sb.append(", incomeYear=").append(incomeYear);
        sb.append(", houseState=").append(houseState);
        sb.append(", education=").append(education);
        sb.append(", maritalStatus=").append(maritalStatus);
        sb.append(", houseStatus=").append(houseStatus);
        sb.append(", carStatus=").append(carStatus);
        sb.append(", job=").append(job);
        sb.append(", friendRequire=").append(friendRequire);
        sb.append(", drinkStatus=").append(drinkStatus);
        sb.append(", childStatus=").append(childStatus);
        sb.append(", smokeStatus=").append(smokeStatus);
        sb.append(", livingStatus=").append(livingStatus);
        sb.append("]");
        return sb.toString();
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
        FUserRequest other = (FUserRequest) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getShape() == null ? other.getShape() == null : this.getShape().equals(other.getShape()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getIncomeMonthly() == null ? other.getIncomeMonthly() == null : this.getIncomeMonthly().equals(other.getIncomeMonthly()))
            && (this.getIncomeYear() == null ? other.getIncomeYear() == null : this.getIncomeYear().equals(other.getIncomeYear()))
            && (this.getHouseState() == null ? other.getHouseState() == null : this.getHouseState().equals(other.getHouseState()))
            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
            && (this.getMaritalStatus() == null ? other.getMaritalStatus() == null : this.getMaritalStatus().equals(other.getMaritalStatus()))
            && (this.getHouseStatus() == null ? other.getHouseStatus() == null : this.getHouseStatus().equals(other.getHouseStatus()))
            && (this.getCarStatus() == null ? other.getCarStatus() == null : this.getCarStatus().equals(other.getCarStatus()))
            && (this.getJob() == null ? other.getJob() == null : this.getJob().equals(other.getJob()))
            && (this.getFriendRequire() == null ? other.getFriendRequire() == null : this.getFriendRequire().equals(other.getFriendRequire()))
            && (this.getDrinkStatus() == null ? other.getDrinkStatus() == null : this.getDrinkStatus().equals(other.getDrinkStatus()))
            && (this.getChildStatus() == null ? other.getChildStatus() == null : this.getChildStatus().equals(other.getChildStatus()))
            && (this.getSmokeStatus() == null ? other.getSmokeStatus() == null : this.getSmokeStatus().equals(other.getSmokeStatus()))
            && (this.getLivingStatus() == null ? other.getLivingStatus() == null : this.getLivingStatus().equals(other.getLivingStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getShape() == null) ? 0 : getShape().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getIncomeMonthly() == null) ? 0 : getIncomeMonthly().hashCode());
        result = prime * result + ((getIncomeYear() == null) ? 0 : getIncomeYear().hashCode());
        result = prime * result + ((getHouseState() == null) ? 0 : getHouseState().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getMaritalStatus() == null) ? 0 : getMaritalStatus().hashCode());
        result = prime * result + ((getHouseStatus() == null) ? 0 : getHouseStatus().hashCode());
        result = prime * result + ((getCarStatus() == null) ? 0 : getCarStatus().hashCode());
        result = prime * result + ((getJob() == null) ? 0 : getJob().hashCode());
        result = prime * result + ((getFriendRequire() == null) ? 0 : getFriendRequire().hashCode());
        result = prime * result + ((getDrinkStatus() == null) ? 0 : getDrinkStatus().hashCode());
        result = prime * result + ((getChildStatus() == null) ? 0 : getChildStatus().hashCode());
        result = prime * result + ((getSmokeStatus() == null) ? 0 : getSmokeStatus().hashCode());
        result = prime * result + ((getLivingStatus() == null) ? 0 : getLivingStatus().hashCode());
        return result;
    }
}