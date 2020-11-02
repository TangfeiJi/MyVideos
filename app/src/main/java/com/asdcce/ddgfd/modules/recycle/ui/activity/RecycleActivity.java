package com.asdcce.ddgfd.modules.recycle.ui.activity;

import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.base.activity.BaseActivity;
import com.asdcce.ddgfd.modules.recycle.bean.RecycleBean;
import com.asdcce.ddgfd.modules.recycle.contract.RecycleContract;
import com.asdcce.ddgfd.modules.recycle.presenter.RecyclePresenter;


import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import butterknife.BindView;

import android.view.View;

import butterknife.OnClick;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.asdcce.ddgfd.modules.recycle.adapter.RecycleAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:JTF
 * Date :
 * Desc :
 */
public class RecycleActivity extends BaseActivity<RecyclePresenter> implements RecycleContract.View, SwipeRefreshLayout.OnRefreshListener,
        OnLoadMoreListener {


//mAdapter.getLoadMoreModule().loadMoreComplete();


//mAdapter.getLoadMoreModule().loadMoreFail();


//mAdapter.getLoadMoreModule().loadMoreEnd();


    //mAdapter.getLoadMoreModule().loadMoreToLoading();
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mTitle;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipe_refresh;

    @BindView(R.id.rv_content)
    RecyclerView rv_content;


    private RecycleAdapter mAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.activity_recycle;
    }

    @Override
    public void initView() {
        rv_content.setLayoutManager(new LinearLayoutManager(this));
        rv_content.setHasFixedSize(true);
        mAdapter = new RecycleAdapter(this, null);
        mAdapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn);
        rv_content.setAdapter(mAdapter);
        swipe_refresh.setOnRefreshListener(this);
        mAdapter.getLoadMoreModule().setOnLoadMoreListener(this);

        List<RecycleBean> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(new RecycleBean());
        }
        mAdapter.setList(list);
    }

    @Override
    public void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        mTitle.setText("MyTitle");
        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }

    @Override
    public void initEventAndData() {
        onRefresh();
    }


    @Override
    public void responRecycle(boolean showViewAndLoadMore) {
        showRefreshView(false);
        if (showViewAndLoadMore) {
            //mAdapter.setList(data);
        } else {
//            mAdapter.addData(data);
//            if (data.size() < PAGE_SIZE) {
//                //�������һҳ,��ʾû�и������ݲ���
//                mAdapter.getLoadMoreModule().loadMoreEnd();
//                Tips.show("no more data");
//            } else {
//                mAdapter.getLoadMoreModule().loadMoreComplete();
//            }
        }

    }


    @Override
    public void onRefresh() {
        mAdapter.getLoadMoreModule().setEnableLoadMore(false);
        mPresenter.requestRecycle(true);
    }

    @Override
    public void onLoadMore() {
        showRefreshView(false);
        mPresenter.requestRecycle(false);
    }

    @OnClick({R.id.tvContent})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvContent:
//                Logger.e("11111111");
                Log.e("1111111", "11111111");
                break;

        }
    }

    public void showRefreshView(final Boolean refresh) {
        swipe_refresh.post(new Runnable() {
            @Override
            public void run() {
                swipe_refresh.setRefreshing(refresh);
                mAdapter.getLoadMoreModule().setEnableLoadMore(!refresh);
            }
        });
    }
}
