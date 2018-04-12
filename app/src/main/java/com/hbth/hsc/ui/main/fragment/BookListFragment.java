package com.hbth.hsc.ui.main.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.BookListBean;
import com.hbth.hsc.ui.book.view.BookDetailActivity;
import com.hbth.hsc.ui.main.adapter.BookClassAdapter;
import com.hbth.hsc.ui.main.adapter.BookListAdapter;
import com.hbth.hsc.ui.main.contract.BookListContract;
import com.hbth.hsc.ui.main.model.BookListModel;
import com.hbth.hsc.ui.main.presenter.BookListPresenter;
import com.hbth.hsc.utils.ShareParameterUtils;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.utils.LogUtils;

/**
 * Created by Kevin on 2018/2/6.
 * 展示电子书列表的页面
 */
public class BookListFragment
        extends BaseResourceListFragment<
        BookListModel, BookListPresenter, BookClassAdapter, BookListAdapter>
        implements BookListContract.View, BaseAdapter.OnItemClickListener {

    public static final String TAG = BookListFragment.class.getName();

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        //
        page = 1;
        pageCount = ShareParameterUtils.getPageCount();
        rows = 15;
        //
        super.initView();
        //
        mPresenter.getBookListRequest();
    }

    @Override
    public void initLayoutManagerAndAdapter() {
        classLayoutManager = new LinearLayoutManager(getActivity());
        containerLayoutManager = new GridLayoutManager(getActivity(), 3);
        classAdapter = new BookClassAdapter(getActivity(), recycler_class);
        containerAdapter = new BookListAdapter(getActivity(), recycler_container);
    }

    @Override
    public void pageChanged() {
        mPresenter.getBookListRequest();
    }

    @Override
    protected void initListener() {
        super.initListener();
        classAdapter.setOnItemClickListener(this);
        containerAdapter.setOnItemClickListener(this);
    }

    @Override
    public void showLoading(String title) {
        // TODO: 2018/4/8  
    }

    @Override
    public void stopLoading() {
        // TODO: 2018/4/8
    }

    @Override
    public void showErrorTip(String msg) {
        LogUtils.loge("错误信息：" + msg);
    }

    /**
     * 获取到数据
     *
     * @param bookListBean
     */
    @Override
    public void returnBookList(BookListBean bookListBean) {
        runLayoutAnimation();
        classAdapter.refreshData(bookListBean.getSubject());
        containerAdapter.refreshData(bookListBean.getResource());

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
        return "book";
    }

    @Override
    public String getClassId() {
        return classID;
    }

    /**
     * 条目点击事件
     *
     * @param viewId
     * @param position
     * @param bean
     */
    @Override
    public void itemClicked(int viewId, int position, Object bean) {
        switch (viewId) {
            case R.id.recycler_class_resourcelist://分类条目点击事件
                BookListBean.SubjectBean subjectBean = (BookListBean.SubjectBean) bean;
                classID = subjectBean.getCode();
                goToFirstPage();
                mPresenter.getBookListRequest();
                break;
            case R.id.recycler_container_resourcelist://资源列表条目点击事件
                BookListBean.ResourceBean resourceBean = (BookListBean.ResourceBean) bean;
                startActivity(BookDetailActivity.getIntent(getActivity(),
                        String.valueOf(resourceBean.getResourceId())));
                break;

        }
    }
}
