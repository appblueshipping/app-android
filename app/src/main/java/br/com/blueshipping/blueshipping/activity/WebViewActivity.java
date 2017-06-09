package br.com.blueshipping.blueshipping.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import br.com.blueshipping.blueshipping.R;
import br.com.blueshipping.blueshipping.utils.Constants;

public class WebViewActivity extends AppCompatActivity {

    // UI
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        String url = getIntent().getStringExtra(Constants.PUT_LINK_STATUS_GERAL);

        // UI
        mWebView = (WebView) findViewById(R.id.activity_web_view_webView);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(url);
    }
}
