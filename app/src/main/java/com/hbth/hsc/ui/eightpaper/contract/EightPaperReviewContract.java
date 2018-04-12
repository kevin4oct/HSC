package com.hbth.hsc.ui.eightpaper.contract;

import com.hbth.hsc.bean.EightPaperReaderBean;
import com.hbth.hsc.bean.EightPaperRootBean;
import com.hbth.mylibrary.base.BaseModel;
import com.hbth.mylibrary.base.BasePresenter;
import com.hbth.mylibrary.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2018/3/5.
 */

public class EightPaperReviewContract {

    public interface Model extends BaseModel {
        Observable<EightPaperRootBean> getEightPaperRootBean(String dataname, String year, String type);
    }

    public interface View extends BaseView {

        void returnEightPaperRootBean(EightPaperRootBean bean);

        String getDataname();

        String getYear();

        String getType();
    }

    public static abstract class Presenter
            extends BasePresenter<EightPaperReviewContract.Model,EightPaperReviewContract.View> {
        public  abstract void returnEightRootBeanRequest();
    }
}
