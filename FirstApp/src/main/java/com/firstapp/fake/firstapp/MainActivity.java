package com.firstapp.fake.firstapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView r_view;
    private List<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        r_view = (RecyclerView) findViewById(R.id.rec_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        r_view.setLayoutManager(llm);

        initializeData();
        for (int i = 0; i < notes.size(); i++) {
            System.out.println(notes.get(i).toString());
        }
//        initializeAdapter();
    }

    private void initializeData() {
        notes = new ArrayList<>();
        for (int i = 0; i < 50; i += 7) {
            for (int j = i; j < 7; j++) {
                switch (j) {
                    case 0:
                        notes.add(new Note(j+1, R.color.red));
                        break;
                    case 1:
                        notes.add(new Note(j+1, R.color.orange));
                        break;
                    case 2:
                        notes.add(new Note(j+1, R.color.yellow));
                        break;
                    case 3:
                        notes.add(new Note(j+1, R.color.green));
                        break;
                    case 4:
                        notes.add(new Note(j+1, R.color.blue));
                        break;
                    case 5:
                        notes.add(new Note(j+1, R.color.dark_blue));
                        break;
                    case 6:
                        notes.add(new Note(j+1,R.color.violet));
                        break;
                }
            }
        }
    }

    private void initializeAdapter() {
    }
}
