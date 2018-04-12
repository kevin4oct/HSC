package com.hbth.hsc.ui.main.model;

import com.hbth.hsc.api.Api;
import com.hbth.hsc.api.ApiService;
import com.hbth.hsc.bean.VideoListBean;
import com.hbth.hsc.ui.main.contract.VideoListContract;
import com.hbth.mylibrary.rxevent.RxSchedulers;
import com.hbth.mylibrary.utils.LogUtils;

import rx.Observable;

/**
 * Created by Administrator on 2018/3/6.
 * 获取视频列表数据
 */

public class VideoListModel
        implements VideoListContract.Model {

    @Override
    public Observable<VideoListBean> getVideoList(
            String pId, int page, int rows, String type, String classId) {

        ApiService aDefault = Api.getDefault();

        Observable<VideoListBean> videoList = aDefault.getVideoList(pId, page, rows, type, classId);

        return videoList
                .compose(RxSchedulers.<VideoListBean>io_main());
    }

}
