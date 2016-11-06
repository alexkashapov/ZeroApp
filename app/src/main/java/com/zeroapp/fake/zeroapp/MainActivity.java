package com.zeroapp.fake.zeroapp;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int style=1;
    public TextView label;
    public RelativeLayout layout;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("style",style);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if(savedInstanceState.containsKey("style"))style=savedInstanceState.getInt("style");
    }

    @Override
    protected void onResume() {

        super.onResume();
        switch(style) {
            case 1:
                layout.setBackgroundColor(getResources().getColor(R.color.backgroundcolor1));;
                label.setTextColor(getResources().getColor(R.color.labelcolor1));
                label.setGravity(Gravity.CENTER);
                break;
            case 2:
                layout.setBackgroundColor(getResources().getColor(R.color.backgroundcolor2));;
                label.setTextColor(getResources().getColor(R.color.labelcolor2));
                label.setGravity(Gravity.RIGHT);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (RelativeLayout) findViewById(R.id.layout);
        label = (TextView) findViewById(R.id.label);

        Button fstyle = (Button) findViewById(R.id.fstylebt);
        Button sstyle = (Button) findViewById(R.id.sstylebt);

        fstyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setBackgroundColor(getResources().getColor(R.color.backgroundcolor1));;
                label.setTextColor(getResources().getColor(R.color.labelcolor1));
                label.setGravity(Gravity.CENTER);
                style=1;
            }
        });

        sstyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setBackgroundColor(getResources().getColor(R.color.backgroundcolor2));;
                label.setTextColor(getResources().getColor(R.color.labelcolor2));
                label.setGravity(Gravity.RIGHT);
                style=2;
            }
        });
    }
}
