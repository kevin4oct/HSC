package com.hbth.hsc.ui.main.model;

import com.hbth.hsc.api.Api;
import com.hbth.hsc.bean.BookListBean;
import com.hbth.hsc.ui.main.contract.BookListContract;
import com.hbth.mylibrary.rxevent.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2018/2/6.
 * 获取公司服务器电子书资源的列表数据
 */

public class BookListModel
        implements BookListContract.Model {

    @Override
    public Observable<BookListBean> getBookList(
            String pId, int page, int rows, String type, String classID) {

        return Api.getDefault().getBookList(pId, page, rows, type, classID)
                .compose(RxSchedulers.<BookListBean>io_main());
    }

}
