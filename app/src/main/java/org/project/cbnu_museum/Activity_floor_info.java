package org.project.cbnu_museum;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_floor_info extends AppCompatActivity {

    private WebView mWebView; // 웹뷰 선언
    private WebSettings mWebSettings; //웹뷰세팅

    int frame_index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_info);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("층별 안내");

        Button button1 = findViewById(R.id.first_floor);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.webview);
                mWebView = (WebView) findViewById(R.id.webView);

                frame_index = 1;    //뒤로가기 버튼을 위한 index를 설정

                mWebView.setWebViewClient(new WebViewClient()); // 클릭시 새창 안뜨게
                mWebSettings = mWebView.getSettings(); //세부 세팅 등록
                mWebSettings.setJavaScriptEnabled(true); // 웹페이지 자바스클비트 허용 여부
                mWebSettings.setSupportMultipleWindows(false); // 새창 띄우기 허용 여부
                mWebSettings.setJavaScriptCanOpenWindowsAutomatically(false); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
                mWebSettings.setLoadWithOverviewMode(true); // 메타태그 허용 여부
                mWebSettings.setUseWideViewPort(true); // 화면 사이즈 맞추기 허용 여부
                mWebSettings.setSupportZoom(false); // 화면 줌 허용 여부
                mWebSettings.setBuiltInZoomControls(false); // 화면 확대 축소 허용 여부
                mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // 컨텐츠 사이즈 맞추기
                mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 브라우저 캐시 허용 여부
                mWebSettings.setDomStorageEnabled(true); // 로컬저장소 허용 여부

                mWebView.loadUrl("https://my.matterport.com/show/?m=fWBNURqTxEq"); // 웹뷰에 표시할 웹사이트 주소, 웹뷰 시작
            }
        });

        Button button2 = findViewById(R.id.second_floor);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.webview);
                mWebView = (WebView) findViewById(R.id.webView);

                frame_index = 1;

                mWebView.setWebViewClient(new WebViewClient()); // 클릭시 새창 안뜨게
                mWebSettings = mWebView.getSettings(); //세부 세팅 등록
                mWebSettings.setJavaScriptEnabled(true); // 웹페이지 자바스클비트 허용 여부
                mWebSettings.setSupportMultipleWindows(false); // 새창 띄우기 허용 여부
                mWebSettings.setJavaScriptCanOpenWindowsAutomatically(false); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
                mWebSettings.setLoadWithOverviewMode(true); // 메타태그 허용 여부
                mWebSettings.setUseWideViewPort(true); // 화면 사이즈 맞추기 허용 여부
                mWebSettings.setSupportZoom(false); // 화면 줌 허용 여부
                mWebSettings.setBuiltInZoomControls(false); // 화면 확대 축소 허용 여부
                mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // 컨텐츠 사이즈 맞추기
                mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 브라우저 캐시 허용 여부
                mWebSettings.setDomStorageEnabled(true); // 로컬저장소 허용 여부

                mWebView.loadUrl("https://my.matterport.com/show/?m=FmqhAK76MrS"); // 웹뷰에 표시할 웹사이트 주소, 웹뷰 시작
            }
        });

    }

    @Override
    public void onBackPressed() {
        //웹뷰에서 뒤로가기로 누르면 이전화면으로 이동
        if(frame_index == 1){
            setContentView(R.layout.activity_floor_info);
            frame_index = 0;
        }
        //선택화면인 경우 main_activity로 이동
        else{
            super.onBackPressed();
        }
    }

}