package com.zheng.upms.server.controller.friend;


import com.zheng.common.base.BaseController;
import com.zheng.friend.dao.model.FActivity;
import com.zheng.friend.dao.model.FActivityExample;
import com.zheng.friend.rpc.api.FActivityService;
import com.zheng.upms.server.controller.modle.PageOnterModle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * 后台controller
 * Created by ZhangShuzheng on 2017/01/12.
 */
@Controller
@RequestMapping("/manage/activity")
@Api(value = "后台控制器", description = "后台管理")

public class ActivityController extends BaseController {

    private static Logger _log = LoggerFactory.getLogger(ActivityController.class);
    public final static String imageBase = "http://jxwbb.oss-cn-zhangjiakou.aliyuncs.com/";

    @Autowired
    private FActivityService fActivityService;

    private int pageSize=15;


    /**
     * 后台首页
     * @return
     */
    @ApiOperation(value = "后台首页")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String index(@RequestParam(defaultValue = "1") Integer pageNum,ModelMap modelMap) {


        FActivityExample fActivityExample = new FActivityExample();
        fActivityExample.createCriteria();
        //fActivityExample.setOrderByClause("desc ctime");

        List<FActivity> rows = fActivityService.selectByExampleForOffsetPage(fActivityExample, pageSize*(pageNum-1), pageSize);
        long total = fActivityService.countByExample(fActivityExample);
        modelMap.put("page", PageOnterModle.getInstence(pageNum,total,pageSize,rows));
        return "/content/manage/list_activity.jsp";
    }

    @ApiOperation(value = "活动编辑")
    @RequestMapping(value = "/doEdit", method = RequestMethod.POST)
    public String edit(@RequestParam(defaultValue = "0") String keyword, FActivity modle){


        if("del".equals(keyword)){
            if(modle.getActivityId()>0){
                fActivityService.deleteByPrimaryKey(modle.getActivityId());
            }
        }else if("update".equals(keyword)){
            fActivityService.updateByPrimaryKeyWithBLOBs(modle);
        }else{
            modle.setCtime(new Date().getTime());
            fActivityService.insert(modle);
        }
        return "redirect:list";
    }

    @ApiOperation(value = "活动编辑")
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam(defaultValue = "0") Integer id,ModelMap modelMap){

        if(id>0){
            FActivity fActivity = fActivityService.selectByPrimaryKey(id);
            modelMap.put("modle",fActivity);
            modelMap.put("keyword","update");
        }else{
            modelMap.put("keyword","create");
        }
        modelMap.put("imageBase",imageBase);

        return "/content/manage/add_activity.jsp";
    }

}