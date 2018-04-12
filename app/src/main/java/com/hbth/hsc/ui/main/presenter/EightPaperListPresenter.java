package com.hbth.hsc.ui.main.presenter;

import com.hbth.hsc.api.ALLVARIABLE;
import com.hbth.hsc.bean.EightPaperRootBean;
import com.hbth.hsc.ui.main.contract.EightPaperListContract;
import com.hbth.mylibrary.rxevent.RxSchedulers;
import com.hbth.mylibrary.rxevent.RxSubscriber;

/**
 * Created by Kevin on 2018/3/2.
 * 8点报获取首页列表的适配器
 */

public class EightPaperListPresenter extends EightPaperListContract.Presenter {

    @Override
    public void getEightPaperListRequest(String methor) {
        mView.showLoading("数字资源正在加载中..");
        mRxManager.add(
                mModel.getEightPaperList(
                        methor, mView.getType(), mView.getRows(), mView.getPage(), mView.getClassfy())
                        .subscribe(new RxSubscriber<EightPaperRootBean>(mContext) {
                            @Override
                            protected void _onNext(EightPaperRootBean bean) {
                                mView.returnEightPaperList(bean);
                                mView.stopLoading();
                            }

                            @Override
                            protected void _onError(String message) {
                                mView.showErrorTip("接收到错误信息：" + message);
                                mView.stopLoading();
                            }
                        })
        );
    }
}
