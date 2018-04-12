package com.hbth.hsc.ui.book.contract;

import com.hbth.hsc.bean.BookDetailBean;
import com.hbth.mylibrary.base.BaseModel;
import com.hbth.mylibrary.base.BasePresenter;
import com.hbth.mylibrary.base.BaseView;

import rx.Observable;

/**
 * Created by Kevin on 2018/2/10.
 * 电子书详情协议
 */

public class BookDetailContract {

    public interface Model extends BaseModel {

        Observable<BookDetailBean> getBookDetail(String resourceId);
    }

    public interface View extends BaseView {

        void returnBookDetail(BookDetailBean bean);

        String getResourceId();
    }

    public static abstract class Presenter extends BasePresenter<Model, View> {

        public abstract void returnBookDetailRequest();
    }

}
