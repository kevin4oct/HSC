package com.hbth.mylibrary.utils;

import android.content.Context;

/**
 * Created by Administrator on 2018/2/5.
 *
 */

public class ScreenUtil {

    private static int screenWidth = 0;

    private static int screenHeight = 0;

    public static void init(Context context) {
        screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        screenHeight = context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(){
        return screenWidth;
    }

    public static int getScreenHeight(){
        return screenHeight;
    }


}
