package com.hbth.hsc.ui.video.presenter;

import com.hbth.hsc.bean.VideoDetailBean;
import com.hbth.hsc.ui.video.contract.VideoDetailContract;
import com.hbth.mylibrary.rxevent.RxSubscriber;

/**
 * Created by Kevin on 2018/3/6.
 * 视频详情的主导器
 */

public class VideoDetailPresenter
        extends VideoDetailContract.Presenter {
    @Override
    public void getVideoDetailRequest() {
        mRxManager.add(
                mModel.getVideoDetail(
                        "DK0QNVWJ", "7", mView.getResourceId(), mView.getRows())
                        .subscribe(new RxSubscriber<VideoDetailBean>(mContext) {
                                       @Override
                                       protected void _onNext(VideoDetailBean bean) {
                                           mView.returnVideoDetail(bean);
                                       }

                                       @Override
                                       protected void _onError(String message) {
                                           mView.showErrorTip(message);
                                       }
                                   }
                        )
        );
    }
}
