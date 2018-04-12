package com.hbth.hsc.ui.eightpaper.model;

import com.hbth.hsc.bean.EightPaperReaderBean;
import com.hbth.hsc.eightpaper.DbAndroidTool;
import com.hbth.hsc.eightpaper.WebServiceClient;
import com.hbth.hsc.ui.eightpaper.contract.EightPaperReadContract;
import com.hbth.mylibrary.rxevent.RxSchedulers;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2018/3/5.
 * 8点报阅读实体类
 */

public class EightPaperReaderModel implements EightPaperReadContract.Model {
    @Override
    public Observable<EightPaperReaderBean> getEightPaperReaderBean(final String paperid, final String dbname, final String type) {

        return Observable.create(new Observable.OnSubscribe<EightPaperReaderBean>() {
            @Override
            public void call(Subscriber<? super EightPaperReaderBean> subscriber) {
                EightPaperReaderBean eightPaperReaderBean = DbAndroidTool.returnPaperContainer(
                        WebServiceClient.jaxWSMethod(
                                DbAndroidTool.returnReadSoapObject(paperid, dbname, type)));
                subscriber.onNext(eightPaperReaderBean);
                subscriber.onCompleted();

            }
        }).compose(RxSchedulers.<EightPaperReaderBean>io_main());

    }
}
