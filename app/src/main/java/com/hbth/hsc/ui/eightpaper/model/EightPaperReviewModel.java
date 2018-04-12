package com.hbth.hsc.ui.eightpaper.model;

import com.hbth.hsc.bean.EightPaperRootBean;
import com.hbth.hsc.eightpaper.DbAndroidTool;
import com.hbth.hsc.eightpaper.WebServiceClient;
import com.hbth.hsc.ui.eightpaper.contract.EightPaperReviewContract;
import com.hbth.mylibrary.rxevent.RxSchedulers;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Kevin on 2018/3/5.
 * 获取8点报资源往期回顾列表数据
 */

public class EightPaperReviewModel implements EightPaperReviewContract.Model {

    @Override
    public Observable<EightPaperRootBean> getEightPaperRootBean(final String dataname, final String year, final String type) {

        return Observable.create(new Observable.OnSubscribe<EightPaperRootBean>() {
            @Override
            public void call(Subscriber<? super EightPaperRootBean> subscriber) {
                EightPaperRootBean reviewEightPaperRootBean = DbAndroidTool.getReviewEightPaperRootBean(
                        WebServiceClient.jaxWSMethod(
                                DbAndroidTool.returnReXmlSoap(dataname, year, type)));
                subscriber.onNext(reviewEightPaperRootBean);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<EightPaperRootBean>io_main());

    }
}
