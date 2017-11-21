package com.zheng.friend.dao.model;

import java.io.Serializable;

public class FUserBaseMsg implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * 昵称
     *
     * @mbg.generated
     */
    private String nikename;

    /**
     * 出生年月
     *
     * @mbg.generated
     */
    private String birthDate;

    /**
     * 身高
     *
     * @mbg.generated
     */
    private Float height;

    /**
     * 体型
     *
     * @mbg.generated
     */
    private String shape;

    /**
     * 年收入
     *
     * @mbg.generated
     */
    private String yearIncome;

    /**
     * 月薪
     *
     * @mbg.generated
     */
    private String monthIncome;

    /**
     * 教育
     *
     * @mbg.generated
     */
    private String education;

    /**
     * 性格
     *
     * @mbg.generated
     */
    private String disposition;

    /**
     * 职业
     *
     * @mbg.generated
     */
    private String profession;

    /**
     * 单位性质
     *
     * @mbg.generated
     */
    private String unitProperty;

    /**
     * 工作单位
     *
     * @mbg.generated
     */
    private String workUnit;

    /**
     * 工作地点
     *
     * @mbg.generated
     */
    private String workPlace;

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
     * 婚姻状况
     *
     * @mbg.generated
     */
    private String maritalStatus;

    /**
     * 孩子状况
     *
     * @mbg.generated
     */
    private String childrenStatus;

    /**
     * 内心独白
     *
     * @mbg.generated
     */
    private String soliloquy;

    /**
     * 交友宣言
     *
     * @mbg.generated
     */
    private String declaration;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getYearIncome() {
        return yearIncome;
    }

    public void setYearIncome(String yearIncome) {
        this.yearIncome = yearIncome;
    }

    public String getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(String monthIncome) {
        this.monthIncome = monthIncome;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getUnitProperty() {
        return unitProperty;
    }

    public void setUnitProperty(String unitProperty) {
        this.unitProperty = unitProperty;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
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

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getChildrenStatus() {
        return childrenStatus;
    }

    public void setChildrenStatus(String childrenStatus) {
        this.childrenStatus = childrenStatus;
    }

    public String getSoliloquy() {
        return soliloquy;
    }

    public void setSoliloquy(String soliloquy) {
        this.soliloquy = soliloquy;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", nikename=").append(nikename);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", height=").append(height);
        sb.append(", shape=").append(shape);
        sb.append(", yearIncome=").append(yearIncome);
        sb.append(", monthIncome=").append(monthIncome);
        sb.append(", education=").append(education);
        sb.append(", disposition=").append(disposition);
        sb.append(", profession=").append(profession);
        sb.append(", unitProperty=").append(unitProperty);
        sb.append(", workUnit=").append(workUnit);
        sb.append(", workPlace=").append(workPlace);
        sb.append(", houseStatus=").append(houseStatus);
        sb.append(", carStatus=").append(carStatus);
        sb.append(", maritalStatus=").append(maritalStatus);
        sb.append(", childrenStatus=").append(childrenStatus);
        sb.append(", soliloquy=").append(soliloquy);
        sb.append(", declaration=").append(declaration);
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
        FUserBaseMsg other = (FUserBaseMsg) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getNikename() == null ? other.getNikename() == null : this.getNikename().equals(other.getNikename()))
            && (this.getBirthDate() == null ? other.getBirthDate() == null : this.getBirthDate().equals(other.getBirthDate()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getShape() == null ? other.getShape() == null : this.getShape().equals(other.getShape()))
            && (this.getYearIncome() == null ? other.getYearIncome() == null : this.getYearIncome().equals(other.getYearIncome()))
            && (this.getMonthIncome() == null ? other.getMonthIncome() == null : this.getMonthIncome().equals(other.getMonthIncome()))
            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
            && (this.getDisposition() == null ? other.getDisposition() == null : this.getDisposition().equals(other.getDisposition()))
            && (this.getProfession() == null ? other.getProfession() == null : this.getProfession().equals(other.getProfession()))
            && (this.getUnitProperty() == null ? other.getUnitProperty() == null : this.getUnitProperty().equals(other.getUnitProperty()))
            && (this.getWorkUnit() == null ? other.getWorkUnit() == null : this.getWorkUnit().equals(other.getWorkUnit()))
            && (this.getWorkPlace() == null ? other.getWorkPlace() == null : this.getWorkPlace().equals(other.getWorkPlace()))
            && (this.getHouseStatus() == null ? other.getHouseStatus() == null : this.getHouseStatus().equals(other.getHouseStatus()))
            && (this.getCarStatus() == null ? other.getCarStatus() == null : this.getCarStatus().equals(other.getCarStatus()))
            && (this.getMaritalStatus() == null ? other.getMaritalStatus() == null : this.getMaritalStatus().equals(other.getMaritalStatus()))
            && (this.getChildrenStatus() == null ? other.getChildrenStatus() == null : this.getChildrenStatus().equals(other.getChildrenStatus()))
            && (this.getSoliloquy() == null ? other.getSoliloquy() == null : this.getSoliloquy().equals(other.getSoliloquy()))
            && (this.getDeclaration() == null ? other.getDeclaration() == null : this.getDeclaration().equals(other.getDeclaration()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getNikename() == null) ? 0 : getNikename().hashCode());
        result = prime * result + ((getBirthDate() == null) ? 0 : getBirthDate().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getShape() == null) ? 0 : getShape().hashCode());
        result = prime * result + ((getYearIncome() == null) ? 0 : getYearIncome().hashCode());
        result = prime * result + ((getMonthIncome() == null) ? 0 : getMonthIncome().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getDisposition() == null) ? 0 : getDisposition().hashCode());
        result = prime * result + ((getProfession() == null) ? 0 : getProfession().hashCode());
        result = prime * result + ((getUnitProperty() == null) ? 0 : getUnitProperty().hashCode());
        result = prime * result + ((getWorkUnit() == null) ? 0 : getWorkUnit().hashCode());
        result = prime * result + ((getWorkPlace() == null) ? 0 : getWorkPlace().hashCode());
        result = prime * result + ((getHouseStatus() == null) ? 0 : getHouseStatus().hashCode());
        result = prime * result + ((getCarStatus() == null) ? 0 : getCarStatus().hashCode());
        result = prime * result + ((getMaritalStatus() == null) ? 0 : getMaritalStatus().hashCode());
        result = prime * result + ((getChildrenStatus() == null) ? 0 : getChildrenStatus().hashCode());
        result = prime * result + ((getSoliloquy() == null) ? 0 : getSoliloquy().hashCode());
        result = prime * result + ((getDeclaration() == null) ? 0 : getDeclaration().hashCode());
        return result;
    }
}