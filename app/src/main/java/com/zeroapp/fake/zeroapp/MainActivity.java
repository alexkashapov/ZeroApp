package com.zeroapp.fake.zeroapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout);
        Button fstyle = (Button) findViewById(R.id.fstylebt);
        final TextView label = (TextView) findViewById(R.id.label);
        Button sstyle = (Button) findViewById(R.id.sstylebt);

        fstyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setBackgroundColor(getResources().getColor(R.color.backgroundcolor1));;
                label.setTextColor(getResources().getColor(R.color.labelcolor1));
            }
        });

        sstyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setBackgroundColor(getResources().getColor(R.color.backgroundcolor2));;
                label.setTextColor(getResources().getColor(R.color.labelcolor2));
            }
        });

    }
}
