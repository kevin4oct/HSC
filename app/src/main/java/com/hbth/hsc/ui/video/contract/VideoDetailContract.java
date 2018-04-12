package com.hbth.hsc.ui.video.contract;

import com.hbth.hsc.bean.VideoDetailBean;
import com.hbth.mylibrary.base.BaseModel;
import com.hbth.mylibrary.base.BasePresenter;
import com.hbth.mylibrary.base.BaseView;

import rx.Observable;

/**
 * Created by Kevin on 2018/3/6.
 * 视频详情协议
 */

public class VideoDetailContract {

    public interface Model extends BaseModel{

        Observable<VideoDetailBean> getVideoDetail(
                String machineCode,String pId,String resourceId,int rows);
    }

    public interface View extends BaseView{

        void returnVideoDetail(VideoDetailBean bean);

        String getResourceId();

        int getRows();
    }

    public static abstract class Presenter extends BasePresenter<Model,View>{

        public abstract void getVideoDetailRequest();
    }
}
