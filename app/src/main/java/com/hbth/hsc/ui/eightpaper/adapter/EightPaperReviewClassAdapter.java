package com.hbth.hsc.ui.eightpaper.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;

import com.hbth.hsc.R;
import com.hbth.hsc.ui.main.adapter.EightPaperClassAdapter;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.ui.recyclerview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/5.
 */

public class EightPaperReviewClassAdapter extends BaseAdapter<String> {

    public EightPaperReviewClassAdapter(Context mContext, RecyclerView mRecycler) {
        super(mContext, mRecycler);
    }

    @Override
    public void refreshData(List<String> mList) {
        super.refreshData(mList);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_class;
    }

    @Override
    public void setBindHolder(ViewHolder holder, int position, String str) {
        holder.setText(R.id.tv_class_item, str.trim());
        //设置文字颜色
        if (position == selPosition) {
            holder.setTextColor(R.id.tv_class_item, Color.GREEN);
        } else {
            holder.setTextColor(R.id.tv_class_item, Color.BLACK);
        }
    }
}
