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

package com.asdcce.ddgfd.modules.main.contract;

import android.content.Context;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.asdcce.ddgfd.base.presenter.IPresenter;
import com.asdcce.ddgfd.base.view.IView;
import com.asdcce.ddgfd.modules.bean.DetasasilsBean;

public interface ProductContract {
    interface View extends IView {
        void getProductData(DetasasilsBean data);
        void getClickSuccess();
    }
    interface Presenter extends IPresenter<View> {
        void getProduct(String id, String token, String terminal);
        void getClick(String terminal, String token, String id);

    }
}
