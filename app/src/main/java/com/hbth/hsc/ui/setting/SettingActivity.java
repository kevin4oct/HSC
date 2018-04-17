package com.hbth.hsc.ui.setting;

import android.view.View;

import com.hbth.hsc.R;
import com.hbth.hsc.ui.splash.SplashActivity;
import com.hbth.mylibrary.base.BaseActivity;

public class SettingActivity extends BaseActivity {


    @Override
    public int getLayoutResId() {
        return R.layout.activity_setting;
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


    /**
     * 设置完成按钮点击事件
     * @param view
     */
    public void commitSetting(View view) {
        // TODO: 2018/3/8 设置完成
        startActivity(SplashActivity.getMyIntent(this));
    }
}
