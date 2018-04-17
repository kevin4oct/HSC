package com.hbth.hsc.ui.eightpaper.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.hbth.hsc.R;
import com.hbth.hsc.bean.EightPaperPicBean;
import com.hbth.hsc.bean.EightPaperReaderBean;
import com.hbth.hsc.ui.eightpaper.adapter.EightPaperReaderAdapter;
import com.hbth.hsc.ui.eightpaper.contract.EightPaperReadContract;
import com.hbth.hsc.ui.eightpaper.model.EightPaperReaderModel;
import com.hbth.hsc.ui.eightpaper.presenter.EightPaperReaderPresenter;
import com.hbth.mylibrary.base.BaseActivity;
import com.hbth.mylibrary.ui.recyclerview.BaseAdapter;
import com.hbth.mylibrary.utils.ScreenUtil;
import com.hbth.mylibrary.utils.ToastUtil;
import com.zhy.android.percent.support.PercentRelativeLayout;

import java.util.List;

import butterknife.BindView;
import me.relex.photodraweeview.PhotoDraweeView;

public class EightPaperReadActivity
        extends BaseActivity<EightPaperReaderModel, EightPaperReaderPresenter>
        implements EightPaperReadContract.View, BaseAdapter.OnItemClickListener,
        View.OnClickListener {

    @BindView(R.id.tv_title_eightread)
    TextView tvTitleEightread;
    @BindView(R.id.recycler_eightread)
    RecyclerView recyclerEightread;
    @BindView(R.id.rl_list_eightreader)
    PercentRelativeLayout rlListEightreader;
    @BindView(R.id.iv_eightreader)
    SimpleDraweeView backPage;
    @BindView(R.id.photoView)
    PhotoDraweeView mPhotoDraweeView;
    @BindView(R.id.iv_showChapter_eightread)
    ImageView ivShowChapter;
    @BindView(R.id.iv_icon_eightread)
    ImageView ivIcon;
    @BindView(R.id.progress_eightread)
    ProgressBar progressbar;
    @BindView(R.id.iv_lastpage_eightreader)
    ImageView lastPageBtn;
    @BindView(R.id.iv_nextpage_eightreader)
    ImageView nextPageBtn;

    //
    private String paperId;
    private String dbName;
    private String type;//资源类象
    private EightPaperReaderAdapter adapter;
    private boolean isChapterShow = true;//菜单区域是否显示

    private static final int GOTOLASTPAGE = 0x001;//上一页的标记
    private static final int GOTONEXTPAGE = 0x002;//下一页的标记

    private int page;//当前页数
    private int pageCount;//总的页数


    @Override
    protected void doBeforeSetContentView() {
        super.doBeforeSetContentView();
        Intent intent = getIntent();
        paperId = intent.getStringExtra("paperId");
        dbName = intent.getStringExtra("dbName");
        type = intent.getStringExtra("type");
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_eight_read;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        //
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        recyclerEightread.setLayoutManager(layoutManager);
        adapter = new EightPaperReaderAdapter(this, recyclerEightread);
        recyclerEightread.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        adapter.setOnItemClickListener(this);
        ivShowChapter.setOnClickListener(this);
        lastPageBtn.setOnClickListener(this);
        nextPageBtn.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        //
        mPresenter.returnEightReaderBeanRequest();
    }

    public static Intent getMyIntent(Context mContext, String paperId, String dbName, String type) {
        Intent intent = new Intent(mContext, EightPaperReadActivity.class);
        intent.putExtra("paperId", paperId);
        intent.putExtra("dbName", dbName);
        intent.putExtra("type", type);
        return intent;
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {
        ToastUtil.showShort(msg);
    }

    @Override
    public void returnEightPaperReaderBean(EightPaperReaderBean bean) {

        tvTitleEightread.setText(bean.getPaperName());//菜单的杂志名称
        List<EightPaperPicBean> picList = bean.getPicList();

        loadImg(picList.get(0).getPaperPicUrl());//加载展示页
        backPage.setImageURI(picList.get(1).getPaperPicUrl());//加载背景页
        pageCount = picList.size();
        adapter.refreshData(picList);
        //
        progressbar.setVisibility(View.GONE);
        hideOrShowList();
    }

    @Override
    public String getPaperid() {
        return paperId;
    }

    @Override
    public String getDbname() {
        return dbName;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void itemClicked(int viewId, int position, Object bean) {
        page = position;
        loadImg(((EightPaperPicBean) bean).getPaperPicUrl());
    }

    /**
     * 返回按钮点击事件
     *
     * @param view
     */
    public void returnBtnClick(View view) {
        this.finish();
    }

    /**
     * 点击事件
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_lastpage_eightreader://上一页
                gotoLastPage();
                break;
            case R.id.iv_nextpage_eightreader://下一页
                gotoNextPage();
                break;
            case R.id.iv_showChapter_eightread:
                hideOrShowList();
                break;
        }
    }

    /**
     * 跳转到上一页
     */
    private void gotoLastPage() {
        if (page <= 0) {//不可以向上翻页
            new AlertDialog.Builder(EightPaperReadActivity.this)
                    .setTitle("提示")
                    .setMessage("现在已经是第一页啦")
                    .setPositiveButton("跳转到第二页", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            loadImg(adapter.getItemBean(1).getPaperPicUrl());
                            adapter.selPosition = 1;
                            adapter.notifyItemChanged(0);
                            adapter.notifyItemChanged(1);
                            recyclerEightread.scrollToPosition(page);
                        }
                    })
                    .setNegativeButton("知道了", null)
                    .show();
        } else {
            //隐藏菜单
            if (isChapterShow) {
                hideOrShowList();
            }
            //
            page--;
            backPage.setImageURI(Uri.parse(adapter.getItemBean(page).getPaperPicUrl()));
            //
            Animation lastAnimation = AnimationUtils.loadAnimation(this, R.anim.set_lastpage);
            lastAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {

                    loadImg(adapter.getItemBean(page).getPaperPicUrl());
                    adapter.selPosition = page;
                    adapter.notifyItemChanged(page + 1);
                    adapter.notifyItemChanged(page);
                    recyclerEightread.scrollToPosition(page);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            mPhotoDraweeView.startAnimation(lastAnimation);
        }
    }

    /**
     * 跳转到下一页
     */
    private void gotoNextPage() {
        if (page >= pageCount) {//不可以向下翻页
            new AlertDialog.Builder(EightPaperReadActivity.this)
                    .setTitle("提示")
                    .setMessage("现在已经是最后一页啦")
                    .setPositiveButton("跳转到第一页", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            loadImg(adapter.getItemBean(0).getPaperPicUrl());
                            adapter.selPosition = 0;
                            adapter.notifyItemChanged(page - 1);
                            adapter.notifyItemChanged(0);
                            recyclerEightread.scrollToPosition(page);
                        }
                    })
                    .setNegativeButton("知道了", null)
                    .show();
        } else {
            //隐藏菜单
            if (isChapterShow) {
                hideOrShowList();
            }
            //
            page++;
            if (page + 1 < pageCount) {
                backPage.setImageURI(Uri.parse(adapter.getItemBean(page).getPaperPicUrl()));
            }
            Animation nextAnimation = AnimationUtils.loadAnimation(this, R.anim.set_nextpage);
            nextAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {

                    loadImg(adapter.getItemBean(page).getPaperPicUrl());
                    adapter.selPosition = page;
                    adapter.notifyItemChanged(page);
                    adapter.notifyItemChanged(page - 1);
                    recyclerEightread.scrollToPosition(page);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            mPhotoDraweeView.startAnimation(nextAnimation);
        }
    }

    /**
     * 显示或者隐藏菜单
     */
    private void hideOrShowList() {
        if (isChapterShow) {
            isChapterShow = false;
            startChapterAnimation(false);
        } else {
            isChapterShow = true;
            startChapterAnimation(true);
        }
    }

    /**
     * 执行菜单显示或隐藏动画
     *
     * @param isShow true 显示列表；false 隐藏列表
     */
    public void startChapterAnimation(boolean isShow) {
        float[] animationValue = null;
        if (isShow) {
            animationValue = new float[]{-rlListEightreader.getWidth(), 0};
        } else {
            animationValue = new float[]{0, -rlListEightreader.getWidth()};
        }
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(
                animationValue);
        valueAnimator.setDuration(500);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float value = (Float) valueAnimator.getAnimatedValue();
                rlListEightreader.setX(value);
                float x = value + rlListEightreader.getWidth();
                ivShowChapter.setX(x);
                lastPageBtn.setX(x);
                //
                ivIcon.setX(x);
                ivIcon.setPivotX(ivIcon.getWidth() / 2);
                ivIcon.setPivotY(ivIcon.getHeight() / 2);
                ivIcon.setRotation(-(value * 540) / rlListEightreader.getWidth());//旋转
                //
            }
        });
        valueAnimator.start();

    }

    /**
     * 加载手势控制的大图
     *
     * @param img_url
     */
    private void loadImg(String img_url) {
        if (!TextUtils.isEmpty(img_url)) {
            PipelineDraweeControllerBuilder controller = Fresco.newDraweeControllerBuilder();
            controller.setUri(img_url);//设置图片url
            controller.setOldController(mPhotoDraweeView.getController());
            controller.setControllerListener(new BaseControllerListener<ImageInfo>() {
                @Override
                public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                    super.onFinalImageSet(id, imageInfo, animatable);
                    if (imageInfo == null || mPhotoDraweeView == null) {
                        return;
                    }
                    mPhotoDraweeView.update(imageInfo.getWidth(), imageInfo.getHeight());
                }
            });
            mPhotoDraweeView.setController(controller.build());
        } else {
            Toast.makeText(this, "图片获取失败", Toast.LENGTH_SHORT).show();
        }
    }

}
