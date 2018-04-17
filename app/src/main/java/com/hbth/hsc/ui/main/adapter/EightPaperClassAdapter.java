package com.hbth.hsc.ui.main.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.BookListBean;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.ui.recyclerview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 2018/3/3.
 * 8点首页分类列表适配器
 */

public class EightPaperClassAdapter extends BaseAdapter<String> {

    public EightPaperClassAdapter(Context mContext, RecyclerView mRecycler) {
        super(mContext, mRecycler);
    }

    @Override
    public void refreshData(List<String> mList) {
        ArrayList<String> list = new ArrayList<>();
        list.add("最新推荐");
        list.addAll(mList);
        super.refreshData(list);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_class;
    }

    @Override
    public void setBindHolder(ViewHolder holder, int position, String str) {
        holder.setText(R.id.tv_class_item, str.trim());
        //设置文字背景
        if (position == selPosition) {
            holder.setBackgroundRes(R.id.tv_class_item, R.drawable.bg_selector);
        } else {
            holder.setBackgroundRes(R.id.tv_class_item, 0);

        }
    }
}
