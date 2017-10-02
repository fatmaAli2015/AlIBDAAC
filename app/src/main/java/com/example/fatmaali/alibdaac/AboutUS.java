package com.example.fatmaali.alibdaac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class AboutUS extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        TextView English = (TextView) findViewById(R.id.btn_English1);
        TextView Arabic = (TextView) findViewById(R.id.btn_Arabic1);
        final WebView wv = (WebView) findViewById(R.id.webview);
        wv.loadUrl("file:///android_asset/home_1.html");
        Arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wv.loadUrl("file:///android_asset/home_1.html");
            }
        });
        English.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wv.loadUrl("file:///android_asset/home_2.html");
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AboutUS.this.finish();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
