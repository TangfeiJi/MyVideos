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

package com.asdcce.ddgfd.core.rx;

import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.CallSuper;

import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.application.MyApplication;
import com.asdcce.ddgfd.base.view.IView;
import com.asdcce.ddgfd.core.http.BaseResponse;
import com.asdcce.ddgfd.core.http.exception.ServerException;
import com.asdcce.ddgfd.utils.CommonUtils;


import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;


public abstract class BaseObserver<T> extends ResourceObserver<BaseResponse<T>> {
    private static final String TAG = "BaseObserver";

    private IView mView;
    private String mErrorMsg;
    private boolean isShowStatusView = true;

    private boolean showLoading = true;

    protected BaseObserver(IView view) {
        this.mView = view;
    }

    protected BaseObserver(IView view, String errorMsg) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected BaseObserver(IView view, boolean isShowStatusView) {
        this.mView = view;
        this.isShowStatusView = isShowStatusView;
    }

    protected BaseObserver(IView view, String errorMsg, boolean isShowStatusView) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowStatusView = isShowStatusView;
    }

    //    1 activity/fragment的布局    2错误信息   3是否显示loading  true 显示白色背景   false显示透明背景  4是否显示所有loading（true显示所有  false都不显示）
    protected BaseObserver(IView view, String errorMsg, boolean isShowStatusView, boolean showLoading) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowStatusView = isShowStatusView;
        this.showLoading = showLoading;
    }

    public abstract void onSuccess(T t);

    @CallSuper
    public void onFailure(int code, String message) {

        mView.showErrorMsg(message);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");
        if (showLoading) {
            if (isShowStatusView) {
                mView.showLoading();
            } else {
                mView.showOpenLoading();
            }
        }
    }

    @Override
    public final void onNext(BaseResponse<T> baseResponse) {
        if (baseResponse.getRet() == BaseResponse.SUCCESS) {
            Log.d(TAG, "onSuccess");
            mView.showContent();
            mView.hideLoading();
            onSuccess((T) baseResponse);
        } else {
            Log.d(TAG, "onFailure");
            mView.showError();
            mView.hideLoading();
           onFailure(baseResponse.getRet(), baseResponse.getMsg());

        }
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete");
        if (mView == null) {
            return;
        }
        if (!CommonUtils.isNetworkConnected()) {
            mView.showErrorMsg(MyApplication.getContext().getString(R.string.http_error));
        }

    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError");
        if (mView == null) {
            return;
        }
        mView.hideLoading();
        if (e instanceof HttpException) {
            mView.showErrorMsg(MyApplication.getContext().getString(R.string.http_error));
            if(isShowStatusView){
                mView.showNoNetwork();
            }
            mView.hideLoading();

        } else if (e instanceof ServerException) {
            if(isShowStatusView){
                mView.showError();
            }
            mView.showErrorMsg(e.toString());
            mView.hideLoading();

        } else {
            if (!TextUtils.isEmpty(mErrorMsg)) {
                mView.showErrorMsg(mErrorMsg);
            }

            if(isShowStatusView){
                mView.showError();
            }

            mView.hideLoading();

            Log.e(TAG, e.toString());
        }
    }

}
