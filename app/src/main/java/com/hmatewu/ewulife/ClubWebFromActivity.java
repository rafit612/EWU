package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ClubWebFromActivity extends AppCompatActivity {
    public static final String EXTRA_CLUB_FORM= "com.hm.roktojoddha.EXTRA_CLUB_FORM";
    WebView webView;
    String link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_web_from);
        Intent intent = getIntent();
        link=intent.getStringExtra(ClubInfoActivity.EXTRA_CLUB_FORM);
        webView=findViewById(R.id.web_club_form);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(link);
    }
}