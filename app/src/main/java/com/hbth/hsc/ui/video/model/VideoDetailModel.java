package com.hbth.hsc.ui.video.model;

import com.hbth.hsc.api.Api;
import com.hbth.hsc.bean.VideoDetailBean;
import com.hbth.hsc.ui.video.contract.VideoDetailContract;
import com.hbth.mylibrary.rxevent.RxSchedulers;

import rx.Observable;

/**
 * Created by Kevin on 2018/3/6.
 * 获取视频详情
 */

public class VideoDetailModel
        implements VideoDetailContract.Model{

    @Override
    public Observable<VideoDetailBean> getVideoDetail(
            String machineCode,String pId,String resourceId,int rows) {

        return Api.getDefault().getVideoDetail(machineCode,pId,resourceId,rows)
                .compose(RxSchedulers.<VideoDetailBean>io_main());
    }
}
