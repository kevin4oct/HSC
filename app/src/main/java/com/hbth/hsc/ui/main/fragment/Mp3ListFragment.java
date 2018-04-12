package com.hbth.hsc.ui.main.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.Mp3ListBean;
import com.hbth.hsc.ui.main.adapter.Mp3ClassAdapter;
import com.hbth.hsc.ui.main.adapter.Mp3ListAdapter;
import com.hbth.hsc.ui.main.contract.Mp3ListContract;
import com.hbth.hsc.ui.main.model.Mp3ListModel;
import com.hbth.hsc.ui.main.presenter.Mp3ListPresenter;
import com.hbth.hsc.utils.ShareParameterUtils;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.utils.LogUtils;

/**
 * Created by Administrator on 2018/2/6.
 * 展示期刊列表的页面
 */

public class Mp3ListFragment
        extends BaseResourceListFragment<
        Mp3ListModel, Mp3ListPresenter, Mp3ClassAdapter, Mp3ListAdapter>
        implements Mp3ListContract.View, BaseAdapter.OnItemClickListener {

    public static final String TAG = Mp3ListFragment.class.getName();

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        page = 1;
//        pageCount = ShareParameterUtils.getPageCount();
        pageCount = 2;
        rows = 15;
        super.initView();
        mPresenter.getMp3ListRequest();
    }

    @Override
    public void initLayoutManagerAndAdapter() {
        classLayoutManager = new LinearLayoutManager(getActivity());
        containerLayoutManager = new GridLayoutManager(getActivity(), 3);
        classAdapter = new Mp3ClassAdapter(getActivity(), recycler_class);
        containerAdapter = new Mp3ListAdapter(getActivity(), recycler_container);
    }

    @Override
    public void pageChanged() {
        mPresenter.getMp3ListRequest();
    }

    @Override
    protected void initListener() {
        super.initListener();
        classAdapter.setOnItemClickListener(this);
        containerAdapter.setOnItemClickListener(this);
    }

    @Override
    public void showLoading(String title) {
        LogUtils.loge("MP3 fragment显示加载框" + title);
    }

    @Override
    public void stopLoading() {
        LogUtils.loge("MP3 fragment停止加载");
    }

    @Override
    public void showErrorTip(String msg) {
        LogUtils.loge("MP3 fragment接收到错误信息：" + msg);
    }

    @Override
    public void returnMp3List(Mp3ListBean bean) {
        runLayoutAnimation();
        classAdapter.refreshData(bean.getSubject());
        containerAdapter.refreshData(bean.getResource());
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
    public String getType() {
        return "mp3";
    }

    @Override
    public String getClassId() {
        return classID;
    }

    @Override
    public void itemClicked(int viewId, int position, Object bean) {
        switch (viewId) {
            case R.id.recycler_class_resourcelist://分类条目点击事件
                Mp3ListBean.SubjectBean subjectBean = (Mp3ListBean.SubjectBean) bean;
                classID = subjectBean.getCode();
                goToFirstPage();
                mPresenter.getMp3ListRequest();
                break;
            case R.id.recycler_container_resourcelist://内容条目点击事件
                Mp3ListBean.ResourceBean resourceBean = (Mp3ListBean.ResourceBean) bean;
                // TODO: 2018/4/11
                break;
        }
    }
}
