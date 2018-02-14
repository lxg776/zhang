package com.zheng.cms.admin.controller.oos;

import com.alibaba.fastjson.JSONObject;
import com.zheng.oss.common.constant.OssConstant;
import com.zheng.oss.common.constant.OssResult;
import com.zheng.oss.common.constant.OssResultConstant;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZhangShuzheng on 2017/5/15.
 */
@Controller
@RequestMapping("/aliyun/oss")
public class AliyunOssController {

	private static Logger _log = LoggerFactory.getLogger(AliyunOssController.class);

	@Autowired
	private AliyunOssService aliyunOssService;

	/**
	 * 签名生成
	 * @param callback 跨域请求
	 * @return
	 */
	@GetMapping("/policy")
	@ResponseBody
	//@CrossOrigin(origins = "*", methods = RequestMethod.GET) // 该注解不支持JDK1.7
	public Object policy(@RequestParam(required = false) String callback) {
		JSONObject result = aliyunOssService.policy();
		if (StringUtils.isBlank(callback)) {
			return result;
		}
		MappingJacksonValue jsonp = new MappingJacksonValue(result);
		jsonp.setJsonpFunction(callback);
		return jsonp;
	}


	/**
	 * 签名生成
	 * @param callback 跨域请求
	 * @return
	 */
	//@CrossOrigin(origins = "http://127.0.0.1:2222")
	@GetMapping("/ky_policy")
	@ResponseBody
//	@CrossOrigin(origins = "*", methods = RequestMethod.GET) // 该注解不支持JDK1.7
	public String kyPolicy(@RequestParam(required = false) String callback,String ky) {
		JSONObject result = aliyunOssService.policy();
		if (StringUtils.isBlank(callback)) {
			return converJsonResultSimple(result.toJSONString(),ky);
		}
		MappingJacksonValue jsonp = new MappingJacksonValue(result);
		jsonp.setJsonpFunction(callback);
			return converJsonResultSimple(result.toJSONString(),ky);
	}


	public String converJsonResultSimple(String jsonString ,String callback){
		if(callback!=null && !"".equals(callback)){
			jsonString = callback + "(" + jsonString + ")";
		}
		return jsonString;
	}



	/**
	 * 上传成功回调方法
	 * @param request
	 * @return
	 */
	@PostMapping("callback")
	@ResponseBody
	public Object callback(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		String filename = request.getParameter("filename");
		filename = "http://".concat(OssConstant.ALIYUN_OSS_BUCKET_NAME).concat(".").concat(OssConstant.ALIYUN_OSS_ENDPOINT).concat("/").concat(filename);
		data.put("filename", filename);
		data.put("size", request.getParameter("size"));
		data.put("mimeType", request.getParameter("mimeType"));
		data.put("width", request.getParameter("width"));
		data.put("height", request.getParameter("height"));
		return new OssResult(OssResultConstant.SUCCESS, data);

		//http://188968ee02.51mypc.cn/aliyun/oss/callback
	}




}
