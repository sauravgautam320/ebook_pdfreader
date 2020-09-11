package com.examplecompany.ebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.examplecompany.ebook.R;

import java.net.URLEncoder;

public class viewpdf extends AppCompatActivity {


    WebView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpdf);


        pdfView = (WebView) findViewById(R.id.viewpdf);
        pdfView.getSettings().setJavaScriptEnabled(true);

        //if your filename and fileurl content holder is not named 'filename' and 'fileurl' then change the below name to exactly what it is named
        String filename = getIntent().getStringExtra("filename");
        String fileurl = getIntent().getStringExtra("fileurl");

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(filename);
        progressDialog.setMessage("Opening...!!!");

        pdfView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressDialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressDialog.dismiss();
            }
        });

        String url = "";
        try {

            url = URLEncoder.encode(fileurl, "UTF-8");
        }catch (Exception ex){

        }

        pdfView.loadUrl("http://docs.google.com/gview?embedded=true&url=" + url);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}