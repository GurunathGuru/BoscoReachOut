package com.integro.boscoreachout.fragments;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.integro.boscoreachout.R;
import com.victor.loading.newton.NewtonCradleLoading;

public class FragmentWeb extends Fragment {

    WebView webView;
    String url = "http://www.boscoreachout.org/";
    NewtonCradleLoading newtonCradleLoading;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_web, container, false);
        newtonCradleLoading = view.findViewById(R.id.newton_cradle_loading);
        newtonCradleLoading.setLoadingColor(Color.parseColor("#378dbe"));
        newtonCradleLoading.start();

        webView = view.findViewById(R.id.webview);
        webView.loadUrl(url);
        openWebView();
        webView.canGoBack();
        webView.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && webView.canGoBack()) {
                    webView.goBack();
                    return true;
                }
                return false;
            }
        });
        return view;
    }
    @SuppressLint("SetJavaScriptEnabled")
    public void openWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                newtonCradleLoading.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                newtonCradleLoading.setVisibility(View.GONE);
            }
        });

    }

}