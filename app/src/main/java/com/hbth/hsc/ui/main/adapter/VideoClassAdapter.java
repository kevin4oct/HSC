package com.hbth.hsc.ui.main.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.VideoListBean;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.ui.recyclerview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 * 视频首页列表分类适配器
 */

public class VideoClassAdapter extends BaseAdapter<VideoListBean.SubjectBean> {

    public VideoClassAdapter(Context mContext, RecyclerView mRecycler) {
        super(mContext, mRecycler);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_class;
    }

    @Override
    public void refreshData(List<VideoListBean.SubjectBean> mList) {
        VideoListBean.SubjectBean bean = new VideoListBean.SubjectBean();
        bean.setName("最新推荐");
        bean.setCode("");
        ArrayList<VideoListBean.SubjectBean> list = new ArrayList<>();
        list.add(bean);
        list.addAll(mList);
        super.refreshData(list);
    }

    @Override
    public void setBindHolder(ViewHolder holder, int position, VideoListBean.SubjectBean bean) {
        holder.setText(R.id.tv_class_item, bean.getName().trim());
        //设置文字颜色
        if (position == selPosition) {
            holder.setTextColorRes(R.id.tv_class_item, R.color.bg_selected);
        } else {
            holder.setTextColor(R.id.tv_class_item, Color.BLACK);
        }
    }


}
