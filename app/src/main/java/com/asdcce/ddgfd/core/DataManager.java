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

package com.asdcce.ddgfd.core;

import com.asdcce.ddgfd.core.db.DbHelper;
import com.asdcce.ddgfd.core.greendao.HistoryData;
import com.asdcce.ddgfd.core.http.BaseResponse;
import com.asdcce.ddgfd.core.http.HttpHelper;
import com.asdcce.ddgfd.core.preference.PreferenceHelper;
import com.asdcce.ddgfd.modules.bean.ConfigBean;
import com.asdcce.ddgfd.modules.bean.DetasasilsBean;
import com.asdcce.ddgfd.modules.bean.FriendsBean;
import com.asdcce.ddgfd.modules.bean.LogisasnBean;
import com.asdcce.ddgfd.modules.bean.ProdusasctBean;
import com.asdcce.ddgfd.modules.bean.UserDetailsBean;
import com.asdcce.ddgfd.modules.login.bean.ContentBean;
import com.asdcce.ddgfd.modules.login.bean.LoginBean;
import com.asdcce.ddgfd.modules.mine.bean.FriendsApplyBean;
import com.google.gson.JsonObject;


import org.json.JSONObject;

import java.util.List;

import io.reactivex.Observable;

public class DataManager implements HttpHelper, DbHelper,PreferenceHelper {
    private HttpHelper mHttpHelper;
    private DbHelper mDbHelper;
    private PreferenceHelper mPreferenceHelper;

    public DataManager(HttpHelper httpHelper, DbHelper dbHelper, PreferenceHelper preferenceHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
        mPreferenceHelper = preferenceHelper;
    }

    @Override
    public Observable<BaseResponse> activate(String jsonData) {

        return mHttpHelper.activate(jsonData);
    }

    @Override
    public Observable<BaseResponse> requestLogin(String jsonData) {
        return mHttpHelper.requestLogin(jsonData);
    }






    @Override
    public List<HistoryData> addHistoryData(String data) {
        return mDbHelper.addHistoryData(data);
    }

    @Override
    public void clearAllHistoryData() {
        mDbHelper.clearAllHistoryData();
    }

    @Override
    public void deleteHistoryDataById(Long id) {
        mDbHelper.deleteHistoryDataById(id);
    }

    @Override
    public List<HistoryData> loadAllHistoryData() {
        return mDbHelper.loadAllHistoryData();
    }

    @Override
    public void setLoginStatus(boolean isLogin) {
        mPreferenceHelper.setLoginStatus(isLogin);
    }

    @Override
    public boolean getLoginStatus() {
        return mPreferenceHelper.getLoginStatus();
    }

    @Override
    public void setLoginAccount(String account) {
        mPreferenceHelper.setLoginAccount(account);
    }

    @Override
    public String getLoginAccount() {
        return mPreferenceHelper.getLoginAccount();
    }

}
