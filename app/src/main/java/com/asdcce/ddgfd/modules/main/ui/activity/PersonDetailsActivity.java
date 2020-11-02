package com.asdcce.ddgfd.modules.main.ui.activity;

import com.asdcce.ddgfd.base.activity.BaseActivity;
import com.asdcce.ddgfd.modules.main.contract.PersonDetailsContract;
import com.asdcce.ddgfd.modules.main.presenter.PersonDetailsPresenter;
import com.asdcce.ddgfd.R;

import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import butterknife.BindView;

import android.view.View;

import butterknife.OnClick;

/**
 * Author:JTF
 * Date :
 * Desc :
 */
public class PersonDetailsActivity extends BaseActivity<PersonDetailsPresenter> implements PersonDetailsContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_person_details;
    }

    @Override
    public void initView() {

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

    }


    @Override
    public void responPersonDetails() {

    }


    @OnClick({})
    public void onClick(View v) {
        switch (v.getId()) {
            case 0:

                break;

        }
    }

}
