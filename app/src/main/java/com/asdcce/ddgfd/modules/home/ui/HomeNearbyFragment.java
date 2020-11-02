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


import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.base.fragment.BaseFragment;
import com.asdcce.ddgfd.modules.home.adapter.HomeRecomAdapter;
import com.asdcce.ddgfd.modules.location.contract.LocationContract;
import com.asdcce.ddgfd.modules.location.presenter.LocationPresenter;
import com.asdcce.ddgfd.modules.recycle.bean.RecycleBean;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeNearbyFragment extends BaseFragment<LocationPresenter> implements LocationContract.View , SwipeRefreshLayout.OnRefreshListener,
        OnLoadMoreListener {

    @BindView(R.id.rvContent)
    RecyclerView rvContent;
    @BindView(R.id.swLayout)
    SwipeRefreshLayout swLayout;
    private HomeRecomAdapter mAdapter;



    public static HomeNearbyFragment newInstance() {
        return new HomeNearbyFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_nearby;
    }

    @Override
    protected void initView() {
        List<RecycleBean> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        list.add(null);
        mAdapter = new HomeRecomAdapter(mContext, list);
        rvContent.setLayoutManager(new GridLayoutManager(mContext,2));
        rvContent.setAdapter(mAdapter);
        swLayout.setOnRefreshListener(this);
        mAdapter.getLoadMoreModule().setOnLoadMoreListener(this);
    }






//    @OnClick({R.id.currentosition})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.currentosition:
//                startLocationManger();
//                break;
//        }
//    }


    @Override
    protected void initEventAndData() {

    }


    @Override
    public void showErrorMsg(String errorMsg) {
        super.showErrorMsg(errorMsg);
    }

    @Override
    public void onRefresh() {
        mAdapter.getLoadMoreModule().loadMoreComplete();
    }

    @Override
    public void onLoadMore() {
        mAdapter.getLoadMoreModule().loadMoreComplete();


//        mAdapter.getLoadMoreModule().loadMoreEnd();
    }


    //    @OnClick({R.id.currentosition})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.currentosition:
//                startLocationManger();
//                break;
//        }
//    }
    public void showRefreshView(final Boolean refresh) {
        swLayout.post(new Runnable() {
            @Override
            public void run() {
                swLayout.setRefreshing(refresh);
            }
        });
    }



}
