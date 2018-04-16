package com.zheng.cpw.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDateUtil {

    //根据字符串计算年龄
    public String getAgeByString(String dateFormat,String strDate){

        if(null==dateFormat||dateFormat.equals("")){
            dateFormat = "yyyy-MM-dd";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        Date birthDay = null;
        try {
            birthDay=sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int age = 0 ;

        if(birthDay!=null){
            Calendar cal = Calendar.getInstance();

            if (cal.before(birthDay)) {
                throw new IllegalArgumentException(
                        "The birthDay is before Now.It's unbelievable!");
            }
            int yearNow = cal.get(Calendar.YEAR);
            int monthNow = cal.get(Calendar.MONTH);
            int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
            cal.setTime(birthDay);

            int yearBirth = cal.get(Calendar.YEAR);
            int monthBirth = cal.get(Calendar.MONTH);
            int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

            age = yearNow - yearBirth;

            if (monthNow <= monthBirth) {
                if (monthNow == monthBirth) {
                    if (dayOfMonthNow < dayOfMonthBirth) age--;
                }else{
                    age--;
                }
            }
        }

        if(age==0){
            return "";
        }
        return age+"";

    }




}
