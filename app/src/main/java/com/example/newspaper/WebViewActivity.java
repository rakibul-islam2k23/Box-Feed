package com.example.newspaper;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.webView);
        toolbar = findViewById(R.id.toolBar);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
         webView.setWebViewClient(new WebViewClient());
         webView.loadUrl(url);

    }
}