package com.hbth.hsc.ui.eightpaper.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.EightPaperListBean;
import com.hbth.hsc.bean.EightPaperRootBean;
import com.hbth.hsc.ui.eightpaper.adapter.EightPaperReviewClassAdapter;
import com.hbth.hsc.ui.eightpaper.adapter.EightPaperReviewContainerAdapter;
import com.hbth.hsc.ui.eightpaper.contract.EightPaperReviewContract;
import com.hbth.hsc.ui.eightpaper.model.EightPaperReviewModel;
import com.hbth.hsc.ui.eightpaper.presenter.EightPaperReviewPresenter;
import com.hbth.mylibrary.base.BaseActivity;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.utils.ToastUtil;

import butterknife.BindView;

public class EightPaperReviewActivity
        extends BaseActivity<EightPaperReviewModel, EightPaperReviewPresenter>
        implements EightPaperReviewContract.View, BaseAdapter.OnItemClickListener {

    @BindView(R.id.tv_title_pastlist)
    TextView tvTitlePastlist;
    @BindView(R.id.recycler_class_pastlist)
    RecyclerView recyclerClassPastlist;
    @BindView(R.id.recycler_container_pastlist)
    RecyclerView recyclerContainerPastlist;
    @BindView(R.id.page_pastlist)
    TextView pagePastlist;
    @BindView(R.id.pagecount_pastlist)
    TextView pagecountPastlist;
    @BindView(R.id.ll_page_pastlist)
    LinearLayout llPagePastlist;
    @BindView(R.id.btn_return_pastlist)
    ImageView btnReturnPastlist;

    private String dbName;
    private String year;
    private String type;
    private EightPaperReviewClassAdapter classAdapter;
    private EightPaperReviewContainerAdapter containerAdapter;


    @Override
    protected void doBeforeSetContentView() {
        super.doBeforeSetContentView();
        Intent intent = getIntent();
        dbName = intent.getStringExtra("dbName");
        type = intent.getStringExtra("type");
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_eight_paper_review;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        LinearLayoutManager classLayout = new LinearLayoutManager(this);
        recyclerClassPastlist.setLayoutManager(classLayout);
        classAdapter = new EightPaperReviewClassAdapter(this, recyclerClassPastlist);
        recyclerClassPastlist.setAdapter(classAdapter);
        //
        GridLayoutManager containerManager = new GridLayoutManager(this, 3);
        recyclerContainerPastlist.setLayoutManager(containerManager);
        containerAdapter = new EightPaperReviewContainerAdapter(this, recyclerContainerPastlist);
        recyclerContainerPastlist.setAdapter(containerAdapter);

    }

    @Override
    protected void initListener() {
        classAdapter.setOnItemClickListener(this);
        containerAdapter.setOnItemClickListener(this);
    }

    @Override
    protected void initData() {
        //
        mPresenter.returnEightRootBeanRequest();
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
    public void returnEightPaperRootBean(EightPaperRootBean bean) {
        classAdapter.refreshData(bean.getClassList());
        containerAdapter.refreshData(bean.getBeanList());
    }

    @Override
    public String getDataname() {
        return dbName;
    }

    @Override
    public String getYear() {
        return year;
    }

    @Override
    public String getType() {
        return type;
    }

    public static Intent getMyIntent(Context context, String dbName, String type) {
        Intent intent = new Intent(context, EightPaperReviewActivity.class);
        intent.putExtra("dbName", dbName);
        intent.putExtra("type", type);
        return intent;
    }

    @Override
    public void itemClicked(int viewId, int position, Object bean) {
        switch (viewId) {
            case R.id.recycler_class_pastlist:
                String yearStr = (String) bean;
                if (position == 0) {
                    year = "";
                } else {
                    year = yearStr;
                }
                mPresenter.returnEightRootBeanRequest();
                break;
            case R.id.recycler_container_pastlist:
                EightPaperListBean bean2 = (EightPaperListBean) bean;
                startActivity(EightPaperReadActivity.getMyIntent(
                        this, bean2.getItemPaperId(), bean2.getDbname(), type));
                break;
        }
    }

    public void returnBtnClick(View view) {
        this.finish();
    }
}
