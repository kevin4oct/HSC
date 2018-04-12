package com.hbth.hsc.ui.video.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.VideoDetailBean;
import com.hbth.hsc.utils.TimeUtil;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.ui.recyclerview.ViewHolder;

/**
 * Created by Kevin on 2018/3/7.
 * 播放列表的视频适配器
 */

public class CatalogueAdapter
        extends BaseAdapter<VideoDetailBean.UrlBean> {

    public CatalogueAdapter(Context mContext, RecyclerView mRecycler) {
        super(mContext, mRecycler);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_catalogue_video;
    }

    @Override
    public void setBindHolder(ViewHolder holder, int position, VideoDetailBean.UrlBean bean) {
        holder.setText(R.id.tv_name_catalogue_video, "视频名称：" + bean.getName())
                .setText(R.id.tv_summary_catalogue_video, "视频大小：" + bean.getSize())
                .setText(R.id.tv_videolong_catalogue_video,
                        "视频时长：" + TimeUtil.parseToMMSS(
                                Integer.parseInt(
                                        bean.getVideoLong())));
        if (position == selPosition) {
            holder.setTextColor(R.id.tv_name_catalogue_video, Color.BLUE)
                    .setTextColor(R.id.tv_summary_catalogue_video, Color.BLUE)
                    .setTextColor(R.id.tv_videolong_catalogue_video, Color.BLUE)
                    .setVisible(R.id.iv_playing_catalogue_video, true);
        } else {
            holder.setTextColorRes(R.id.tv_name_catalogue_video, R.color.tv_detail_container)
                    .setTextColorRes(R.id.tv_summary_catalogue_video, R.color.tv_detail_container)
                    .setTextColorRes(R.id.tv_videolong_catalogue_video, R.color.tv_detail_container)
                    .setVisible(R.id.iv_playing_catalogue_video, false);
        }
    }
}
