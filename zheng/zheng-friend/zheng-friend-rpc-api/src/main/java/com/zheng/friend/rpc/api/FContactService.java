package com.zheng.friend.rpc.api;

import com.zheng.common.base.BaseService;
import com.zheng.friend.dao.model.FContact;
import com.zheng.friend.dao.model.FContactExample;
import com.zheng.friend.dao.vo.FContactVo;

import java.util.List;

/**
* FContactService接口
* Created by shuzheng on 2018/1/27.
*/
public interface FContactService extends BaseService<FContact, FContactExample> {



    public List<FContactVo>  getContactList(Integer pageNum, Integer pageSize);



    public FContactVo  getContactById(Integer cid);


}