package com.hbth.hsc.ui.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.BookListBean;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.ui.recyclerview.ViewHolder;
import com.hbth.mylibrary.utils.LogUtils;

/**
 * Created by Administrator on 2018/2/9.
 *电子书列表内容适配器
 */

public class BookListAdapter extends BaseAdapter<BookListBean.ResourceBean> {

    public BookListAdapter(Context mContext, RecyclerView mRecycler) {
        super(mContext, mRecycler);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_eightpaper;
    }

    @Override
    public void setBindHolder(ViewHolder holder, int position, BookListBean.ResourceBean bean) {
        String picUrl = bean.getPicUrl();
        holder.setSimpleDraweeViewUrl(R.id.iv_item_container, picUrl)
                .setText(R.id.tv_item_container, bean.getResourceName());
    }
}
