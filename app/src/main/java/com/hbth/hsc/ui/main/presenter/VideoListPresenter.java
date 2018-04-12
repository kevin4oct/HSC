package com.hbth.hsc.ui.main.presenter;

import com.hbth.hsc.bean.BookListBean;
import com.hbth.hsc.bean.VideoListBean;
import com.hbth.hsc.ui.main.contract.VideoListContract;
import com.hbth.mylibrary.rxevent.RxSubscriber;

/**
 * Created by Kevin on 2018/3/6.
 * 视频列表主导器
 */

public class VideoListPresenter extends VideoListContract.Presenter {

    @Override
    public void getVideoListRequest() {
        mView.showLoading("视频正在加载中..");
        // TODO: 2018/3/6 获取pid
        mRxManager.add(
                mModel.getVideoList(
                        "7", mView.getPage(), mView.getRows(), mView.getType(), mView.getClassId())

                        .subscribe(new RxSubscriber<VideoListBean>(mContext) {
                                       @Override
                                       protected void _onNext(VideoListBean bean) {
                                           mView.returnVideoList(bean);
                                           mView.stopLoading();
                                       }

                                       @Override
                                       protected void _onError(String message) {
                                           mView.showErrorTip(message);
                                           mView.stopLoading();
                                       }
                                   }
                        )
        );
    }

}
