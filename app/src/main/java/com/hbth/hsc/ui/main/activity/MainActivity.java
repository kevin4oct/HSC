package com.hbth.hsc.ui.main.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextClock;

import com.hbth.hsc.R;
import com.hbth.hsc.ui.main.fragment.BookListFragment;
import com.hbth.hsc.ui.main.fragment.Mp3ListFragment;
import com.hbth.hsc.ui.main.fragment.RssListFragment;
import com.hbth.hsc.ui.main.fragment.VideoListFragment;
import com.hbth.hsc.ui.main.fragment.MgzListFragment;
import com.hbth.hsc.ui.main.fragment.PaperListFragment;
import com.hbth.hsc.widget.NativeControlerView;
import com.hbth.mylibrary.base.BaseActivity;
import com.hbth.mylibrary.utils.LogUtils;
import com.hbth.mylibrary.utils.ToastUtil;

import butterknife.BindView;

public class MainActivity extends BaseActivity
        implements NativeControlerView.OnNativeControlClickListener {

    @BindView(R.id.iv_logo01_main)
    ImageView ivLogo01Main;
    @BindView(R.id.tv_clock_main)
    TextClock tvClockMain;
    @BindView(R.id.container_main)
    FrameLayout containerMain;
    @BindView(R.id.iv_leaf_right_main)
    ImageView ivLeafRightMain;
    @BindView(R.id.iv_leaf_left_main)
    ImageView ivLeafLeftMain;
    private Fragment mShowFragment;

    public static Intent getTheIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
//        // TODO: 2018/2/9  严苛模式，debug模式下使用，release模式下不要使用
//        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                .detectDiskReads().detectDiskWrites().detectNetwork()
//                .penaltyLog().build());

        switchPage(BookListFragment.TAG);
    }

    @Override
    protected void initListener() {
        ((NativeControlerView) findViewById(R.id.navigation_main))
                .setOnNativeControlClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //开始播放动画
        startLeafAnimation();
    }

    /**
     * 切换fragment
     *
     * @param fragmentTag
     */
    private void switchPage(String fragmentTag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
//        if (mShowFragment != null) {
//            transaction.hide(mShowFragment);
//        }
//        mShowFragment = fm.findFragmentByTag(fragmentTag);
//        if (mShowFragment != null) {
//            transaction.show(mShowFragment);
//        } else {
        try {
            mShowFragment = (Fragment) Class.forName(fragmentTag).newInstance();
//                transaction.add(R.id.container_main, mShowFragment, fragmentTag);
            transaction.replace(R.id.container_main, mShowFragment, fragmentTag);

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            LogUtils.loge(e.getMessage());
        }
//        }
        transaction.commit();
    }

    /**
     * 禁止退出
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            ToastUtil.showShort("程序运行中禁止退出");
        }
        return true;
    }

    @Override
    public void bookBtnClick() {
        switchPage(BookListFragment.TAG);
    }

    @Override
    public void magzineBtnClick() {
        switchPage(MgzListFragment.TAG);
    }

    @Override
    public void paperBtnClick() {
        switchPage(PaperListFragment.TAG);
    }

    @Override
    public void videoBtnClick() {
        switchPage(VideoListFragment.TAG);
    }

    @Override
    public void mp3BtnClick() {
        switchPage(Mp3ListFragment.TAG);
    }

    @Override
    public void rssBtnClick() {
        switchPage(RssListFragment.TAG);
    }

    /**
     * 设置树叶的动画
     */
    private void startLeafAnimation() {
        //设置左侧树叶动画
        RotateAnimation animation_left = new RotateAnimation(8, -8,
                Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.8F);
        animation_left.setInterpolator(new OvershootInterpolator());
        animation_left.setDuration(3000);
        animation_left.setRepeatCount(-1);
        animation_left.setRepeatMode(Animation.REVERSE);
        ivLeafLeftMain.setAnimation(animation_left);
        //设置右侧树叶动画
        RotateAnimation animation_right = new RotateAnimation(-10, 2);
        animation_right.setInterpolator(new OvershootInterpolator());
        animation_right.setDuration(3200);
        animation_right.setRepeatCount(-1);
        animation_right.setRepeatMode(Animation.REVERSE);
        ivLeafRightMain.setAnimation(animation_right);
    }
}
