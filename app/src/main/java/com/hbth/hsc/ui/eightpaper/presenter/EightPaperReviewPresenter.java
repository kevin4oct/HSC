package com.hbth.hsc.ui.eightpaper.presenter;

import com.hbth.hsc.bean.EightPaperReaderBean;
import com.hbth.hsc.bean.EightPaperRootBean;
import com.hbth.hsc.ui.eightpaper.contract.EightPaperReviewContract;
import com.hbth.mylibrary.rxevent.RxSubscriber;

/**
 * Created by Administrator on 2018/3/5.
 */

public class EightPaperReviewPresenter extends EightPaperReviewContract.Presenter {
    @Override
    public void returnEightRootBeanRequest() {
        mRxManager.add(
                mModel.getEightPaperRootBean(
                        mView.getDataname(), mView.getYear(), mView.getType())
                        .subscribe(new RxSubscriber<EightPaperRootBean>(mContext) {
                            @Override
                            protected void _onNext(EightPaperRootBean eightPaperRootBean) {
                                mView.returnEightPaperRootBean(eightPaperRootBean);
                            }

                            @Override
                            protected void _onError(String message) {
                                mView.showErrorTip(message);
                            }
                        })

        );
    }
}
