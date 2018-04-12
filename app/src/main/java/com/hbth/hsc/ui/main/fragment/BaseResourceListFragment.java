package com.hbth.hsc.ui.main.fragment;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TextView;

import com.hbth.hsc.R;
import com.hbth.mylibrary.base.BaseFragment;
import com.hbth.mylibrary.base.BaseModel;
import com.hbth.mylibrary.base.BasePresenter;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.zhy.android.percent.support.PercentRelativeLayout;

import butterknife.BindView;

/**
 * Created by Kevin on 2018/2/6.
 * 资源列表的基类
 */

public abstract class BaseResourceListFragment<
        M extends BaseModel, P extends BasePresenter,
        classAdapter extends BaseAdapter, containerAdapter extends BaseAdapter>
        extends BaseFragment<M, P>
        implements View.OnTouchListener, View.OnClickListener {

    @BindView(R.id.recycler_class_resourcelist)
    public RecyclerView recycler_class;
    @BindView(R.id.recycler_container_resourcelist)
    public RecyclerView recycler_container;
    @BindView(R.id.bg_resourcelist)
    public PercentRelativeLayout back_ppl;
    @BindView(R.id.page_resourcelist)
    TextView page_tv;
    @BindView(R.id.pagecount_resourcelist)
    TextView count_tv;
    @BindView(R.id.iv_lastpage_resourcelist)
    ImageView lastPage_iv;
    @BindView(R.id.iv_nextpage_resourcelist)
    ImageView nextPage_iv;

    //分类适配器
    public classAdapter classAdapter;
    //内容列表适配器
    public containerAdapter containerAdapter;
    //分类的布局管理器
    public LinearLayoutManager classLayoutManager;
    //内容的布局管理器
    public GridLayoutManager containerLayoutManager;

    public int page;//页码
    public int pageCount;//总的页数
    public int rows;//加载条目数量
    public String classID;//当前分类号

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_base_resourcelist;
    }

    @Override
    protected void initView() {
        //
        page_tv.setText(String.valueOf(page));
        count_tv.setText(String.valueOf(pageCount));
        //初始化布局管理器和适配器
        initLayoutManagerAndAdapter();
        //设置布局管理器和适配器
        setLayoutManagerAndAdapter();

    }

    @Override
    protected void initListener() {
        recycler_container.setOnTouchListener(this);
        lastPage_iv.setOnClickListener(this);
        nextPage_iv.setOnClickListener(this);
    }

    /**
     * 初始化布局管理器和适配器
     */
    public abstract void initLayoutManagerAndAdapter();

    /**
     * 设置布局管理器和适配器
     */
    public void setLayoutManagerAndAdapter() {
        recycler_class.setLayoutManager(classLayoutManager);
        recycler_container.setLayoutManager(containerLayoutManager);
        recycler_class.setAdapter(classAdapter);
        recycler_container.setAdapter(containerAdapter);
    }

    private float x_down;

    /**
     * 判断手势控制
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x_down = motionEvent.getX();
                x_down = motionEvent.getX();
                break;
            case MotionEvent.ACTION_UP:
                float x_up = motionEvent.getX();
                if (Math.abs(x_up - x_down) > 100) {
                    if (x_up < x_down) {
                        goToNextPage();
                    } else if (x_up > x_down) {
                        goToLastPage();
                    }
                } else {
                    return false;
                }
                break;
        }
        return true;
    }

    /**
     * 跳转到指定页数
     * @param view
     */
    public void gotoSelectPage(View view){
        new AlertDialog.Builder(getActivity())
                .setTitle("跳转到指定页数")
                .setMessage("帅哥，这个功能还没写代码呢，不要忘了！！！！！")
                .show();
    }

    /**
     * 跳转到上一页
     */
    public void goToLastPage() {

        if (page <= 1) {
            new AlertDialog.Builder(getActivity())
                    .setTitle("提示")
                    .setMessage("已经是第一页啦..")
                    .setPositiveButton("前往第二页", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            goToNextPage();
                        }
                    })
                    .setNegativeButton("好的", null)
                    .show();

        } else {
            page--;
            page_tv.setText(String.valueOf(page));
            pageChanged();
        }
    }

    /**
     * 跳转到下一页
     */
    public void goToNextPage() {

        if (page >= pageCount) {

            new AlertDialog.Builder(getActivity())
                    .setTitle("提示")
                    .setMessage("已经是最后一页啦..")
                    .setPositiveButton("返回首页", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            goToFirstPage();
                        }
                    })
                    .setNegativeButton("好的", null)
                    .show();
        } else {
            page++;
            page_tv.setText(String.valueOf(page));
            pageChanged();
        }
    }

    /**
     * 页数改变了
     */
    public abstract void pageChanged();

    /**
     * 跳转到第一页
     */
    public void goToFirstPage() {
        page = 1;
        page_tv.setText(String.valueOf(page));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_lastpage_resourcelist:
                goToLastPage();
                break;
            case R.id.iv_nextpage_resourcelist:
                goToNextPage();
                break;
        }
    }

    public void runLayoutAnimation() {
//        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(
                        getActivity(), R.anim.layout_animation_fall_down);
        recycler_container.setLayoutAnimation(controller);
        recycler_container.scheduleLayoutAnimation();
    }


}
