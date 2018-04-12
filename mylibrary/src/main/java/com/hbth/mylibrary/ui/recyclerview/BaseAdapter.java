package com.hbth.mylibrary.ui.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 2017/12/1.
 * recyclerview适配器的基类
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<ViewHolder>
        implements View.OnClickListener,
        View.OnLongClickListener {

    public final RecyclerView mRecycler;//recycler对象
    private final LayoutInflater layoutInflater;//填充器
    private final Context mContext;//上下文对象
    public List<T> mList;//盛放实体类的容器
    public int selPosition;//选中的位置
    private OnItemClickListener<T> itemClickListener;//条目点击事件
    private OnItemLongClickListener<T> itemLongClickListener;//条牧长点击事件

    public BaseAdapter(Context mContext, RecyclerView mRecycler) {
        selPosition = 0;//默认选中第一条
        this.mContext = mContext;
        this.mRecycler = mRecycler;
        this.mList = new ArrayList<>();
        layoutInflater = LayoutInflater.from(mContext);
    }

    /**
     * 刷新数据
     *
     * @param mList 新的数据
     */
    public void refreshData(List<T> mList) {
        if (mList != null) {
            this.mList.clear();
            this.mList.addAll(mList);
            notifyDataSetChanged();
        }
    }

    /**
     * 加载数据
     *
     * @param mList 新的数据
     */
    public void loadMoreData(List<T> mList) {
        if (mList != null) {
            this.mList.addAll(mList);
            notifyDataSetChanged();
        }
    }

    /**
     * 获取条目布局
     *
     * @return
     */
    public abstract int getItemLayout();

    /**
     * 获取指定位置的实体类
     *
     * @param position
     * @return
     */
    public T getItemBean(int position) {
        return mList.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(getItemLayout(), parent, false);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return new ViewHolder(mContext, view);
    }

    /**
     * 设置绑定的viewHolder
     *
     * @param holder
     * @param bean
     */
    public abstract void setBindHolder(ViewHolder holder, int position, T bean);

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        setBindHolder(holder, position, mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    /**
     * 点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {

        int position = selPosition;
        selPosition = mRecycler.getChildAdapterPosition(view);//记录选中的位置
        if (itemClickListener != null) {
            itemClickListener.itemClicked(mRecycler.getId(), selPosition, (T) mList.get(selPosition));
        }
        notifyItemChanged(selPosition);
        notifyItemChanged(position);
    }

    /**
     * 长按事件
     * @param v
     * @return
     */
    @Override
    public boolean onLongClick(View v) {

        int position = mRecycler.getChildAdapterPosition(v);
        notifyDataSetChanged();
        if (itemLongClickListener != null) {
            itemLongClickListener.itemLongClicked(position, mList.get(position));
        }
        return false;
    }

    /**
     * 设置点击事件回调接口
     *
     * @param listener
     */
    public void setOnItemClickListener(@Nullable OnItemClickListener listener) {
        if (listener != null) {
            this.itemClickListener = listener;
        }
    }

    public interface OnItemClickListener<T> {
        void itemClicked(int viewId, int position, T bean);
    }

    /**
     * 设置长按回调接口
     *
     * @param listener
     */
    public void setOnItemLongClickListener(@Nullable OnItemLongClickListener listener) {
        if (listener != null) {
            itemLongClickListener = listener;
        }
    }

    public interface OnItemLongClickListener<T> {
        void itemLongClicked(int position, T bean);
    }
}
