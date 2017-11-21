package com.zheng.friend.dao.model;

import java.io.Serializable;

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
     * 能否访问用户资料(0:没有终止,1:终止)
     *
     * @mbg.generated
     */
    private Byte endStatus;

    /**
     * 能否发送邮件(0:不能,1:可以)
     *
     * @mbg.generated
     */
    private Byte msgSendStatus;

    /**
     * 等级
     *
     * @mbg.generated
     */
    private Integer level;

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
     * 结束时间
     *
     * @mbg.generated
     */
    private String createtime;

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

    public Byte getEndStatus() {
        return endStatus;
    }

    public void setEndStatus(Byte endStatus) {
        this.endStatus = endStatus;
    }

    public Byte getMsgSendStatus() {
        return msgSendStatus;
    }

    public void setMsgSendStatus(Byte msgSendStatus) {
        this.msgSendStatus = msgSendStatus;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
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
        sb.append(", endStatus=").append(endStatus);
        sb.append(", msgSendStatus=").append(msgSendStatus);
        sb.append(", level=").append(level);
        sb.append(", begTime=").append(begTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", createtime=").append(createtime);
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
            && (this.getEndStatus() == null ? other.getEndStatus() == null : this.getEndStatus().equals(other.getEndStatus()))
            && (this.getMsgSendStatus() == null ? other.getMsgSendStatus() == null : this.getMsgSendStatus().equals(other.getMsgSendStatus()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getBegTime() == null ? other.getBegTime() == null : this.getBegTime().equals(other.getBegTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMemberTypeId() == null) ? 0 : getMemberTypeId().hashCode());
        result = prime * result + ((getEndStatus() == null) ? 0 : getEndStatus().hashCode());
        result = prime * result + ((getMsgSendStatus() == null) ? 0 : getMsgSendStatus().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getBegTime() == null) ? 0 : getBegTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        return result;
    }
}