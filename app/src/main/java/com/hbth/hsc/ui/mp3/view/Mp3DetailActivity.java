package com.hbth.hsc.ui.mp3.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.Mp3DetailBean;
import com.hbth.hsc.ui.mp3.adapter.Mp3CatalogueAdapter;
import com.hbth.hsc.ui.mp3.constract.Mp3DetailContract;
import com.hbth.hsc.ui.mp3.model.Mp3DetailModel;
import com.hbth.hsc.ui.mp3.presenter.Mp3DetailPresenter;
import com.hbth.hsc.widget.mp3.AudioInfoInterface;
import com.hbth.hsc.widget.mp3.AudioPlayerView;
import com.hbth.hsc.widget.mp3.CloseInterface;
import com.hbth.mylibrary.base.BaseActivity;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.utils.LogUtils;

import java.util.List;

import butterknife.BindView;

public class Mp3DetailActivity
        extends BaseActivity<Mp3DetailModel, Mp3DetailPresenter>
        implements Mp3DetailContract.View, BaseAdapter.OnItemClickListener,
        View.OnClickListener, AudioInfoInterface, CloseInterface {

    @BindView(R.id.recycler_catalogue_mp3detail)
    RecyclerView recyclerCatalogue;//目录列表
    @BindView(R.id.audio_mp3detail)
    AudioPlayerView playerView;//音频播放器
    @BindView(R.id.tv_mp3name_mp3detail)
    TextView nameTv;//音频名称
    @BindView(R.id.tv_long_mp3detail)
    TextView longTv;//音频时长
    @BindView(R.id.tv_size_mp3detail)
    TextView sizeTv;//音频大小
    @BindView(R.id.tv_childs_mp3detail)
    TextView childsTv;//专辑包含集数
    @BindView(R.id.tv_summary_mp3detail)
    TextView summaryTv;//摘要
    @BindView(R.id.tv_singer_mp3detail)
    TextView singerTv;//主讲人
    @BindView(R.id.tv_parentname_mp3detail)
    TextView parentNameTv;//专辑名称

    private String resourceId;//资源的ID
    private Mp3CatalogueAdapter catalogueAdapter;//剧集列表的适配器

    @Override
    protected void doBeforeSetContentView() {
        resourceId = getIntent().getStringExtra("resourceId");
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_mp3_detail;
    }

    /**
     * 初始化主导器
     */
    @Override
    protected void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    /**
     * 初始化视图控件
     */
    @Override
    protected void initView() {
        //
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        recyclerCatalogue.setLayoutManager(layoutManager);
        catalogueAdapter = new Mp3CatalogueAdapter(this, recyclerCatalogue);
        recyclerCatalogue.setAdapter(catalogueAdapter);
    }

    /**
     * 初始化监听
     */
    @Override
    protected void initListener() {
        catalogueAdapter.setOnItemClickListener(this);
        playerView.setOnAudioInfoInterface(this);
        playerView.setOnCloseInterface(this);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        //
        mPresenter.getMp3DetailRequest();
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

    /**
     * 返回获取到的数据
     *
     * @param bean
     */
    @Override
    public void returnMp3Detail(Mp3DetailBean bean) {
        //
        List<Mp3DetailBean.UrlBean> url = bean.getUrl();
        Mp3DetailBean.Mp3Bean mp3Bean = bean.getMp3();
        //初始化播放数据
        playerView.setPlayData(bean);
        //设置专辑信息
        singerTv.setText(mp3Bean.getAuthor());
        parentNameTv.setText(mp3Bean.getMp3Name());
        childsTv.setText("共" + url.size() + "集");
        summaryTv.setText(mp3Bean.getSummary());
        //刷新目录
        catalogueAdapter.refreshData(url);
        //开始播放
        playerView.startPlay(0);
    }

    @Override
    public String getResourceId() {
        return resourceId;
    }

    @Override
    public int getRows() {
        return 10;
    }

    /**
     * 条目点击事件
     */
    @Override
    public void itemClicked(int viewId, int position, Object bean) {
        switch (viewId) {
            case R.id.recycler_catalogue_mp3detail://目录列表条目点击事件
                playerView.startPlay(position);
                break;
        }
    }

    /**
     * 点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    /**
     * 销毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        playerView.stopPlay();
    }

    /**
     * 提供跳转到本Activity的Intent
     *
     * @param mContext
     * @param resourceId
     * @return
     */
    public static Intent getMyIntent(Context mContext, String resourceId) {
        Intent intent = new Intent(mContext, Mp3DetailActivity.class);
        intent.putExtra("resourceId", resourceId);
        return intent;
    }

    /**
     * 返回的播放信息
     *
     * @param urlBean
     */
    @Override
    public void returnUrlBean(Mp3DetailBean.UrlBean urlBean) {
        nameTv.setText(urlBean.getName());
        sizeTv.setText(urlBean.getSize());
        longTv.setText(urlBean.getVideoLong());
    }

    /**
     * 关闭按钮点击回调
     */
    @Override
    public void returnBtnClicked() {
        this.finish();
    }
}
