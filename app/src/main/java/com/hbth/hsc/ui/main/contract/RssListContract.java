package com.hbth.hsc.ui.main.contract;

import com.hbth.hsc.bean.RssListBean;
import com.hbth.mylibrary.base.BaseModel;
import com.hbth.mylibrary.base.BasePresenter;
import com.hbth.mylibrary.base.BaseView;

import rx.Observable;


/**
 * Created by Administrator on 2018/3/5.
 * 公司服务器Rss资源的协议
 */

public class RssListContract {

    public interface Model extends BaseModel {
        Observable<RssListBean> getRssList(String pId);
    }

    public interface View extends BaseView {
        void returnRssList(RssListBean bean);

        int getPage();

        int getRows();
    }

    public static abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getRssListRequest();
    }
}
