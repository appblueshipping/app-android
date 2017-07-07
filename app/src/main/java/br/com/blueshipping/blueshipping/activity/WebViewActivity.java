package br.com.blueshipping.blueshipping.activity;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import br.com.blueshipping.blueshipping.R;
import br.com.blueshipping.blueshipping.utils.Constants;

public class WebViewActivity extends AppCompatActivity {

    // UI
    private WebView mWebView;

    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        String url = getIntent().getStringExtra(Constants.PUT_LINK_STATUS_GERAL);

        // UI
        btnBack = (ImageView) findViewById(R.id.item_custom_navigation_btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        // UI
        mWebView = (WebView) findViewById(R.id.activity_web_view_webView);

        String extension = url.substring(url.length() - 3, url.length());

        if (extension.equals("pdf")){

            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + url);
        }
        else {

            mWebView.setWebViewClient(new WebViewClient());
            mWebView.loadUrl(url);
        }

    }

}
