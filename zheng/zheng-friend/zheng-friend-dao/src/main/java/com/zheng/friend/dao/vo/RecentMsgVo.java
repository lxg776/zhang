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


    public int getShowFla() {
        return showFla;
    }

    public void setShowFla(int showFla) {
        this.showFla = showFla;
    }

    // 0 left  1 right
    private int showFla =1;

    private String showDate;

    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }
}
