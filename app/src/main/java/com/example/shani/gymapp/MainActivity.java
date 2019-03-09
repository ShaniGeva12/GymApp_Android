package com.example.shani.gymapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newui);

        WebView browser =(WebView)findViewById(R.id.webby);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl("http://gym-app.epizy.com");
    }
}
