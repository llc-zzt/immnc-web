package com.moon.immncweb.core.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * @Author zhaoxiang
 * @Date 2018/11/28
 * @Desc 时间工具类
 */
public class TimeUtil {
    /**
     * 据当前时间差
     *
     * @param tim
     * @return
     */
    public static String getCurrentTimeMillisDiff(Long tim) {
        Long lll = (System.currentTimeMillis() - tim) / (1000 * 60);
        String time = "";
        String s1 = "";
        if (lll < 60) {
            s1 = BigDecimal.valueOf(Math.floor(lll)).stripTrailingZeros().toPlainString();
            time = (lll==0 ? "刚刚":lll + "分钟前");
        } else if (lll > 60 && lll < 60 * 24) {
            s1 = BigDecimal.valueOf(Math.floor(lll / 60)).stripTrailingZeros().toPlainString();
            time = s1 + "小时前";
        } else if (lll > 60 * 24 && lll < 60 * 24 * 30) {
            s1 = BigDecimal.valueOf(Math.floor(lll / (60 * 24))).stripTrailingZeros().toPlainString();
            time = s1 + "天前";
        } else if (lll < 60 * 24 * 30 * 12 && lll > 60 * 24 * 30) {
            s1 = BigDecimal.valueOf(Math.floor(lll / (60 * 24 * 30))).stripTrailingZeros().toPlainString();
            time = s1 + "月前";
        } else {
            s1 = BigDecimal.valueOf(Math.floor(lll / (60 * 24 * 30 * 12))).stripTrailingZeros().toPlainString();
            time = s1 + "年前";
        }
        return time;
    }

    public static String getDateFormat(long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(time);
    }

}
