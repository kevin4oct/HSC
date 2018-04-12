package com.hbth.hsc.ui.main.contract;

import com.hbth.hsc.bean.EightPaperRootBean;
import com.hbth.mylibrary.base.BaseModel;
import com.hbth.mylibrary.base.BasePresenter;
import com.hbth.mylibrary.base.BaseView;

import rx.Observable;

/**
 * Created by Kevin on 2018/2/6.
 * 8点资源的协议
 */

public class EightPaperListContract {

    public interface Model extends BaseModel {

        Observable<EightPaperRootBean> getEightPaperList(
                String methor, String type, int num, int page, String classfy);
    }

    public interface View extends BaseView {

        void returnEightPaperList(EightPaperRootBean bean);
        int getPage();
        int getRows();
        String getType();
        String getClassfy();
    }

    public static abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getEightPaperListRequest(String methor);
    }

}
