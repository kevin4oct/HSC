package com.hbth.hsc.ui.splash;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.hbth.hsc.R;
import com.hbth.hsc.ui.main.activity.MainActivity;
import com.hbth.hsc.utils.TimeUtil;
import com.hbth.mylibrary.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    public int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    public static Intent getMyIntent(Context mContext) {
        return new Intent(mContext, SplashActivity.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initTime();
    }

    /**
     * 初始化系统时间
     */
    private void initTime() {

        //设置系统时间
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        ((AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE))
                                .setTime(TimeUtil.getDatetimeLong());
                    }
                }
        ).start();

        startActivity(MainActivity.getTheIntent(this));
    }


}
