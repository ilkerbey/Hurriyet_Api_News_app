package com.example.heydrich.newsapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
    private static int GECEN_SURE =4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent splashIntent = new Intent(SplashActivity.this,MainActivity.class);
               startActivity(splashIntent);
               finish();
           }
       },GECEN_SURE);
    }
}
