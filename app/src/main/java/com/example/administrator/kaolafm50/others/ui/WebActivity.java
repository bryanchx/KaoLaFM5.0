package com.example.administrator.kaolafm50.others.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.recommend_page.bean.Special;

public class WebActivity extends AppCompatActivity {


    private ImageView web_iv_back;
    private ImageView web_iv_play;
    private ImageView web_iv_share;
    private ProgressBar web_pb;
    private WebView web_content_wv;
    private Special special;
    private WebViewClient webViewClient = new WebViewClient() {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    };
    private WebChromeClient chromeClient = new WebChromeClient() {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            web_pb.setProgress(newProgress);
            if (newProgress == 100) {
                web_pb.setVisibility(View.INVISIBLE);
            }
        }
    };
    private TextView web_tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
        web_content_wv.setWebViewClient(webViewClient);
        web_content_wv.setWebChromeClient(chromeClient);
        WebSettings settings = web_content_wv.getSettings();
        //允许运行脚本语言
        settings.setJavaScriptEnabled(true);

        web_content_wv.addJavascriptInterface(new KaolaClientApi(), "KaolaClientApi");
        initData();

    }

    private void initView() {
        web_iv_back = (ImageView) findViewById(R.id.web_iv_back);
        web_iv_play = (ImageView) findViewById(R.id.web_iv_play);
        web_iv_share = (ImageView) findViewById(R.id.web_iv_share);
        web_pb = (ProgressBar) findViewById(R.id.web_pb);
        web_content_wv = (WebView) findViewById(R.id.web_content_wv);
        web_tv_title = (TextView) findViewById(R.id.web_tv_title);
    }

    private void initData() {
        special = getIntent().getParcelableExtra("special");
        web_content_wv.loadUrl(special.getWeburl());
    }

    class KaolaClientApi {
        public void refreshTitle(String title){
            web_tv_title.setText(title);
        }
        public void setTitle(String title){
            web_tv_title.setText(title);
        }
    }
}
