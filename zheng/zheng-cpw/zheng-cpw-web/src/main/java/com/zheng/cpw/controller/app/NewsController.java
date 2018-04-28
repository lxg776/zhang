package com.zheng.cpw.controller.app;


import com.github.pagehelper.util.StringUtil;
import com.zheng.cms.common.constant.CpwResult;
import com.zheng.cms.common.constant.CpwResultConstant;
import com.zheng.common.base.BaseController;
import com.zheng.cpw.dao.model.CpwNews;
import com.zheng.cpw.dao.model.CpwNewsExample;
import com.zheng.cpw.dao.model.PageOnterModle;
import com.zheng.cpw.rpc.api.CpwNewsService;
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
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 后台controller
 * Created by ZhangShuzheng on 2017/01/12.
 */
@Controller
@RequestMapping("/cpw")
@Api(value = "后台控制器", description = "后台管理")

public class NewsController extends BaseController {

    private static Logger _log = LoggerFactory.getLogger(NewsController.class);
    public final static String imageBase = "http://jxwbb.oss-cn-zhangjiakou.aliyuncs.com/";

    @Autowired
    private CpwNewsService cpwNewsService;

    private int pageSize=15;


    /**
     * 后台首页
     * @return
     */
    @ApiOperation(value = "后台首页")
    @RequestMapping(value = "/newsList", method = RequestMethod.GET)
    public String newsList(@RequestParam(defaultValue = "1") Integer pageNum,ModelMap modelMap) {


        CpwNewsExample example = new CpwNewsExample();
        example.createCriteria();
        //fActivityExample.setOrderByClause("desc ctime");

        List<CpwNews> rows = cpwNewsService.selectByExampleForOffsetPage(example, pageSize*(pageNum-1), pageSize);
        long total = cpwNewsService.countByExample(example);
        modelMap.put("page", PageOnterModle.getInstence(pageNum,total,pageSize,rows));
        return "/content/manage/list_news.jsp";
    }

    /**
     * 后台首页
     * @return
     */
    @ApiOperation(value = "后台首页")
    @RequestMapping(value = "/getNewsList", method = RequestMethod.GET)
    @ResponseBody
    public Object getNewsList(@RequestParam(defaultValue = "1") Integer pageNum,String newsColumn) {


        CpwNewsExample example = new CpwNewsExample();
        if(StringUtil.isNotEmpty(newsColumn)){
            example.createCriteria().andNewsColumnEqualTo(newsColumn);
        }else{
            example.createCriteria();
        }

        //fActivityExample.setOrderByClause("desc ctime");
        CpwResult result =new CpwResult(CpwResultConstant.SUCCESS,null);

        HashMap<String,Object> map =new HashMap<>();
        List<CpwNews> rows = cpwNewsService.selectByExampleForOffsetPage(example, pageSize*(pageNum-1), pageSize);
        for(CpwNews item:rows){
            item.setContent("");
        }
        map.put("list",rows);
        result.setData(map);

       return  result;
    }


    /**
     * 后台首页
     * @return
     */
    @ApiOperation(value = "后台首页")
    @RequestMapping(value = "/getNewsDetail", method = RequestMethod.GET)
    @ResponseBody
    public Object getNewsDetail(@RequestParam(defaultValue = "1") Integer id) {


        CpwResult result =new CpwResult(CpwResultConstant.SUCCESS,null);
        CpwNews cpwNews = cpwNewsService.selectByPrimaryKey(id);
        HashMap<String,Object> map =new HashMap<>();
        map.put("modle",cpwNews);
        result.setData(map);
        return  result;
    }




    @ApiOperation(value = "活动编辑")
    @RequestMapping(value = "/newsEdit", method = RequestMethod.POST)
    public String edit(@RequestParam(defaultValue = "0") String keyword, CpwNews modle){


        if("del".equals(keyword)){
            if(modle.getId()>0){
                cpwNewsService.deleteByPrimaryKey(modle.getId());
            }
        }else if("update".equals(keyword)){
            cpwNewsService.updateByPrimaryKeySelective(modle);
        }else{
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy年MM月dd日 HH:mm:SS");
            modle.setCreateTime(sdf.format(new Date()));
            cpwNewsService.insert(modle);
        }
        return "redirect:newsList";
    }

    @ApiOperation(value = "活动编辑")
    @RequestMapping(value = "/newsEdit", method = RequestMethod.GET)
    public String edit(@RequestParam(defaultValue = "0") Integer id,ModelMap modelMap){

        if(id>0){
            CpwNews fActivity = cpwNewsService.selectByPrimaryKey(id);
            modelMap.put("modle",fActivity);
            modelMap.put("keyword","update");
        }else{
            modelMap.put("keyword","create");
        }
        modelMap.put("imageBase",imageBase);

        return "/content/manage/add_news.jsp";
    }

}