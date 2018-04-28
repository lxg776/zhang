package com.zheng.friend.dao.vo;

import com.zheng.friend.dao.model.FMemberType;

public class FMemberTypeVo  extends FMemberType{

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
}
