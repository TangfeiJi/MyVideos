package com.asdcce.ddgfd.modules.mine.ui;

import com.asdcce.ddgfd.base.activity.BaseActivity;
import com.asdcce.ddgfd.core.http.api.ApiService;
import com.asdcce.ddgfd.modules.bean.UserDetailsBean;
import com.asdcce.ddgfd.modules.mine.contract.InforEditContract;
import com.asdcce.ddgfd.modules.mine.presenter.InforEditPresenter;
import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.utils.DataUtils;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.lxj.xpopup.XPopup;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

import butterknife.BindView;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import butterknife.OnClick;

/**
 * Author:JTF
 * Date :
 * Desc :
 */
public class InforEditActivity extends BaseActivity<InforEditPresenter> implements InforEditContract.View {



    @Override
    public int getLayoutId() {
        return R.layout.activity_infor_edit;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initToolbar() {
    }

    @Override
    public void initEventAndData() {

    }


    @Override
    public void responInforEdit() {

    }


//    @OnClick({R.id.super_quit})
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.super_quit:
//                new XPopup.Builder(InforEditActivity.this)
//                        .asCustom(new DropOutDialog(InforEditActivity.this))
//                        .show();
//                break;
//
//
//        }
//    }

}
