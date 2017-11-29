package com.zheng.friend.dao.vo;

import com.zheng.friend.dao.model.FUserMemberRel;

public class FUserMemberRelVo extends FUserMemberRel{


    /**
     * 会员类型id
     *
     * @mbg.generated
     */
    private String  memberTypeName;

    public String getMemberTypeName() {
        return memberTypeName;
    }

    public void setMemberTypeName(String memberTypeName) {
        this.memberTypeName = memberTypeName;
    }
}
