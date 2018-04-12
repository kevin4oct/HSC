package com.hbth.hsc.ui.book.presenter;

import com.hbth.hsc.bean.BookDetailBean;
import com.hbth.hsc.ui.book.contract.BookDetailContract;
import com.hbth.mylibrary.rxevent.RxSubscriber;

/**
 * Created by Kevin on 2018/2/10.
 * 图书详情的主导器
 */

public class BookDetailPresenter extends BookDetailContract.Presenter {
    @Override
    public void returnBookDetailRequest() {
        mView.showLoading("");
        mRxManager.add(
                mModel.getBookDetail(mView.getResourceId())
                        .subscribe(new RxSubscriber<BookDetailBean>(mContext) {
                            @Override
                            protected void _onNext(BookDetailBean bean) {
                                mView.returnBookDetail(bean);
                                mView.stopLoading();
                            }

                            @Override
                            protected void _onError(String message) {
                                mView.showErrorTip(message);
                                mView.stopLoading();
                            }
                        }));
    }
}
