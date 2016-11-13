package com.firstapp.fake.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Fake on 07.11.2016.
 */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_splash);

        if (savedInstanceState == null) {
            final Intent intent = new Intent(this, MainActivity.class);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    SplashActivity.this.finish();
                    startActivity(intent);
                }
            }, 2000);
        }
    }
}
