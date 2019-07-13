package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toolbar;

public class AboutAlcActivity extends AppCompatActivity {
  private WebView alcwebsite;
  private WebSettings webSettings;
  private ProgressBar progressBar;
  ActionBar actionBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activty_about_alc);
    actionBar = getSupportActionBar();
    actionBar.setDisplayHomeAsUpEnabled(true);

    alcwebsite = (WebView) findViewById(R.id.alcwebsite);
    progressBar = findViewById(R.id.progressBar);
    WebSettings webSettings = alcwebsite.getSettings();
    webSettings.setJavaScriptEnabled(true);
//    webSettings.setUseWideViewPort(true);
//    webSettings.setLoadWithOverviewMode(true);
    alcwebsite.setWebChromeClient(new WebChromeClient(){
      /*
          public void onProgressChanged (WebView view, int newProgress)
              Tell the host application the current progress of loading a page.

          Parameters
              view WebView: The WebView that initiated the callback.

              newProgress int: Current page loading progress, represented by an
                  integer between 0 and 100.
      */
      public void onProgressChanged(WebView view, int newProgress){
        progressBar.setProgress(newProgress);

        if(newProgress == 100){
          // Page loading finish
          progressBar.setVisibility(View.GONE);
        }
      }
    });
    alcwebsite.loadUrl("https://andela.com/alc/");
    alcwebsite.setWebViewClient(new WebViewClient(){
      @Override
      public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//        super.onReceivedSslError(view, handler, error);
        handler.proceed();
      }
    });
//    alcwebsite.load

  }

  @Override
  public void onBackPressed() {
    if (alcwebsite.canGoBack()) {
      alcwebsite.goBack();
    } else {
      super.onBackPressed();

    }
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
    }

    return super.onOptionsItemSelected(item);
  }

}