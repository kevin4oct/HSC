package com.hbth.mylibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.hbth.mylibrary.Kevin;
import com.hbth.mylibrary.config.LibraryConfig;

/**
 * Created by Kevin on 2018/2/6.
 * 共享参数的工具类
 */

public class SharedUtil {

    public static int getIntValue(String key,int defaultValue){
        SharedPreferences sdf = getSdf();
        return sdf.getInt(key,0);
    }

    public static void putIntValue(String key,int value){
        SharedPreferences sdf = getSdf();
        sdf.edit().putInt(key,value).apply();
    }

    public static String getStringValue(String key){
        SharedPreferences sdf = getSdf();
        return sdf.getString(key,"");
    }

    public static void putStringValue(String key,String value){
        SharedPreferences sdf = getSdf();
        sdf.edit().putString(key,value).apply();
    }

    public static boolean getFlag(String key) {
        SharedPreferences sdf = getSdf();
        return sdf.getBoolean(key, false);
    }

    public static void putFlag(String key, boolean value) {
        SharedPreferences sdf = getSdf();
        sdf.edit().putBoolean(key, value).apply();
    }

    private static SharedPreferences getSdf() {
        return Kevin.getContext()
                .getSharedPreferences(LibraryConfig.APP_NAME, Context.MODE_PRIVATE);
    }

}
