package com.hbth.mylibrary.base;

import android.content.Context;

import com.hbth.mylibrary.rxevent.RxManager;

/**
 * Created by Administrator on 2018/2/5.
 * 主导器基类
 */

public abstract class BasePresenter<M,V> {
    public Context mContext;

    public M mModel;

    public V mView;

    public RxManager mRxManager = new RxManager();

    public void setVM(V view,M model){
        this.mView = view;
        this.mModel = model;
        this.onStart();
    }

    public void onStart(){

    }

    public void onStop(){
        mRxManager.clear();
    }
}
