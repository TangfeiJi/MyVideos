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

package com.asdcce.ddgfd.core.http.api;

import com.asdcce.ddgfd.core.http.BaseResponse;
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
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

//    http://149.129.219.14/


//    网络请求POST
//    @POST("/api/sms/send")    https://abroad.51jshc.com
//    @FormUrlEncoded          带参数     不带参数去掉
//    Observable<BaseResponse> requestSend(@Field("phone") String phone);

//    网络请求GET    带参数
//    @GET("/api/user/myfriends")
//    Observable<BaseResponse<List<FriendsBean>>> requestMyFriends(@Query("token") String token);

//    网络请求GET    不带参数
//    @GET("/api/global/config")
//    Observable<BaseResponse<ConfigBean>> requestConfig();

//    网路请求上传图片
//    @POST(BASE_IMAGE+"/027.api?")
//    Observable<BaseResponse<ConfigBean>> get0277(@Body RequestBody body);



    String BASE_MURL = "http://im.chatnowapp.com";

//    String BASE_MURL = "http://147.139.1.128";



    String BASE_IMAGE = "https://abroad.51jshc.com/upload/";






    /**
     * 激活app
     */
    @POST("/activate")
    @FormUrlEncoded
    Observable<BaseResponse> activate(@Field("jsonData") String jsonData);



    /**
     * 登录
     */
    @POST("/activate")
    @FormUrlEncoded
    Observable<BaseResponse>  requestLogin (@Field("jsonData") String jsonData);














}
