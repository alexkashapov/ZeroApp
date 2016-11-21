package com.firstapp.fake.firstapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnDialogCallback, RecyclerAdapter.OnRecyclerCallback {

    private RecyclerView recycler;
    private LinearLayoutManager llm;
    private List<Note> notes;
    private RecyclerAdapter adapter;
    private String element_name_template;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        llm = new LinearLayoutManager(this);
        recycler.setLayoutManager(llm);
        element_name_template = getResources().getString(R.string.element_name_template);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        if (savedInstanceState == null) {
            adapter = new RecyclerAdapter(this);
            initializeData();
            adapter.addAll(notes);
        } else {
            adapter = (RecyclerAdapter) getLastCustomNonConfigurationInstance();
        }
        recycler.setAdapter(adapter);
//        recycler.addOnScrollListener(new RecyclerView.OnScrollListener()
//        {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
//            {
//                if (dy > 0 && fab.isShown())
//                {
//                    fab.hide();
//                }
//            }
//
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState)
//            {
//                if (newState == RecyclerView.SCROLL_STATE_IDLE)
//                {
//                    fab.show();
//                }
//
//                super.onScrollStateChanged(recyclerView, newState);
//            }
//        });

        ItemTouchHelper.Callback callback = new SwipeHelper(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recycler);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddItemDialog dialog = new AddItemDialog();
                dialog.setCallback(MainActivity.this);
                dialog.show(getFragmentManager(), AddItemDialog.TAG);
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

            int color;
            switch (i % 7) {
                case 1:
                    color = R.color.red;
                    break;
                case 2:
                    color = R.color.orange;
                    break;
                case 3:
                    color = R.color.yellow;
                    break;
                case 4:
                    color = R.color.green;
                    break;
                case 5:
                    color = R.color.blue;
                    break;
                case 6:
                    color = R.color.dark_blue;
                    break;
                case 0:
                    color = R.color.violet;
                    break;
                default:
                    color=R.color.red;
            }
            notes.add(new Note(element_name_template+" " + i, color));
        }
    }

    @Override
    public void onButtonClick(Note note) {
        if (note.getTitle().equals("")) {
            note.setTitle(element_name_template + (adapter.getItemCount() + 1));
        }
        boolean hasItem = false;
        ArrayList<Note> elements = new ArrayList<>(adapter.getElements());
        //elements.contains()
        for (int i = 0; i < elements.size(); i++) {
            if (note.getTitle().equals(elements.get(i).getTitle())) {
                Snackbar.make(this.findViewById(android.R.id.content), R.string.hasItem, Snackbar.LENGTH_LONG).show();
                hasItem = true;
                break;
            }
        }

        if (!hasItem) {
            adapter.addItem(note);
        }
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(MainActivity.this, getString(R.string.toast_onItemClick) + (position + 1), Toast.LENGTH_SHORT).show();
    }

}
