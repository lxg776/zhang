package com.zheng.friend.dao.model;

import java.io.Serializable;
import java.util.Date;

public class FUserMemberRel implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 用户id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * 会员类型id
     *
     * @mbg.generated
     */
    private Integer memberTypeId;

    /**
     * 开始时间
     *
     * @mbg.generated
     */
    private String begTime;

    /**
     * 结束时间
     *
     * @mbg.generated
     */
    private String endTime;

    /**
     * 终止状态(0:没有终止,1:终止)
     *
     * @mbg.generated
     */
    private Byte endStatus;

    /**
     * 操作时间
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 等级
     *
     * @mbg.generated
     */
    private Integer level;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMemberTypeId() {
        return memberTypeId;
    }

    public void setMemberTypeId(Integer memberTypeId) {
        this.memberTypeId = memberTypeId;
    }

    public String getBegTime() {
        return begTime;
    }

    public void setBegTime(String begTime) {
        this.begTime = begTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Byte getEndStatus() {
        return endStatus;
    }

    public void setEndStatus(Byte endStatus) {
        this.endStatus = endStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", memberTypeId=").append(memberTypeId);
        sb.append(", begTime=").append(begTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", endStatus=").append(endStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", level=").append(level);
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
        FUserMemberRel other = (FUserMemberRel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMemberTypeId() == null ? other.getMemberTypeId() == null : this.getMemberTypeId().equals(other.getMemberTypeId()))
            && (this.getBegTime() == null ? other.getBegTime() == null : this.getBegTime().equals(other.getBegTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getEndStatus() == null ? other.getEndStatus() == null : this.getEndStatus().equals(other.getEndStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMemberTypeId() == null) ? 0 : getMemberTypeId().hashCode());
        result = prime * result + ((getBegTime() == null) ? 0 : getBegTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getEndStatus() == null) ? 0 : getEndStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        return result;
    }
}