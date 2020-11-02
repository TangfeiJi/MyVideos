/*
 *     (C) Copyright 2019, FlySky.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.asdcce.ddgfd.modules.main.presenter;

import android.Manifest;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.application.MyApplication;
import com.asdcce.ddgfd.base.presenter.BasePresenter;
import com.asdcce.ddgfd.core.rx.BaseObserver;
import com.asdcce.ddgfd.modules.bean.ConfigBean;
import com.asdcce.ddgfd.modules.bean.LogisasnBean;
import com.asdcce.ddgfd.modules.main.contract.MainContract;
import com.asdcce.ddgfd.utils.GetAndroidIdGAid;
import com.asdcce.ddgfd.utils.RxUtils;
import com.google.gson.Gson;


import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;


public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    MainPresenter() {
    }

    @Override
    public void reload() {
        super.reload();
    }


    @Override
    public void activityApp() {
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
