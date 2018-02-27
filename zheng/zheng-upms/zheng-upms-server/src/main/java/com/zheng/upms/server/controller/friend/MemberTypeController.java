package com.zheng.upms.server.controller.friend;


import com.zheng.common.base.BaseController;
import com.zheng.friend.dao.model.FMemberType;
import com.zheng.friend.dao.model.FMemberTypeExample;
import com.zheng.friend.rpc.api.FMemberTypeService;
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

import java.util.List;


@Controller
@RequestMapping("/manage/memberType")
@Api(value = "会员类型控制器", description = "会员管理")
public class MemberTypeController extends BaseController{



    private static Logger _log = LoggerFactory.getLogger(ActivityController.class);


    @Autowired
    private FMemberTypeService fMemberTypeService;





    private int pageSize=15;


    /**
     * 后台首页
     * @return
     */
    @ApiOperation(value = "后台首页")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(defaultValue = "1") Integer pageNum, ModelMap modelMap) {


        FMemberTypeExample example = new FMemberTypeExample();
        example.createCriteria();
        //fActivityExample.setOrderByClause("desc ctime");

        List<FMemberType> rows = fMemberTypeService.selectByExampleForOffsetPage(example, pageSize*(pageNum-1), pageSize);
        long total = fMemberTypeService.countByExample(example);
        modelMap.put("page", PageOnterModle.getInstence(pageNum,total,pageSize,rows));
        return "/content/manage/list_member_type.jsp";
    }



    @ApiOperation(value = "活动编辑")
    @RequestMapping(value = "/editType", method = RequestMethod.GET)
    public String edit(@RequestParam(defaultValue = "0") Integer id,ModelMap modelMap){

        if(id>0){
            FMemberType modle = fMemberTypeService.selectByPrimaryKey(id);
            modelMap.put("modle",modle);
            modelMap.put("keyword","update");
        }else{
            modelMap.put("keyword","create");
        }

        return "/content/manage/add_member_type.jsp";
    }









    @ApiOperation(value = "活动编辑")
    @RequestMapping(value = "/editType", method = RequestMethod.POST)
    public String createAndUpdate(@RequestParam(defaultValue = "0") String keyword, FMemberType modle){
        if("del".equals(keyword)){
            if(modle.getId()>0){
                fMemberTypeService.deleteByPrimaryKey(modle.getId());
            }
        }else if("update".equals(keyword)){
            fMemberTypeService.updateByPrimaryKeySelective(modle);
        }else{
            fMemberTypeService.insert(modle);
        }
        return "redirect:list";
    }


}
