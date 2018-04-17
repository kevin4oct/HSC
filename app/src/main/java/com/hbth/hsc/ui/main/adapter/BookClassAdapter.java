package com.hbth.hsc.ui.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.BookListBean;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.ui.recyclerview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 2018/2/9.
 * 电子书首页分类适配器
 */

public class BookClassAdapter extends BaseAdapter<BookListBean.SubjectBean> {

    public BookClassAdapter(Context mContext, RecyclerView mRecycler) {
        super(mContext, mRecycler);
    }

    @Override
    public void refreshData(List<BookListBean.SubjectBean> mList) {
        BookListBean.SubjectBean bean = new BookListBean.SubjectBean();
        bean.setName("最新推荐");
        bean.setCode("");
        ArrayList<BookListBean.SubjectBean> list = new ArrayList<>();
        list.add(bean);
        list.addAll(mList);
        super.refreshData(list);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_class;
    }

    @Override
    public void setBindHolder(ViewHolder holder, int position, BookListBean.SubjectBean bean) {
        holder.setText(R.id.tv_class_item, bean.getName().trim());
        //设置文字背景
        if (position == selPosition) {
            holder.setBackgroundRes(R.id.tv_class_item, R.drawable.bg_selector);
        } else {
            holder.setBackgroundRes(R.id.tv_class_item, 0);
        }
    }
}
