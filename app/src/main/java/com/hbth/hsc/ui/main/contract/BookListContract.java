package com.hbth.hsc.ui.main.contract;

import com.hbth.hsc.bean.BookListBean;
import com.hbth.mylibrary.base.BaseModel;
import com.hbth.mylibrary.base.BasePresenter;
import com.hbth.mylibrary.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2018/2/6.
 * 获取电子书的协议
 */

public class BookListContract {

    public interface Model extends BaseModel {
        Observable<BookListBean> getBookList(
                String pId, int page, int rows, String type, String classID);
    }

    public interface View extends BaseView {

        void returnBookList(BookListBean bookListBean);

        int getPage();

        int getRows();

        String getType();

        String getClassId();
    }

    public static abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getBookListRequest();
    }
}
