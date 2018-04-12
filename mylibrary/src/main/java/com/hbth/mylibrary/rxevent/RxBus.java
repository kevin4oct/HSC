package com.hbth.mylibrary.rxevent;

import android.support.annotation.NonNull;

import com.hbth.mylibrary.utils.LogUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * Created by Administrator on 2018/2/5.
 */

public class RxBus {

    private static RxBus sRxBus;

    public static RxBus getInstance() {
        if (sRxBus == null) {
            synchronized (RxBus.class) {
                sRxBus = new RxBus();
            }
        }
        return sRxBus;
    }

    private ConcurrentHashMap<Object, List<Subject>> subjectMapper = new ConcurrentHashMap<>();

    /**
     * 注册事件源
     */
    public <T> Observable<T> register(@NonNull Object tag) {
        List<Subject> subjects = subjectMapper.get(tag);
        if (subjects == null) {
            subjects = new ArrayList<>();
            subjectMapper.put(tag, subjects);
        }
        Subject<T, T> subject = PublishSubject.create();
        subjects.add(subject);
        LogUtils.logd("register：" + tag + "，size:" + subjects.size());
        return subject;
    }

    public void unRegister(@NonNull Object tag) {
        List<Subject> subjects = subjectMapper.get(tag);
        if (subjects != null) {
            subjectMapper.remove(tag);
        }
    }

    /**
     * 取消监听
     */
    @SuppressWarnings("rawtypes")
    public RxBus unRegister(@NonNull Object tag,
                            @NonNull Observable<?> observable) {
        if (observable == null) {
            return getInstance();
        }

        List<Subject> subjects = subjectMapper.get(tag);

        if (subjects != null) {
            subjects.remove((Subject<?, ?>) observable);
            if (isEmpty((subjects))) {
                subjectMapper.remove(tag);
            }
        }
        return getInstance();
    }

    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Collection<Subject> collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * 触发事件
     *
     * @param tag
     * @param content
     */
    public void post(@NonNull Object tag, @NonNull Object content) {
        LogUtils.logd("post:" + "eventName:" + tag);
        List<Subject> subjectList = subjectMapper.get(tag);
        if (!isEmpty(subjectList)) {
            for (Subject subject :
                    subjectList) {
                subject.onNext(content);
                LogUtils.logd("onEvent:" + "eventName:" + tag);
            }
        }
    }
}