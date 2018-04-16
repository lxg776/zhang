package com.zheng.cms.common.constant;

import com.zheng.common.base.BaseResult;

/**
 * cms系统常量枚举类
 * Created by shuzheng on 2017/2/19.
 */
public class CpwResult extends BaseResult {

    public CpwResult(CpwResultConstant cmsResultConstant, Object data) {
        super(cmsResultConstant.getCode(), cmsResultConstant.getMessage(), data);
    }

}
