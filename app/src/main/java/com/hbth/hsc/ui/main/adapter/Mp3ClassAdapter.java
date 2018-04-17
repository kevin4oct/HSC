package com.hbth.hsc.ui.main.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.Mp3ListBean;
import com.hbth.hsc.bean.VideoListBean;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.ui.recyclerview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 * 视频首页列表分类适配器
 */

public class Mp3ClassAdapter extends BaseAdapter<Mp3ListBean.SubjectBean> {

    public Mp3ClassAdapter(Context mContext, RecyclerView mRecycler) {
        super(mContext, mRecycler);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_class;
    }

    @Override
    public void refreshData(List<Mp3ListBean.SubjectBean> mList) {
        Mp3ListBean.SubjectBean bean = new Mp3ListBean.SubjectBean();
        bean.setName("最新推荐");
        bean.setCode("");
        ArrayList<Mp3ListBean.SubjectBean> list = new ArrayList<>();
        list.add(bean);
        list.addAll(mList);
        super.refreshData(list);
    }

    @Override
    public void setBindHolder(ViewHolder holder, int position, Mp3ListBean.SubjectBean bean) {
        holder.setText(R.id.tv_class_item, bean.getName().trim());
        //设置文字背景
        if (position == selPosition) {
//            holder.setTextColorRes(R.id.tv_class_item, R.color.bg_selected);
            holder.setBackgroundRes(R.id.tv_class_item, R.drawable.bg_selector);
        } else {
            holder.setBackgroundRes(R.id.tv_class_item, 0);

        }
    }


}
