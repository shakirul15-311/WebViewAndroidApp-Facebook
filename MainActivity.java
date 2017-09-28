package com.example.shakirul.facebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import  android.webkit.WebViewClient;
import android.webkit.WebView;
import android.webkit.WebChromeClient;



public class MainActivity extends AppCompatActivity {

    private WebView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (WebView) this.findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new MyBrowser());
        view.loadUrl("http://www.facebook.com");
        view.setWebChromeClient(new WebChromeClient());
    }
private class MyBrowser extends WebViewClient{


    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url){
        view.loadUrl(url);
        return true;
    }
}

public boolean onKeyDown(int keyCode, KeyEvent event){

    if ((keyCode == KeyEvent.KEYCODE_BACK) && view.canGoBack()){
        view.goBack();
        return true;
    }

    return super.onKeyDown(keyCode, event);
}




}
