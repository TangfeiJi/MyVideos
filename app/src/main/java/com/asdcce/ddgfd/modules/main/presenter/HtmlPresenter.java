package com.asdcce.ddgfd.modules.main.presenter;

import com.asdcce.ddgfd.base.presenter.BasePresenter;
import com.asdcce.ddgfd.modules.main.contract.HtmlContract;

import javax.inject.Inject;

/**
 * Author:JTF
 * Date :
 * Desc :
 */
public class HtmlPresenter extends BasePresenter<HtmlContract.View> implements HtmlContract.Presenter {
    @Inject
    HtmlPresenter() {

    }

    @Override
    public void reload() {

    }

    @Override
    public void requestHtml() {


        //     addSubscribe(mDataManager.requestLoan()
//                .compose(RxUtils.SchedulerTransformer())
//                .filter(articleListData -> mView != null)
//                .subscribeWith(new BaseObserver<List<ProductBean>>(mView,
//                        MoviceApp.getContext().getString(R.string.http_error),
//                        true) {
//                    @Override
//                    public void onSuccess(List<ProductBean> bannerData) {
//                        mView.getLoanSuccess(bannerData);
//                    }
//                }));


    }

}
