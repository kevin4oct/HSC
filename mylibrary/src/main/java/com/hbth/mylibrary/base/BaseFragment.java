package com.hbth.mylibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hbth.mylibrary.rxevent.RxManager;
import com.hbth.mylibrary.utils.TypeUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/2/6.
 */
public abstract class BaseFragment<M extends BaseModel,P extends BasePresenter> extends Fragment {

    public M mModel;

    public P mPresenter;

    protected View layout;

    public RxManager mRxManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (layout == null) {
            layout = inflater.inflate(getLayoutResId(),container,false);
        }
        mRxManager = new RxManager();
        ButterKnife.bind(this,layout);
        mModel = TypeUtil.getTypeObject(this,0);
        mPresenter = TypeUtil.getTypeObject(this,1);
        this.initPresenter();
        this.initView();
        this.initListener();
        return layout;
    }

    public abstract int getLayoutResId();

    protected abstract void initPresenter();

    protected abstract void initView();

    protected abstract void initListener();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mRxManager.clear();
    }
}
