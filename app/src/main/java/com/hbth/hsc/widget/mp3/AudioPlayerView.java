package com.hbth.hsc.widget.mp3;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hbth.hsc.R;
import com.hbth.hsc.bean.Mp3DetailBean;
import com.hbth.hsc.widget.verticalseekbar.VerticalSeekBar;
import com.hbth.mylibrary.utils.LogUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by Kevin on 2018/4/12.
 * mp3播放界面
 * 1、播放动画
 * 2、显示播放内容的相关信息：歌曲名称，演唱者，歌曲摘要
 * 3、显示播放列表
 * 4、控制区：播放/停止，上一曲、下一曲、播放顺序、收藏
 * 5、暂时没有后台播放功能
 */

public class AudioPlayerView extends FrameLayout
        implements Handler.Callback, MediaPlayer.OnCompletionListener,
        MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener,
        MediaPlayer.OnSeekCompleteListener, View.OnClickListener {

    private SimpleDraweeView ivCover;//封面
    //    private TextView tvProgress;//播放进度文字提示
    private TextView tvLong;//音频时长文字提示
    //    private SeekBar seekBar;//播放进度条
    private ImageView playBtn;//播放按钮
    private ImageView lastBtn;//上一曲
    private ImageView nextBtn;//下一曲
    private VerticalSeekBar volumeSeekbar;//音量进度条
    private ImageView closeBtn;//返回按钮

    private View rootView;//布局
    private MediaPlayer mPlayer;//播放器
    private Context context;//上下文对象

    private Handler mHandler = new Handler(this);
    private static final int PROGRESSUPDATA = 0x700;//更新播放进度

    private AudioInfoInterface audioInfoInterface;//返回播放信息的接口
    private CloseInterface closeInterface;//关闭按钮点击回调接口

    private Mp3DetailBean bean;//播放的对象列表

    private int index;//当前播放索引
    private int soundSize;//音量大小
    private int playPosition;//播放进度
    private int mp3Size;//音频总的长度

    public AudioPlayerView(Context context) {
        this(context, null);
    }

    public AudioPlayerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AudioPlayerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        rootView = LayoutInflater.from(context)
                .inflate(R.layout.view_audio_player, null);
        addView(rootView);
        initView();
        initListener();
    }

    /**
     * 初始化监听
     */
    private void initListener() {
        closeBtn.setOnClickListener(this);
//        ivOrderMp3.setOnClickListener(this);
//        ivLastMp3.setOnClickListener(this);
//        ivNextMp3.setOnClickListener(this);
//        ivPlayMp3.setOnClickListener(this);
//        ivListMp3.setOnClickListener(this);
//        adapter.setOnItemClickListener(this);
//        seekbarMp3.setOnSeekBarChangeListener(this);

    }

    /**
     * 初始化控件
     */
    private void initView() {
        ivCover = ((SimpleDraweeView) rootView.findViewById(R.id.iv_cover_audio));
        tvLong = (TextView) rootView.findViewById(R.id.tv_long_mp3);
        playBtn = (ImageView) rootView.findViewById(R.id.iv_play_mp3);
        lastBtn = (ImageView) rootView.findViewById(R.id.iv_last_mp3);
        nextBtn = (ImageView) rootView.findViewById(R.id.iv_next_mp3);
        volumeSeekbar = (VerticalSeekBar) rootView.findViewById(R.id.seekbar_volume_mp3);
        closeBtn = (ImageView) rootView.findViewById(R.id.btn_close_mp3);
    }

    /**
     * 设置播放列表
     *
     * @param bean
     */
    public void setPlayData(Mp3DetailBean bean) {
        if (bean != null) {
            this.bean = bean;
        }
    }

    /**
     * 开始or暂停
     */
    public void startPlay(int index) {
        if (mPlayer != null && mPlayer.isPlaying()) {
            pausePlay();
        } else {
            this.index = index;
            startPlayMp3(index);
        }
    }

    /**
     * 设置并开始唱片动画
     */
    public void startAnimation() {
        // 设置唱片动画
        playBtn.setImageResource(R.mipmap.btn_pause_metal);
        Animation phonorecordStartAnimator = AnimationUtils.loadAnimation(context,
                R.anim.anim_phonorecord_start);
        ivCover.startAnimation(phonorecordStartAnimator);
    }

    /**
     * 停止唱片动画
     */
    public void stopAnimation() {
        playBtn.setImageResource(R.mipmap.btn_play_metal);
        ivCover.clearAnimation();
    }

    /**
     * 开始播放音频
     */
    public void startPlayMp3(int index) {

        List<Mp3DetailBean.UrlBean> urls = bean.getUrl();

        if (urls != null && urls.size() - 1 >= index) {

            LogUtils.loge("开始播放");

            ivCover.setImageURI(Uri.parse(bean.getMp3().getMp3Pic()));
            Mp3DetailBean.UrlBean urlBean = urls.get(index);
            //返回播放信息
            if (audioInfoInterface != null) {
                audioInfoInterface.returnUrlBean(urlBean);
            }
            if (mPlayer == null) {
                try {
                    mPlayer = new MediaPlayer();
                    mPlayer.setDataSource(urlBean.getUrl());//设置播放的数据源。
                    mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//            mediaPlayer.prepare();//同步的准备方法。
                    mPlayer.prepareAsync();//异步的准备
                    startAnimation();
                    mPlayer.setOnCompletionListener(this);
                    mPlayer.setOnPreparedListener(this);
                    mPlayer.setOnErrorListener(this);
                    mPlayer.setOnSeekCompleteListener(this);
                    //
                    startAnimation();

                } catch (IOException e) {
                    LogUtils.loge(e.getMessage());
                }
            } else {
                rePlay();
            }
        } else {
            // TODO: 2018/4/16 未获取到播放列表
            new AlertDialog.Builder(context)
                    .setTitle("不好啦！")
                    .setMessage("未获取到播放信息...")
                    .show();
        }
    }

    /**
     * 再次播放
     */
    public void rePlay() {
        if (mPlayer != null)
            startAnimation();
        mPlayer.start();
//        mHandler.sendEmptyMessage(PLAY_PROGRESS);
    }

    /**
     * 暂停播放
     */
    public void pausePlay() {
        if (mPlayer != null)
            stopAnimation();
        mPlayer.pause();
//        mHandler.removeMessages(PLAY_PROGRESS);
    }

    /**
     * 停止播放
     */
    public void stopPlay() {
        //当对象不为空时
        if (mPlayer != null) {
            stopAnimation();
            mPlayer.stop();//停止播放
            mPlayer.release();//释放资源
            mPlayer = null;//把player对象设置为null
        }
    }

    /**
     * 滑动到指定播放位置
     */
    public void seekToPosition(int position) {
        LogUtils.loge("滑动到指定位置：" + position);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        LogUtils.loge("onCompletion方法被调用了");
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        LogUtils.loge("onPrepared方法被调用了");
        mPlayer.start();
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        LogUtils.loge("播放错误！");
        return false;
    }

    @Override
    public void onSeekComplete(MediaPlayer mp) {
        LogUtils.loge("onSeekComplete方法被调用了");
    }

    /**
     * 调整声音大小
     */
    public void soundControler() {
        // TODO: 2018/4/13 设置音量大小
    }

    /**
     * Handler 接收到请求
     *
     * @param msg
     * @return
     */
    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case PROGRESSUPDATA:

                break;
        }
        return false;
    }

    /**
     * 设置播放信息的回调接口
     *
     * @param audioInfoInterface
     */
    public void setOnAudioInfoInterface(@NonNull AudioInfoInterface audioInfoInterface) {
        this.audioInfoInterface = audioInfoInterface;
    }

    /**
     * 设置关闭按钮回调接口
     * @param closeInterface
     */
    public void setOnCloseInterface(@NonNull CloseInterface closeInterface) {
        this.closeInterface = closeInterface;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_close_mp3://关闭按钮
                closeInterface.returnBtnClicked();
                break;
        }
    }
}
