package com.hbth.hsc.ui.mp3.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.Mp3DetailBean;
import com.hbth.hsc.bean.VideoDetailBean;
import com.hbth.hsc.utils.TimeUtil;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.ui.recyclerview.ViewHolder;

/**
 * Created by Kevin on 2018/3/7.
 * 播放列表的视频适配器
 */

public class Mp3CatalogueAdapter
        extends BaseAdapter<Mp3DetailBean.UrlBean> {

    public Mp3CatalogueAdapter(Context mContext, RecyclerView mRecycler) {
        super(mContext, mRecycler);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_catalogue_mp3;
    }

    @Override
    public void setBindHolder(ViewHolder holder, int position, Mp3DetailBean.UrlBean bean) {
        holder.setText(R.id.tv_name_item_mp3, bean.getName());

        if (position == selPosition) {
            holder.setTextColor(R.id.tv_name_item_mp3, Color.BLUE);
        } else {
            holder.setTextColorRes(R.id.tv_name_item_mp3, R.color.tv_detail_container);
        }

    }
}
