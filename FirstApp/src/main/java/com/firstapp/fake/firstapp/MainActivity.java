package com.firstapp.fake.firstapp;

import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.PorterDuff.Mode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnDialogCallback{

    private RecyclerView recycler;
    private LinearLayoutManager llm;
    private List<Note> notes;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        llm = new LinearLayoutManager(this);
        recycler.setLayoutManager(llm);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        if(savedInstanceState==null){
            adapter = new RecyclerAdapter();
            initializeData();
            adapter.addAll(notes);
        }
        else adapter = (RecyclerAdapter) getLastCustomNonConfigurationInstance();
        recycler.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new SwipeHelper(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recycler);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddItemDialog dialog = new AddItemDialog();
                dialog.setCallback(MainActivity.this);
                dialog.show(getFragmentManager(),"addNote");
            }
        });
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return adapter;
    }



    private void initializeData() {
        notes = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {

                switch (i%7) {
                    case 1:
                        notes.add(new Note("Element "+i, R.color.red));
                        break;
                    case 2:
                        notes.add(new Note("Element "+i, R.color.orange));
                        break;
                    case 3:
                        notes.add(new Note("Element "+i, R.color.yellow));
                        break;
                    case 4:
                        notes.add(new Note("Element "+i, R.color.green));
                        break;
                    case 5:
                        notes.add(new Note("Element "+i, R.color.blue));
                        break;
                    case 6:
                        notes.add(new Note("Element "+i, R.color.dark_blue));
                        break;
                    case 0:
                        notes.add(new Note("Element "+i, R.color.violet));
                        break;
                }
        }
    }

    @Override
    public void onButtonClick(Note note) {
        boolean flag = false;
        ArrayList<Note> elements = new ArrayList<>(adapter.getElements());
        for (int i = 0; i < elements.size(); i++) {
            if(note.getTitle().equals(elements.get(i).getTitle())){
                Snackbar.make(this.findViewById(android.R.id.content), "An element with this name already bexists", Snackbar.LENGTH_LONG).show();
                flag = true;
                RecyclerAdapter.itemCount--;
            }
        }
        if(!flag)adapter.addItem(new Note(note.getTitle(),note.getColor()));
    }
}
