package com.zheng.cms.admin.controller.manage;

import com.zheng.common.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 文章控制器
 * Created by shuzheng on 2016/11/14.
 */
@Controller
@Api(value = "文章管理", description = "文章管理")
@RequestMapping("/Test")
public class TestController extends BaseController {






	@ApiOperation(value = "上传")
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String create(ModelMap modelMap) {

		return "/content/manage/test.jsp";
	}


}