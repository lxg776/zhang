package com.zheng.cms.admin.util;

import java.math.RoundingMode;
import java.text.NumberFormat;

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
}
