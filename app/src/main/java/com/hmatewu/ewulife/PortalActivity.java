package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.HashMap;
import java.util.Map;

public class PortalActivity extends AppCompatActivity {
    WebView myWebView;
    SwipeRefreshLayout refreshLayout;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) { // Enables browsing to previous pages with the hardware back button
            myWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);
        myWebView = (WebView) this.findViewById(R.id.portal);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("http://portal.ewubd.edu/"); // Specify the URL to load when the application starts
        //myWebView.loadUrl("file://sdcard/"); // Specify a local file to load when the application starts. Will only load file types WebView supports
        myWebView.setWebViewClient(new WebViewKeep());
        myWebView.setInitialScale(1); // Set the initial zoom scale
        myWebView.getSettings().setBuiltInZoomControls(true); // Initialize zoom controls for your WebView component
        myWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        myWebView.getSettings().setUseWideViewPort(true); // Initializes double-tap zoom control

    }

    private class WebViewKeep extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }




        //webView.loadUrl("http://portal.ewubd.edu/");
    }
}