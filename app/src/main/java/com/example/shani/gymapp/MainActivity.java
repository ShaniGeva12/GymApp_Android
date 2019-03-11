package com.example.shani.gymapp;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        WebView ob = new WebView(this);
        ob.getSettings().setJavaScriptEnabled(true);
        ob.getSettings().setAllowFileAccess(true);
        ob.getSettings().setAppCacheEnabled(true);
        ob.loadUrl("file:///android_asset/www/Home.html");
        ob.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        ob.addJavascriptInterface(new WebAppInterface(this), "Android");
        //opens all link in the same web view instead of the default browser
        ob.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });

        setContentView(ob);
    }
}
