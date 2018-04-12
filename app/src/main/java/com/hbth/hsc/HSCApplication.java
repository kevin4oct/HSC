package com.hbth.hsc;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.hbth.mylibrary.Kevin;

/**
 * Created by Administrator on 2018/2/5.
 * 提供全局的上下文，做一些初始化工作
 */

public class HSCApplication extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化
        Kevin.init(this);
        Fresco.initialize(this);
        sContext = this;
    }

    public static Context getContext() {
        return sContext;
    }

}
