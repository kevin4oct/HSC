package com.hbth.hsc.ui.main.model;

import com.hbth.hsc.bean.EightPaperRootBean;
import com.hbth.hsc.eightpaper.DbAndroidTool;
import com.hbth.hsc.eightpaper.WebServiceClient;
import com.hbth.hsc.ui.main.contract.EightPaperListContract;
import com.hbth.mylibrary.rxevent.RxSchedulers;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Kevin on 2018/2/7.
 * 获取8点资源列表
 */

public class EightPaperListModel
        implements EightPaperListContract.Model {

    @Override
    public Observable<EightPaperRootBean> getEightPaperList(
            final String methor, final String type, final int num, final int page, final String classfy) {

        return Observable.create(new Observable.OnSubscribe<EightPaperRootBean>() {
            @Override
            public void call(Subscriber<? super EightPaperRootBean> subscriber) {
                EightPaperRootBean interIndexEightPaperRootBean = DbAndroidTool.getInterIndexEightPaperRootBean(
                        WebServiceClient.jaxWSMethod(
                                DbAndroidTool.returnEnterindexSoapObject(
                                        methor, type, num, page, classfy)));
                subscriber.onNext(interIndexEightPaperRootBean);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<EightPaperRootBean>io_main());
    }

}
