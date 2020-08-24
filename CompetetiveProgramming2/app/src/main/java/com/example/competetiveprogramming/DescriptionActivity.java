package com.example.competetiveprogramming;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DescriptionActivity extends AppCompatActivity {

    private Bundle extras;                                  // these all four lines are variables //
    private Context mContext;
    private static final String TAG = "DescriptionActivity";
    private WebView webView;

    //    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        mContext = DescriptionActivity.this;
        webView = (WebView) findViewById(R.id.simpleWebView);
        webView.setWebViewClient(new WebViewClient());

        extras = getIntent().getExtras();

        if (!extras.equals(null)) {

//            String data = extras.getString("titles");
//            Log.d(TAG, "onCreate: the coming data is "+data);

            String url = "www.google.com";
            webView.loadUrl(url);

            WebSettings webSettings = webView.getSettings();
            webSettings.getAllowFileAccessFromFileURLs();
//            webSettings.getAllowConltentAccess(true);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(true);
            webSettings.setJavaScriptEnabled(true);
        }

    }
}