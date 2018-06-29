package com.zheng.cms.admin.util;

import com.zheng.cms.common.constant.FriendResult;

import javax.servlet.http.HttpServletRequest;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CommonUtil {

    public static String format3(double value) {

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
 /*
  * setMinimumFractionDigits设置成2
  *
  * 如果不这么做，那么当value的值是100.00的时候返回100
  *
  * 而不是100.00
  */
        nf.setMinimumFractionDigits(2);
        nf.setRoundingMode(RoundingMode.HALF_UP);
 /*
  * 如果想输出的格式用逗号隔开，可以设置成true
  */
        nf.setGroupingUsed(false);
        return nf.format(value);
    }

    /**
     * 获取随机字符串
     * @param length
     * @return
     */
    public static String getRandomString(int length){
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<length; ++i){
            //产生0-61的数字
            int number=random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }



    public static FriendResult handResult(FriendResult result, HttpServletRequest request){

        if(result!=null){
            Object newsToken = request.getAttribute("newsToken");
            if(null!=newsToken){
                String token = (String) newsToken;

                Map<String,Object> map = (Map<String, Object>) result.getData();
                if(map==null){
                    map =new HashMap<>();
                    result.setData(map);
                }
                map.put("token",token);

            }
       }
         return  result;
    }
}
