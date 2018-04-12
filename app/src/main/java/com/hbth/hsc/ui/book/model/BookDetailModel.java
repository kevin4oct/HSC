package com.hbth.hsc.ui.book.model;

import com.hbth.hsc.api.Api;
import com.hbth.hsc.bean.BookDetailBean;
import com.hbth.hsc.ui.book.contract.BookDetailContract;
import com.hbth.mylibrary.rxevent.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2018/2/10.
 */

public class BookDetailModel implements BookDetailContract.Model {

    @Override
    public Observable<BookDetailBean> getBookDetail(String resourceId) {
        return Api.getDefault()
                .getBookDetail("6",resourceId)
                .compose(RxSchedulers.<BookDetailBean>io_main());
    }
}
