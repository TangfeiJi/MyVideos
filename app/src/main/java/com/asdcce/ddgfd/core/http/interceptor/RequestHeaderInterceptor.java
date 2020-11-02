package com.asdcce.ddgfd.core.http.interceptor;

import android.service.autofill.UserData;
import android.text.TextUtils;
import android.util.Log;

import com.asdcce.ddgfd.BuildConfig;
import com.asdcce.ddgfd.core.constant.Constants;
import com.asdcce.ddgfd.core.http.api.ApiService;
import com.asdcce.ddgfd.modules.bean.UserBean;
import com.asdcce.ddgfd.utils.ToolMD5;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestHeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        if (request.method().equals("GET")) {
            //TODO 暂未添加GET请求逻辑
//            request = addGetParams(request);
        } else if (request.method().equals("POST")) {
            request = addPostParams(request);
        }

        return chain.proceed(request);
    }


    //post 添加签名和公共参数
    private Request addPostParams(Request request) {
        String url = request.url().toString();
     if (url.contains(ApiService.BASE_MURL)) {
            //业务服务器逻辑
            if (request.body() instanceof FormBody) {
                FormBody.Builder bodyBuilder = new FormBody.Builder();
                FormBody formBody = (FormBody) request.body();

                String jsonData = null;
                for (int i = 0; i < formBody.size(); i++) {
                    if ("jsonData".equals(formBody.encodedName(i))) {
                        jsonData = URLDecoder.decode(formBody.encodedValue(i));
                    } else {
                        bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
                    }
                }
                try {
                    JSONObject jsonObject = new JSONObject(jsonData);
                    UserBean user =new  UserBean();
                    if (user.getUserId() != -1) {
                        jsonObject.put("user_id", user.getUserId());
                        jsonObject.put("userId", user.getUserId());
                        jsonObject.put("token", user.getToken());
                    }
                    jsonData = jsonObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.e(Constants.LOG_TYPE,jsonData);
                String key = getKey(jsonData);
                Log.e(Constants.LOG_TYPE,"key:" + key);
                //添加公参
                formBody = bodyBuilder
                        .add("ver", "3.3")
                        .add("plat", "android")
                        .add("jsonData", jsonData == null ? "" : jsonData)
                        .add("key", key)
                        .add("appid", "1")
                        .add("fromchannel", BuildConfig.CHANNEL_ID)
                        .add("appver", BuildConfig.VERSION_CODE + "")
                        .add("funver", "451")
                        .build();
                request = request.newBuilder().post(formBody).build();
            }



        }
        return request;
    }


    private static String getKey(String json) {
        return ToolMD5.getMD5Str(ToolMD5.getMD5Str(json + "a5ef79w"));
    }}