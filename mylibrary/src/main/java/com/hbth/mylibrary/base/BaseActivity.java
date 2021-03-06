package com.hbth.mylibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hbth.mylibrary.rxevent.RxManager;
import com.hbth.mylibrary.utils.TypeUtil;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/5.
 * 所有自定义Activity的基类
 */


public abstract class BaseActivity<M extends  BaseModel,P extends BasePresenter> extends AppCompatActivity {

    public M mModel;

    public P mPresenter;

    public Context mContext;

    public RxManager mRxManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRxManager = new RxManager();
        // 在设置内容View之前调用
        doBeforeSetContentView();
        // 设置布局
        setContentView(getLayoutResId());
        // Butterknife注入
        ButterKnife.bind(this);
        mContext = this;
        // 实例化Model
        mModel = TypeUtil.getTypeObject(this,0);
        // 实例化Presenter
        mPresenter = TypeUtil.getTypeObject(this,1);
        // 实例化Presenter中的Context
        if (mPresenter != null) {
            mPresenter.mContext = this;
        }
        this.initPresenter();
        this.initView();
        this.initListener();
        this.initData();
    }

    protected void doBeforeSetContentView() {}

    public abstract int getLayoutResId();

    protected abstract void initPresenter();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRxManager.clear();
    }
}
