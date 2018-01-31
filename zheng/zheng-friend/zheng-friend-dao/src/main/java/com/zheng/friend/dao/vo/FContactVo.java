package com.zheng.friend.dao.vo;

import com.zheng.friend.dao.model.FContact;
import com.zheng.friend.dao.model.FUserBaseMsg;
import com.zheng.friend.dao.model.FUserRequest;

public class FContactVo extends FContact {

    FUserBaseMsg fUserBaseMsg;
    FUserBaseMsg tUserBaseMsg;

    FUserRequest fUserRequest;
    FUserRequest tUserRequest;


    public FUserBaseMsg getfUserBaseMsg() {
        return fUserBaseMsg;
    }

    public void setfUserBaseMsg(FUserBaseMsg fUserBaseMsg) {
        this.fUserBaseMsg = fUserBaseMsg;
    }

    public FUserBaseMsg gettUserBaseMsg() {
        return tUserBaseMsg;
    }

    public void settUserBaseMsg(FUserBaseMsg tUserBaseMsg) {
        this.tUserBaseMsg = tUserBaseMsg;
    }

    public FUserRequest getfUserRequest() {
        return fUserRequest;
    }

    public void setfUserRequest(FUserRequest fUserRequest) {
        this.fUserRequest = fUserRequest;
    }

    public FUserRequest gettUserRequest() {
        return tUserRequest;
    }

    public void settUserRequest(FUserRequest tUserRequest) {
        this.tUserRequest = tUserRequest;
    }
}