package com.asdcce.ddgfd.modules.login.ui.activity;

import com.asdcce.ddgfd.base.activity.BaseActivity;
import com.asdcce.ddgfd.modules.login.contract.PersonInforContract;
import com.asdcce.ddgfd.modules.login.presenter.PersonInforPresenter;
import com.asdcce.ddgfd.R;

import android.widget.TextView;

import butterknife.BindView;

import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import java.util.Random;

import butterknife.OnClick;

/**
 * Author:JTF
 * Date :
 * Desc :
 */
public class PersonInforActivity extends BaseActivity<PersonInforPresenter> implements PersonInforContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_person_infor;
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
    public void responPersonInfor() {
       String[]  nameList= getResources().getStringArray(R.array.nameList);
        mPresenter.requestPersonInfor(nameList[new Random().nextInt(nameList.length)],"11","1","111111");
    }


    @OnClick({})
    public void onClick(View v) {
        switch (v.getId()) {
            case 0:

                break;

        }
    }

}
