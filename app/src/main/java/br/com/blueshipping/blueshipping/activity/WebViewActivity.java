package br.com.blueshipping.blueshipping.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;


import br.com.blueshipping.blueshipping.R;

public class WebViewActivity extends Activity {

    WebView webView;
    ImageView btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        btnBack = (ImageView) findViewById(R.id.activity_tracking_result_btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        webView = (WebView) findViewById(R.id.activity_webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.google.com");

    }
}
