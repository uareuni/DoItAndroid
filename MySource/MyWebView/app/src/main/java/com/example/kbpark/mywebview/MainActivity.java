package com.example.kbpark.mywebview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);

        //webView에는 설정이 있는데요, 그걸 좀만 건들여볼게요
        //WebSettings settings = webView.getSettings();
        //settings.setJavaScriptEnabled(true);


    }

    public void onButtonClicked(View v)
    {
        //webView.loadUrl("http://m.naver.com");
        webView.loadUrl("file:///android_asset/sample.html");

    }

}
