package com.zheng.cms.admin.controller.manage;

import com.zheng.cms.admin.modle.PageOnterModle;
import com.zheng.common.base.BaseController;

import com.zheng.ucenter.dao.model.UcenterUser;
import com.zheng.ucenter.dao.model.UcenterUserExample;
import com.zheng.ucenter.rpc.api.UcenterIdentificaionService;
import com.zheng.ucenter.rpc.api.UcenterUserService;
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
@RequestMapping("/manage/member")
@Api(value = "会员控制器", description = "会员管理")
public class MemberController extends BaseController{



    private static Logger _log = LoggerFactory.getLogger(ActivityController.class);


    @Autowired
    private UcenterIdentificaionService ucenterIdentificaionService;

    @Autowired
    private UcenterUserService ucenterUserService;


    private int pageSize=15;


    /**
     * 后台首页
     * @return
     */
    @ApiOperation(value = "后台首页")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String index(@RequestParam(defaultValue = "1") Integer pageNum, ModelMap modelMap) {


        UcenterUserExample example = new UcenterUserExample();
        example.createCriteria();
        //fActivityExample.setOrderByClause("desc ctime");

        List<UcenterUser> rows = ucenterUserService.selectByExampleForOffsetPage(example, pageSize*(pageNum-1), pageSize);
        long total = ucenterUserService.countByExample(example);
        modelMap.put("page", PageOnterModle.getInstence(pageNum,total,pageSize,rows));
        return "/content/manage/list_member.jsp";
    }



    @ApiOperation(value = "活动编辑")
    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String edit(@RequestParam(defaultValue = "0") Integer id,ModelMap modelMap){

        if(id>0){
            UcenterUser ucenterUser = ucenterUserService.selectByPrimaryKey(id);
            modelMap.put("modle",ucenterUser);
            modelMap.put("keyword","update");
        }else{
            modelMap.put("keyword","create");
        }

        return "/content/manage/add_member.jsp";
    }


    @ApiOperation(value = "活动编辑")
    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String createAndUpdate(@RequestParam(defaultValue = "0") String keyword, UcenterUser modle){




        if("del".equals(keyword)){
            if(modle.getUserId()>0){
                ucenterUserService.deleteByPrimaryKey(modle.getUserId());
            }
        }else if("update".equals(keyword)){
            ucenterUserService.updateByPrimaryKey(modle);
        }else{

            ucenterUserService.insert(modle);
        }
        return "redirect:list";
    }

}
