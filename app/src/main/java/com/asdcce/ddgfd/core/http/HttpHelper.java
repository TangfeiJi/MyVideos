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

package com.asdcce.ddgfd.core.http;


import com.asdcce.ddgfd.modules.bean.ConfigBean;
import com.asdcce.ddgfd.modules.bean.DetasasilsBean;
import com.asdcce.ddgfd.modules.bean.FriendsBean;
import com.asdcce.ddgfd.modules.bean.LogisasnBean;
import com.asdcce.ddgfd.modules.bean.ProdusasctBean;
import com.asdcce.ddgfd.modules.bean.UserDetailsBean;
import com.asdcce.ddgfd.modules.login.bean.ContentBean;
import com.asdcce.ddgfd.modules.login.bean.LoginBean;
import com.asdcce.ddgfd.modules.mine.bean.FriendsApplyBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface HttpHelper {





    Observable<BaseResponse> activate(String jsonData);


    Observable<BaseResponse> requestLogin(String jsonData);











}
