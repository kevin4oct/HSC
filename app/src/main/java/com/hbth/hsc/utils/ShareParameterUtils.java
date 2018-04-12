package com.hbth.hsc.utils;

import android.text.TextUtils;

import com.hbth.mylibrary.utils.SharedUtil;

/**
 * Created by Kevin on 2018/3/8.
 * 本地持久化一些参数
 */

public class ShareParameterUtils {

    /**
     * 获取PID
     */
    public static String getPID() {
        return SharedUtil.getStringValue("pid");
    }

    /**
     * 保存pid
     */
    public static void savePID(String pId) {
        SharedUtil.putStringValue("pid", pId);
    }

    /**
     * 获取机器码
     */
    public static String getMachineCode() {
        return SharedUtil.getStringValue("machineCode");
    }

    /**
     * 保存机器码
     *
     * @param machineCode 机器码
     */
    public static void saveMachineCode(String machineCode) {
        SharedUtil.putStringValue("machineCode", machineCode);
    }

    /**
     * 是否设置了pid和机器码
     */
    public static boolean isLogin() {
        return !TextUtils.isEmpty(getPID()) && !TextUtils.isEmpty(getMachineCode());
    }

    /**
     * 获取资源页数
     *
     * @return
     */
    public static int getPageCount() {
        // TODO: 2018/3/8 修改返回的页数
        return 10;
//        return SharedUtil.getIntValue("pageCount", 10);
    }

    /**
     * 保存资源页数
     *
     * @param pageCount
     */
    public static void savaPageCount(int pageCount) {
        SharedUtil.putIntValue("pageCount", pageCount);
    }

}
