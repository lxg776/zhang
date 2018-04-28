package com.zheng.cpw.controller.app;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.baidu.ueditor.ActionEnter;
import com.zheng.common.base.BaseController;
import com.zheng.oss.common.constant.OssConstant;
import io.swagger.annotations.Api;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 后台controller
 * Created by ZhangShuzheng on 2017/01/12.
 */
@Controller
@RequestMapping("/manage/ue")
@Api(value = "后台控制器", description = "后台管理")

public class UeditorController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(UeditorController.class);
	public final static String imageBase = "http://jxwbb.oss-cn-zhangjiakou.aliyuncs.com/";

	@Autowired
	private OSSClient aliyunOssClient;

	private String rootPath = null;

	@RequestMapping("/dispatch")
	public void index(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setHeader("Content-Type", "text/html");
			String tmpRootPath = request.getServletPath();
//            String contextPath = request.getContextPath();
//            if(null==contextPath ||"".equals(contextPath)){
//                contextPath="";
//            }
			response.getWriter().write(new ActionEnter(request, (rootPath != null && !"".equals(rootPath)) ?
					rootPath : tmpRootPath).exec());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public String getRootPath() {
		return this.rootPath;
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
			String originalFilename = upfile.getOriginalFilename();
			String ext = originalFilename.substring(originalFilename.lastIndexOf("."),originalFilename.length());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String dir = sdf.format(new Date());
			String fileName  = "editor"+"/"+dir+"/"+String.valueOf(System.currentTimeMillis()).concat("_").concat(RandomUtils.nextInt(100)+"").concat(ext);
			StringBuilder sb = new StringBuilder(fileName);

			try {
				PutObjectResult putObjectResult = aliyunOssClient.putObject(OssConstant.ALIYUN_OSS_BUCKET_NAME, fileName, upfile.getInputStream());
				String visitUrl = imageBase+fileName;
				params.put("state", "SUCCESS");
				params.put("url", visitUrl);
				params.put("size", upfile.getSize());
				params.put("original", fileName);
				params.put("type", upfile.getContentType());
			} catch (IOException e) {
				params.put("state", "ERROR");
			}



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