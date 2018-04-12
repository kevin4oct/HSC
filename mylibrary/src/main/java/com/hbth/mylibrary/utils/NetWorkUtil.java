package com.hbth.mylibrary.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.hbth.mylibrary.Kevin;

/**
 * Created by Administrator on 2018/2/5.
 * 网络工具，需要 android。permission.ACCE_NETWORK_STATE 权限
 */

public class NetWorkUtil {

    /**
     * 判断设备有没有网络
     * @param context
     * @return
     */
    public static boolean isNetConnected(Context context){
        NetworkInfo localNetworkInfo = ((ConnectivityManager)context
                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return (localNetworkInfo !=null) && (localNetworkInfo.isAvailable());
    }

    public static boolean isNetConnection(){
        return isNetConnected(Kevin.getContext());
    }

}
