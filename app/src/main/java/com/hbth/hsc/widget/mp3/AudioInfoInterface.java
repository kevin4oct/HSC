package com.hbth.hsc.widget.mp3;

import com.hbth.hsc.bean.Mp3DetailBean;

/**
 * Created by Kevin on 2018/4/16.
 * 音频播放器的回调接口，用于返回播放信息
 */

public interface AudioInfoInterface {

    void returnUrlBean(Mp3DetailBean.UrlBean urlBean);
}
