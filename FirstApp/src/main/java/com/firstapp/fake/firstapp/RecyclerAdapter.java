package com.firstapp.fake.firstapp;

import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fake on 13.11.2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private ArrayList<Note> items = new ArrayList<>();
    static int itemCount=50;

    public void addAll(List<Note> elements) {
        int pos = getItemCount();
        this.items.addAll(elements);
        notifyItemRangeInserted(pos, this.items.size());
    }

    public void addItem(Note newNote) {
        this.items.add(newNote);
        notifyItemInserted(getItemCount());
    }

    public ArrayList<Note> getElements(){
        return new ArrayList<>(items);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.i_card, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void dismissNote(int pos){
        for (int i = pos; i < items.size(); i++) {
            if(items.get(i).getTitle().equals("Element "+(i+1))){
                items.get(i).setTitle("Element "+ i);
            }
        }
        items.remove(pos);
        itemCount--;
        this.notifyDataSetChanged();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView image;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            image = (ImageView) itemView.findViewById(R.id.circleImage);
        }

        public void bind(Note note) {
            int color = itemView.getContext().getResources().getColor(note.getColor());
            image.getDrawable().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            title.setText(note.getTitle());
        }
    }
}

