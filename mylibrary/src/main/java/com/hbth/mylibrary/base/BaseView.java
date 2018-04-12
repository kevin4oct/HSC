package com.hbth.mylibrary.base;

/**
 * Created by Kevin on 2018/2/6.
 * view接口的基类
 */

public interface BaseView {

    void showLoading(String title);

    void stopLoading();

    void showErrorTip(String msg);
}
