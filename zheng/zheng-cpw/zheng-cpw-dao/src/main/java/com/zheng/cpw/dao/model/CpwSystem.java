package com.zheng.cpw.dao.model;

import java.io.Serializable;
import java.util.Date;

public class CpwSystem implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 系统名称
     *
     * @mbg.generated
     */
    private String sysName;

    /**
     * key
     *
     * @mbg.generated
     */
    private String sysKey;

    /**
     * 系统状态(0:审核中,1:审核通过)
     *
     * @mbg.generated
     */
    private Byte sysState;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysKey() {
        return sysKey;
    }

    public void setSysKey(String sysKey) {
        this.sysKey = sysKey;
    }

    public Byte getSysState() {
        return sysState;
    }

    public void setSysState(Byte sysState) {
        this.sysState = sysState;
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
        sb.append(", id=").append(id);
        sb.append(", sysName=").append(sysName);
        sb.append(", sysKey=").append(sysKey);
        sb.append(", sysState=").append(sysState);
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
        CpwSystem other = (CpwSystem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSysName() == null ? other.getSysName() == null : this.getSysName().equals(other.getSysName()))
            && (this.getSysKey() == null ? other.getSysKey() == null : this.getSysKey().equals(other.getSysKey()))
            && (this.getSysState() == null ? other.getSysState() == null : this.getSysState().equals(other.getSysState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSysName() == null) ? 0 : getSysName().hashCode());
        result = prime * result + ((getSysKey() == null) ? 0 : getSysKey().hashCode());
        result = prime * result + ((getSysState() == null) ? 0 : getSysState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}