package com.hbth.hsc.ui.main.model;

import com.hbth.hsc.api.Api;
import com.hbth.hsc.api.ApiService;
import com.hbth.hsc.bean.Mp3ListBean;
import com.hbth.hsc.bean.VideoListBean;
import com.hbth.hsc.ui.main.contract.Mp3ListContract;
import com.hbth.hsc.ui.main.contract.VideoListContract;
import com.hbth.mylibrary.rxevent.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2018/3/6.
 * 获取视频列表数据
 */

public class Mp3ListModel
        implements Mp3ListContract.Model {

    @Override
    public Observable<Mp3ListBean> getMp3List(
            String pId, int page, int rows, String type, String classId) {

        ApiService aDefault = Api.getDefault();

        Observable<Mp3ListBean> mp3List = aDefault.getMp3List(pId, page, rows, type, classId);

        return mp3List
                .compose(RxSchedulers.<Mp3ListBean>io_main());
    }

}
