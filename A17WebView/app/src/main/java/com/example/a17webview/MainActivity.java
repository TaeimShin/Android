package com.example.a17webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_go = (Button) findViewById(R.id.btn_go);
        Button btn_back = (Button) findViewById(R.id.btn_back);

        final EditText url_addr = (EditText) findViewById(R.id.url_addr);
        final WebView webView = (WebView) findViewById(R.id.webview);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDisplayZoomControls(true);

        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new CustomWebViewClient());
        webView.setWebChromeClient(new CustomWebChromeClient());

        btn_go.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String url = url_addr.getText().toString();
                webView.loadUrl(url);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goBack();
            }
        });
    }

    class CustomWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
    class CustomWebChromeClient extends WebChromeClient{

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            String[] msgArray = message.split("[|]]");
            Log.d("Kosmo123","message[0]="+msgArray[0]);
            if(msgArray[0].equals("1")){
                Log.d("kosmo123","??????????????? ?????????????????????");
                Log.d("kosmo123","????????????1"+msgArray[1]);
                Log.d("kosmo123","????????????2"+msgArray[2]);
            }
            else{
                Toast.makeText(MainActivity.this
                ,message, Toast.LENGTH_LONG).show();
            }
            /*
            ????????? ?????? ???????????? alert()?????? ??????????????? ??????????????? ????????????
            ???????????? ????????? ??????. ???????????????????????? ???????????????

             */
            result.confirm();
            return true;
        }
    }



}