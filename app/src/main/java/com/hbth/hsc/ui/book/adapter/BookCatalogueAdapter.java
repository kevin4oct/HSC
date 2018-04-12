package com.hbth.hsc.ui.book.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.BookDetailBean;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.ui.recyclerview.ViewHolder;

/**
 * Created by Kevin on 2018/2/28.
 * 图书分类列表适配器
 */

public class BookCatalogueAdapter extends BaseAdapter<BookDetailBean.UrlBean> {

    public BookCatalogueAdapter(Context mContext, RecyclerView mRecycler) {
        super(mContext, mRecycler);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_catalogue;
    }

    @Override
    public void setBindHolder(ViewHolder holder, int position, BookDetailBean.UrlBean bean) {
        holder.setText(R.id.tv_catalogue, bean.getName());
        //设置文字颜色
        if (position == selPosition) {
            holder.setTextColor(R.id.tv_catalogue, Color.BLUE);
        } else {
            holder.setTextColorRes(R.id.tv_catalogue, R.color.tv_detail_container);
        }
    }
}
