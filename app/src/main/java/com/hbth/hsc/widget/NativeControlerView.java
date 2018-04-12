package com.hbth.hsc.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hbth.hsc.R;


/**
 * Created by hebth on 2017-11-14.
 * 自定义导航条
 */

public class NativeControlerView extends RelativeLayout {

    private TextView book_tv;
    private TextView magzine_tv;
    private TextView paper_tv;
    private TextView video_tv;
    private TextView mp3_tv;
    private TextView rss_tv;

    private OnNativeControlClickListener listener;
    private Animation animation;

    private int selColorColor = Color.WHITE;//选中的文字颜色
    private int normalColorColor = Color.BLACK;//未选中的文字颜色

    public void setAnimation(View view) {
        view.startAnimation(animation);
    }

    /**
     * 初始化监听
     */
    private void initListener() {

        book_tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnimation(book_tv);
                listener.bookBtnClick();
                changeBackGround(v);
            }
        });
        magzine_tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnimation(magzine_tv);
                listener.magzineBtnClick();
                changeBackGround(v);
            }
        });
        paper_tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnimation(paper_tv);
                listener.paperBtnClick();
                changeBackGround(v);
            }
        });
        video_tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnimation(video_tv);
                listener.videoBtnClick();
                changeBackGround(v);
            }
        });
        mp3_tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnimation(mp3_tv);
                listener.mp3BtnClick();
                changeBackGround(v);
            }
        });
        rss_tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnimation(rss_tv);
                listener.rssBtnClick();
                changeBackGround(v);
            }
        });
    }

    /**
     * 设置选择效果
     *
     * @param view
     */
    private void changeBackGround(View view) {
        book_tv.setBackgroundResource(0);
        book_tv.setTextColor(normalColorColor);
        magzine_tv.setBackgroundResource(0);
        magzine_tv.setTextColor(normalColorColor);
        paper_tv.setBackgroundResource(0);
        paper_tv.setTextColor(normalColorColor);
        video_tv.setBackgroundResource(0);
        video_tv.setTextColor(normalColorColor);
        mp3_tv.setBackgroundResource(0);
        mp3_tv.setTextColor(normalColorColor);
        rss_tv.setBackgroundResource(0);
        rss_tv.setTextColor(normalColorColor);
        view.setBackgroundResource(R.mipmap.bg_selected);
        ((TextView) (view)).setTextColor(selColorColor);
    }

    /**
     * 初始化控件
     *
     * @param context
     */
    private void initView(Context context) {
        //
        animation = AnimationUtils.loadAnimation(context, R.anim.scale_native);
        animation.setRepeatCount(0);
        animation.setInterpolator(context, android.R.anim.accelerate_interpolator);
        animation.setDuration(200);
        //设置控件背景
        setBackgroundResource(R.mipmap.bg_navigation);
        //构造导航条按钮
        book_tv = new TextView(context);
        magzine_tv = new TextView(context);
        paper_tv = new TextView(context);
        video_tv = new TextView(context);
//        search_tv = new TextView(context);
        mp3_tv = new TextView(context);
        rss_tv = new TextView(context);
        //设置按钮文字
        book_tv.setText("电子书");
        magzine_tv.setText("期刊");
        paper_tv.setText("报纸");
        video_tv.setText("视频");
//        search_tv.setText("搜索");
        mp3_tv.setText("音频");
        rss_tv.setText("订阅");
        //设置ID
        book_tv.setId(R.id.tv_book_id);
        magzine_tv.setId(R.id.tv_magzine_id);
        paper_tv.setId(R.id.tv_paper_id);
        video_tv.setId(R.id.tv_video_id);
//        search_tv.setId(R.id.tv_search_id);
        mp3_tv.setId(R.id.tv_mp3_id);
        rss_tv.setId(R.id.tv_rss_id);
        //设置特殊的TextView
        book_tv.setBackgroundResource(R.mipmap.bg_selected);
        Drawable icon_search = getResources().getDrawable(R.drawable.icon_search);
        icon_search.setBounds(0, 0, icon_search.getMinimumWidth(), icon_search.getMinimumHeight());
//        search_tv.setCompoundDrawables(icon_search, null, null, null);
//        search_tv.setCompoundDrawablePadding(0);
//        search_tv.setPadding(35,0,0,0);
        //
        setTextview(book_tv, magzine_tv, paper_tv, video_tv, mp3_tv, rss_tv);
        //设置基本信息
        int width = 1080;
        int height = 100;
        int height_view = (int) (height / 1.4);
        int width_view = (int) (width / 7);
//        int book_marginLeft = width / 5;
        int MP3Btn_marginright = width_view / 8;
        int width_overly = (int) (height_view / 2.6);

        //设置订阅按钮位置
        LayoutParams rssPara = (LayoutParams) rss_tv.getLayoutParams();
        rssPara.height = height_view;
        rssPara.width = width_view;
        rssPara.topMargin = height / 12;
        rssPara.rightMargin = MP3Btn_marginright;
        rssPara.addRule(RelativeLayout.ALIGN_PARENT_END);

        //设置MP3按钮位置
        LayoutParams mp3Para = (LayoutParams) mp3_tv.getLayoutParams();
        mp3Para.height = height_view;
        mp3Para.width = width_view;
//        mp3Para.topMargin = height / 12;
//        mp3Para.rightMargin = MP3Btn_marginright;
        mp3Para.addRule(RelativeLayout.ALIGN_PARENT_END);
        mp3Para.addRule(RelativeLayout.ALIGN_TOP, R.id.tv_rss_id);
        mp3Para.rightMargin = MP3Btn_marginright + (width_view - width_overly);
        mp3_tv.setLayoutParams(mp3Para);

        //设置视频按钮位置
        LayoutParams videoPara = (LayoutParams) video_tv.getLayoutParams();
        videoPara.height = height_view;
        videoPara.width = width_view;
        videoPara.addRule(RelativeLayout.ALIGN_TOP, R.id.tv_rss_id);
        videoPara.addRule(RelativeLayout.ALIGN_PARENT_END);
        videoPara.rightMargin = MP3Btn_marginright + (width_view - width_overly) * 2;
        video_tv.setLayoutParams(videoPara);

        //设置报纸按钮位置
        LayoutParams paperPara = (LayoutParams) paper_tv.getLayoutParams();
        paperPara.height = height_view;
        paperPara.width = width_view;
        paperPara.addRule(RelativeLayout.ALIGN_TOP, R.id.tv_rss_id);
        paperPara.rightMargin = MP3Btn_marginright + (width_view - width_overly) * 3;
        paperPara.addRule(RelativeLayout.ALIGN_PARENT_END);
        paper_tv.setLayoutParams(paperPara);

        //设置期刊按钮位置
        LayoutParams magzinePara = (LayoutParams) magzine_tv.getLayoutParams();
        magzinePara.height = height_view;
        magzinePara.width = width_view;
        magzinePara.addRule(RelativeLayout.ALIGN_TOP, R.id.tv_rss_id);
        magzinePara.rightMargin = MP3Btn_marginright + (width_view - width_overly) * 4;
        magzinePara.addRule(RelativeLayout.ALIGN_PARENT_END);
        magzine_tv.setLayoutParams(magzinePara);

        //设置电子书按钮位置
        LayoutParams bookPara = (LayoutParams) book_tv.getLayoutParams();
        bookPara.height = height_view;
        bookPara.width = width_view;
        bookPara.addRule(RelativeLayout.ALIGN_TOP, R.id.tv_rss_id);
        bookPara.rightMargin = MP3Btn_marginright + (width_view - width_overly) * 5;
        bookPara.addRule(RelativeLayout.ALIGN_PARENT_END);
        book_tv.setLayoutParams(bookPara);

    }

    /**
     * 设置字体大小颜色位置
     *
     * @param tvs
     */
    private void setTextview(TextView... tvs) {
        Drawable icon_slant = getResources().getDrawable(R.drawable.icon_slant);
        icon_slant.setBounds(0, 0, icon_slant.getMinimumWidth(), icon_slant.getMinimumHeight());

        for (int i = 0; i < tvs.length; i++) {
            tvs[i].setTextSize(24);//设置字体大小
            tvs[i].setTextColor(normalColorColor);//设置字体颜色
            tvs[i].setGravity(Gravity.CENTER);//设置文字居中
            if (i != 5) {
                tvs[i].setCompoundDrawablesWithIntrinsicBounds(null, null, icon_slant, null);
                tvs[i].setPadding(20, 0, 0, 0);
            }
            addView(tvs[i]);
        }
    }

    public NativeControlerView(Context context) {
        this(context, null);
    }

    public NativeControlerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NativeControlerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundResource(R.mipmap.bg_navigation);
        //
        initView(context);

        //
        initListener();
    }

    /**
     * 设置点击事件
     *
     * @param listener
     */
    public void setOnNativeControlClickListener(OnNativeControlClickListener listener) {
        if (listener != null) {
            this.listener = listener;
        }
    }

    /**
     * 点击事件的回调接口
     */
    public interface OnNativeControlClickListener {

        void bookBtnClick();

        void magzineBtnClick();

        void paperBtnClick();

        void videoBtnClick();

        void mp3BtnClick();

        void rssBtnClick();

    }
}
