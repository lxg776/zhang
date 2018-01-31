package com.zheng.friend.dao.model;

import java.io.Serializable;
import java.util.Date;

public class FContact implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 来自用户
     *
     * @mbg.generated
     */
    private Integer fUserId;

    /**
     * 要求联系的用户
     *
     * @mbg.generated
     */
    private Integer tUserId;

    /**
     * 联系次数
     *
     * @mbg.generated
     */
    private Integer contactCount;

    /**
     * 双方状况(0:不是双方,1双方都要去联系对方)
     *
     * @mbg.generated
     */
    private Byte bothStatus;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remarks;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getfUserId() {
        return fUserId;
    }

    public void setfUserId(Integer fUserId) {
        this.fUserId = fUserId;
    }

    public Integer gettUserId() {
        return tUserId;
    }

    public void settUserId(Integer tUserId) {
        this.tUserId = tUserId;
    }

    public Integer getContactCount() {
        return contactCount;
    }

    public void setContactCount(Integer contactCount) {
        this.contactCount = contactCount;
    }

    public Byte getBothStatus() {
        return bothStatus;
    }

    public void setBothStatus(Byte bothStatus) {
        this.bothStatus = bothStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fUserId=").append(fUserId);
        sb.append(", tUserId=").append(tUserId);
        sb.append(", contactCount=").append(contactCount);
        sb.append(", bothStatus=").append(bothStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", remarks=").append(remarks);
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
        FContact other = (FContact) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getfUserId() == null ? other.getfUserId() == null : this.getfUserId().equals(other.getfUserId()))
            && (this.gettUserId() == null ? other.gettUserId() == null : this.gettUserId().equals(other.gettUserId()))
            && (this.getContactCount() == null ? other.getContactCount() == null : this.getContactCount().equals(other.getContactCount()))
            && (this.getBothStatus() == null ? other.getBothStatus() == null : this.getBothStatus().equals(other.getBothStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getfUserId() == null) ? 0 : getfUserId().hashCode());
        result = prime * result + ((gettUserId() == null) ? 0 : gettUserId().hashCode());
        result = prime * result + ((getContactCount() == null) ? 0 : getContactCount().hashCode());
        result = prime * result + ((getBothStatus() == null) ? 0 : getBothStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        return result;
    }
}