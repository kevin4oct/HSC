package com.hbth.hsc.ui.main.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.VideoListBean;
import com.hbth.hsc.ui.main.adapter.VideoClassAdapter;
import com.hbth.hsc.ui.main.adapter.VideoListAdapter;
import com.hbth.hsc.ui.main.contract.VideoListContract;
import com.hbth.hsc.ui.main.model.VideoListModel;
import com.hbth.hsc.ui.main.presenter.VideoListPresenter;
import com.hbth.hsc.ui.video.view.VideoDetailActivity;
import com.hbth.hsc.utils.ShareParameterUtils;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.utils.LogUtils;

/**
 * Created by Kevin on 2018/2/6.
 * 展示视频列表的页面
 */

public class VideoListFragment
        extends BaseResourceListFragment<
        VideoListModel, VideoListPresenter, VideoClassAdapter, VideoListAdapter>
        implements VideoListContract.View, BaseAdapter.OnItemClickListener {

    public static final String TAG = VideoListFragment.class.getName();

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        page = 1;
        pageCount = ShareParameterUtils.getPageCount();
        rows = 12;
        super.initView();
        mPresenter.getVideoListRequest();
    }

    @Override
    public void initLayoutManagerAndAdapter() {
        classLayoutManager = new LinearLayoutManager(getActivity());
        containerLayoutManager = new GridLayoutManager(getActivity(), 2);
        classAdapter = new VideoClassAdapter(getActivity(), recycler_class);
        containerAdapter = new VideoListAdapter(getActivity(), recycler_container);
    }

    @Override
    public void pageChanged() {
        mPresenter.getVideoListRequest();
    }

    @Override
    protected void initListener() {
        super.initListener();
        classAdapter.setOnItemClickListener(this);
        containerAdapter.setOnItemClickListener(this);
    }

    @Override
    public void showLoading(String title) {
        LogUtils.loge("fragment显示加载框：" + title);
        // TODO: 2018/4/8  
    }

    @Override
    public void stopLoading() {
        LogUtils.loge("fragment停止加载");
        // TODO: 2018/4/8
    }

    @Override
    public void showErrorTip(String msg) {
        LogUtils.loge("fragment接收到错误信息：" + msg);
    }

    @Override
    public void returnVideoList(VideoListBean bean) {
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
        return "video";
    }

    @Override
    public String getClassId() {
        return classID;
    }

    @Override
    public void itemClicked(int viewId, int position, Object bean) {
        switch (viewId) {
            case R.id.recycler_class_resourcelist://分类条目点击事件
                VideoListBean.SubjectBean subjectBean = (VideoListBean.SubjectBean) bean;
                classID = subjectBean.getCode();
                goToFirstPage();
                mPresenter.getVideoListRequest();
                break;
            case R.id.recycler_container_resourcelist://内容条目点击事件
                VideoListBean.ResourceBean resourceBean = (VideoListBean.ResourceBean) bean;
                startActivity(VideoDetailActivity.getMyIntent(
                        getActivity(), String.valueOf(resourceBean.getResourceId())));
                break;
        }
    }
}
