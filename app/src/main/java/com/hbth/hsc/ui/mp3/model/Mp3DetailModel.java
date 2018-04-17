package com.hbth.hsc.ui.mp3.model;

import com.hbth.hsc.api.Api;
import com.hbth.hsc.bean.Mp3DetailBean;
import com.hbth.hsc.bean.VideoDetailBean;
import com.hbth.hsc.ui.mp3.constract.Mp3DetailContract;
import com.hbth.hsc.ui.video.contract.VideoDetailContract;
import com.hbth.mylibrary.rxevent.RxSchedulers;

import rx.Observable;

/**
 * Created by Kevin on 2018/3/6.
 * 获取视频详情
 */

public class Mp3DetailModel
        implements Mp3DetailContract.Model{

    @Override
    public Observable<Mp3DetailBean> getMp3Detail(
            String machineCode,String pId,String resourceId,int rows) {

        return Api.getDefault().getMp3Detail(machineCode,pId,resourceId,rows)
                .compose(RxSchedulers.<Mp3DetailBean>io_main());
    }
}
