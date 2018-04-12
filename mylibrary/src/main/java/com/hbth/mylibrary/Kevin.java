package com.hbth.mylibrary;

import android.annotation.SuppressLint;
import android.app.Application;

import com.hbth.mylibrary.utils.LogUtils;
import com.hbth.mylibrary.utils.ScreenUtil;

/**
 * Created by Administrator on 2018/2/5.
 */

public class Kevin {

    @SuppressLint("StaticFieldLeak")
    private static Application sApp;

    public static void init(Application application) {
        sApp = application;
        LogUtils.logInit(BuildConfig.IS_DEBUG);
        ScreenUtil.init(application);
    }

    public static  Application getContext(){
        if (sApp == null) {
            throw new NullPointerException("Kevin需要初始化");
        }
        return sApp;
    }

}
