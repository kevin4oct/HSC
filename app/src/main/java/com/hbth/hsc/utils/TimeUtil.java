package com.hbth.hsc.utils;

import android.annotation.SuppressLint;

import com.hbth.mylibrary.utils.LogUtils;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kevin on 2018/2/6.
 * 处理时间格式的工具类
 */

public class TimeUtil {

    /**
     * 格式化视频时长
     *
     * @param time
     * @return
     */
    public static String parseToMMSS(long time) {

        Date date = new Date(time);// 转换为标准时间对象
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        return sdf.format(date);

//        return (String) DateFormat.format("hh:mm:ss", time);
    }

    /**
     * 获取指定网站的日期时间
     */
    public static long getDatetimeLong() {

        long timeLong = 0;
        try {
            URL url = new URL("http://www.baidu.com/");// 取得资源对象
            URLConnection uc = url.openConnection();// 生成连接对象
            uc.connect();// 发出连接
            timeLong = uc.getDate();// 读取网站日期时间
//            LogUtils.loge("" + ld);
//            Date date = new Date(ld);// 转换为标准时间对象
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);// 输出北京时间
//            timeLong = sdf.format(date);
        } catch (IOException e) {
            LogUtils.loge(e.getMessage());
        }
        return timeLong;
    }

}
