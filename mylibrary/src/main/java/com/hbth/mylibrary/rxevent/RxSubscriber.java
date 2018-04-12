package com.hbth.mylibrary.rxevent;

import android.app.Activity;
import android.content.Context;

import com.hbth.mylibrary.Kevin;
import com.hbth.mylibrary.utils.LoadingDialog;
import com.hbth.mylibrary.utils.LogUtils;
import com.hbth.mylibrary.utils.NetWorkUtil;

import rx.Subscriber;

/**
 * des:订阅封装
 * <p>
 * <p>
 * 使用例子
 */
/*_apiService.login(mobile, verifyCode)
        .//省略
        .subscribe(new RxSubscriber<User user>(mContext,false) {
@Override
public void _onNext(User user) {
        // 处理user
        }

@Override
public void _onError(String msg) {
        ToastUtil.showShort(mActivity, msg);
        });*/
public abstract class RxSubscriber<T> extends Subscriber<T> {

    private Context mContext;
    private String msg;
    private boolean showDialog = true;

    /**
     * 是否显示浮动dialog
     */
    public void showDialog() {
        this.showDialog = true;
    }

    public void hideDialog() {
        this.showDialog = true;
    }

    public RxSubscriber(Context context, String msg, boolean showDialog) {
        this.mContext = context;
        this.msg = msg;
        this.showDialog = showDialog;
    }

    public RxSubscriber(Context context) {
        this(context, "加载中...", false);
    }

    public RxSubscriber(Context context, boolean showDialog) {
        this(context, "加载中", showDialog);
    }

    @Override
    public void onCompleted() {
        if (showDialog)
            LoadingDialog.cancelDialogForLoading();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (showDialog) {
            try {
                LoadingDialog.showDialogForLoading((Activity) mContext, msg, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        if (showDialog)
            LoadingDialog.cancelDialogForLoading();
        LogUtils.loge(e.getMessage());
        //网络
        if (!NetWorkUtil.isNetConnected(Kevin.getContext())) {
            _onError("没有网络");
        }
        //服务器
        else if (e instanceof ServerException) {
            _onError(e.getMessage());
        }
        //其它
        else {
            _onError("状态异常");
        }
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);

}