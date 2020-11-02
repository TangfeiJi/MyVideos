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

package com.asdcce.ddgfd.base.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.asdcce.ddgfd.core.event.BindEventBus;
import com.asdcce.ddgfd.modules.login.ui.activity.LoginActivity;
import com.classic.common.MultipleStatusView;
import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.base.presenter.IPresenter;
import com.asdcce.ddgfd.base.view.IView;
import com.asdcce.ddgfd.utils.CommonUtils;
import com.asdcce.ddgfd.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;


public abstract class BaseActivity<T extends IPresenter> extends AbstractSimpleActivity implements
        HasSupportFragmentInjector,
        IView {
    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentDispatchingAndroidInjector;
    @Inject
    protected T mPresenter;
    private AlertDialog mDialog;
    private MultipleStatusView mMultipleStatusView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().register(this);
        }
    }
    @Override
    protected void onViewCreated() {
        mMultipleStatusView = findViewById(R.id.custom_multiple_status_view);
        if (mMultipleStatusView != null) {
            mMultipleStatusView.setOnClickListener(v -> mPresenter.reload());
        }
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().unregister(this);
        }
        hideLoading();
        super.onDestroy();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentDispatchingAndroidInjector;
    }

    @Override
    public void onBackPressedSupport() {
        CommonUtils.hideKeyBoard(this, this.getWindow().getDecorView().getRootView());
        super.onBackPressedSupport();
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        ToastUtils.showToast( errorMsg);
    }

    @Override
    public void showLoading() {
        if (mMultipleStatusView == null) return;
        mMultipleStatusView.showLoading();

    }
    @Override
    public void showOpenLoading() {
        showLoadingLoading();
    }

    @Override
    public void showError() {
        if (mMultipleStatusView == null) return;
        mMultipleStatusView.showError();
    }

    @Override
    public void showNoNetwork() {
        if (mMultipleStatusView == null) return;
        mMultipleStatusView.showNoNetwork();
    }

    @Override
    public void showEmpty() {
        if (mMultipleStatusView == null) return;
        mMultipleStatusView.showEmpty();
    }

    @Override
    public void showContent() {
        if (mMultipleStatusView == null) return;
        mMultipleStatusView.showContent();
    }




    public void showLoadingLoading() {
        if (mDialog == null) {
            mDialog = CommonUtils.getLoadingDialog(this, getString(R.string.loading));
        }
        mDialog.show();
    }

    public void hideLoadingLoading() {
        if (mDialog != null) {
            mDialog.dismiss();
            mDialog = null;
        }
    }

    @Override
    public void hideLoading() {
hideLoadingLoading();
    }



    @Override
    public void showLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void toActivity(@NonNull final Class<?> clz){
        startActivity(new Intent(this,clz));
    }
}
