package com.zheng.upms.server.controller.friend;

import com.zheng.cms.common.constant.FriendResult;
import com.zheng.cms.common.constant.FriendResultConstant;
import com.zheng.common.base.BaseController;
import com.zheng.friend.dao.model.*;
import com.zheng.friend.rpc.api.FAreasService;
import com.zheng.friend.rpc.api.FCitiesService;
import com.zheng.friend.rpc.api.FProvincesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * 省区市获取controller
 * Created by ZhangShuzheng on 2017/01/12.
 */
@Controller
@RequestMapping("/c")
@Api(value = "省区市获取", description = "后台管理")
public class CityController extends BaseController{


    @Autowired
    FProvincesService fProvincesService;
    @Autowired
    FCitiesService fCitiesService;
    @Autowired
    FAreasService fAreasService;

    /**
     * 获取省份
     * @return
     */
    @ApiOperation(value = "获取省份")
    @RequestMapping(value = "/provinceList", method = RequestMethod.GET)
    @ResponseBody
    public Object getProvinceList() {

        FriendResult result =new FriendResult(FriendResultConstant.SUCCESS,null);
        result.setMessage("获取成功");
        FProvincesExample fProvincesExample = new FProvincesExample();
        fProvincesExample.createCriteria();
        List<FProvinces> provincesList  = fProvincesService.selectByExample(fProvincesExample);
        HashMap<String,Object> data =new HashMap<>();
        data.put("dataList",provincesList);
        result.setData(data);
        return result;
    }



    /**
     * 获取城市列表
     * @return
     */
    @ApiOperation(value = "城市列表")
    @RequestMapping(value = "/cityList", method = RequestMethod.GET)
    @ResponseBody
    public Object getCityList(String provinceid) {

        FriendResult result =new FriendResult(FriendResultConstant.SUCCESS,null);
        result.setMessage("获取成功");
        FCitiesExample example = new FCitiesExample();
        example.createCriteria().andProvinceidEqualTo(provinceid);
        List<FCities> fCitiesList  = fCitiesService.selectByExample(example);
        HashMap<String,Object> data =new HashMap<>();
        data.put("dataList",fCitiesList);
        result.setData(data);
        return result;
    }


    /**
     * 区域列表
     * @return
     */
    @ApiOperation(value = "区域列表")
    @RequestMapping(value = "/areasList", method = RequestMethod.GET)
    @ResponseBody
    public Object getAreasList(String cityid) {
        FriendResult result =new FriendResult(FriendResultConstant.SUCCESS,null);
        result.setMessage("获取成功");
        FAreasExample example = new FAreasExample();
        example.createCriteria().andCityidEqualTo(cityid);
        List<FAreas> fCitiesList  = fAreasService.selectByExample(example);
        HashMap<String,Object> data =new HashMap<>();
        data.put("dataList",fCitiesList);
        result.setData(data);
        return result;
    }
}
