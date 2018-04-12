package com.hbth.hsc.ui.eightpaper.presenter;

import com.hbth.hsc.bean.EightPaperReaderBean;
import com.hbth.hsc.ui.eightpaper.contract.EightPaperReadContract;
import com.hbth.mylibrary.rxevent.RxSubscriber;

/**
 * Created by Administrator on 2018/3/5.
 * 8点报阅读的主导器
 */

public class EightPaperReaderPresenter extends EightPaperReadContract.Presenter {
    @Override
    public void returnEightReaderBeanRequest() {
        mRxManager.add(
                mModel.getEightPaperReaderBean(
                        mView.getPaperid(), mView.getDbname(), mView.getType())
                        .subscribe(new RxSubscriber<EightPaperReaderBean>(mContext) {
                            @Override
                            protected void _onNext(EightPaperReaderBean eightPaperReaderBean) {
                                mView.returnEightPaperReaderBean(eightPaperReaderBean);
                            }

                            @Override
                            protected void _onError(String message) {
                                mView.showErrorTip(message);
                            }
                        })
        );

    }
}
