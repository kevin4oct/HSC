package com.hbth.hsc.ui.video.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.VideoDetailBean;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.ui.recyclerview.ViewHolder;

/**
 * Created by Kevin on 2018/3/7.
 * 视频推荐列表的适配器
 */

public class RecommendAdapter extends BaseAdapter<VideoDetailBean.ListBean> {

    public RecommendAdapter(Context mContext, RecyclerView mRecycler) {
        super(mContext, mRecycler);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_recommend_video;
    }

    @Override
    public void setBindHolder(ViewHolder holder, int position, VideoDetailBean.ListBean bean) {
        holder.setText(R.id.tv_recomend_videoitem, bean.getResourceName())
                .setSimpleDraweeViewUrl(R.id.iv_recomend_videoitem, bean.getPicUrl());
    }
}
