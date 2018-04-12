package com.hbth.hsc.ui.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.Mp3ListBean;
import com.hbth.hsc.bean.VideoListBean;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.ui.recyclerview.ViewHolder;

/**
 * Created by Administrator on 2018/3/6.
 * 视频列表内容适配器
 */

public class Mp3ListAdapter extends BaseAdapter<Mp3ListBean.ResourceBean> {

    public Mp3ListAdapter(Context mContext, RecyclerView mRecycler) {
        super(mContext, mRecycler);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_mp3list;
    }

    @Override
    public void setBindHolder(ViewHolder holder, int position, Mp3ListBean.ResourceBean bean) {
        String picUrl = bean.getPicUrl();
        holder.setSimpleDraweeViewUrl(R.id.iv_cover_mp3list, picUrl)
                .setText(R.id.tv_name_mp3list, bean.getResourceName());
    }
}
