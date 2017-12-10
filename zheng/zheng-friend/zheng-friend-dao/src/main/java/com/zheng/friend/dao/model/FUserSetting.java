package com.zheng.friend.dao.model;

import java.io.Serializable;

public class FUserSetting implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * 首页能否显示(0:能,1:不能)
     *
     * @mbg.generated
     */
    private Byte showIndexPage;

    /**
     * 基本信息能否显示(0:能,1:不能)
     *
     * @mbg.generated
     */
    private Byte showBaseMsg;

    /**
     * 择偶要求能否显示(0:能,1:不能)
     *
     * @mbg.generated
     */
    private Byte showFriendRequest;

    /**
     * 生活状况能否显示(0:能,1:不能)
     *
     * @mbg.generated
     */
    private Byte showLivingStatus;

    /**
     * 生活状况能否显示(0:能,1:不能)
     *
     * @mbg.generated
     */
    private Byte showFavorite;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getShowIndexPage() {
        return showIndexPage;
    }

    public void setShowIndexPage(Byte showIndexPage) {
        this.showIndexPage = showIndexPage;
    }

    public Byte getShowBaseMsg() {
        return showBaseMsg;
    }

    public void setShowBaseMsg(Byte showBaseMsg) {
        this.showBaseMsg = showBaseMsg;
    }

    public Byte getShowFriendRequest() {
        return showFriendRequest;
    }

    public void setShowFriendRequest(Byte showFriendRequest) {
        this.showFriendRequest = showFriendRequest;
    }

    public Byte getShowLivingStatus() {
        return showLivingStatus;
    }

    public void setShowLivingStatus(Byte showLivingStatus) {
        this.showLivingStatus = showLivingStatus;
    }

    public Byte getShowFavorite() {
        return showFavorite;
    }

    public void setShowFavorite(Byte showFavorite) {
        this.showFavorite = showFavorite;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", showIndexPage=").append(showIndexPage);
        sb.append(", showBaseMsg=").append(showBaseMsg);
        sb.append(", showFriendRequest=").append(showFriendRequest);
        sb.append(", showLivingStatus=").append(showLivingStatus);
        sb.append(", showFavorite=").append(showFavorite);
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
        FUserSetting other = (FUserSetting) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getShowIndexPage() == null ? other.getShowIndexPage() == null : this.getShowIndexPage().equals(other.getShowIndexPage()))
            && (this.getShowBaseMsg() == null ? other.getShowBaseMsg() == null : this.getShowBaseMsg().equals(other.getShowBaseMsg()))
            && (this.getShowFriendRequest() == null ? other.getShowFriendRequest() == null : this.getShowFriendRequest().equals(other.getShowFriendRequest()))
            && (this.getShowLivingStatus() == null ? other.getShowLivingStatus() == null : this.getShowLivingStatus().equals(other.getShowLivingStatus()))
            && (this.getShowFavorite() == null ? other.getShowFavorite() == null : this.getShowFavorite().equals(other.getShowFavorite()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getShowIndexPage() == null) ? 0 : getShowIndexPage().hashCode());
        result = prime * result + ((getShowBaseMsg() == null) ? 0 : getShowBaseMsg().hashCode());
        result = prime * result + ((getShowFriendRequest() == null) ? 0 : getShowFriendRequest().hashCode());
        result = prime * result + ((getShowLivingStatus() == null) ? 0 : getShowLivingStatus().hashCode());
        result = prime * result + ((getShowFavorite() == null) ? 0 : getShowFavorite().hashCode());
        return result;
    }
}