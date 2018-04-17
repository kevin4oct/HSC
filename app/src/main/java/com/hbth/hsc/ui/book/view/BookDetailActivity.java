package com.hbth.hsc.ui.book.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hbth.hsc.R;
import com.hbth.hsc.bean.BookDetailBean;
import com.hbth.hsc.ui.book.adapter.BookCatalogueAdapter;
import com.hbth.hsc.ui.book.contract.BookDetailContract;
import com.hbth.hsc.ui.book.model.BookDetailModel;
import com.hbth.hsc.ui.book.presenter.BookDetailPresenter;
import com.hbth.mylibrary.base.BaseActivity;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;

public class BookDetailActivity
        extends BaseActivity<BookDetailModel, BookDetailPresenter>
        implements BookDetailContract.View, BaseAdapter.OnItemClickListener {

    @BindView(R.id.iv_cover_bookdetail)
    SimpleDraweeView ivCoverBookdetail;
    @BindView(R.id.tv_bookname_bookdetail)
    TextView tvBooknameBookdetail;
    @BindView(R.id.tv_author_bookdetail)
    TextView tvAuthorBookdetail;
    @BindView(R.id.tv_publish_bookdetail)
    TextView tvPublishBookdetail;
    @BindView(R.id.tv_price_bookdetail)
    TextView tvPriceBookdetail;
    @BindView(R.id.tv_pubdate_bookdetail)
    TextView tvPubdateBookdetail;
    @BindView(R.id.tv_summary_bookdetail)
    TextView tvSummaryBookdetail;
    @BindView(R.id.recycler_catalogue_bookdetail)
    RecyclerView recyclerCatalogueBookdetail;

    private String resourceId;
    private BookCatalogueAdapter adapter;
    //跳转使用
    private BookDetailBean bean;

    /**
     * 开始阅读
     *
     * @param view
     */
    public void startRead(View view) {
        if (bean != null) {
            startActivity(EpubReaderActivity.getMyIntent(this, this.bean, 0));
        } else {
            ToastUtil.showShort("请稍后..");
        }
    }

    /**
     * 条目点击事件
     *
     * @param position
     * @param bean
     */
    @Override
    public void itemClicked(int viewId, int position, Object bean) {
        if (bean != null) {
            startActivity(EpubReaderActivity.getMyIntent(this, this.bean, position));
        } else {
            ToastUtil.showShort("请稍后..");
        }
    }

    /**
     * 返回按钮
     *
     * @param view
     */
    public void returnBtnClick(View view) {
        this.finish();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_book_detail;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        //
        LinearLayoutManager layout = new LinearLayoutManager(this);
        recyclerCatalogueBookdetail.setLayoutManager(layout);
        adapter = new BookCatalogueAdapter(this, recyclerCatalogueBookdetail);
        recyclerCatalogueBookdetail.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        adapter.setOnItemClickListener(this);
    }

    @Override
    protected void initData() {
        mPresenter.returnBookDetailRequest();
    }

    @Override
    protected void doBeforeSetContentView() {
        super.doBeforeSetContentView();
        resourceId = getIntent().getStringExtra("resourceId");
    }

    public static Intent getIntent(Context mContext, String resourceId) {
        Intent intent = new Intent(mContext, BookDetailActivity.class);
        intent.putExtra("resourceId", resourceId);
        return intent;
    }

    @Override
    public void showLoading(String title) {
        // TODO: 2018/3/19
    }

    @Override
    public void stopLoading() {
        // TODO: 2018/3/19
    }

    @Override
    public void showErrorTip(String msg) {

    }

    @Override
    public void returnBookDetail(BookDetailBean bean) {

        this.bean = bean;//初始化
        BookDetailBean.EpubBean epub = bean.getEpub();
        ivCoverBookdetail.setImageURI(Uri.parse(epub.getPicUrl()));
        tvBooknameBookdetail.setText(epub.getBookName());
        tvAuthorBookdetail.setText(epub.getAuthor());
        tvPublishBookdetail.setText(epub.getPublisher());
        tvPriceBookdetail.setText(epub.getPrice() + " 元");
        tvPubdateBookdetail.setText(epub.getPubdate());
        tvSummaryBookdetail.setText(epub.getSummary());
        List<BookDetailBean.UrlBean> url = bean.getUrl();
        adapter.refreshData(url);
    }

    @Override
    public String getResourceId() {
        return resourceId;
    }

}
