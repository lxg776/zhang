package com.zheng.ucenter.dao.model;

import java.io.Serializable;

public class UcenterIdentificaion implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * 真实姓名
     *
     * @mbg.generated
     */
    private String realName;

    /**
     * 证件类型
     *
     * @mbg.generated
     */
    private String idcardType;

    /**
     * 证件号码
     *
     * @mbg.generated
     */
    private String idcardNo;

    /**
     * 手机号码
     *
     * @mbg.generated
     */
    private String cellphone;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdcardType() {
        return idcardType;
    }

    public void setIdcardType(String idcardType) {
        this.idcardType = idcardType;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", realName=").append(realName);
        sb.append(", idcardType=").append(idcardType);
        sb.append(", idcardNo=").append(idcardNo);
        sb.append(", cellphone=").append(cellphone);
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
        UcenterIdentificaion other = (UcenterIdentificaion) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getIdcardType() == null ? other.getIdcardType() == null : this.getIdcardType().equals(other.getIdcardType()))
            && (this.getIdcardNo() == null ? other.getIdcardNo() == null : this.getIdcardNo().equals(other.getIdcardNo()))
            && (this.getCellphone() == null ? other.getCellphone() == null : this.getCellphone().equals(other.getCellphone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getIdcardType() == null) ? 0 : getIdcardType().hashCode());
        result = prime * result + ((getIdcardNo() == null) ? 0 : getIdcardNo().hashCode());
        result = prime * result + ((getCellphone() == null) ? 0 : getCellphone().hashCode());
        return result;
    }
}