package com.hbth.hsc.ui.main.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.hbth.hsc.bean.RssListBean;
import com.hbth.hsc.ui.main.adapter.BookClassAdapter;
import com.hbth.hsc.ui.main.adapter.BookListAdapter;
import com.hbth.hsc.ui.main.contract.RssListContract;
import com.hbth.hsc.ui.main.model.RssListModel;
import com.hbth.hsc.ui.main.presenter.RssListPresenter;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.utils.LogUtils;
import com.hbth.mylibrary.utils.ToastUtil;

/**
 * Created by Administrator on 2018/2/6.
 * 展示订阅列表的页面
 */

public class RssListFragment
        extends BaseResourceListFragment<
        RssListModel, RssListPresenter, BookClassAdapter, BookListAdapter>
        implements RssListContract.View, BaseAdapter.OnItemClickListener {

    public static final String TAG = RssListFragment.class.getName();

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {

        // TODO: 2018/3/6 开始获取数据
//        mPresenter.getRssListRequest();
    }

    @Override
    public void initLayoutManagerAndAdapter() {
        classLayoutManager = new LinearLayoutManager(getActivity());
        containerLayoutManager = new GridLayoutManager(getActivity(), 1);
        classAdapter = new BookClassAdapter(getActivity(), recycler_class);
        containerAdapter = new BookListAdapter(getActivity(), recycler_container);
    }

    @Override
    public void pageChanged() {
        // TODO: 2018/3/8 切换页数
//        mPresenter.getRssListRequest();
    }

    @Override
    protected void initListener() {
//        classAdapter.setOnItemClickListener(this);
//        containerAdapter.setOnItemClickListener(this);
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {
        ToastUtil.showShort(msg);
    }

    @Override
    public void returnRssList(RssListBean bean) {
        runLayoutAnimation();
        LogUtils.loge(bean.toString());
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public void itemClicked(int viewId, int position, Object bean) {
        switch (viewId) {

        }
    }

}
