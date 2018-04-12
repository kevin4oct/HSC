package com.hbth.hsc.ui.book.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.BookDetailBean;
import com.hbth.hsc.ui.book.adapter.BookCatalogueAdapter;
import com.hbth.mylibrary.base.BaseActivity;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.utils.LogUtils;
import com.hbth.mylibrary.utils.ScreenUtil;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.util.List;

import butterknife.BindView;

public class EpubReaderActivity extends BaseActivity
        implements BaseAdapter.OnItemClickListener,
        View.OnClickListener,
        View.OnTouchListener {

    @BindView(R.id.recycler_bookreader)
    RecyclerView recyclerBookreader;
    @BindView(R.id.fl_recycler_bookreader)
    FrameLayout flRecyclerBookreader;
    @BindView(R.id.webview_bookread)
    WebView returnBtnClick;
    @BindView(R.id.iv_showChapter_bookreader)
    ImageView ivShowChapterBookreader;
    @BindView(R.id.iv_icon_bookreader)
    ImageView ivIconBookreader;
    @BindView(R.id.fl_webview_bookreader)
    FrameLayout flWebView;
    @BindView(R.id.web_bar_bookread)
    ProgressBar web_bar;
    @BindView(R.id.tv_hint_bookreader)
    TextView tvHint;

    private WebView webView;

    private BookCatalogueAdapter adapter;
    private BookDetailBean bean;//包含图书信息和目录的实体类
    private int index;//目录的下标索引
    private boolean isChapterShow = true;//当前目录是否显示
    private int pageCount;//总的页数

    @Override
    protected void doBeforeSetContentView() {
        super.doBeforeSetContentView();
        Intent intent = getIntent();
        bean = intent.getParcelableExtra("bean");
        index = intent.getIntExtra("index", 0);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_epub_reader;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
        //
        LinearLayoutManager layout = new LinearLayoutManager(this);
        recyclerBookreader.setLayoutManager(layout);
        adapter = new BookCatalogueAdapter(this, recyclerBookreader);
        recyclerBookreader.setAdapter(adapter);
        adapter.selPosition = index;//设置选中的目录条目
        List<BookDetailBean.UrlBean> urlList = bean.getUrl();
        pageCount = urlList.size();//设置总的页数
        adapter.refreshData(urlList);//刷新数据
        recyclerBookreader.scrollToPosition(index);//滑动到指定位置
        //
        webView = (WebView) findViewById(R.id.webview_bookread);
        WebSettings settings = webView.getSettings();

//         设置加载进来的页面自适应屏幕
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);

//        settings.setSupportZoom(true);
//        settings.setBuiltInZoomControls(true);
//        settings.setDisplayZoomControls(true);

        settings.setJavaScriptEnabled(true);
        settings.setPluginsEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setPluginsEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);


        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                LogUtils.loge("shouldOverrideUrlLoading " + url);
                view.loadUrl(url);
                return true;
            }

        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

                web_bar.setProgress(newProgress);
                tvHint.setText(newProgress+"%");

                if (newProgress == 100) {
                    web_bar.setVisibility(View.GONE);
                    tvHint.setVisibility(View.GONE);
                    hideChapter();
                } else {
                    web_bar.setVisibility(View.VISIBLE);
                    tvHint.setVisibility(View.VISIBLE);
                }
            }

        });
        BookDetailBean.UrlBean urlBean = (BookDetailBean.UrlBean) urlList.get(index);
        webView.loadUrl(urlBean.getUrl());
    }

    @Override
    protected void initListener() {
        adapter.setOnItemClickListener(this);
        ivShowChapterBookreader.setOnClickListener(this);
        webView.setOnTouchListener(this);
    }

    public static Intent getMyIntent(Context context, BookDetailBean bean, int index) {
        Intent intent = new Intent(context, EpubReaderActivity.class);
        intent.putExtra("bean", bean);
        intent.putExtra("index", index);
        return intent;
    }

    public void returnBtnClick(View view) {
        this.finish();
    }

    @Override
    public void itemClicked(int viewId, int position, Object bean) {
        index = position;
        BookDetailBean.UrlBean urlBean = (BookDetailBean.UrlBean) bean;
        webView.loadUrl(urlBean.getUrl());
    }

    @Override
    public void onClick(View view) {
        if (isChapterShow) {
            hideChapter();
        } else {
            showChapter();
        }
    }

    /**
     * 显示目录列表
     */
    public void showChapter() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(
                flRecyclerBookreader.getX(), 0);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float value = (Float) valueAnimator.getAnimatedValue();
                flRecyclerBookreader.setX(value);
                float x = value + flRecyclerBookreader.getWidth();
                ivShowChapterBookreader.setX(x);
                //
                ivIconBookreader.setX(x);
                ivIconBookreader.setPivotX(ivIconBookreader.getWidth() / 2);
                ivIconBookreader.setPivotY(ivIconBookreader.getHeight() / 2);
                ivIconBookreader.setRotation(-(value * 540) / flRecyclerBookreader.getWidth());
                //
                flWebView.setX(x);
                RelativeLayout.LayoutParams layoutParams =
                        new RelativeLayout.LayoutParams(
                                (int) (ScreenUtil.getScreenWidth() - x),
                                ScreenUtil.getScreenHeight() + 35);
                flWebView.setLayoutParams(layoutParams);
                flWebView.requestLayout();
            }
        });
        valueAnimator.start();
        isChapterShow = true;
    }

    /**
     * 隐藏目录列表
     */
    public void hideChapter() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(
                flRecyclerBookreader.getX(), -flRecyclerBookreader.getWidth());
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float value = (Float) valueAnimator.getAnimatedValue();
                flRecyclerBookreader.setX(value);
                float x = value + flRecyclerBookreader.getWidth();
                ivShowChapterBookreader.setX(x);
                //
                ivIconBookreader.setX(x);
                ivIconBookreader.setPivotX(ivIconBookreader.getWidth() / 2);
                ivIconBookreader.setPivotY(ivIconBookreader.getHeight() / 2);
                ivIconBookreader.setRotation(-(value * 540) / flRecyclerBookreader.getWidth());
                //
                flWebView.setX(x);
                RelativeLayout.LayoutParams layoutParams =
                        new RelativeLayout.LayoutParams(
                                (int) (ScreenUtil.getScreenWidth() - value),
                                ScreenUtil.getScreenHeight() + 35);
                flWebView.setLayoutParams(layoutParams);
                flWebView.requestLayout();
            }
        });
        valueAnimator.start();
        isChapterShow = false;
    }

    private float x_down;

    /**
     * 判断手势控制
     *
     * @param view
     * @param motionEvent
     * @return
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x_down = motionEvent.getX();
                break;
            case MotionEvent.ACTION_UP:
                float x_up = motionEvent.getX();
                if (Math.abs(x_up - x_down) > 80) {
                    if (x_up < x_down) {//向前翻页
                        if (index >= pageCount - 1) {
                            new AlertDialog.Builder(EpubReaderActivity.this)
                                    .setTitle("提示")
                                    .setMessage("已经是最后一页了..")
                                    .setNegativeButton("知道了", null)
                                    .show();
                        } else {
                            index++;
                        }
                    } else if (x_up > x_down) {//向后翻页
                        if (index <= 0) {
                            new AlertDialog.Builder(EpubReaderActivity.this)
                                    .setTitle("提示")
                                    .setMessage("已经是第一页了..")
                                    .setNegativeButton("知道了", null)
                                    .show();
                        } else {
                            index--;
                        }
                    }
                    String url = bean.getUrl().get(index).getUrl();
                    if (url != null) {
                        webView.loadUrl(url);
                        adapter.selPosition = index;
                        adapter.notifyDataSetChanged();
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return false;
    }
}
