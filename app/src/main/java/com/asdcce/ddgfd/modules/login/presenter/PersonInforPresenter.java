package com.asdcce.ddgfd.modules.login.presenter;

import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.application.MyApplication;
import com.asdcce.ddgfd.base.presenter.BasePresenter;
import com.asdcce.ddgfd.core.constant.Constants;
import com.asdcce.ddgfd.core.rx.BaseObserver;
import com.asdcce.ddgfd.modules.login.contract.PersonInforContract;
import com.asdcce.ddgfd.utils.GetAndroidIdGAid;
import com.asdcce.ddgfd.utils.RxUtils;

import org.json.JSONObject;


import javax.inject.Inject;

/**
 * Author:JTF
 * Date :
 * Desc :
 */
public class PersonInforPresenter extends BasePresenter<PersonInforContract.View> implements PersonInforContract.Presenter {
    @Inject
    PersonInforPresenter() {

    }

    @Override
    public void reload() {

    }



    @Override
    public void requestPersonInfor(String name, String age, String sex, String phone_no) {

        JSONObject jsonData = new JSONObject();
        try {
            jsonData.put("register_type", "");
            jsonData.put("phone_type", "android");
            jsonData.put("imei", GetAndroidIdGAid.getAndroidGaid());
            jsonData.put("time", System.currentTimeMillis());
            jsonData.put("longitude", "");
            jsonData.put("latitude", "");
            jsonData.put("province", "");
            jsonData.put("country", "IND");
            jsonData.put("city", "");
            jsonData.put("district", "");
            jsonData.put("channel", Constants.APP_CHANNEL);
            jsonData.put("time", System.currentTimeMillis());
            jsonData.put("user_name", name);
            jsonData.put("sex", sex);
            jsonData.put("birthday", age);
            jsonData.put("code", "0");
            jsonData.put("phone_no", phone_no);
        } catch (Exception e) {

        }

        addSubscribe(mDataManager.requestLogin(jsonData.toString())
                .compose(RxUtils.SchedulerTransformer())
                .filter(articleListData -> mView != null)
                .subscribeWith(new BaseObserver(mView,
                        MyApplication.getContext().getString(R.string.http_error),
                        true) {
                    @Override
                    public void onSuccess( Object o) {


                    }
                }));
    }
}
