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

package com.asdcce.ddgfd.modules.mine.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.base.fragment.BaseFragment;
import com.asdcce.ddgfd.dialog.DialogComm;
import com.asdcce.ddgfd.modules.mine.contract.MineContract;
import com.asdcce.ddgfd.modules.mine.presenter.MinePresenter;
import com.asdcce.ddgfd.utils.PictureSelector;
import com.asdcce.ddgfd.utils.ToastUtils;
import com.asdcce.ddgfd.utils.ActivityStart;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.OnConfirmListener;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class MineFragment extends BaseFragment<MinePresenter> implements MineContract.View {
private static final int REQUEST_CODE_SELECT_USER_ICON=2;


    @BindView(R.id.tvLogin)
    TextView tvLogin;
    @BindView(R.id.tvHeader)
    ImageView tvHeader;



    public static MineFragment newInstance() {
        return new MineFragment();
    }


    @Override
    protected void initView() {


    }

    @Override
    protected int getLayoutId() {

        return R.layout.fragment_mine;
    }

    @Override
    protected void initEventAndData() {

    }

    @OnClick({R.id.tvLogin, R.id.tvAbout, R.id.tvDialog, R.id.tvHeader})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvLogin:
                ActivityStart.start(_mActivity);
                break;
            case R.id.tvAbout:
                startToActivity(AboutActivity.class);
                break;
            case R.id.tvDialog:
                new XPopup.Builder(getContext())
                        .hasShadowBg(true)//弹窗是否有半透明背景遮罩，默认是true
                        .asCustom(new DialogComm(_mActivity, "1111", "确认", "取消", new OnConfirmListener() {
                            @Override
                            public void onConfirm() {
                                ToastUtils.showToast("111111");
                            }
                        }, null))
                        .show();
                break;
            case R.id.tvHeader:
                break;

        }
    }


    @Override
    public void loginSuccess() {


    }
    @Override
    public void respontPermission() {
        ToastUtils.showToast("success");
        PictureSelector.select(MineFragment.this, REQUEST_CODE_SELECT_USER_ICON);
    }


}
