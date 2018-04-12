package com.hbth.hsc.ui.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.hbth.hsc.R;
import com.hbth.hsc.bean.EightPaperListBean;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.ui.recyclerview.ViewHolder;
import com.hbth.mylibrary.utils.LogUtils;

/**
 * Created by Administrator on 2018/3/3.
 * 8点报列表内容
 */

public class EightPaperContainerAdapter
        extends BaseAdapter<EightPaperListBean> {

    public EightPaperContainerAdapter(Context mContext, RecyclerView mRecycler) {
        super(mContext, mRecycler);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_eightpaper;
    }

    @Override
    public void setBindHolder(ViewHolder holder, int position, EightPaperListBean bean) {
        String picUrl = bean.getPicUrl();
        holder.setSimpleDraweeViewUrl(R.id.iv_item_container, picUrl)
                .setText(R.id.tv_item_container, bean.getPapername());
    }
}
