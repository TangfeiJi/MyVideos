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

package com.asdcce.ddgfd.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.asdcce.ddgfd.core.DataManager;
import com.asdcce.ddgfd.di.component.DaggerAppComponent;
import com.asdcce.ddgfd.di.module.AppModule;
import com.asdcce.ddgfd.di.module.HttpModule;


import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;


import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MyApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }

    private static Context mContext;
    private RefWatcher refWatcher;
    @Inject
    public DataManager mDataManager;




    @Override
    public void onCreate() {
        super.onCreate();
        mContext =this;
        DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .httpModule(new HttpModule())
                .build().inject(this);
        refWatcher = setupLeakCanary();

        MultiDex.install(this);
//        initLogger();
    }


//    private void initLogger() {
//        Logger.addLogAdapter(new AndroidLogAdapter());
//        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
//                .showThreadInfo(false)  //是否选择显示线程信息，默认为true
//                .methodCount(0)         //方法数显示多少行，默认2行
//                .methodOffset(7)        //隐藏方法内部调用到偏移量，默认5
//                .tag("MyTag")   //自定义TAG全部标签，默认PRETTY_LOGGER
//                .build();
//        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
//    }


    private RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    public static Context getContext() {
        return mContext;
    }


}
