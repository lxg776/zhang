package com.zheng.friend.dao.model;

import java.io.Serializable;
import java.util.Date;

public class FActivity implements Serializable {
    /**
     * 活动编号
     *
     * @mbg.generated
     */
    private Integer activityId;

    /**
     * 标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 报名时间
     *
     * @mbg.generated
     */
    private String signTime;

    /**
     * 报名截止时间
     *
     * @mbg.generated
     */
    private Date signEndTime;

    /**
     * 活动时间
     *
     * @mbg.generated
     */
    private Date activityTime;

    /**
     * 主办方
     *
     * @mbg.generated
     */
    private String sponsor;

    /**
     * 联系人
     *
     * @mbg.generated
     */
    private String linkMan;

    /**
     * 报名费用
     *
     * @mbg.generated
     */
    private String signCost;

    /**
     * 联系地址
     *
     * @mbg.generated
     */
    private String linkAddress;

    /**
     * 活动地址
     *
     * @mbg.generated
     */
    private String activityAddress;

    /**
     * 显示标识
     *
     * @mbg.generated
     */
    private String showStatus;

    /**
     * 内容
     *
     * @mbg.generated
     */
    private String context;

    /**
     * 注意事项
     *
     * @mbg.generated
     */
    private String attention;

    private static final long serialVersionUID = 1L;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public Date getSignEndTime() {
        return signEndTime;
    }

    public void setSignEndTime(Date signEndTime) {
        this.signEndTime = signEndTime;
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getSignCost() {
        return signCost;
    }

    public void setSignCost(String signCost) {
        this.signCost = signCost;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public String getActivityAddress() {
        return activityAddress;
    }

    public void setActivityAddress(String activityAddress) {
        this.activityAddress = activityAddress;
    }

    public String getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(String showStatus) {
        this.showStatus = showStatus;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", activityId=").append(activityId);
        sb.append(", title=").append(title);
        sb.append(", signTime=").append(signTime);
        sb.append(", signEndTime=").append(signEndTime);
        sb.append(", activityTime=").append(activityTime);
        sb.append(", sponsor=").append(sponsor);
        sb.append(", linkMan=").append(linkMan);
        sb.append(", signCost=").append(signCost);
        sb.append(", linkAddress=").append(linkAddress);
        sb.append(", activityAddress=").append(activityAddress);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", context=").append(context);
        sb.append(", attention=").append(attention);
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
        FActivity other = (FActivity) that;
        return (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getSignTime() == null ? other.getSignTime() == null : this.getSignTime().equals(other.getSignTime()))
            && (this.getSignEndTime() == null ? other.getSignEndTime() == null : this.getSignEndTime().equals(other.getSignEndTime()))
            && (this.getActivityTime() == null ? other.getActivityTime() == null : this.getActivityTime().equals(other.getActivityTime()))
            && (this.getSponsor() == null ? other.getSponsor() == null : this.getSponsor().equals(other.getSponsor()))
            && (this.getLinkMan() == null ? other.getLinkMan() == null : this.getLinkMan().equals(other.getLinkMan()))
            && (this.getSignCost() == null ? other.getSignCost() == null : this.getSignCost().equals(other.getSignCost()))
            && (this.getLinkAddress() == null ? other.getLinkAddress() == null : this.getLinkAddress().equals(other.getLinkAddress()))
            && (this.getActivityAddress() == null ? other.getActivityAddress() == null : this.getActivityAddress().equals(other.getActivityAddress()))
            && (this.getShowStatus() == null ? other.getShowStatus() == null : this.getShowStatus().equals(other.getShowStatus()))
            && (this.getContext() == null ? other.getContext() == null : this.getContext().equals(other.getContext()))
            && (this.getAttention() == null ? other.getAttention() == null : this.getAttention().equals(other.getAttention()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getSignTime() == null) ? 0 : getSignTime().hashCode());
        result = prime * result + ((getSignEndTime() == null) ? 0 : getSignEndTime().hashCode());
        result = prime * result + ((getActivityTime() == null) ? 0 : getActivityTime().hashCode());
        result = prime * result + ((getSponsor() == null) ? 0 : getSponsor().hashCode());
        result = prime * result + ((getLinkMan() == null) ? 0 : getLinkMan().hashCode());
        result = prime * result + ((getSignCost() == null) ? 0 : getSignCost().hashCode());
        result = prime * result + ((getLinkAddress() == null) ? 0 : getLinkAddress().hashCode());
        result = prime * result + ((getActivityAddress() == null) ? 0 : getActivityAddress().hashCode());
        result = prime * result + ((getShowStatus() == null) ? 0 : getShowStatus().hashCode());
        result = prime * result + ((getContext() == null) ? 0 : getContext().hashCode());
        result = prime * result + ((getAttention() == null) ? 0 : getAttention().hashCode());
        return result;
    }
}