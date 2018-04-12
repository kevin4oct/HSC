package com.hbth.hsc.ui.main.presenter;

import com.hbth.hsc.bean.BookListBean;
import com.hbth.hsc.ui.main.contract.BookListContract;
import com.hbth.mylibrary.rxevent.RxSubscriber;

/**
 * Created by Kevin on 2018/2/6.
 * 电子书列表的主导器
 */

public class BookListPresenter extends BookListContract.Presenter {
    @Override
    public void getBookListRequest() {
        mView.showLoading("电子书正在加载中..");
        // TODO: 2018/3/1 获取Pid
        mRxManager.add(
                mModel.getBookList(
                        "6", mView.getPage(), mView.getRows(), mView.getType(), mView.getClassId())

                        .subscribe(new RxSubscriber<BookListBean>(mContext) {
                                       @Override
                                       protected void _onNext(BookListBean bookListBean) {
                                           mView.stopLoading();
                                           mView.returnBookList(bookListBean);
                                       }

                                       @Override
                                       protected void _onError(String message) {
                                           mView.stopLoading();
                                           mView.showErrorTip(message);
                                       }

                                   }
                        )
        );
    }


}
