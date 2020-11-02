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

package com.asdcce.ddgfd.modules.main.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.core.event.BindEventBus;
import com.asdcce.ddgfd.core.event.LocationEvent;
import com.asdcce.ddgfd.modules.adapter.FragmentAdapter;
import com.asdcce.ddgfd.modules.home.ui.HomeFragment;
import com.asdcce.ddgfd.modules.location.ui.VideoFragment;
import com.asdcce.ddgfd.modules.message.ui.MessageFragment;
import com.asdcce.ddgfd.modules.mine.ui.MineFragment;
import com.asdcce.ddgfd.base.activity.BaseActivity;
import com.asdcce.ddgfd.core.constant.Constants;
import com.asdcce.ddgfd.modules.main.contract.MainContract;
import com.asdcce.ddgfd.modules.main.presenter.MainPresenter;
import com.asdcce.ddgfd.utils.ToastUtils;
import com.asdcce.ddgfd.widget.CustomNoTouchViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.gyf.barlibrary.ImmersionBar;
import com.squareup.haha.perflib.Main;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@BindEventBus
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {



    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView mBottomNavigationView;


    @BindView(R.id.cv_content_view)
    CustomNoTouchViewPager cv_content_view;

    //fragments
    private long clickTime;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void initView() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance());
        fragments.add(VideoFragment.newInstance());
        fragments.add(MessageFragment.newInstance());
        fragments.add(MineFragment.newInstance());
        fragments.add(MineFragment.newInstance());
        FragmentAdapter adapter = new FragmentAdapter(fragments, getSupportFragmentManager());
        cv_content_view.setAdapter(adapter);
        cv_content_view.setOffscreenPageLimit(2);
//        mBottomNavigationView.setSelectedItemId(mBottomNavigationView.getMenu().getItem(1).getItemId());
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int menuId = menuItem.getItemId();
                // 跳转指定页面：Fragment
                switch (menuId) {
                    case R.id.tab_one:
                        cv_content_view.setCurrentItem(0);
                        return  true;
                    case R.id.tab_two:
                        cv_content_view.setCurrentItem(1);
                        return  true;
                    case R.id.tab_three:
                        cv_content_view.setCurrentItem(2);
                        return  true;
                    case R.id.tab_four:
                        cv_content_view.setCurrentItem(3);
                        return  true;
                    case R.id.tab_five:
                        cv_content_view.setCurrentItem(4);
                        return  true;

                }
                return false;
            }
        });

    }





    @Override
    protected void initToolbar() {


    }


    //标题栏的左右图标 以后会用的
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void initEventAndData() {
        mPresenter.activityApp();
    }

    /**
     * 处理回退事件
     */
    @Override
    public void onBackPressedSupport() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - clickTime) > Constants.DOUBLE_INTERVAL_TIME) {
                ToastUtils.showToast( getString(R.string.double_click_exit_toast));
                clickTime = System.currentTimeMillis();
            } else {
                finish();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }



    /** 方法名可自定义 */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(LocationEvent event) {
        if (event != null) {

        }
    }
}
