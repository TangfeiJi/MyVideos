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

package com.asdcce.ddgfd.modules.message.ui;


import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.base.fragment.BaseFragment;
import com.asdcce.ddgfd.modules.location.contract.LocationContract;
import com.asdcce.ddgfd.modules.location.presenter.LocationPresenter;
import com.asdcce.ddgfd.modules.message.contract.MessageContract;
import com.asdcce.ddgfd.modules.message.presenter.MessagePresenter;

public class MessageFragment extends BaseFragment<MessagePresenter> implements MessageContract.View {


    public static MessageFragment newInstance() {
        return new MessageFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initView() {

    }





    @Override
    protected void initEventAndData() {

    }


    @Override
    public void showErrorMsg(String errorMsg) {
        super.showErrorMsg(errorMsg);
    }







//    @OnClick({R.id.currentosition})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.currentosition:
//                startLocationManger();
//                break;
//        }
//    }





}
