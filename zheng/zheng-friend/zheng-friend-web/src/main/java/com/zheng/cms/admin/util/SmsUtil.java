package com.zheng.cms.admin.util;

import com.alibaba.fastjson.JSONObject;
import com.zheng.common.util.MD5Util;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.http.util.EntityUtils;


import java.util.Date;
import java.util.Random;

/**
 * 短信工具
 */
public class SmsUtil {

    private static final String url = "http://user.xiweb.cn/run.php?item=app&a=setsmscode&sig=#sig&appid=#appid&key=#key&type=mobile&mobile=#mobile&code=#code";
    private static final String appkey = "lxg776";
    private static final String appid = "5";
    private static final String sig = "jxnet";

    public static int getSMS(String mobile,String code) throws Exception {

        String smsUrl =  url.replace("#sig",sig);
        smsUrl=smsUrl.replace("#appid",appid);
        smsUrl=smsUrl.replace("#key",getMd5Key(appid,appkey,mobile,code));
        smsUrl=smsUrl.replace("#mobile",mobile);
        smsUrl=smsUrl.replace("#code",code);


        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(smsUrl);






        int returnCode =200;
        if(Config.isDebug){
            return  returnCode;
        }

        HttpResponse httpResponse = httpclient.execute(httpGet);
        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity httpEntity = httpResponse.getEntity();
            JSONObject result = JSONObject.parseObject(EntityUtils.toString(httpEntity));
            returnCode = result.getIntValue("code");
            System.out.println(result.toJSONString());

        }

        return  returnCode;
    }

    // 写方法
    public static String randomCheckCode(int length) {

        // 声明返回值
        String temp = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 随机获取 0-61 数字 4次 charAt(num);
            int num = random.nextInt(10);
            temp += num;
        }

        return temp;

    }


    private static String getMd5Key(String mAppid,String mAppkey,String mobile,String code) throws Exception {


        return MD5Util.getMD5(mAppid+mAppkey+mobile+code);


    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param date1
     * @param date2
     * @return
     */
    public static long differentDateByMillisecond(Date date1, Date date2)
    {
        return date2.getTime() - date1.getTime();


    }
}
