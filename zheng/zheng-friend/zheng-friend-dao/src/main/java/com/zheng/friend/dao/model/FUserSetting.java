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

    /**
     * 能否查看收件箱(0:不能,1:可以)
     *
     * @mbg.generated
     */
    private Byte msgReadStatus;

    /**
     * 能否发送邮件(0:不能,1:可以)
     *
     * @mbg.generated
     */
    private Byte msgSendStatus;

    /**
     * 能否访问用户资料(0:不能,1:可以)
     *
     * @mbg.generated
     */
    private Byte viewMsgStatus;

    /**
     * 是否开通红娘服务(0:不能,1:可以)
     *
     * @mbg.generated
     */
    private Byte hongniangStatus;

    /**
     * 能否查看访问记录(0:不能,1:可以)
     *
     * @mbg.generated
     */
    private Byte historyviewStatus;

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

    public Byte getMsgReadStatus() {
        return msgReadStatus;
    }

    public void setMsgReadStatus(Byte msgReadStatus) {
        this.msgReadStatus = msgReadStatus;
    }

    public Byte getMsgSendStatus() {
        return msgSendStatus;
    }

    public void setMsgSendStatus(Byte msgSendStatus) {
        this.msgSendStatus = msgSendStatus;
    }

    public Byte getViewMsgStatus() {
        return viewMsgStatus;
    }

    public void setViewMsgStatus(Byte viewMsgStatus) {
        this.viewMsgStatus = viewMsgStatus;
    }

    public Byte getHongniangStatus() {
        return hongniangStatus;
    }

    public void setHongniangStatus(Byte hongniangStatus) {
        this.hongniangStatus = hongniangStatus;
    }

    public Byte getHistoryviewStatus() {
        return historyviewStatus;
    }

    public void setHistoryviewStatus(Byte historyviewStatus) {
        this.historyviewStatus = historyviewStatus;
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
        sb.append(", msgReadStatus=").append(msgReadStatus);
        sb.append(", msgSendStatus=").append(msgSendStatus);
        sb.append(", viewMsgStatus=").append(viewMsgStatus);
        sb.append(", hongniangStatus=").append(hongniangStatus);
        sb.append(", historyviewStatus=").append(historyviewStatus);
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
            && (this.getShowFavorite() == null ? other.getShowFavorite() == null : this.getShowFavorite().equals(other.getShowFavorite()))
            && (this.getMsgReadStatus() == null ? other.getMsgReadStatus() == null : this.getMsgReadStatus().equals(other.getMsgReadStatus()))
            && (this.getMsgSendStatus() == null ? other.getMsgSendStatus() == null : this.getMsgSendStatus().equals(other.getMsgSendStatus()))
            && (this.getViewMsgStatus() == null ? other.getViewMsgStatus() == null : this.getViewMsgStatus().equals(other.getViewMsgStatus()))
            && (this.getHongniangStatus() == null ? other.getHongniangStatus() == null : this.getHongniangStatus().equals(other.getHongniangStatus()))
            && (this.getHistoryviewStatus() == null ? other.getHistoryviewStatus() == null : this.getHistoryviewStatus().equals(other.getHistoryviewStatus()));
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
        result = prime * result + ((getMsgReadStatus() == null) ? 0 : getMsgReadStatus().hashCode());
        result = prime * result + ((getMsgSendStatus() == null) ? 0 : getMsgSendStatus().hashCode());
        result = prime * result + ((getViewMsgStatus() == null) ? 0 : getViewMsgStatus().hashCode());
        result = prime * result + ((getHongniangStatus() == null) ? 0 : getHongniangStatus().hashCode());
        result = prime * result + ((getHistoryviewStatus() == null) ? 0 : getHistoryviewStatus().hashCode());
        return result;
    }
}