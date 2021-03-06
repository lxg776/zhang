package com.zheng.pay.dao.model;

import java.io.Serializable;

public class PayInOrder implements Serializable {


    public final static byte STATUS_CREATE = '1';//订单创建
    public final static byte STATUS_PAY = '2';//订单支付，但未完成更改资料
    public final static byte ORDER_FINISH = '3';//订单完成，未完成更改资料
    public final static byte ORDER_CANCEL = '4';//订单取消


    private Integer payInOrderId;

    private Integer payVendorId;

    private Long amount;

    private Byte status;

    private Long ctime;

    private String callBack;

    private static final long serialVersionUID = 1L;

    public Integer getPayInOrderId() {
        return payInOrderId;
    }

    public void setPayInOrderId(Integer payInOrderId) {
        this.payInOrderId = payInOrderId;
    }

    public Integer getPayVendorId() {
        return payVendorId;
    }

    public void setPayVendorId(Integer payVendorId) {
        this.payVendorId = payVendorId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public String getCallBack() {
        return callBack;
    }

    public void setCallBack(String callBack) {
        this.callBack = callBack;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", payInOrderId=").append(payInOrderId);
        sb.append(", payVendorId=").append(payVendorId);
        sb.append(", amount=").append(amount);
        sb.append(", status=").append(status);
        sb.append(", ctime=").append(ctime);
        sb.append(", callBack=").append(callBack);
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
        PayInOrder other = (PayInOrder) that;
        return (this.getPayInOrderId() == null ? other.getPayInOrderId() == null : this.getPayInOrderId().equals(other.getPayInOrderId()))
            && (this.getPayVendorId() == null ? other.getPayVendorId() == null : this.getPayVendorId().equals(other.getPayVendorId()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getCallBack() == null ? other.getCallBack() == null : this.getCallBack().equals(other.getCallBack()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPayInOrderId() == null) ? 0 : getPayInOrderId().hashCode());
        result = prime * result + ((getPayVendorId() == null) ? 0 : getPayVendorId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getCallBack() == null) ? 0 : getCallBack().hashCode());
        return result;
    }
}