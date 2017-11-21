package com.zheng.friend.dao.model;

import java.io.Serializable;
import java.util.Date;

public class FMemberType implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 类型名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 简介图片
     *
     * @mbg.generated
     */
    private String infoImg;

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

    /**
     * 等级
     *
     * @mbg.generated
     */
    private Integer level;

    /**
     * 开通价格
     *
     * @mbg.generated
     */
    private Float price;

    /**
     * 服务天数
     *
     * @mbg.generated
     */
    private Integer serviceDays;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 类型简介
     *
     * @mbg.generated
     */
    private String info;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfoImg() {
        return infoImg;
    }

    public void setInfoImg(String infoImg) {
        this.infoImg = infoImg;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getServiceDays() {
        return serviceDays;
    }

    public void setServiceDays(Integer serviceDays) {
        this.serviceDays = serviceDays;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", infoImg=").append(infoImg);
        sb.append(", msgReadStatus=").append(msgReadStatus);
        sb.append(", msgSendStatus=").append(msgSendStatus);
        sb.append(", viewMsgStatus=").append(viewMsgStatus);
        sb.append(", hongniangStatus=").append(hongniangStatus);
        sb.append(", historyviewStatus=").append(historyviewStatus);
        sb.append(", level=").append(level);
        sb.append(", price=").append(price);
        sb.append(", serviceDays=").append(serviceDays);
        sb.append(", createTime=").append(createTime);
        sb.append(", info=").append(info);
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
        FMemberType other = (FMemberType) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getInfoImg() == null ? other.getInfoImg() == null : this.getInfoImg().equals(other.getInfoImg()))
            && (this.getMsgReadStatus() == null ? other.getMsgReadStatus() == null : this.getMsgReadStatus().equals(other.getMsgReadStatus()))
            && (this.getMsgSendStatus() == null ? other.getMsgSendStatus() == null : this.getMsgSendStatus().equals(other.getMsgSendStatus()))
            && (this.getViewMsgStatus() == null ? other.getViewMsgStatus() == null : this.getViewMsgStatus().equals(other.getViewMsgStatus()))
            && (this.getHongniangStatus() == null ? other.getHongniangStatus() == null : this.getHongniangStatus().equals(other.getHongniangStatus()))
            && (this.getHistoryviewStatus() == null ? other.getHistoryviewStatus() == null : this.getHistoryviewStatus().equals(other.getHistoryviewStatus()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getServiceDays() == null ? other.getServiceDays() == null : this.getServiceDays().equals(other.getServiceDays()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getInfo() == null ? other.getInfo() == null : this.getInfo().equals(other.getInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getInfoImg() == null) ? 0 : getInfoImg().hashCode());
        result = prime * result + ((getMsgReadStatus() == null) ? 0 : getMsgReadStatus().hashCode());
        result = prime * result + ((getMsgSendStatus() == null) ? 0 : getMsgSendStatus().hashCode());
        result = prime * result + ((getViewMsgStatus() == null) ? 0 : getViewMsgStatus().hashCode());
        result = prime * result + ((getHongniangStatus() == null) ? 0 : getHongniangStatus().hashCode());
        result = prime * result + ((getHistoryviewStatus() == null) ? 0 : getHistoryviewStatus().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getServiceDays() == null) ? 0 : getServiceDays().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getInfo() == null) ? 0 : getInfo().hashCode());
        return result;
    }
}