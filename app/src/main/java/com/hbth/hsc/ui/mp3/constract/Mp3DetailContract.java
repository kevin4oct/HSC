package com.hbth.hsc.ui.mp3.constract;

import com.hbth.hsc.bean.Mp3DetailBean;
import com.hbth.hsc.bean.VideoDetailBean;
import com.hbth.mylibrary.base.BaseModel;
import com.hbth.mylibrary.base.BasePresenter;
import com.hbth.mylibrary.base.BaseView;

import rx.Observable;

/**
 * Created by Kevin on 2018/3/6.
 * 视频详情协议
 */

public class Mp3DetailContract {

    public interface Model extends BaseModel{

        Observable<Mp3DetailBean> getMp3Detail(
                String machineCode, String pId, String resourceId, int rows);
    }

    public interface View extends BaseView{

        void returnMp3Detail(Mp3DetailBean bean);

        String getResourceId();

        int getRows();
    }

    public static abstract class Presenter extends BasePresenter<Model,View>{

        public abstract void getMp3DetailRequest();
    }
}
