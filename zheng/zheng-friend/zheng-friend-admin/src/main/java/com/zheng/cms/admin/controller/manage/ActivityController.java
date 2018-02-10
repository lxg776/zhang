package com.zheng.cms.admin.controller.manage;

import com.zheng.cms.admin.modle.PageOnterModle;
import com.zheng.common.base.BaseController;
import com.zheng.friend.dao.model.FActivity;
import com.zheng.friend.dao.model.FActivityExample;
import com.zheng.friend.rpc.api.FActivityService;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台controller
 * Created by ZhangShuzheng on 2017/01/12.
 */
@Controller
@RequestMapping("/manage/activity")
@Api(value = "后台控制器", description = "后台管理")

public class ActivityController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(ActivityController.class);


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
		modelMap.put("page",PageOnterModle.getInstence(pageNum,total,pageSize,rows));
		return "/content/manage/list_activity.jsp";
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

			return "/content/manage/add_activity.jsp";
	}


	@ApiOperation(value = "活动编辑")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String createAndUpdate(@RequestParam(defaultValue = "0") String keyword, FActivity modle){


		if("del".equals(keyword)){
			if(modle.getActivityId()>0){
				fActivityService.deleteByPrimaryKey(modle.getActivityId());
			}
		}else if("update".equals(keyword)){
			fActivityService.updateByPrimaryKey(modle);
		}else{
			fActivityService.insert(modle);
		}
		return "redirect:list";
	}



	/**
	 * 上传图片
	 * @param upfile
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/images")
	public Map<String, Object> images (MultipartFile upfile, HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> params = new HashMap<String, Object>();
//		try{
//			String basePath = LoadPropertiesDataUtils.getValue("lyz.uploading.url");
//			String visitUrl = LoadPropertiesDataUtils.getValue("lyz.visit.url");
//			if(basePath == null || "".equals(basePath)){
//				basePath = "d:/lyz/static";  //与properties文件中lyz.uploading.url相同，未读取到文件数据时为basePath赋默认值
//			}
//			if(visitUrl == null || "".equals(visitUrl)){
//				visitUrl = "/upload/"; //与properties文件中lyz.visit.url相同，未读取到文件数据时为visitUrl赋默认值
//			}
//			String ext = StringUtils.getExt(upfile.getOriginalFilename());
//			String fileName = String.valueOf(System.currentTimeMillis()).concat("_").concat(RandomUtils.getRandom(6)).concat(".").concat(ext);
//			StringBuilder sb = new StringBuilder();
//			//拼接保存路径
//			sb.append(basePath).append("/").append(fileName);
//			visitUrl = visitUrl.concat(fileName);
//			File f = new File(sb.toString());
//			if(!f.exists()){
//				f.getParentFile().mkdirs();
//			}
//			OutputStream out = new FileOutputStream(f);
//			FileCopyUtils.copy(upfile.getInputStream(), out);
//			params.put("state", "SUCCESS");
//			params.put("url", visitUrl);
//			params.put("size", upfile.getSize());
//			params.put("original", fileName);
//			params.put("type", upfile.getContentType());
//		} catch (Exception e){
//			params.put("state", "ERROR");
//		}
		return params;
	}

}