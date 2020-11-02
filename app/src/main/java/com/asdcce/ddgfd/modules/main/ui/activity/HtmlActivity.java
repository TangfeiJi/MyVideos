package com.asdcce.ddgfd.modules.main.ui.activity;

import com.asdcce.ddgfd.base.activity.BaseActivity;
import com.asdcce.ddgfd.modules.main.contract.HtmlContract;
import com.asdcce.ddgfd.modules.main.presenter.HtmlPresenter;
import com.asdcce.ddgfd.R;

import android.content.Intent;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import butterknife.BindView;

import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import butterknife.OnClick;

/**
 * Author:JTF
 * Date :
 * Desc :
 */
public class HtmlActivity extends BaseActivity<HtmlPresenter> implements HtmlContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mTitle;

    @BindView(R.id.mWebView)
    WebView mWebView;

    Intent intent;
    @Override
    public int getLayoutId() {
        return R.layout.activity_html;
    }

    @Override
    public void initView() {

        loadHtml(intent.getStringExtra("content"));
    }

    @Override
    public void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        intent= getIntent();
        mTitle.setText(intent.getStringExtra("title"));
        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }

    @Override
    public void initEventAndData() {

    }


    @Override
    public void responHtml() {

    }

    private void loadHtml(String link) {
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setBlockNetworkImage(false);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setGeolocationEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setSupportZoom(false);
        webSettings.setNeedInitialFocus(false);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setBuiltInZoomControls(false);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWebView.getSettings().setMixedContentMode(
                    WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        mWebView.loadData(link, "text/html", "UTF-8");
        mWebView.loadDataWithBaseURL(null, link, "text/html", "UTF-8", null);

    }


}
