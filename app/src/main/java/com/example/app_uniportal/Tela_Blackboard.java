package com.example.app_uniportal;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class Tela_Blackboard extends AppCompatActivity {

    private static WebView site;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_blackboard);


        site = (WebView)findViewById(R.id.page_blackboard);
        String url = "https://servicos.eadlaureate.com.br/blackboard/";

        site.getSettings().getJavaScriptEnabled();
        site.loadUrl(url);
    }
}