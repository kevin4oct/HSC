package com.hbth.mylibrary.utils;

import android.content.Context;
import android.widget.Toast;

import com.hbth.mylibrary.Kevin;

/**
 * Created by Administrator on 2018/2/5.
 */

public class ToastUtil {

    private static Toast toast;

    private static Toast iniToast(CharSequence message, int duration) {
        if (toast == null) {
            toast = Toast.makeText(Kevin.getContext(), message, duration);
        } else {
            toast.setText(message);
            toast.setDuration(duration);
        }
        return toast;
    }

    /**
     * 短时间显示Toast
     *
     * @param strResId
     */
    public static void showShort(int strResId) {
        iniToast(Kevin.getContext().getResources().getText(strResId), Toast.LENGTH_SHORT).show();
    }

    /**
     * 短时间显示Toast
     *
     * @param message
     */
    public static void showShort(CharSequence message) {
        iniToast(message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间显示Toast
     *
     * @param message
     */
    public static void showLong(CharSequence message) {
        iniToast(message, Toast.LENGTH_LONG).show();
    }

    /**
     * 长时间显示Toast
     *
     * @param strResId
     */
    public static void showLong(int strResId) {
        iniToast(Kevin.getContext().getResources().getText(strResId), Toast.LENGTH_LONG).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param message
     * @param duration
     */
    public static void show(CharSequence message, int duration) {
        iniToast(message, duration).show();
    }

    /**
     * 自定义显示Toast时间
     */
    public static void show(Context context, int strResId, int duration) {
        iniToast(context.getResources().getText(strResId), duration).show();
    }

}
