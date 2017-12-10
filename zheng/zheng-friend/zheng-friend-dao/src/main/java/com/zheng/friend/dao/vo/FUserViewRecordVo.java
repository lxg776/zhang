package com.zheng.friend.dao.vo;

import com.zheng.friend.dao.model.FUserBaseMsg;
import com.zheng.friend.dao.model.FUserViewRecord;
import com.zheng.ucenter.dao.model.UcenterUser;


public class FUserViewRecordVo extends FUserViewRecord {



    private FUserBaseMsg fwUserBaseMsg;


    public FUserBaseMsg getFwUserBaseMsg() {
        return fwUserBaseMsg;
    }

    public void setFwUserBaseMsg(FUserBaseMsg fwUserBaseMsg) {
        this.fwUserBaseMsg = fwUserBaseMsg;
    }

}
