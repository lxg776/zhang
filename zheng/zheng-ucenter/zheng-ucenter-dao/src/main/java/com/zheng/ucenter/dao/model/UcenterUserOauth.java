package com.zheng.ucenter.dao.model;

import java.io.Serializable;
import java.util.Date;

public class UcenterUserOauth implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Integer userOauthId;

    /**
     * 帐号编号
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * 认证方式编号
     *
     * @mbg.generated
     */
    private Integer oauthId;

    /**
     * 第三方ID
     *
     * @mbg.generated
     */
    private String openId;

    /**
     * 绑定状态(0:解绑,1:绑定)
     *
     * @mbg.generated
     */
    private Byte status;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getUserOauthId() {
        return userOauthId;
    }

    public void setUserOauthId(Integer userOauthId) {
        this.userOauthId = userOauthId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOauthId() {
        return oauthId;
    }

    public void setOauthId(Integer oauthId) {
        this.oauthId = oauthId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userOauthId=").append(userOauthId);
        sb.append(", userId=").append(userId);
        sb.append(", oauthId=").append(oauthId);
        sb.append(", openId=").append(openId);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
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
        UcenterUserOauth other = (UcenterUserOauth) that;
        return (this.getUserOauthId() == null ? other.getUserOauthId() == null : this.getUserOauthId().equals(other.getUserOauthId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOauthId() == null ? other.getOauthId() == null : this.getOauthId().equals(other.getOauthId()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserOauthId() == null) ? 0 : getUserOauthId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOauthId() == null) ? 0 : getOauthId().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}