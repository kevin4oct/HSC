package com.hbth.hsc.ui.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.VideoListBean;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.ui.recyclerview.ViewHolder;

/**
 * Created by Administrator on 2018/3/6.
 * 视频列表内容适配器
 */

public class VideoListAdapter extends BaseAdapter<VideoListBean.ResourceBean> {

    public VideoListAdapter(Context mContext, RecyclerView mRecycler) {
        super(mContext, mRecycler);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_videolist;
    }

    @Override
    public void setBindHolder(ViewHolder holder, int position, VideoListBean.ResourceBean bean) {
        String picUrl = bean.getPicUrl();
        holder.setSimpleDraweeViewUrl(R.id.iv_item_videolist, picUrl)
                .setText(R.id.tv_item_videolist, bean.getResourceName());
    }
}
