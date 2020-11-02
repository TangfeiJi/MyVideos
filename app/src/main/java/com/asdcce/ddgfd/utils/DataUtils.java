package com.asdcce.ddgfd.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.asdcce.ddgfd.application.MyApplication;
import com.asdcce.ddgfd.modules.bean.UserDetailsBean;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/8/10.
 */
public class DataUtils {

private static final String TOKEN="token";



    //============================================================================
    //===============================Set==========================================
    //============================================================================


    public static void setToken( String arg) {
        SharedPreferencesUtil.getInstance(MyApplication.getContext()).putString(TOKEN, arg);
    }



    //============================================================================
    //===============================Get==========================================
    //============================================================================


    public static String getToken() {
        return SharedPreferencesUtil.getInstance(MyApplication.getContext()).getString(TOKEN);
    }




















}
