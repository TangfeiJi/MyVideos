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

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.base.activity.BaseActivity;
import com.asdcce.ddgfd.modules.mine.contract.SettingContract;
import com.asdcce.ddgfd.modules.mine.presenter.SettingPresenter;

import butterknife.BindView;
import butterknife.OnClick;


public class AboutActivity extends BaseActivity<SettingPresenter> implements SettingContract.View {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mTitle;


    @Override
    protected void initView() {
mContext=AboutActivity.this;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            mTitle.setText("xxxx");
        }
        mToolbar.setNavigationOnClickListener(v -> {
            onBackPressedSupport();
        });
    }

    @Override
    protected void initEventAndData() {

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void getData(String data) {

    }

    @OnClick({R.id.tvUpdate, R.id.content_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvUpdate:
                break;
        }
    }
}
