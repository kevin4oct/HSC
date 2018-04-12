package com.hbth.hsc.ui.eightpaper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.EightPaperPicBean;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.ui.recyclerview.ViewHolder;

/**
 * Created by Administrator on 2018/3/5.
 * 8点资源阅读的适配器
 */

public class EightPaperReaderAdapter extends BaseAdapter<EightPaperPicBean> {

    public EightPaperReaderAdapter(Context mContext, RecyclerView mRecycler) {
        super(mContext, mRecycler);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_eightread;
    }

    @Override
    public void setBindHolder(ViewHolder holder, int position, EightPaperPicBean bean) {
        holder.setSimpleDraweeViewUrl(R.id.iv_item_eightread, bean.getPaperPicUrl());
        holder.setText(R.id.tv_page_eightread, "第" + bean.getPaperPage() + "页");
        if (position == selPosition) {
            holder.setBackgroundRes(R.id.rl_bg_item_eightreader, R.color.bg_selected);
        } else {
            holder.setBackgroundColor(R.id.rl_bg_item_eightreader, 0);
        }
    }

}
