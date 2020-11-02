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

import android.content.Context;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.application.MyApplication;
import com.asdcce.ddgfd.base.presenter.BasePresenter;
import com.asdcce.ddgfd.core.rx.BaseObserver;
import com.asdcce.ddgfd.modules.bean.DetasasilsBean;
import com.asdcce.ddgfd.modules.main.contract.ProductContract;
import com.asdcce.ddgfd.utils.RxUtils;

import javax.inject.Inject;

public class ProductPresenter extends BasePresenter<ProductContract.View>
        implements ProductContract.Presenter {
private String productId;
    @Inject
    ProductPresenter() {
    }

    @Override
    public void reload() {
        super.reload();

    }
    @Override
    public void getProduct(String id, String token, String terminal) {


    }

    @Override
    public void getClick(String terminal, String token, String id) {

    }
}
