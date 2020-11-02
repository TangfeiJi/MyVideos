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

package com.asdcce.ddgfd.modules.mine.presenter;

import android.Manifest;
import android.content.Context;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.asdcce.ddgfd.base.presenter.BasePresenter;
import com.asdcce.ddgfd.modules.mine.contract.MineContract;


import java.util.List;

import javax.inject.Inject;

public class MinePresenter extends BasePresenter<MineContract.View>
        implements MineContract.Presenter {

    @Inject
    MinePresenter() {
    }



    @Override
    public void reload() {

    }


    @Override
    public void requestPermission(FragmentActivity context) {



    }
}
