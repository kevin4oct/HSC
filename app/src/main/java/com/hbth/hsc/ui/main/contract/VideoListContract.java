package com.hbth.hsc.ui.main.contract;

import com.hbth.hsc.bean.VideoListBean;
import com.hbth.mylibrary.base.BaseModel;
import com.hbth.mylibrary.base.BasePresenter;
import com.hbth.mylibrary.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2018/3/6.
 * 获取视频的协议
 */

public class VideoListContract {

    public interface Model extends BaseModel {
        Observable<VideoListBean> getVideoList(
                String pId, int page, int rows, String type, String classId);
    }

    public interface View extends BaseView {

        void returnVideoList(VideoListBean bean);

        int getPage();

        int getRows();

        String getType();

        String getClassId();
    }

    public static abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getVideoListRequest();
    }
}
