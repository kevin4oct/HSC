package com.hbth.hsc.ui.main.presenter;

import com.hbth.hsc.bean.RssListBean;
import com.hbth.hsc.ui.main.contract.RssListContract;
import com.hbth.mylibrary.rxevent.RxSubscriber;

/**
 * Created by Administrator on 2018/3/5.
 */

public class RssListPresenter extends RssListContract.Presenter {

    @Override
    public void getRssListRequest() {
        // TODO: 2018/3/6 获取pid
        mRxManager.add(
                mModel.getRssList("6")
                        .subscribe(new RxSubscriber<RssListBean>(mContext) {
                            @Override
                            protected void _onNext(RssListBean bean) {
                                mView.returnRssList(bean);
                            }

                            @Override
                            protected void _onError(String message) {
                                mView.showErrorTip(message);
                            }
                        })
        );
    }

}
