package com.example.nadyav.gmaxtoolkit;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Gravity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webView);
        // turn on JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);
        // the page we want to load as the main
        mWebView.loadUrl("https://gmaxinfoblog.wordpress.com");
        mWebView.setWebViewClient(new MyWebViewClient());

    }

    private class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }


    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            Toast toast = Toast.makeText(MainActivity.this, "Thank you for using GMAXTOOLKIT", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            super.onBackPressed();
        }
    }



}
