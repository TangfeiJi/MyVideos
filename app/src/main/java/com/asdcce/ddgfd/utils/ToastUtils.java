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

package com.asdcce.ddgfd.utils;

import android.content.Context;
import android.widget.Toast;

import com.asdcce.ddgfd.application.MyApplication;

public class ToastUtils {

    private static Toast mToast;
    private static Context mContext;

    public static void showToast( String text, int duration) {
        if(mContext==null){
            mContext= MyApplication.getContext();
        }
        if (mToast == null) {
            mToast = Toast.makeText(mContext.getApplicationContext(), text, duration);
        } else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }
        mToast.show();
    }


    public static void showToast(String string) {
        showToast(string, Toast.LENGTH_SHORT);
    }
}
