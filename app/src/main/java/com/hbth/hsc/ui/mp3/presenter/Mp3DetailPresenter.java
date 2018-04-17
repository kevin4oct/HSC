package com.hbth.hsc.ui.mp3.presenter;

import com.hbth.hsc.bean.Mp3DetailBean;
import com.hbth.hsc.ui.mp3.constract.Mp3DetailContract;
import com.hbth.mylibrary.rxevent.RxSubscriber;

/**
 * Created by Kevin on 2018/3/6.
 * 视频详情的主导器
 */

public class Mp3DetailPresenter
        extends Mp3DetailContract.Presenter {
    @Override
    public void getMp3DetailRequest() {
        mRxManager.add(
                // TODO: 2018/4/12 获取machineCode的方式 ，PID的方式
                mModel.getMp3Detail(
                        "ISQB4056", "7", mView.getResourceId(), mView.getRows())
                        .subscribe(new RxSubscriber<Mp3DetailBean>(mContext) {
                                       @Override
                                       protected void _onNext(Mp3DetailBean bean) {
                                           mView.returnMp3Detail(bean);
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
