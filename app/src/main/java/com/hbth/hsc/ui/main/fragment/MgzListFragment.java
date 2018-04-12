package com.hbth.hsc.ui.main.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.hbth.hsc.R;
import com.hbth.hsc.api.ALLVARIABLE;
import com.hbth.hsc.bean.EightPaperListBean;
import com.hbth.hsc.bean.EightPaperRootBean;
import com.hbth.hsc.ui.eightpaper.view.EightPaperReviewActivity;
import com.hbth.hsc.ui.main.adapter.EightPaperClassAdapter;
import com.hbth.hsc.ui.main.adapter.EightPaperContainerAdapter;
import com.hbth.hsc.ui.main.contract.EightPaperListContract;
import com.hbth.hsc.ui.main.model.EightPaperListModel;
import com.hbth.hsc.ui.main.presenter.EightPaperListPresenter;
import com.hbth.hsc.utils.ShareParameterUtils;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.utils.ToastUtil;

/**
 * Created by Kevin on 2018/2/6.
 * 展示期刊列表的页面
 */
public class MgzListFragment
        extends BaseResourceListFragment<EightPaperListModel, EightPaperListPresenter,
        EightPaperClassAdapter, EightPaperContainerAdapter>
        implements EightPaperListContract.View, BaseAdapter.OnItemClickListener {

    public static final String TAG = MgzListFragment.class.getName();

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        super.initView();
        //
        page = 1;
        pageCount = ShareParameterUtils.getPageCount();
        rows = 20;
        //
        super.initView();
        //
        mPresenter.getEightPaperListRequest(ALLVARIABLE.getEnterindex());
    }

    @Override
    public void initLayoutManagerAndAdapter() {
        classLayoutManager = new LinearLayoutManager(getActivity());
        containerLayoutManager = new GridLayoutManager(getActivity(), 3);
        classAdapter = new EightPaperClassAdapter(getActivity(), recycler_class);
        containerAdapter = new EightPaperContainerAdapter(getActivity(), recycler_container);
    }

    @Override
    public void pageChanged() {
        mPresenter.getEightPaperListRequest(ALLVARIABLE.getEnterindex());
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
        ToastUtil.showShort(msg);
    }

    @Override
    public void returnEightPaperList(EightPaperRootBean bean) {
        runLayoutAnimation();
        classAdapter.refreshData(bean.getClassList());
        containerAdapter.refreshData(bean.getBeanList());
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
        return ALLVARIABLE.getMtype();
    }

    @Override
    public String getClassfy() {
        return classID;
    }

    @Override
    public void itemClicked(int viewId, int position, Object bean) {
        switch (viewId) {
            case R.id.recycler_class_resourcelist://分类列表点击事件
                String classStr = (String) bean;
                goToFirstPage();
                if (position == 0) {
                    classID = "";
                    mPresenter.getEightPaperListRequest(ALLVARIABLE.getEnterindex());
                } else {
                    classID = classStr;
                    mPresenter.getEightPaperListRequest(ALLVARIABLE.getSelindexbyclassify());
                }
                break;
            case R.id.recycler_container_resourcelist://内容条目点击事件
                EightPaperListBean bean2 = (EightPaperListBean) bean;
                startActivity(EightPaperReviewActivity.getMyIntent(
                        getActivity(), bean2.getPapername(), ALLVARIABLE.getMtype()));
                break;
        }
    }

}
