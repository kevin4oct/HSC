package com.hbth.hsc.ui.main.model;

import com.hbth.hsc.api.Api;
import com.hbth.hsc.bean.RssListBean;
import com.hbth.hsc.ui.main.contract.RssListContract;
import com.hbth.mylibrary.rxevent.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2018/3/5.
 * 获取公司服务器Rss订阅的列表数据
 */

public class RssListModel
        implements RssListContract.Model {

    @Override
    public Observable<RssListBean> getRssList(String pId) {
        return Api.getDefault().getRssListBean(pId)
                .compose(RxSchedulers.<RssListBean>io_main());
    }

}
