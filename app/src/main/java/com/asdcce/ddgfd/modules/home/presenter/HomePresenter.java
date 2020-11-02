package com.asdcce.ddgfd.modules.home.presenter;

import com.asdcce.ddgfd.core.event.LocationEvent;
import com.asdcce.ddgfd.modules.bean.FriendsBean;
import com.asdcce.ddgfd.modules.bean.ProdusasctBean;
import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.application.MyApplication;
import com.asdcce.ddgfd.base.presenter.BasePresenter;
import com.asdcce.ddgfd.core.rx.BaseObserver;
import com.asdcce.ddgfd.modules.bean.UserDetailsBean;
import com.asdcce.ddgfd.modules.home.contract.HomeContract;

import com.asdcce.ddgfd.utils.RxUtils;



import java.util.List;

import javax.inject.Inject;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {
    @Inject
    HomePresenter() {
    }
    private String token;

    @Override
    public void reload() {

    }


}
