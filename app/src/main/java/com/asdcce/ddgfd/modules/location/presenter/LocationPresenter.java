package com.asdcce.ddgfd.modules.location.presenter;


import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.application.MyApplication;
import com.asdcce.ddgfd.base.presenter.BasePresenter;
import com.asdcce.ddgfd.core.rx.BaseObserver;
import com.asdcce.ddgfd.modules.location.contract.LocationContract;
import com.asdcce.ddgfd.utils.RxUtils;






import javax.inject.Inject;

public class LocationPresenter extends BasePresenter<LocationContract.View> implements LocationContract.Presenter {

    @Inject
    LocationPresenter() {
    }


    @Override
    public void reload() {


    }


    @Override
    public void requestUpload(String token, String lon,String lat) {
//        addSubscribe(mDataManager.requestUpload(token,lon,lat)
//                .compose(RxUtils.SchedulerTransformer())
//                .filter(articleListData -> mView != null)
//                .subscribeWith(new BaseObserver(mView,
//                        MyApplication.getContext().getString(R.string.http_error),
//                        false, false) {
//                    @Override
//                    public void onSuccess(Object o) {
//
//                    }
//                }));
    }



}
