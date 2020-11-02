package com.asdcce.ddgfd.modules.login.ui.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.base.activity.BaseActivity;
import com.asdcce.ddgfd.dialog.DialogComm;
import com.asdcce.ddgfd.dialog.DialogGetCode;
import com.asdcce.ddgfd.dialog.DialogGetCodeListener;
import com.asdcce.ddgfd.modules.login.contract.LoginContract;
import com.asdcce.ddgfd.modules.login.presenter.LoginActivityPresenter;
import com.asdcce.ddgfd.utils.CommonUtils;
import com.asdcce.ddgfd.utils.ToastUtils;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.OnConfirmListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author:JTF
 * Date :
 * Desc :
 */
public class LoginActivity extends BaseActivity<LoginActivityPresenter> implements LoginContract.View {


    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.etCode)
    EditText etCode;

    @BindView(R.id.tvCountry)
    TextView tvCountry;

    @BindView(R.id.tvSend)
    TextView tvSend;
    @BindView(R.id.tvNext)
    TextView tvNext;
    private CountDownTimer mCountTimer;
    private long mTimer = -1;
    private int mCountAllS = 120;

    private final String COUNTRY_91 = "+91", COUNTRY_01 = "+01", COUNTRY_44 = "+44";

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
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
    protected void onPause() {
        super.onPause();
    }


    @Override
    public void loginRespon() {

    }


    @OnClick({R.id.tvSend, R.id.tvNext})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvSend:
                String phone = etPhone.getText().toString().trim();
                String country = tvCountry.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    ToastUtils.showToast("Mobile phone number does not meet the rules");
                    return;
                }
                switch (country) {
                    case COUNTRY_91:
                        if (CommonUtils.checkPhone91(phone)) {

                        } else {
                            ToastUtils.showToast("Mobile phone number does not meet the rules");
                        }

                        break;
                    case COUNTRY_01:
                        if (CommonUtils.checkPhone01(phone)) {

                        } else {
                            ToastUtils.showToast("Mobile phone number does not meet the rules");
                        }

                        break;
                    case COUNTRY_44:
                        if (CommonUtils.checkPhone44(phone)) {

                        } else {
                            ToastUtils.showToast("Mobile phone number does not meet the rules");
                        }

                        break;
                }
                CommonUtils.hideKeyBoard(this, getWindow().getDecorView().getRootView());
                startCountdown(mCountAllS);
                break;
            case R.id.tvNext:
                if (TextUtils.isEmpty(etPhone.getText().toString().trim())) {
                    ToastUtils.showToast("Mobile phone number does not meet the rules");
                } else if (TextUtils.isEmpty(etCode.getText().toString().trim())) {
                    ToastUtils.showToast("verification code must be filled");
                } else {
                    toActivity(PersonInforActivity.class);
                }


                break;
        }
    }

    private void startCountdown(long seconds) {
        mCountTimer = new CountDownTimer(seconds * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimer = millisUntilFinished / 1000;
                tvSend.setText(mTimer + "s");
                tvSend.setClickable(false);
                if (mTimer == mCountAllS - 3) {
                    new XPopup.Builder(LoginActivity.this)
                            .hasShadowBg(true)//弹窗是否有半透明背景遮罩，默认是true
                            .asCustom(new DialogGetCode(LoginActivity.this, new DialogGetCodeListener() {
                                @Override
                                public void onConfirm(String code) {
                                    etCode.setText(code);
                                }
                            }
                            ))
                            .show();

                }
            }

            @Override
            public void onFinish() {
                mTimer = 0;
                tvSend.setText("Get code");
                tvSend.setClickable(true);
            }
        };
        mCountTimer.start();
    }
}
