package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class RequestWebFormActivity2 extends AppCompatActivity {
    WebView webView;
    String load_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_web_form2);
        webView=findViewById(R.id.web_blood_form);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSf6K1sSB1orw7LLAtSDp68F4v6vcU0Q8dlhM4fgk39OMoT79A/viewform?usp=sf_link");
    }
}