package com.hbth.hsc.ui.eightpaper.contract;

import com.hbth.hsc.bean.EightPaperReaderBean;
import com.hbth.mylibrary.base.BaseModel;
import com.hbth.mylibrary.base.BasePresenter;
import com.hbth.mylibrary.base.BaseView;

import rx.Observable;

/**
 * Created by Kevin on 2018/3/5.
 * 8点报阅读接口协议
 */

public class EightPaperReadContract {

    public interface Model extends BaseModel {
        Observable<EightPaperReaderBean> getEightPaperReaderBean(
                String paperid, String dbname, String type);
    }

    public interface View extends BaseView {

        void returnEightPaperReaderBean(EightPaperReaderBean bean);

        String getPaperid();

        String getDbname();

        String getType();
    }

    public static abstract class Presenter
            extends BasePresenter<Model,View> {
        public  abstract void returnEightReaderBeanRequest();
    }
}
