package com.asdcce.ddgfd.modules.recycle.presenter;

import com.asdcce.ddgfd.base.presenter.BasePresenter;
import com.asdcce.ddgfd.modules.recycle.contract.RecycleContract;

import javax.inject.Inject;

/**
 * Author:JTF
 * Date :
 * Desc :
 */
public class RecyclePresenter extends BasePresenter<RecycleContract.View> implements RecycleContract.Presenter {
    @Inject
    RecyclePresenter() {

    }

    @Override
    public void reload() {

    }

    @Override
    public void requestRecycle(boolean showViewAndLoadMore) {


        //     addSubscribe(mDataManager.requestLoan()
//                .compose(RxUtils.SchedulerTransformer())
//                .filter(articleListData -> mView != null)
//                .subscribeWith(new BaseObserver<List<ProductBean>>(mView,
//                        MoviceApp.getContext().getString(R.string.http_error),
//                        showViewAndLoadMore) {
//                    @Override
//                    public void onSuccess(List<ProductBean> bannerData) {
//                        mView.getLoanSuccess(bannerData,showViewAndLoadMore);
//                    }
//                }));


    }

}
