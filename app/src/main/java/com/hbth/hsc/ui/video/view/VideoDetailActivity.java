package com.hbth.hsc.ui.video.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.VideoDetailBean;
import com.hbth.hsc.ui.video.adapter.CatalogueAdapter;
import com.hbth.hsc.ui.video.adapter.RecommendAdapter;
import com.hbth.hsc.ui.video.contract.VideoDetailContract;
import com.hbth.hsc.ui.video.model.VideoDetailModel;
import com.hbth.hsc.ui.video.presenter.VideoDetailPresenter;
import com.hbth.hsc.widget.video.CustomMediacontrol;
import com.hbth.hsc.widget.video.CustomVideoView;
import com.hbth.mylibrary.base.BaseActivity;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.utils.LogUtils;
import com.hbth.mylibrary.utils.ScreenUtil;
import com.zhy.android.percent.support.PercentRelativeLayout;

import java.util.List;

import butterknife.BindView;

/**
 * 视频详情界面
 */
public class VideoDetailActivity
        extends BaseActivity<VideoDetailModel, VideoDetailPresenter>
        implements VideoDetailContract.View, BaseAdapter.OnItemClickListener,
        CustomMediacontrol.HandleScreen, View.OnClickListener {

    @BindView(R.id.fl_videoplay_videodetail)
    FrameLayout flVideoplay;
    @BindView(R.id.tv_name_videodetail)
    TextView tvName;
    @BindView(R.id.tv_author_videodetail)
    TextView tvAuthor;
    @BindView(R.id.tv_pubdate_videodetail)
    TextView tvPubdate;
    @BindView(R.id.tv_size_videodetail)
    TextView tvSize;
    @BindView(R.id.rl_baseinfo_videodetail)
    PercentRelativeLayout rlBaseinfoVideodetail;
    @BindView(R.id.tv_summary_videodetail)
    TextView tvSummary;
    @BindView(R.id.recycler_recommend_videodetail)
    RecyclerView recyclerRecommend;
    @BindView(R.id.recycler_catalogue_videodetail)
    RecyclerView recyclerCatalogue;
    @BindView(R.id.videoview_videodetail)
    CustomVideoView videoView;
    @BindView(R.id.fl_bg_videodetail)
    FrameLayout rlBack;

    private CustomMediacontrol mCustomMediacontrol;

    private int mVideoHeaderHeight;//视频播放区域的原始高度
    private int mVideoHeaderWidth;//视频播放区域的原始宽度
    private float mVideoHeaderX;//视频播放区域的原始X位置
    private float mVideoHeaderY;//视频播放区域的原始Y位置

    private String resourceId;//资源的id
    private int rows;//加载推荐的数量

    private CatalogueAdapter catalogueAdapter;//剧集列表的适配器
    private RecommendAdapter recommendAdapter;//推荐列表的适配器

    @Override
    protected void doBeforeSetContentView() {
        super.doBeforeSetContentView();
        resourceId = getIntent().getStringExtra("resourceId");
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_video_detail;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        //
        mCustomMediacontrol = new CustomMediacontrol(this);
        mCustomMediacontrol.setVideoView(videoView);
        mCustomMediacontrol.setHandleScreen(this);
        //
        LinearLayoutManager catalogueAdapter = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        recyclerCatalogue.setLayoutManager(catalogueAdapter);
        this.catalogueAdapter = new CatalogueAdapter(this, recyclerCatalogue);
        recyclerCatalogue.setAdapter(this.catalogueAdapter);
        //
        LinearLayoutManager recommendLayout = new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false);
        recyclerRecommend.setLayoutManager(recommendLayout);
        recommendAdapter = new RecommendAdapter(this, recyclerRecommend);
        recyclerRecommend.setAdapter(recommendAdapter);
    }

    @Override
    protected void initListener() {
        catalogueAdapter.setOnItemClickListener(this);
        recommendAdapter.setOnItemClickListener(this);
        flVideoplay.setOnClickListener(this);
        rlBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                requestCloseFullScreen();
                return true;
            }
        });
    }

    @Override
    protected void initData() {
        //
        rows = 10;
        //
        mPresenter.getVideoDetailRequest();
    }

    public static Intent getMyIntent(Context mContext, String resourceId) {
        Intent intent = new Intent(mContext, VideoDetailActivity.class);
        intent.putExtra("resourceId", resourceId);
        return intent;
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {
        LogUtils.loge(msg);
    }

    @Override
    public void returnVideoDetail(VideoDetailBean bean) {
        VideoDetailBean.VideoBean videoBean = bean.getVideo();
        tvName.setText(videoBean.getVideoName());
        tvAuthor.setText(videoBean.getAuthor());
        tvPubdate.setText(videoBean.getPubdate());
        tvSummary.setText(videoBean.getSummary());
        List<VideoDetailBean.ListBean> listBeans = bean.getList();
        recommendAdapter.refreshData(listBeans);
        List<VideoDetailBean.UrlBean> urlBeans = bean.getUrl();
        catalogueAdapter.refreshData(urlBeans);
        tvSize.setText(urlBeans.size() + "集");
        VideoDetailBean.UrlBean urlBean = urlBeans.get(0);
        mCustomMediacontrol.setDuration(Integer.parseInt(urlBean.getVideoLong()));
        //默认开始播放第一集
        videoView.setVideoURI(Uri.parse(urlBean.getUrl()));
        videoView.start();
    }

    @Override
    public String getResourceId() {
        return resourceId;
    }

    @Override
    public int getRows() {
        return rows;
    }

    public void startRead(View view) {
        requestOpenFullScreen();
    }

    public void returnBtnClick(View view) {
        this.finish();
    }

    @Override
    public void itemClicked(int viewId, int position, Object bean) {
        switch (viewId) {
            case R.id.recycler_recommend_videodetail://推荐列表条目点击事件
                VideoDetailBean.ListBean listBean = (VideoDetailBean.ListBean) bean;
                this.resourceId = String.valueOf(listBean.getResourceId());
                mPresenter.getVideoDetailRequest();
                break;
            case R.id.recycler_catalogue_videodetail://目录列表条目点击事件
                VideoDetailBean.UrlBean urlBean = (VideoDetailBean.UrlBean) bean;
                String url = urlBean.getUrl();
                videoView.setVideoURI(Uri.parse(url));
                break;
        }
    }

    @Override
    public void requestOpenFullScreen() {
        //设置背景
        rlBack.setVisibility(View.VISIBLE);
        //
        if (mVideoHeaderX == 0) {
            mVideoHeaderX = flVideoplay.getX();
        }
        if (mVideoHeaderY == 0) {
            mVideoHeaderY = flVideoplay.getY();
        }
        ViewGroup.LayoutParams layoutParams = flVideoplay.getLayoutParams();
        if (mVideoHeaderHeight == 0) {
            mVideoHeaderHeight = layoutParams.height;
        }
        if (mVideoHeaderWidth == 0) {
            mVideoHeaderWidth = layoutParams.width;
        }
        //
        layoutParams.width = ScreenUtil.getScreenWidth();
        layoutParams.height = ScreenUtil.getScreenWidth() * 9 / 16;
        flVideoplay.setLayoutParams(layoutParams);
        //
        flVideoplay.setX(48);
        flVideoplay.setY(465);
    }

    @Override
    public void requestCloseFullScreen() {
        //设置背景
        rlBack.setVisibility(View.GONE);
        //
        flVideoplay.setX(mVideoHeaderX);
        flVideoplay.setY(mVideoHeaderY);
        ViewGroup.LayoutParams layoutParams = flVideoplay.getLayoutParams();
        layoutParams.height = mVideoHeaderHeight;
        layoutParams.width = mVideoHeaderWidth;
        flVideoplay.setLayoutParams(layoutParams);
    }

    @Override
    public void requestClosePage() {
        if (videoView != null) {
            videoView.stopPlayback();
        }
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.videoview_videodetail:
                LogUtils.loge("全屏播放");
                requestOpenFullScreen();
                break;
        }
    }
}
