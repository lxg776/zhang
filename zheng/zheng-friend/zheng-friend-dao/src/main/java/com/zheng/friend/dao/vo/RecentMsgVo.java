package com.zheng.friend.dao.vo;

import com.zheng.friend.dao.model.FMessage;
import com.zheng.friend.dao.model.FUserBaseMsg;

public class RecentMsgVo extends FMessage{

    private  long unReadCount;

    public long getUnReadCount() {
        return unReadCount;
    }

    public void setUnReadCount(long unReadCount) {
        this.unReadCount = unReadCount;
    }

    public FUserBaseMsg getfUserBaseMsg() {
        return fUserBaseMsg;
    }

    public void setfUserBaseMsg(FUserBaseMsg fUserBaseMsg) {
        this.fUserBaseMsg = fUserBaseMsg;
    }

    private  FUserBaseMsg fUserBaseMsg;

    private  FUserBaseMsg tUserBaseMsg;

    public FUserBaseMsg gettUserBaseMsg() {
        return tUserBaseMsg;
    }

    public void settUserBaseMsg(FUserBaseMsg tUserBaseMsg) {
        this.tUserBaseMsg = tUserBaseMsg;
    }
}
