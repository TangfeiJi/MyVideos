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

package com.asdcce.ddgfd.modules.home.ui;


import android.Manifest;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.base.fragment.BaseFragment;
import com.asdcce.ddgfd.modules.adapter.FragmentAdapter;
import com.asdcce.ddgfd.modules.home.contract.HomeContract;
import com.asdcce.ddgfd.modules.home.presenter.HomePresenter;
import com.asdcce.ddgfd.utils.ToastUtils;
import com.ninetripods.aopermission.permissionlib.annotation.NeedPermission;
import com.ninetripods.aopermission.permissionlib.annotation.PermissionCanceled;
import com.ninetripods.aopermission.permissionlib.annotation.PermissionDenied;
import com.ninetripods.aopermission.permissionlib.bean.CancelBean;
import com.ninetripods.aopermission.permissionlib.bean.DenyBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {


    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tvRecomm)
    TextView tvRecomm;
    @BindView(R.id.tvNearby)
    TextView tvNearby;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initEventAndData() {
    }


    @Override
    protected void initView() {

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeRecomFragment.newInstance());
        fragments.add(HomeNearbyFragment.newInstance());
        FragmentAdapter adapter = new FragmentAdapter(fragments, getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);


    }



    @OnClick({R.id.tvRecomm, R.id.tvNearby})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvRecomm:
                tvRecomm.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
                tvNearby.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
                viewPager.setCurrentItem(0);
                break;
            case R.id.tvNearby:
                tvNearby.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
                tvRecomm.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
                viewPager.setCurrentItem(1);
                break;
        }
    }


    private void setTextView(){


    }



}
