package com.zheng.friend.dao.vo;

import com.zheng.friend.dao.model.FUserBaseMsg;
import com.zheng.friend.dao.model.FUserLivingStatus;
import com.zheng.friend.dao.model.FUserRequest;
import com.zheng.ucenter.dao.model.UcenterIdentificaion;
import com.zheng.ucenter.dao.model.UcenterUser;



public class FuserDetailVo extends UcenterUser {

    private FUserRequest fUserRequest;

    private FUserBaseMsg fUserBaseMsg;

    private FUserLivingStatus fUserLivingStatus;

    private UcenterIdentificaion ucenterIdentificaion;

    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public FUserRequest getfUserRequest() {
        return fUserRequest;
    }

    public void setfUserRequest(FUserRequest fUserRequest) {
        this.fUserRequest = fUserRequest;
    }

    public FUserBaseMsg getfUserBaseMsg() {
        return fUserBaseMsg;
    }

    public void setfUserBaseMsg(FUserBaseMsg fUserBaseMsg) {
        this.fUserBaseMsg = fUserBaseMsg;
    }

    public FUserLivingStatus getfUserLivingStatus() {
        return fUserLivingStatus;
    }

    public void setfUserLivingStatus(FUserLivingStatus fUserLivingStatus) {
        this.fUserLivingStatus = fUserLivingStatus;
    }

    public UcenterIdentificaion getUcenterIdentificaion() {
        return ucenterIdentificaion;
    }

    public void setUcenterIdentificaion(UcenterIdentificaion ucenterIdentificaion) {
        this.ucenterIdentificaion = ucenterIdentificaion;
    }
}
