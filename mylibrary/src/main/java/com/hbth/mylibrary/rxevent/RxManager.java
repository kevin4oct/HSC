package com.hbth.mylibrary.rxevent;


import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2018/2/5.
 * 用于管理单个presenter的RsBus事件和Rxjava相关代码的生命周期处理
 */

public class RxManager {
    public RxBus mRxBus = RxBus.getInstance();
    //管理 rxbus 订阅
    private Map<String, Observable<?>> mObservables = new HashMap<>();
    //管理 Observables 和 Subscribers 订阅
    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    /**
     * rxBus注入监听
     *
     * @param eventName
     * @param action1
     * @param <T>
     */
    public <T> void on(String eventName, Action1<T> action1) {
        Observable<T> mObservable = mRxBus.register(eventName);
        mObservables.put(eventName, mObservable);
        /*订阅管理*/
        mCompositeSubscription.add(
                mObservable
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(action1, new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                throwable.printStackTrace();
                            }
                        }));
    }

    /**
     * 单纯的Observables 和 Subscribers 管理
     *
     * @param m
     */
    public void add(Subscription m) {
        /*订阅管理*/
        mCompositeSubscription.add(m);
    }

    /**
     * 单个presenter生命周期结束，取消订阅所有rxbus观察
     */
    public void clear() {
        mCompositeSubscription.unsubscribe();//取消所有订阅
        for (Map.Entry<String, Observable<?>> entry :
                mObservables.entrySet()) {
            mRxBus.unRegister(entry.getKey(), entry.getValue());//移除rxbus观察
        }
    }

    /**
     * 发送rxbus
     *
     * @param tag
     * @param content
     */
    public void post(Object tag, Object content) {
        mRxBus.post(tag, content);
    }

}
