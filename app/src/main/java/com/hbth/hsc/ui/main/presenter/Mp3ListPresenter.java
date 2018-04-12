package com.hbth.hsc.ui.main.presenter;

import com.hbth.hsc.bean.Mp3ListBean;
import com.hbth.hsc.bean.VideoListBean;
import com.hbth.hsc.ui.main.contract.Mp3ListContract;
import com.hbth.hsc.ui.main.contract.VideoListContract;
import com.hbth.mylibrary.rxevent.RxSubscriber;

/**
 * Created by Kevin on 2018/3/6.
 * 视频列表主导器
 */

public class Mp3ListPresenter extends Mp3ListContract.Presenter {

    @Override
    public void getMp3ListRequest() {
        mView.showLoading("视频正在加载中..");
        // TODO: 2018/3/6 获取pid
        mRxManager.add(
                mModel.getMp3List(
                        "7", mView.getPage(), mView.getRows(), mView.getType(), mView.getClassId())

                        .subscribe(new RxSubscriber<Mp3ListBean>(mContext) {
                                       @Override
                                       protected void _onNext(Mp3ListBean bean) {
                                           mView.returnMp3List(bean);
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
