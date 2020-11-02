package com.asdcce.ddgfd.modules.login.presenter;

import android.util.Log;

import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.application.MyApplication;
import com.asdcce.ddgfd.base.presenter.BasePresenter;
import com.asdcce.ddgfd.core.rx.BaseObserver;
import com.asdcce.ddgfd.modules.bean.UserDetailsBean;
import com.asdcce.ddgfd.modules.login.bean.ContentBean;
import com.asdcce.ddgfd.modules.login.bean.LoginBean;
import com.asdcce.ddgfd.modules.login.contract.LoginContract;
import com.asdcce.ddgfd.utils.GetAndroidIdGAid;
import com.asdcce.ddgfd.utils.RxUtils;
import com.google.gson.Gson;

import org.json.JSONObject;

import javax.inject.Inject;

/**
 * Author:JTF
 * Date :
 * Desc :
 */
public class LoginActivityPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {
    @Inject
    LoginActivityPresenter() {

    }

    @Override
    public void reload() {

    }


    @Override
    public void loginRequest() {
        JSONObject jsonData = new JSONObject();
        try {
            jsonData.put("imei", GetAndroidIdGAid.getAndroidGaid());
        } catch (Exception e) {
        }
        addSubscribe(mDataManager.activate(jsonData.toString())
                .compose(RxUtils.SchedulerTransformer())
                .filter(articleListData -> mView != null)
                .subscribeWith(new BaseObserver(mView,
                        MyApplication.getContext().getString(R.string.http_error),
                        false,false) {
                    @Override
                    public void onSuccess(Object o) {
                        Log.e("1111",new Gson().toJson(o));
                    }
                }));
    }



}
