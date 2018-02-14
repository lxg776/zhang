package com.zheng.friend.dao.model;

import java.io.Serializable;

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
    private String signEndTime;

    /**
     * 活动时间
     *
     * @mbg.generated
     */
    private String activityTime;

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
     * 联系电话
     *
     * @mbg.generated
     */
    private String linkPhone;

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
     * 创建时间
     *
     * @mbg.generated
     */
    private Long ctime;

    /**
     * 封面图片
     *
     * @mbg.generated
     */
    private String coverImage;

    /**
     * 内容
     *
     * @mbg.generated
     */
    private String content;

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

    public String getSignEndTime() {
        return signEndTime;
    }

    public void setSignEndTime(String signEndTime) {
        this.signEndTime = signEndTime;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
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

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
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

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        sb.append(", linkPhone=").append(linkPhone);
        sb.append(", activityAddress=").append(activityAddress);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", ctime=").append(ctime);
        sb.append(", coverImage=").append(coverImage);
        sb.append(", content=").append(content);
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
            && (this.getLinkPhone() == null ? other.getLinkPhone() == null : this.getLinkPhone().equals(other.getLinkPhone()))
            && (this.getActivityAddress() == null ? other.getActivityAddress() == null : this.getActivityAddress().equals(other.getActivityAddress()))
            && (this.getShowStatus() == null ? other.getShowStatus() == null : this.getShowStatus().equals(other.getShowStatus()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getCoverImage() == null ? other.getCoverImage() == null : this.getCoverImage().equals(other.getCoverImage()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
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
        result = prime * result + ((getLinkPhone() == null) ? 0 : getLinkPhone().hashCode());
        result = prime * result + ((getActivityAddress() == null) ? 0 : getActivityAddress().hashCode());
        result = prime * result + ((getShowStatus() == null) ? 0 : getShowStatus().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getCoverImage() == null) ? 0 : getCoverImage().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getAttention() == null) ? 0 : getAttention().hashCode());
        return result;
    }
}