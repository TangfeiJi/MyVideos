package com.asdcce.ddgfd.modules.mine.presenter;

import com.asdcce.ddgfd.base.presenter.BasePresenter;
import com.asdcce.ddgfd.modules.mine.contract.InforEditContract;

import javax.inject.Inject;

/**
 * Author:JTF
 * Date :
 * Desc :
 */
public class InforEditPresenter extends BasePresenter<InforEditContract.View> implements InforEditContract.Presenter {
    @Inject
    InforEditPresenter() {

    }

    @Override
    public void reload() {

    }

    @Override
    public void requestInforEdit() {


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
